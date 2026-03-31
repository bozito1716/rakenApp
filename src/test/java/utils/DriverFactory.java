package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.appium.java_client.ios.IOSDriver;
import java.net.URL;
import io.appium.java_client.ios.options.XCUITestOptions;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public static void initDriver(String browser) {

        WebDriver webDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                webDriver = new EdgeDriver();
                webDriver.manage().window().maximize();
                break;

            case "safari":
                webDriver = new SafariDriver();
                webDriver.manage().window().maximize();
                break;

            case "ios":
                try {
                    XCUITestOptions options = new XCUITestOptions()
                            .setDeviceName(ConfigManager.get("device.name"))
                            .setUdid(ConfigManager.get("udid"))
                            .setBundleId(ConfigManager.get("bundle.id"))
                            .setPlatformVersion(ConfigManager.get("platform.version"))
                            .setAutomationName("XCUITest")
                            .setWdaLaunchTimeout(Duration.ofSeconds(120));

                    webDriver = new IOSDriver(new URL(ConfigManager.get("appium.server")), options);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to initialize iOS driver: " + e.getMessage());
                }
                break;

            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.set(webDriver);
        wait.set(new WebDriverWait(webDriver, Duration.ofSeconds(ConfigManager.getExplicitWait())));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriverWait getWait() {
        return wait.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            wait.remove();
        }
    }
}

