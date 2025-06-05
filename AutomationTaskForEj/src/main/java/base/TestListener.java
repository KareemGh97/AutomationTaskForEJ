package base;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverFactory;
import utils.ReportingUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ReportingUtils.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportingUtils.logPass("Test passed: " + result.getName());
        attachScreenshot(DriverFactory.getDriver(), result.getName(), Status.PASS);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportingUtils.logFail("Test failed: " + result.getName() +
                "\nReason: " + result.getThrowable().getMessage());
        attachScreenshot(DriverFactory.getDriver(), result.getName(), Status.FAIL);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportingUtils.logSkip("Test skipped: " + result.getName());
    }

    private void attachScreenshot(WebDriver driver, String testName, Status status) {
        try {
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotName = testName + "_" + System.currentTimeMillis();

                // Add screenshot to Extent Report
                ReportingUtils.addScreenshot(screenshotName, screenshot, status);
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}