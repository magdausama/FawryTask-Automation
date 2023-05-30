package com.amazon.Base;

import com.amazon.Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new DriverFactory().initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
