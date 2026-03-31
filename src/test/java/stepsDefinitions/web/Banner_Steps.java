package stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.web.BannerPage;

public class Banner_Steps {

    private final BannerPage bannerPage = new BannerPage();

    @Given("I access the Raken website banner page")
    public void i_access_the_raken_website_banner_page() {
        bannerPage.navigateTo();
    }

    @And("I click on the Start Free Trial button")
    public void i_click_on_the_trial_button() {
        bannerPage.clickSelectTime();
    }

    @And("I am redirected to the Calendar page")
    public void i_am_redirected_to_the_calendar_page() {
        System.out.println("Calendar page is displayed");
    }

    @And("I selected a date from the calendar")
    public void i_selected_a_date_from_the_calendar() {
        System.out.println("Selected the Date");
    }

    @And("I selected a time from the time options")
    public void i_selected_a_time_from_the_time_options() {
        System.out.println("Selected the Time");
    }

    @Then("I should see a confirmation message that my trial has been scheduled")
    public void i_should_see_a_confirmation_message_that_my_trial_has_been_scheduled() {
        System.out.println("Thanks! We'll be in touch to confirm a time.");
    }
}