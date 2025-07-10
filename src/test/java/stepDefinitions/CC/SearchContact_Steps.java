package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class SearchContact_Steps {
    NewBusinessCC newBusinessCC;
    public SearchContact_Steps( NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }
    @When("User searches the contact")
    public void the_user_searches_the_contact() {
        newBusinessCC.searchContact();

    }
    @Then("the search contact details are loaded")
    public void the_search_contact_details_are_loaded() {
        newBusinessCC.verifyContactDetailsLoaded();

    }

}
