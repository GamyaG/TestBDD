package stepDefinitions.CC;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.NewBusinessCC;

public class SearchPolicyCC_Steps {
    NewBusinessCC newBusinessCC;
    public SearchPolicyCC_Steps(NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }

    
    @When("the user searches for the policy in Search Claims")
    public void theUserSearchesForThePolicyInSearchClaims() {
        newBusinessCC.searchPolicyInClaims();
    }

    @Then("the claim details are loaded successfully")
    public void theClaimDetailsAreLoadedSuccessfully() {
        newBusinessCC.verifyClaimDetailsLoadedSuccessfully();
    }
}
