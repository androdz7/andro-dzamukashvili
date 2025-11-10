import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class AlertTests {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test() throws InterruptedException, AWTException {
        driver.get("https://demo.automationtesting.in/Alerts.html");

        WebElement alertWithTextbox = driver.findElement(By.xpath("//a[@href='#Textbox']"));
        WebElement alertDemonstrateBtn = driver.findElement(By.className("btn-info"));
        String name = "Andro Dzamukashvili";

        //Switch to Textbox alert
        alertWithTextbox.click();

        //Open the alert
        alertDemonstrateBtn.click();

        //Handle the alert
        wait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        alert.sendKeys(name);
        alert.accept();

        //
        //Checking

        //Checking the printed result right
        String actualResult = driver.findElement(By.id("demo1")).getText();
        String expectedResult = "Hello " + name +" How are you today";
        Assert.assertEquals(actualResult, expectedResult, "Name is WRONG");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
