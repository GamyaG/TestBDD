package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class RenewalSBP_Steps {
    NewBusiness newBusiness;
    public RenewalSBP_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User loads the Small Business policy and initiates a renewal transaction")
    public void user_loads_the_small_business_policy_and_initiates_a_renewal_transaction() {
        newBusiness.initiateSmallBusinessPolicyRenewal();
       
    }
    @And("User edits the transaction")
    public void user_edits_the_transaction() {
        newBusiness.editTransactionForSmallBusiness();

    }
    @And("User adds and updates coverages for Small Business")
    public void user_adds_and_updates_coverages_for_small_business() {
        newBusiness.addUpdateCoveragesForSBP();

    }
    @And("User proceeds to the Quote page and requests a quote")
    public void user_proceeds_to_the_quote_page_and_requests_a_quote() {
        newBusiness.clickQuote();

    }
    @Then("User verifies renewal is processed and Renewal Renewing text is displayed")
    public void user_verifies_renewal_is_processed_and_renewal_renewing_text_is_displayed() {
        newBusiness.verifyRenewalScreen();

    }

    @And("User performs renewal on small business policy")
    public void userPerformsRenewalOnSmallBusinessPolicy() {
        newBusiness.renewalPolicyForSBP();
    }
}
