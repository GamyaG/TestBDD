package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class CancelPolicy_Steps {
    NewBusiness newBusiness;
    public String policyNumber;
    public CancelPolicy_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User chooses to issue the policy")
    public void user_chooses_to_issue_the_policy() {
        newBusiness.clickIssuePolicy();
       
    }
    @And("the user reviews the bound submission and confirms the policy transaction status")
    public void the_user_reviews_the_bound_submission_and_confirms_the_policy_transaction_status() {
      policyNumber=  newBusiness.verifySubmissionBoundScreen();
                   

    }

    @And("User searches for the policy under the policy tab")
    public void user_searches_for_the_policy_under_the_policy_tab() {
        newBusiness.searchPolicy();
                   

    }
    @And("User starts a new transaction for the policy")
    public void user_starts_a_new_transaction_for_the_policy() {
        newBusiness.startNewTransaction();
                   

    }
    @And("User selects the option to cancel the policy")
    public void user_selects_the_option_to_cancel_the_policy() {
        newBusiness.cancelPolicy();
                   

    }
    @And("User enters the mandatory fields on the Cancel Policy screen")
    public void user_enters_the_mandatory_fields_on_the_cancel_policy_screen() {
        newBusiness.enterRequiredDataCancelScreen();
                   

    }
    @And("User clicks on the Start Cancellation button and then selects Cancel Now")
    public void user_clicks_on_the_start_cancellation_button_and_then_selects_cancel_now() {
        newBusiness.clickCancelNow();
                   

    }
    @Then("User verifies the policy cancellation status")
    public void user_verifies_the_policy_cancellation_status() {
        newBusiness.verifyPolicyCancellationStatus();
                   

    }

}
