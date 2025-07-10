package stepDefinitions;

import io.cucumber.java.en.*;
import pageobjects.NewBusiness;

public class CreateAccount_Steps {
    NewBusiness newBusiness;
    public CreateAccount_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }

    @And("User provides required details for a Person account")
    public void user_provides_required_details_for_a_person_account() {
        newBusiness.createPersonalAccount();


    }
    @Then("the account summary should display the correct account details")
    public void the_account_summary_should_display_the_correct_account_details() {
        newBusiness.verifyAccountDetails();


    }

}
