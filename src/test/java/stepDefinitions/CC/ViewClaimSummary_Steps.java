package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class ViewClaimSummary_Steps {
    NewBusinessCC newBusinessCC;
    public ViewClaimSummary_Steps(NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }

    @When("User creates a new FNOL and verifies that it has been added successfully")
    public void user_creates_a_new_fnol_and_verifies_that_it_has_been_added_successfully() {
        newBusinessCC.createNewFNOL();
        newBusinessCC.verifyFNOLAddedSuccessfully();


    }
    @When("User searches with the claim number")
    public void user_search_with_claim_number() {
        newBusinessCC.searchForClaim();

    }
    @Then("the claim summary details are loaded")
    public void the_claim_summary_details_are_loaded() {
        newBusinessCC.verifyClaimLoadedSuccessfully();


    }

}
