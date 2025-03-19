package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


// SubscriptionPage Class - Represents the Subscription page of the STC TV website.
// This class follows the Page Object Model (POM) and provides methods
// to interact with subscription package details (Type, Price, Currency).

public class SubscriptionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators for subscription details
    private By packageTypes = By.xpath("//*[@data-test-id='tier-title']");
    private By packagePrices = By.xpath("//*[@data-test-id='tier-price']/b");
    private By packageCurrencies = By.xpath("//*[@data-test-id='tier-price']/i");


    // Constructor for SubscriptionPage.
    // Initializes WebDriver and WebDriverWait.
    // @param driver WebDriver instance passed from test class.
    public SubscriptionPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    // Retrieves a list of all available subscription package types.
    public List<WebElement> getPackageTypes(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(packageTypes));
        return driver.findElements(packageTypes);
    }

    // Retrieves a list of all available subscription package prices.
    public List<WebElement> getPackagePrices(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(packagePrices));
        return driver.findElements(packagePrices);
    }

    // Retrieves a list of all available subscription package currencies.
    public List<WebElement> getPackageCurrencies(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(packageCurrencies));
        return driver.findElements(packageCurrencies);
    }


    // Extracts and returns the text content of a WebElement after ensuring it is visible.
    // @param element The WebElement from which text needs to be retrieved.
    // @return Trimmed text content of the WebElement.

    public String getText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }
}
