import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTests {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lasName = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement genderRadio = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
        WebElement phone = driver.findElement(By.id("userNumber"));
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        WebElement hobbiesCheckbox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        WebElement stateDropdown = driver.findElement(By.id("state"));
        WebElement cityDropdown = driver.findElement(By.id("city"));
        WebElement submitBtn = driver.findElement(By.id("submit"));

        firstName.sendKeys("Test");
        lasName.sendKeys("Tester");
        email.sendKeys("test@test.com");
        genderRadio.click();
        phone.sendKeys("1111111111");
        dateOfBirth.click();
        driver.findElement(By.className("react-datepicker__month-select")).click();
        driver.findElement(By.className("react-datepicker__year-select")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--001.react-datepicker__day--weekend")).click();
        subjects.sendKeys("Computer Science");
        subjects.sendKeys(Keys.ENTER);
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);
        hobbiesCheckbox.click();
        stateDropdown.click();
        driver.findElement(By.id("react-select-3-option-0")).click();
        cityDropdown.click();
        driver.findElement(By.id("react-select-4-option-0")).click();

        submitBtn.click();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
