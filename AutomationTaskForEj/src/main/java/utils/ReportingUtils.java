package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class ReportingUtils {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static String reportPath = "target/extent-report.html";

    static {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Configure report appearance
        htmlReporter.config().setDocumentTitle("Sauce Demo Test Report");
        htmlReporter.config().setReportName("Automation Test Results");
    }
    public static void logSkip(String message) {
        test.get().skip(message);
    }

    public static void addScreenshot(String name, byte[] screenshot, Status status) {
        if (screenshot != null && screenshot.length > 0) {
            String screenshotBase64 = Base64.getEncoder().encodeToString(screenshot);
            test.get().log(status,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotBase64, name).build());
        }
    }

    public static void createTest(String testName) {
        test.set(extent.createTest(testName));
    }

    public static void logPass(String message) {
        test.get().log(Status.PASS, message);
    }

    public static void logFail(String message) {
        test.get().log(Status.FAIL, message);
    }

    public static void flushReport() {
        extent.flush();
        openReport();
    }

    private static void openReport() {
        try {
            File reportFile = new File(reportPath);
            if (reportFile.exists() && Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            }
        } catch (IOException e) {
            System.out.println("Could not open report automatically: " + e.getMessage());
        }
    }
}