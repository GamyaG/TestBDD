package stepDefinitions;

import io.cucumber.java.en.And;
import pageobjects.NewBusiness;

public class RenewalCUP_Steps {
    NewBusiness newBusiness;
    public RenewalCUP_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User loads the Commercial Umbrella policy and initiates a renewal transaction")
    public void user_loads_the_commercial_umbrella_policy_and_initiates_a_renewal_transaction() {
        newBusiness.initiatesCommercialUmbrellaPolicyRenewal();

    }
    @And("User edits the transaction and adds and updates coverages for commercial umbrella")
    public void user_edits_the_transaction_and_adds_and_updates_coverages_for_commercial_umbrella() {
        newBusiness.editTransactionAndUpdateCommercialUmbrellaCoverages();

    }
    @And("User performs renewal on commercial umbrella policy")
    public void user_performs_renewal_on_commercial_umbrella_policy() {
        newBusiness.renewalPolicyForCUP();

    }


}
