package com.demoautomation.pages;

import com.demoautomation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BasePage {

    // Locator section
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("userEmail");
    private By genderMale = By.cssSelector("label[for='gender-radio-1']");
    private By genderFemale = By.cssSelector("label[for='gender-radio-2']");
    private By genderOther = By.cssSelector("label[for='gender-radio-3']");
    private By phone = By.id("userNumber");
    private By dateOfBirth = By.id("dateOfBirthInput");
    private By subjects = By.id("subjectsInput");
    private By hobbySport = By.cssSelector("label[for='hobbies-checkbox-1']");
    private By hobbyReading = By.cssSelector("label[for='hobbies-checkbox-2']");
    private By hobbyMusic = By.cssSelector("label[for='hobbies-checkbox-3']");
    private By address = By.id("currentAddress");
    private By stateDropdown = By.id("state");
    private By cityDropdown = By.id("city");
    private By submitBtn = By.id("submit");

    private String expectedFirstName;
    private String expectedLastName;
    private String expectedEmail;
    private String expectedGender;
    private String expectedPhone;
    private String expectedBirth;
    private String[] expectedSubjects;
    private String[] expectedHobbies;
    private String expectedAddress;
    private String expectedState;
    private String expectedCity;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    // Methods (actions)
    public FormPage enterFirstName(String userFirstName) {
        type(firstName, userFirstName);
        expectedFirstName = userFirstName;
        return this;
    }

    public FormPage enterLastName(String userLastName) {
        type(lastName, userLastName);
        expectedLastName = userLastName;
        return this;
    }

    public FormPage enterEmail(String userEmail) {
        type(email, userEmail);
        expectedEmail = userEmail;
        return this;
    }

    // 3 options: Male, Female, Other
    public FormPage selectGender(String gender) {
        expectedGender = gender;
        switch (gender) {
            case "Male":
                click(genderMale);
                break;
            case "Female":
                click(genderFemale);
                break;
            case "Other":
                click(genderOther);
                break;
            default:
                try {
                    throw new Exception("Selected gender is wrong");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
        return this;
    }

    public FormPage enterPhone(String number) {
        type(phone, number);
        expectedPhone = number;
        return this;
    }

    private String monthToString(String month) {
        switch (month) {
            case "0":
                month = "January";
                break;
            case "1":
                month = "February";
                break;
            case "2":
                month = "March";
                break;
            case "3":
                month = "April";
                break;
            case "4":
                month = "May";
                break;
            case "5":
                month = "June";
                break;
            case "6":
                month = "July";
                break;
            case "7":
                month = "August";
                break;
            case "8":
                month = "September";
                break;
            case "9":
                month = "October";
                break;
            case "10":
                month = "November";
                break;
            case "11":
                month = "December";
                break;
        }
        return month;
    }

    //month(0 - 11), day(1 - 31)
    public FormPage selectBirth(String day, String month, String year) {
        click(dateOfBirth);
        new Select(findElement(By.className("react-datepicker__month-select"))).selectByValue(month);
        new Select(findElement(By.className("react-datepicker__year-select"))).selectByValue(year);
        click(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='" + day + "']"));
        String paddedDay = String.format("%02d", Integer.parseInt(day));
        expectedBirth = paddedDay + " " + monthToString(month) + "," + year;
        return this;
    }

    public FormPage enterSubjects(String[] subjectsArr) {
        expectedSubjects = subjectsArr;
        for (String subject : subjectsArr) {
            type(subjects, subject);
            sendKeys(subjects, Keys.ENTER);
        }
        return this;
    }

    //3 options: sports, reading, music
    public FormPage selectHobbies(String[] hobbies) {
        expectedHobbies = hobbies;
        for (String hobby : hobbies) {
            switch (hobby) {
                case "Sports":
                    click(hobbySport);
                    break;
                case "Reading":
                    click(hobbyReading);
                    break;
                case "Music":
                    click(hobbyMusic);
                    break;
                default:
                    try {
                        throw new Exception("Selected hobby is wrong");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
            }
        }
        return this;
    }

    public FormPage enterAddress(String userAddress) {
        type(address, userAddress);
        expectedAddress = userAddress;
        return this;
    }

    public FormPage selectState() {
        scrollToElement(stateDropdown);
        click(stateDropdown);
        click(By.id("react-select-3-option-0"));
        String fullText = getText(stateDropdown);
        expectedState = fullText.substring(fullText.indexOf(".") + 1).trim();
        return this;
    }

    public FormPage selectCity() {
        scrollToElement(cityDropdown);
        click(cityDropdown);
        click(By.id("react-select-4-option-0"));
        String fullText = getText(cityDropdown);
        expectedCity = fullText.substring(fullText.indexOf(".") + 1).trim();
        return this;
    }

    public void submit() {
        click(submitBtn);
    }

    public boolean isNameCorrect() {
        By actualName = By.cssSelector(".table > tbody > tr:nth-child(1) > td:nth-child(2)");
        String expectedName = expectedFirstName + " " + expectedLastName;
        return getText(actualName).equals(expectedName);
    }

    public boolean isEmailCorrect() {
        By actualEmail = By.cssSelector(".table > tbody > tr:nth-child(2) > td:nth-child(2)");
        return getText(actualEmail).equals(expectedEmail);
    }

    public boolean isGenderCorrect() {
        By actualGender = By.cssSelector(".table > tbody > tr:nth-child(3) > td:nth-child(2)");
        return getText(actualGender).equals(expectedGender);
    }

    public boolean isPhoneCorrect() {
        By actualPhone = By.cssSelector(".table > tbody > tr:nth-child(4) > td:nth-child(2)");
        return getText(actualPhone).equals(expectedPhone);
    }

    public boolean isBirthCorrect() {
        By actualBirth = By.cssSelector(".table > tbody > tr:nth-child(5) > td:nth-child(2)");
        return getText(actualBirth).equals(expectedBirth);
    }

    public boolean isSubjectsCorrect() {
        By actualSubjects = By.cssSelector(".table > tbody > tr:nth-child(6) > td:nth-child(2)");
        return getText(actualSubjects).equals(String.join(", ", expectedSubjects));
    }

    public boolean isHobbiesCorrect() {
        By actualHobbies = By.cssSelector(".table > tbody > tr:nth-child(7) > td:nth-child(2)");
        return getText(actualHobbies).equals(String.join(", ", expectedHobbies));
    }

    public boolean isAddressCorrect() {
        By actualAddress = By.className("table-responsive");
        return getText(actualAddress

        ).contains(expectedAddress);
    }

    public boolean isStateCityCorrect() {
        By actualStateCity = By.className("table-responsive");
        String expectedSateCity = expectedState + " " + expectedCity;
        return getText(actualStateCity).contains(expectedSateCity);
    }
}
