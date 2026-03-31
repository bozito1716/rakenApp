package pages.mobile.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.web.BasePage;

public class FreeTrialPage extends BasePage {

    // --- Locators ---
    private final By email = AppiumBy.accessibilityId("tf_email");
    private final By firstname = AppiumBy.accessibilityId("tf_first_name");
    private final By lastname = AppiumBy.accessibilityId("tf_last_name");
    private final By company = AppiumBy.accessibilityId("tf_company_name");
    private final By phone = AppiumBy.accessibilityId("tf_phone_number");
    private final By nextButton = AppiumBy.accessibilityId("Nextt");
    private final By confirmTrialPage = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Welcome to Raken!\"]");
    private final By confirmEmailPage = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Confirm your email\"]");

    // Actions

    public void enterEmail(String emailValue) {
        wait.until(ExpectedConditions.elementToBeClickable(email)).sendKeys(emailValue);
        System.out.println("✅ Email entered: " + emailValue);
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.elementToBeClickable(firstname)).sendKeys(firstName);
        System.out.println("✅ First name entered: " + firstName);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(lastname)).sendKeys(lastName);
        System.out.println("✅ Last name entered: " + lastName);
    }

    public void enterPhone(String phoneNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(phone)).sendKeys(phoneNumber);
        System.out.println("✅ Phone number entered: " + phoneNumber);
    }

    public void enterCompany(String companyName) {
        wait.until(ExpectedConditions.elementToBeClickable(company)).sendKeys(companyName);
        System.out.println("✅ Company name entered: " + companyName);
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
        System.out.println("✅ Clicked Next button");
    }

    public boolean isWelcomeToRakenDisplayed() {
        boolean displayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmTrialPage)
        ).isDisplayed();

        System.out.println("✅ Welcome to Raken screen displayed: " + displayed);
        return displayed;
    }

    public boolean isConfirmEmailDisplayed() {
        boolean displayed = wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmEmailPage)
        ).isDisplayed();

        System.out.println("✅ Confirmation email screen displayed: " + displayed);
        return displayed;
    }
}
