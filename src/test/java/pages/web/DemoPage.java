package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.ConfigManager;

public class DemoPage extends BasePage {

    // ─── Locators ────────────────────────────────────────────────────────────────

    private By demoButton = By.cssSelector("a[href='/request-demo']");
    private By nextButton = By.xpath("//button[text()='Next']");
    private By emailField = By.id("email");
    private By emailErrorMessage = By.id("error-msg-email");

    // ─── Actions ─────────────────────────────────────────────────────────────────

    public void navigateTo() {
        driver.navigate().to(ConfigManager.getBaseUrl());
    }

    public void clickDemoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(demoButton)).click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void verifyInvalidEmailError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailErrorMessage));
        String errorText = driver.findElement(emailErrorMessage).getText();
        System.out.println("Error message displayed: " + errorText);
        if (!errorText.contains("Email is required")) {
            throw new AssertionError("Expected 'Email is required' but got: " + errorText);
        }
        System.out.println("✅ Negative test passed - error message correctly displayed");
    }
    public void verifyRedirectedToRequestDemo() {
        wait.until(ExpectedConditions.urlContains("request-demo"));
        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("request-demo")) {
            throw new AssertionError("Expected request-demo page but was: " + currentUrl);
        }
        System.out.println("✅ Redirected to: " + currentUrl);
    }

    public void enterInvalidEmail() {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys("notanemail@@@");
        System.out.println("Entered invalid email: notanemail@@@");
    }
}