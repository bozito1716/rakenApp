package pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = DriverFactory.getWait();
    }
}