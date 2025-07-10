package stepDefinitions.BC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessBC;

public class InvoiceDue_Steps {
    NewBusinessBC newBusinessBC;
    public InvoiceDue_Steps(NewBusinessBC newBusinessBC)
    {
        this.newBusinessBC=newBusinessBC;
    }
//    @When("User navigates to invoices due on billing center home page")
//    public void user_navigates_to_invoices_due_on_billing_center_home_page() {
//        newBusinessBC.navigateToInvoiceDue();
//
//    }
    @When("User changes the invoice billed date")
    public void user_changes_the_invoice_billed_date() {
        newBusinessBC.changeInvoiceDate();

    }
    @Then("the invoice billed date is updated")
    public void the_invoice_billed_date_is_updated() {
        newBusinessBC.verifyUpdatedDate();

    }

}
