package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class ChangePolicy_Steps {
    NewBusiness newBusiness;
    public  ChangePolicy_Steps(NewBusiness newBusiness)
    {
       this.newBusiness=newBusiness;
    }
    @And("User performs change policy transaction")
    public void userPerformsChangePolicyTransaction() {
        newBusiness.changePolicyTransaction();


    }
    @And("User click on change policy and click on next")
    public void user_click_on_change_policy_and_click_on_next() {

    }
    @And("User click on policy address drop and then click on new address")
    public void user_click_on_policy_address_drop_and_then_click_on_new_address() {

    }
    @And("User enters the new address in address detail tab and quote & issue the policy")
    public void user_enters_the_new_address_in_address_detail_tab_and_quote_issue_the_policy() {

    }
    @Then("User verifies the changes in address")
    public void user_verifies_the_changes_in_address() {
        newBusiness.verifyAddressUpdated();

    }


}
