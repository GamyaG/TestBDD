package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class Fnol_Steps {
    NewBusinessCC newBusinessCC;
    public Fnol_Steps( NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;
    }
    @Given("User launches the URL of GuideWire Claim Center")
    public void user_launches_the_url_of_guide_wire_claim_center() {
        newBusinessCC.navigateToCCURL();

    }
    @When("User enters valid credentials and logs into Claim Center")
    public void user_enters_valid_credentials_and_logs_into_claim_center() {
        newBusinessCC.enterValidCredentials();

    }
    @When("User creates new FNOL")
    public void user_creates_new_fnol() {
        newBusinessCC.createNewFNOL();

    }
    @Then("the FNOL is added successfully")
    public void the_fnol_is_added_successfully() {
        newBusinessCC.verifyFNOLAddedSuccessfully();

    }

}
