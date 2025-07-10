package pageobjects;

import pages.BC.AccountBCPage;
import pages.BC.InvoicePage;
import pages.BasePage;
import utils.TestRunConfig;

import java.io.IOException;

public class NewBusinessBC extends BasePage {
    AccountBCPage accountBCPage;
    InvoicePage invoicePage;
    public NewBusinessBC(AccountBCPage accountBCPage,InvoicePage invoicePage)
    {
        pageElementsSetup();
        this.accountBCPage=accountBCPage;
        this.invoicePage=invoicePage;

    }
    public void navigateToBCURL()
    {
        navigateToURL(TestRunConfig.BASE_URL2);
    }
    public void enterValidCredentials()
    {
        inputField.setInputField("Username","su");
        inputField.setInputField("Password","gw");
        buttons.clickButton("Log In");
    }
    public void navigatesTOInvoice()
    {
        try {
            accountBCPage.readTestDataForAccountBCPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountBCPage.clickAccountDropdownIcon();
        accountBCPage.enterAccount();
        accountBCPage.verifyAccount();
        try {
            invoicePage.readTestDataForInvoicePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoicePage.clickInvoice();
    }
//    public void navigateToInvoiceDue()
//    {
//        try {
//            accountBCPage.readTestDataForAccountBCPage();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        accountBCPage.clickAccountDropdownIcon();
//        accountBCPage. enterAccountForDue();
//        accountBCPage.verifyAccount();
//        try {
//            invoicePage.readTestDataForInvoicePage();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        invoicePage.clickInvoice();
//
//    }
    public void resendInvoice()
    {
        try {
            invoicePage.readTestDataForInvoicePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoicePage.selectInvoiceBilledCheck();
        invoicePage.clickResendInvoice();

    }
    public void verifyInvoiceResentConfirmationMessage()
    {
        try {
            invoicePage.readTestDataForInvoicePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoicePage.verifyInvoiceMessageDisplayed();
    }
    public void changeInvoiceDate()
    {
        try {
            invoicePage.readTestDataForInvoicePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoicePage.waitForInvoicePage();
        invoicePage.clickPlannedRow();
        invoicePage.clickChangeInvoiceDate();
        invoicePage.enterBillDate();
        invoicePage.clickUpdate();

    }
    public void verifyUpdatedDate()
    {
        try {
            invoicePage.readTestDataForInvoicePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoicePage.verifyUpdatedDate();
    }


}
