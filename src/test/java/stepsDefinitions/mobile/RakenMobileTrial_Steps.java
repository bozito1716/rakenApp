package stepsDefinitions.mobile;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.mobile.ios.FreeTrialPage;
import pages.mobile.ios.RakenMobilePage;

import utils.DriverFactory;

public class RakenMobileTrial_Steps {

    private RakenMobilePage mobilePage;
    private FreeTrialPage freeTrialPage;

    @Given("I launch the Raken iOS app")
    public void i_launch_the_raken_i_os_app() {
        DriverFactory.initDriver("ios");
        mobilePage = new RakenMobilePage();
        freeTrialPage = new FreeTrialPage();
        System.out.println("Raken iOS app launched successfully");
    }

    @When("I click on the Start your free trial button")
    public void i_click_on_the_start_your_free_trial_button() {
        mobilePage.clickStartFreeTrial();
    }
    @Then("I should be navigated to the free trial screen")
    public void i_should_be_navigated_to_the_free_trial_screen() {
        boolean isDisplayed = freeTrialPage.isWelcomeToRakenDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Expected 'Welcome to Raken!' screen but it was not displayed");
        }
    }

    @And("I add the email address")
    public void i_add_the_email_address() { freeTrialPage.enterEmail("rakenqa@raken.com");

    }

    @And("I add the first name")
    public void i_add_the_first_name() {
        freeTrialPage.enterFirstName("QA Raken");
    }

    @And("I add the last name")
    public void i_add_the_last_name() {
        freeTrialPage.enterLastName("Automation");
    }

    @And("I add the phone number")
    public void i_add_the_phone_number() {
        freeTrialPage.enterPhone("6196665555");
    }

    @And("I add the company name")
    public void i_add_the_company_name() {
        freeTrialPage.enterCompany("Raken QA");
    }

    @And("I click on next button")
    public void i_click_on_next_button() {
        freeTrialPage.clickNext();
    }

    @Then("I should be redirected to the confirm email screen")
    public void i_should_be_redirected_to_the_confirm_email_screen() {
        boolean isDisplayed = freeTrialPage.isConfirmEmailDisplayed();
        if (!isDisplayed) {
            throw new AssertionError("Expected Confirm your email screen but it was not displayed");
        }
    }

}
