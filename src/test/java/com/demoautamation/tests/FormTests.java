package com.demoautamation.tests;

import com.demoautamation.base.BaseTest;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoautomation.pages.FormPage;
import com.demoautomation.utils.DriverFactory;

public class FormTests extends BaseTest {
    @Test
    @Description("Verify that form works correctly")
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
