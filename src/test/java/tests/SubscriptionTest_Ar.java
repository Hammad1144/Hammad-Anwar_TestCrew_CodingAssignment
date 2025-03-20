package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscriptionPage;
import utils.ExtentReportManager;

import java.util.List;

// SubscriptionTest_Ar - A TestNG test class that validates subscription packages
// for different Arabic-language versions of the STC TV website.

public class SubscriptionTest_Ar extends BaseTest {

    // DataProvider method that supplies test data for different Arabic-language subscription pages.
    // Each test run will use a different country URL, expected price, expected package type, and expected currency
    // @return A 2D array containing test data (URL, Expected Price, Expected Package Type, Expected Currency).

    @DataProvider(name = "countries")
    public Object[][] getCountries() {
        return new Object[][]{
                {"https://subscribe.stctv.com/sa-ar", "15", "بيسك", "ريال سعودي"},
                {"https://subscribe.stctv.com/bh-ar", "3", "أساسي", "دينار بحريني"},
                {"https://subscribe.stctv.com/kw-ar", "2.5", "أساسي", "دينار كويتي"}
        };
    }

    // Test method that validates subscription packages using data from the DataProvider.
    // @param url - The subscription page URL.
    // @param expectedPrice - The expected subscription price.
    // @param expectedPackage - The expected subscription package name.
    // @param expectedCurrency - The expected currency format.

    @Test(dataProvider = "countries")
    public void validateSubscriptionPackages(String url, String expectedPrice, String expectedPackage, String expectedCurrency) {

        // Start Extent Report Logging
        ExtentReportManager.createTest("Subscription Test for " + url);
        ExtentReportManager.getTest().info("Navigating to " + url);

        // Navigate to the Arabic subscription page
        driver.get(url);

        // Initialize the Subscription Page
        SubscriptionPage subscriptionPage = new SubscriptionPage(driver);

        // Retrieve subscription details from the page
        List<WebElement> types = subscriptionPage.getPackageTypes();
        List<WebElement> prices = subscriptionPage.getPackagePrices();
        List<WebElement> currencies = subscriptionPage.getPackageCurrencies();

        // Verify that at least one package is found
        Assert.assertFalse(types.isEmpty(), "No packages found!");
        ExtentReportManager.getTest().pass("Packages found successfully.");

        // Assertions for Subscription Type in Arabic
        Assert.assertEquals(subscriptionPage.getText(types.get(0)), expectedPackage, "Basic package type mismatch!");
        ExtentReportManager.getTest().pass("Basic package type verified successfully in Arabic.");

        Assert.assertEquals(subscriptionPage.getText(types.get(1)), "بريميوم", "Premium package type mismatch!");
        ExtentReportManager.getTest().pass("Premium package type verified successfully in Arabic.");

        // Assertions for Subscription Prices
        Assert.assertEquals(subscriptionPage.getText(prices.get(0)), expectedPrice, "Package price mismatch!");
        ExtentReportManager.getTest().pass("Package price verified successfully.");

        // Assertions for Currency in Arabic
        Assert.assertEquals(subscriptionPage.getText(currencies.get(0)), expectedCurrency + "/الشهر", "Currency mismatch!");
        ExtentReportManager.getTest().pass("Currency verified successfully in Arabic.");
    }
}