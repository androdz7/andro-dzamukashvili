package com.demoautomation.pages;

import com.demoautomation.base.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    // Locator section
    private By alertWithTextbox = By.xpath("//a[@href='#Textbox']");
    private By alertDemonstrateBtn = By.className("btn-info");
    private String name = "Andro Dzamukashvili";
    private By actualResult = By.id("demo1");
    private String expectedResult = "Hello " + name + " How are you today";

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public AlertsPage switchToAlertWithTextBoxComponent() {
        click(alertWithTextbox);
        return this;
    }

    public AlertsPage openAlert() {
        click(alertDemonstrateBtn);
        return this;
    }

    public AlertsPage handleTheAlert() {
        Alert alert = switchToAlert();
        alert.sendKeys(name);
        alert.accept();
        return this;
    }

    public String getActualResult() {
        return getText(actualResult);
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
