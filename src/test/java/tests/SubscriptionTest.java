package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.SubscriptionPage;
import utils.ExtentReportManager;
import java.util.List;

// SubscriptionTest - A TestNG test class that validates subscription packages for different countries.
// This test checks if subscription types, prices, and currencies are correctly displayed on the STC TV website.

public class SubscriptionTest extends BaseTest {

    // DataProvider method to supply test data for different countries.
    // Each test run will use a different country URL, expected price, and expected currency.
    // @return A 2D array containing test data (URL, Expected Price, Expected Currency).

    @DataProvider(name = "countries")
    public Object[][] getCountries() {
        return new Object[][]{
                {"https://subscribe.stctv.com/sa-en", "15", "SAR"},  // Saudi Arabia
                {"https://subscribe.stctv.com/bh-en", "3", "BHD"},   // Bahrain
                {"https://subscribe.stctv.com/kw-en", "2.5", "KWD"}  // Kuwait
        };
    }


    // Test method that validates subscription packages using data from the DataProvider.
    // @param url - The subscription page URL.
    // @param expectedPrice - The expected subscription price.
    // @param expectedCurrency - The expected currency format.

    @Test(dataProvider = "countries")
    public void validateSubscriptionPackages(String url, String expectedPrice, String expectedCurrency) {

        // Start Extent Report Logging
        ExtentReportManager.createTest("Subscription Test for " + url);
        ExtentReportManager.getTest().info("Navigating to " + url);

        // Navigate to the subscription page
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

        // Assertions for Subscription Types
        Assert.assertEquals(subscriptionPage.getText(types.get(0)), "Basic", "Basic package type mismatch!");
        ExtentReportManager.getTest().pass("Basic package type verified successfully.");

        Assert.assertEquals(subscriptionPage.getText(types.get(1)), "Premium", "Premium package type mismatch!");
        ExtentReportManager.getTest().pass("Premium package type verified successfully.");

        // Assertions for Subscription Prices
        Assert.assertEquals(subscriptionPage.getText(prices.get(0)), expectedPrice, "Premium package price mismatch!");
        ExtentReportManager.getTest().pass("Package price verified successfully.");

        // Assertions for Currency
        Assert.assertEquals(subscriptionPage.getText(currencies.get(0)), expectedCurrency + "/month", "Currency mismatch!");
        ExtentReportManager.getTest().pass("Currency verified successfully.");
    }
}