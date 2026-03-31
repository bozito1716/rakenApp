package pages.web;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigManager;

public class BannerPage extends BasePage {

    // ─── Locators ────────────────────────────────────────────────────────────────

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By emailField = By.id("email");
    private By phoneField = By.id("phone-1");
    private By companyNameField = By.id("company_name");
    private By companySizeDropdown = By.id("company_size");
    private By companySizeOption1150 = By.xpath("//*[@id='company_size']/option[3]");
    private By selectTimeButton = By.xpath("//button[text()='Select a Time']");

    // ─── Actions ─────────────────────────────────────────────────────────────────

    public void navigateTo() {
        driver.navigate().to(
                ConfigManager.getBaseUrl() + "/trial-set-up-1?utm_content=blue-banner-trial-setup"
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstNameField)).sendKeys(firstName);
    }

    public void enterUniqueFirstName() {
        enterFirstName("Auto FN " + RandomStringUtils.randomNumeric(5));
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastNameField)).sendKeys(lastName);
    }

    public void enterUniqueLastName() {
        enterLastName("AUTO LN " + RandomStringUtils.randomNumeric(5));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    public void enterUniqueEmail() {
        enterEmail("rakenqa" + RandomStringUtils.randomNumeric(5) + "@gmail.com");
    }

    public void enterPhone(String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(phoneField)).sendKeys(phone);
    }

    public void enterUniquePhone() {
        enterPhone(RandomStringUtils.randomNumeric(10));
    }

    public void enterCompanyName(String companyName) {
        wait.until(ExpectedConditions.elementToBeClickable(companyNameField)).sendKeys(companyName);
    }

    public void enterUniqueCompanyName() {
        enterCompanyName("QA: " + RandomStringUtils.randomAlphabetic(5));
    }

    public void selectCompanySize1150() {
        wait.until(ExpectedConditions.elementToBeClickable(companySizeDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(companySizeOption1150)).click();
    }

    public void clickSelectTime() {
        wait.until(ExpectedConditions.elementToBeClickable(selectTimeButton)).click();
    }
}