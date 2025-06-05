package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ReportingUtils;
//import utils.ReportingUtils;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getBaseUrl());
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quitDriver();
    }

    @AfterSuite
    public void afterSuite() {
        ReportingUtils.flushReport();
    }
}