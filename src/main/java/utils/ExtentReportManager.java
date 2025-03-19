package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;


// ExtentReportManager - A utility class for managing Extent Reports.
// This class is responsible for initializing the Extent Report, creating test logs,
// and flushing the final report after test execution.

public class ExtentReportManager {
    private static ExtentReports extent; // ExtentReports instance to manage reporting
    private static ExtentTest test; // Current test instance



    // Initializes the Extent Report with a timestamped filename.
    // The report is stored in the "reports" directory.
    public static void initializeReport() {
        // Generate a timestamp for the report filename
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportPath = "reports/ExtentReport_" + timestamp + ".html";

        // Create a SparkReporter instance for generating the HTML report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

        // Initialize the ExtentReports object and attach the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    // Returns the ExtentReports instance.
    // @return The initialized ExtentReports instance.
    public static ExtentReports getExtentReport() {
        return extent;
    }


    // Creates a new test entry in the Extent Report.
    // @param testName The name of the test case.
    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }


    // Returns the current test instance for logging steps and results.
    // @return The current ExtentTest instance.
    public static ExtentTest getTest() {
        return test;
    }


    // Finalizes the Extent Report and writes all logged information to the file.
    // This should be called at the end of the test suite execution.
    public static void flushReport() {
        extent.flush();
    }
}