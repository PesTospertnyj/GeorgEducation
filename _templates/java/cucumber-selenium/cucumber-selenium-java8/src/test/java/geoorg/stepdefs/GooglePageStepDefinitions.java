package geoorg.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import geoorg.pages.GoogleHomePage;

import static org.junit.Assert.assertTrue;

public class GooglePageStepDefinitions {

    private GoogleHomePage googleHomePage;

    public GooglePageStepDefinitions() {
        googleHomePage = new GoogleHomePage();
    }

    @Given("^I am on the Google search page$")
    public void I_visit_google() {
        googleHomePage.visitHomePage();
    }

    @When("^I search for \"(.*)\"$")
    public void search_for(String query) {
        googleHomePage.searchFor(query);
        googleHomePage.waitForResults();
    }

    @Then("^the page title should start with \"(.*)\"$")
    public void checkTitle(
            final String titleStartsWith
    ) {
        assertTrue(googleHomePage.getTitle().toLowerCase().startsWith(titleStartsWith.toLowerCase()));
    }
}