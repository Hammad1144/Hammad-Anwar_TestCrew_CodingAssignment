package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportManager;
import utils.WebDriverFactory;


// BaseTest - A base test class that handles test setup and teardown.
// This class initializes the WebDriver, sets up Extent Reports,
// and ensures proper cleanup after tests are executed.

public class BaseTest {
    protected WebDriver driver; // WebDriver instance for use in test cases

    // Initializes the Extent Report before the test suite starts.
    @BeforeSuite
    public void setupReport() {
        ExtentReportManager.initializeReport();
    }

    // Sets up the WebDriver before each test method.
    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.createDriver();
    }

    // Closes the WebDriver after each test method to ensure test isolation.
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Flushes and finalizes the Extent Report after the test suite execution.
    @AfterSuite
    public void closeReport() {
        ExtentReportManager.flushReport();
    }
}
