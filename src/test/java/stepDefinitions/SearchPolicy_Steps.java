package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class SearchPolicy_Steps {
    NewBusiness newBusiness;
    public SearchPolicy_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User creates personal Account")
    public void user_creates_personal_account() {
        newBusiness.createPersonalAccount();

    }
    @And("User creates commercial policy")
    public void user_creates_commercial_policy() {
        newBusiness.createCommercialPolicy();

    }
    @And("User searches for the policy with policy number")
    public void user_searches_for_the_policy_with_policy_number() {
        newBusiness.searchPolicy();

    }
    @Then("User verify policy details are loaded successfully")
    public void user_verify_policy_details_are_loaded_successfully() {
        newBusiness.verifyPolicyDetails();

    }


}
