package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class ReinstatePolicy_Steps {
    NewBusiness newBusiness;
    public ReinstatePolicy_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User performs cancel policy transaction")
    public void user_performs_cancel_policy_transaction() {
        newBusiness.cancelPolicyTransaction();
    }
    @And("User performs Reinstate policy transaction")
    public void user_performs_reinstate_policy_transaction() {
        newBusiness.reinstatePolicyTransaction();

    }
    @Then("User verify Reinstatement Bound")
    public void user_verify_reinstatement_bound() {
        newBusiness.verifyReinstateBound();

    }
}
