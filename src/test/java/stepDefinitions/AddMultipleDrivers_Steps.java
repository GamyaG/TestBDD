package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class AddMultipleDrivers_Steps {
    NewBusiness newBusiness;
    public AddMultipleDrivers_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @And("User Select USA Personal Auto as Product")
    public void user_select_usa_personal_auto_as_product() {
        newBusiness.selectPersonalAuto();

    }
    @And("User adds USA Personal Auto Standard Coverages")
    public void user_adds_usa_personal_auto_standard_coverages() {
        newBusiness.addsUSAPersonalAutoStandardCoverages();

    }
    @Given("User adds multiple drivers")
    public void user_adds_multiple_drivers() {
        newBusiness.addMultipleDrivers();

    }
    @Then("User reviews the bound submission and confirms the policy transaction status")
    public void user_reviews_the_bound_submission_and_confirms_the_policy_transaction_status() {
        newBusiness.verifySubmissionBoundScreen();

    }

}
