package stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.web.DemoPage;


public class DemoButton_Steps {
    private final DemoPage demoPage = new DemoPage();


    @Given("I access the Raken website page")
    public void i_access_the_raken_website_page() {
        demoPage.navigateTo();
    }

    @When("I click on the Demo button")
    public void i_click_on_the_demo_button() {
        demoPage.clickDemoButton();
    }

    @Then("I should be redirected to the request demo page")
    public void i_should_be_redirected_to_the_request_demo_page() {
        demoPage.verifyRedirectedToRequestDemo();
    }

    @And("I click on the next button")
    public void i_click_on_the_next_button() {
        demoPage.clickNextButton();
    }
    @And("I Enter an invalid email address")
    public void i_enter_an_invalid_email_address() {
        demoPage.enterInvalidEmail();
    }
    @Then("I should see an error message for invalid email")
    public void i_should_see_an_error_message_for_invalid_email() {
        demoPage.verifyInvalidEmailError();
    }

}
