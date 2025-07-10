package stepDefinitions;

import io.cucumber.java.en.And;
import pageobjects.NewBusiness;

public class RenewalHOP_Steps {
    NewBusiness newBusiness;
    public RenewalHOP_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User loads the Home Owners policy and initiates a renewal transaction")
    public void user_loads_the_home_owners_policy_and_initiates_a_renewal_transaction() {
        newBusiness.initiatesHomeOwnersPolicyRenewal();
        
    }
    @And("User edits the transaction and adds and updates coverages for home owners")
    public void user_edits_the_transaction_and_adds_and_updates_coverages_for_home_owners() {
        newBusiness.editTransactionAndUpdateHomeOwnersCoverages();
        
    }
    @And("User performs renewal on home owners policy")
    public void user_performs_renewal_on_home_owners_policy() {
        newBusiness.renewalPolicyForHOP();
      
    }

}
