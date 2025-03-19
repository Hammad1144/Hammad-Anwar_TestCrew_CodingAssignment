package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// WebDriverFactory - A utility class responsible for creating and configuring WebDriver instances.
// This class ensures that the correct WebDriver is set up before launching the browser.

public class WebDriverFactory {

    // Creates and returns a new instance of WebDriver for Chrome.
    // @return A configured WebDriver instance.

    public static WebDriver createDriver() {

        // Automatically downloads and sets up the correct version of ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        //Maximize the browser window for better visibility
        driver.manage().window().maximize();

        return driver;
    }
}
