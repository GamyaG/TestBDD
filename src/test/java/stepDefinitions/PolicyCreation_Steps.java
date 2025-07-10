package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class PolicyCreation_Steps {
    NewBusiness newBusiness;
    public PolicyCreation_Steps( NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }
    @Given("User launches the URL of GuideWire Policy Center cloud")
    public void user_launches_the_url_of_guide_wire_policy_center_cloud() {
        newBusiness.navigateToPCURL();

    }
    @When("User enters valid credentials and logs into Policy Center cloud")
    public void user_enters_valid_credentials_and_logs_into_policy_center_cloud() {
        newBusiness.enterValidCredentials();

    }
    @When("User Open account and initiates a new submission")
    public void user_open_account_and_click_on_new_submission() {
        newBusiness.openAccountAndClickNewSubmission();

    }
    @When("User Select Go Commercial Property Line of Business")
    public void user_select_go_commercial_property_line_of_business() {
        newBusiness.selectGoCommercialProduct();

    }
    @When("User enters the mandatory fields in the Policy Info screen")
    public void user_is_entering_the_mandatory_fields_in_the_policy_info_screen() {
        newBusiness.enterDetailsPolicyInfo();

    }
    @When("User adds Go Commercial Property coverages")
    public void user_is_adding_go_commercial_property_coverages() {
        newBusiness.addGoCommercialCoverages();

    }
    @When("User adds Cpblanket")
    public void user_adds_cpblanket() {
        newBusiness.addCpBlanket();

    }
    @And("User proceeds next In Location")
    public void userProceedsNextInLocation() {
        newBusiness.proceedNextInLocation();

    }
    @When("User proceeds to quote the policy")
    public void user_is_clicking_on_quote() {
        newBusiness.clickQuote();

    }
    @And("User chooses to bind the policy")
    public void userChoosesToBindThePolicy() {
        newBusiness.clickBindPolicy();
    }
    @Then("User verifies the policy transaction status is Submission Bound")
    public void user_verifies_the_policy_transaction_status_is_submission() {
        newBusiness.verifySubmissionBoundScreen();

    }
    @Given("User selects the premium option and navigates back to the Quote section")
    public void user_selects_the_premium_option_and_navigates_back_to_the_quote_section() {
        newBusiness.selectPremiumAndBackToQuoteScreen();

    }


    @Then("User verifies the policy transaction status is Submission")
    public void userVerifiesThePolicyTransactionStatusIsSubmission() {
        newBusiness.verifyQuoteSubmission();
    }

    @And("User adds Cpblanket with mutiple locations")
    public void userAddsCpblanketWithMutipleLocations() {
        newBusiness.addMultipleLocation();
    }

    @And("User add multiple buildings in location section")
    public void userAddMultipleBuildingsInLocationSection() {
        newBusiness.addMultipleBuildings();
    }

    @And("User Select Small Line of Business")
    public void userSelectSmallLineOfBusiness() {
        newBusiness.selectSmallBusinessProduct();
    }

    @And("User adds Small Business coverages")
    public void userAddsSmallBusinessCoverages() {
        newBusiness.addsSmallBusinessCoverages();

    }

    @And("User adds homeowners coverages")
    public void userAddsHomeownersCoverages() {
        newBusiness.addHomeownersCoverages();
    }

    @And("User Select Commercial Umbrella Product Line of Business")
    public void userSelectCommercialUmbrellaProductLineOfBusiness() {
        newBusiness.selectCommercialUmbrellaProduct();
        
    }

    @And("User adds Commercial Umbrella Property coverages")
    public void userAddsCommercialUmbrellaPropertyCoverages() {
        newBusiness.addCommercialUmbrellaCoverages();
    }

    @And("User enters driver and vehicle Details")
    public void userEntersDriverAndVehicleDetails() {
        newBusiness.addDriverVehicleDetails();

    }
}
