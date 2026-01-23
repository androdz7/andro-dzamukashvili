package com.demoautamation.tests;

import com.demoautamation.base.BaseTest;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoautomation.pages.AlertsPage;
import com.demoautomation.utils.DriverFactory;
import java.awt.*;

public class AlertTests extends BaseTest {
    @Test
    @Description("Verify that alert works correctly")
    public void test() throws InterruptedException, AWTException {
        DriverFactory.getDriver().get("https://demo.automationtesting.in/Alerts.html");

        AlertsPage alerts = new AlertsPage(DriverFactory.getDriver());

        //Switch to Textbox alert
        alerts.switchToAlertWithTextBoxComponent();
        //Open the alert
        alerts.openAlert();
        //Handle the alert
        alerts.handleTheAlert();
        //Checking the printed result
        Assert.assertEquals(alerts.getActualResult(), alerts.getExpectedResult(), "Name is WRONG");
    }
}
