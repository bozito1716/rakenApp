package pages.mobile.ios;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.web.BasePage;

public class RakenMobilePage extends BasePage {

    // --- Locators ---
    private AppiumBy.ByAccessibilityId startFreeTrialButton = (AppiumBy.ByAccessibilityId) AppiumBy.accessibilityId("Start your free trial");

    private AppiumBy.ByAccessibilityId loginButton =
            (AppiumBy.ByAccessibilityId) AppiumBy.accessibilityId("Log in");


    // -- Actions --
    public void clickStartFreeTrial() {
        wait.until(ExpectedConditions.elementToBeClickable(startFreeTrialButton)).click();
        System.out.println("✅ Clicked Start your free trial button");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        System.out.println("✅ Clicked Log in button");
    }

}
