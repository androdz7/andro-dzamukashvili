import base.TestBase;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import utils.DriverFactory;
import java.awt.*;

public class AlertTests extends TestBase {
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
