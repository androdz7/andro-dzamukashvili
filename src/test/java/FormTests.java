import base.TestBase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;
import utils.DriverFactory;

import java.awt.*;
import java.time.Duration;

public class FormTests extends TestBase {
    @Test
    public void test() {
        DriverFactory.getDriver().get("https://demoqa.com/automation-practice-form");
        FormPage form = new FormPage(DriverFactory.getDriver());

        //filling out the form
        form.enterFirstName("Test") //name
            .enterLastName("Tester")
            .enterEmail("test@test.com")
            .selectGender("Male")
            .enterPhone("1111111111")
            .selectBirth("1","0", "2000")
            .enterSubjects(new String[]{"Maths", "Arts", "Computer Science"})
            .selectHobbies(new String[]{"Sports"})
            .enterAddress("Georgia, Tbilisi 0108, Rustaveli Avenue, N17")
            .selectState()
            .selectCity()
            .submit();


        //Checking the Submission
            Assert.assertTrue(form.isNameCorrect());
            Assert.assertTrue(form.isEmailCorrect());
            Assert.assertTrue(form.isGenderCorrect());
            Assert.assertTrue(form.isPhoneCorrect());
            Assert.assertTrue(form.isBirthCorrect());
            Assert.assertTrue(form.isSubjectsCorrect());
            Assert.assertTrue(form.isHobbiesCorrect());
            Assert.assertTrue(form.isAddressCorrect());
            Assert.assertTrue(form.isStateCityCorrect());
    }
}
