package com.demoautamation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.demoautomation.utils.DriverFactory;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}