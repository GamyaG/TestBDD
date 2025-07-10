package pageelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class BCElements extends BasePage {
    @FindBy(xpath = "//*[@id=\"TabBar-AccountsTab\"]/div[3]")
    WebElement accountDropdown;
    @FindBy(xpath = "//*[@id=\"TabBar-AccountsTab-AccountNumberSearchItem_Button\"]")
    WebElement accountSearchIcon;
    @FindBy(xpath = "//*[@id=\"AccountGroup-MenuLinks-AccountGroup_AccountDetailInvoices\"]/div")
    WebElement invoiceTab;
    @FindBy(xpath = "//*[@id=\"AccountDetailInvoices-AccountDetailInvoicesScreen-DetailPanel-AccountInvoicesLV-0-_Checkbox_checkboxDiv\"]")
    WebElement invoiceBillCheckbox;
    @FindBy(xpath = "//*[@id=\"AccountDetailInvoices-AccountDetailInvoicesScreen-AccountDetailInvoices_InvoiceSentAlertBar-label\"]")
    WebElement verifyInvoiceResendMessage;
    @FindBy(xpath = "//*[@id=\"AccountDetailInvoices-AccountDetailInvoicesScreen-DetailPanel-AccountInvoicesLV-3-1\"]")
    WebElement plannedRow;
    @FindBy(xpath = "//*[@id=\"AccountDetailInvoices-AccountDetailInvoicesScreen-DetailPanel-InvoiceDetailDV_tb-Edit\"]/div")
    WebElement changeInvoiceDatesBtn;
    @FindBy(xpath = "//*[@id=\"AccountDetailInvoices-AccountDetailInvoicesScreen-DetailPanel-InvoiceDetailDV-AccountInvoiceInformationInputSet-InvoiceDate_Input\"]")
    WebElement verifyBillDate;
    public void clickAccountDropdown()
    {
        waitForWebElementAndClick(accountDropdown);
    }
    public void clickInvoice()
    {
        waitForWebElementAndClick(invoiceTab);
    }
    public void clickAccountSearchIcon()
    {
        waitForWebElementAndClick(accountSearchIcon);
    }

    public void selectInvoiceBilledCheck()
    {
        waitForWebElementAndClick(invoiceBillCheckbox);
    }
    public void verifyInvoiceResendMessage()
    {
        Assert.assertTrue(verifyInvoiceResendMessage.isDisplayed());
    }
    public void clickPlanned()
    {
        waitForWebElementAndClick(plannedRow);
    }
    public void clickChangeInvoiceDateButton()
    {
        waitForWebElementAndClick(changeInvoiceDatesBtn);
    }
    public void verifyUpdatedDate(String billDate)
    {
        waitFor(verifyBillDate);

        System.out.println(verifyBillDate.getText());

        Assert.assertTrue(verifyBillDate.isDisplayed());
    }
}
