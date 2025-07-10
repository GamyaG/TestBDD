package stepDefinitions.BC;

import io.cucumber.java.en.*;
import pageobjects.BasePO;

import pageobjects.NewBusinessBC;

public class InvoiceBilled_Steps extends BasePO {
    NewBusinessBC newBusinessBC;
    public InvoiceBilled_Steps(NewBusinessBC newBusinessBC)
    {
        this.newBusinessBC=newBusinessBC;
    }
    @Given("User launches the URL of GuideWire Billing Center")
    public void user_launches_the_url_of_guide_wire_billing_center() {
        newBusinessBC.navigateToBCURL();
    }
    @When("User enters valid credentials and logs into Billing Center")
    public void user_enters_valid_credentials_and_logs_into_billing_center() {
        newBusinessBC.enterValidCredentials();

    }
    @When("User navigates to invoices on billing center home page")
    public void user_navigates_to_invoices_on_billing_center_home_page() {
        newBusinessBC.navigatesTOInvoice();

    }
    @When("User resends invoice")
    public void user_resends_invoice() {
        newBusinessBC.resendInvoice();

    }
    @Then("the invoice resent confirmation message is displayed")
    public void the_invoice_resent_confirmation_message_is_displayed() {
        newBusinessBC.verifyInvoiceResentConfirmationMessage();

    }

}
