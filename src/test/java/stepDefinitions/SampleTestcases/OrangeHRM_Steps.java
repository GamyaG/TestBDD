package stepDefinitions.SampleTestcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.sampletestcases.OrangeHRM_PO;


public class OrangeHRM_Steps {
    OrangeHRM_PO orangeHRMPo;
    public OrangeHRM_Steps(OrangeHRM_PO orangeHRMPo)
    {
        this.orangeHRMPo=orangeHRMPo;
    }
    @Given("User is on the OrangeHRM login page")
    public void user_is_on_the_orange_hrm_login_page() {
        orangeHRMPo.launchOrangeHRMURL();

    }
    @When("User logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        orangeHRMPo.loginWithValidCredentials();
    }
    @When("User navigates to the Add Employee page")
    public void user_navigates_to_the_add_employee_page() {
        orangeHRMPo.navigateToAddEmployeePage();
    }
    @When("User fills in employee details")
    public void user_fills_in_employee_details() {
        orangeHRMPo.fillEmployeeDetails();
    }
    @When("User saves the employee details")
    public void user_saves_the_employee_details() {
        orangeHRMPo.saveEmployeeDetails();
    }
    @Then("User verifies the employee is added successfully")
    public void user_verifies_the_employee_is_added_successfully() {
        orangeHRMPo.verifyEmployeeAdded();
    }

}
