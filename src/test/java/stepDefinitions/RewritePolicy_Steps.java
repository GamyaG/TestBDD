package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class RewritePolicy_Steps {
    NewBusiness newBusiness;
    public RewritePolicy_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User performs Rewrite policy transaction")
    public void user_performs_rewrite_policy_transaction() {
        newBusiness.rewritePolicyTransaction();

    }

    @Then("User verify Rewrite Full Term Bound")
    public void user_verify_rewrite_full_term_bound() {

    }

}
