package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class SearchRecovery_Steps {
    NewBusinessCC newBusinessCC;
    public SearchRecovery_Steps(NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }
    @And("User searches with the claim number and verify")
    public void user_searches_with_the_claim_number_and_verify() {
        newBusinessCC.searchForClaim();
        newBusinessCC.verifyClaimLoadedSuccessfully();
    }
    @And("the user creates the recovery")
    public void the_user_creates_the_recovery() {
        newBusinessCC.createRecovery();



    }
    @And("the user searches for the recovery details with claim number")
    public void the_user_searches_for_the_recovery_details_with_claim_number() {
        newBusinessCC.searchRecovery();

    }
    @Then("the recovery details are loaded")
    public void the_recovery_details_are_loaded() {
        newBusinessCC.verifyRecoveriesLoaded();

    }
}
