import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class FormTests {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException, AWTException {
        driver.get("https://demoqa.com/automation-practice-form");

        //Remove adds
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('iframe, #fixedban, .advertisement').forEach(e => e.remove());"
        );

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement genderRadio = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        WebElement phone = driver.findElement(By.id("userNumber"));
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        WebElement hobbiesCheckbox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        WebElement address = driver.findElement(By.id("currentAddress"));
        WebElement stateDropdown = driver.findElement(By.id("state"));
        WebElement cityDropdown = driver.findElement(By.id("city"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        //name
        firstName.sendKeys("Test");
        lastName.sendKeys("Tester");

        //Email
        email.sendKeys("test@test.com");

        //Gender
        genderRadio.click();

        //Phone
        phone.sendKeys("1111111111");

        //Date
        dateOfBirth.click();
        new Select(driver.findElement(By.className("react-datepicker__month-select"))).selectByValue("0");
        new Select(driver.findElement(By.className("react-datepicker__year-select"))).selectByValue("2000");
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='1']")).click();

        //Subjects
        subjects.sendKeys("Computer Science");
        subjects.sendKeys(Keys.ENTER);
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);

        //Hobbies
        hobbiesCheckbox.click();

        //Address
        address.sendKeys("Georgia, Tbilisi 0108, Rustaveli Avenue, N17");

        //State/City
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", stateDropdown);
        stateDropdown.click();
        driver.findElement(By.id("react-select-3-option-0")).click();
        cityDropdown.click();
        driver.findElement(By.id("react-select-4-option-0")).click();

        //Submit
        submitBtn.click();

        //
        //Checking the Submition
        //

        //Cheking Name
        String actualName = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(1) > td:nth-child(2)")).getText();
        String expectedName = firstName.getAttribute("value") + " " + lastName.getAttribute("value");
        Assert.assertEquals(actualName, expectedName, "Name is WRONG!");

        //Checking Email
        String actualEmail = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(2) > td:nth-child(2)")).getText();
        String expectedEmail = email.getAttribute("value");
        Assert.assertEquals(actualEmail, expectedEmail, "Email is WRONG!");

        //Checking Gender
        String actualGender = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(3) > td:nth-child(2)")).getText();
        String expectedGender = genderRadio.getText();
        Assert.assertEquals(actualGender, expectedGender, "Gender is WRONG");

        //Checking phone
        String actualPhone = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(4) > td:nth-child(2)")).getText();
        String expectedPhone = phone.getAttribute("value");
        Assert.assertEquals(actualPhone, expectedPhone, "Gender is WRONG");

        //Checking Date of Birth
        String actualBirth = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(5) > td:nth-child(2)")).getText();
        String expectedBirth = "01 January,2000";
        Assert.assertEquals(actualBirth, expectedBirth, "Date of birth is WRONG");

        //Checking Subjects
        String actualSubjects = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(6) > td:nth-child(2)")).getText();
        String expectedSubjects = "Computer Science, Maths";
        Assert.assertEquals(actualSubjects, expectedSubjects, "Subjects is WRONG");

        //Checking Hobbies
        String actualHobbies = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(7) > td:nth-child(2)")).getText();
        String expectedHobbies = hobbiesCheckbox.getText();
        Assert.assertEquals(actualHobbies, expectedHobbies, "Hobbies is WRONG");

        //Checking Address
        String actualAddress = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(8) > td:nth-child(2)")).getText();
        String expectedAddress = address.getText();
        Assert.assertEquals(actualAddress, expectedAddress, "Address is WRONG");

        //Checking State/City
        String actualStateCity = driver.findElement(By.cssSelector(".table > tbody > tr:nth-child(10) > td:nth-child(2)")).getText();
        String expectedStateCity = stateDropdown.getText() + " " + cityDropdown.getText();
        Assert.assertEquals(actualStateCity, expectedStateCity, "State and City are WRONG");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
