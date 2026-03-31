package stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.web.BannerPage;

public class CommonSteps {

    private final BannerPage bannerPage = new BannerPage();

    @When("I Enter a unique first name")
    public void i_enter_a_unique_first_name() {
        bannerPage.enterUniqueFirstName();
    }

    @When("I Enter a real first name {}")
    public void i_enter_a_real_first_name(String firstName) {
        bannerPage.enterFirstName(firstName);
    }

    @And("I Enter a unique last name")
    public void i_enter_a_unique_last_name() {
        bannerPage.enterUniqueLastName();
    }

    @And("I Enter a real last name {}")
    public void i_enter_a_real_last_name(String lastName) {
        bannerPage.enterLastName(lastName);
    }

    @And("I Enter a unique email address")
    public void i_enter_a_unique_email_address() {
        bannerPage.enterUniqueEmail();
    }

    @And("I Enter a real email address {}")
    public void i_enter_a_real_email_address(String email) {
        bannerPage.enterEmail(email);
    }

    @And("I Enter a unique phone number")
    public void i_enter_a_unique_phone_number() {
        bannerPage.enterUniquePhone();
    }

    @And("I Enter a real phone number {}")
    public void i_enter_a_real_phone_number(String phone) {
        bannerPage.enterPhone(phone);
    }

    @And("I Enter a unique company name")
    public void i_enter_a_unique_company_name() {
        bannerPage.enterUniqueCompanyName();
    }

    @And("I Enter a real company name {}")
    public void i_enter_a_real_company_name(String companyName) {
        bannerPage.enterCompanyName(companyName);
    }

    @And("I click on the Company Size dropdown")
    public void i_click_on_the_company_size_dropdown() {
        bannerPage.selectCompanySize1150();
    }

    @And("I select 11-50 from the dropdown options")
    public void i_select_11_50_from_the_dropdown_options() {
        System.out.println("Selected company size: 11-50");
    }
}