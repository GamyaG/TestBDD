package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class VerifyUIErrorMessage_Steps {
    NewBusiness newBusiness;
    public VerifyUIErrorMessage_Steps( NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }

    @And("User selects Homeowners Product")
    public void user_select_homeowners_product() {
        newBusiness.selectHomeOwnersLine();
      
    }
    @And("User proceeds without completing the required information on the Homeowners screen")
    public void user_proceeds_next_button_in_gw_homeowners_line() {
        newBusiness.proceedWithoutCompletingHomeownersInfo();
        
    }
//    @And("User confirms coverage selections, generates a quote, and ensures the submission is error-free")
//    public void user_verify_the_error_message_in_gw_homeowners_line() {
//
//    }

    @Then("User confirms that appropriate error messages are displayed on the coverages screen")
    public void user_verify_the_error_message_in_coverages_screen() {
        newBusiness.verifyErrorMessagesOnCoveragesScreen();
       
    }

}
