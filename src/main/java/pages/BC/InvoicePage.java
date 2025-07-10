package pages.BC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;

public class InvoicePage extends BasePage {
    String invoicePage;
    String formattedDate;
     public AbstractMap.SimpleEntry<String, String> invoicePageExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickResendInvoiceLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterBillDateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickUpdateLabelAndValue;


    public InvoicePage()
    {
        pageElementsSetup();
        invoicePage="Invoices";
    }
    public void readTestDataForInvoicePage() throws IOException {
        invoicePageExistsLabelAndValue=commonFunctions.getLabelAndValue(invoicePage,"InvoicePageExists");
        clickResendInvoiceLabelAndValue=commonFunctions.getLabelAndValue(invoicePage,"ClickResendInvoice");
        enterBillDateLabelAndValue=commonFunctions.getLabelAndValue(invoicePage,"EnterBillDate");
        clickUpdateLabelAndValue=commonFunctions.getLabelAndValue(invoicePage,"ClickUpdate");
    }
    public void clickInvoice()
    {
        bcElements.clickInvoice();
    }
    public void waitForInvoicePage()
    {
        label.waitForScreenHeading(invoicePageExistsLabelAndValue.getKey());
    }
    public void selectInvoiceBilledCheck()
    {
        bcElements.selectInvoiceBilledCheck();

    }
    public void clickResendInvoice()
    {
        buttons.clickButton(clickResendInvoiceLabelAndValue.getKey());
    }
    public void verifyInvoiceMessageDisplayed()
    {
        bcElements.verifyInvoiceResendMessage();
    }
    public void clickPlannedRow()
    {
        bcElements.clickPlanned();
    }
    public void clickChangeInvoiceDate()
    {
        bcElements.clickChangeInvoiceDateButton();

    }
    public void enterBillDate()
    {
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        formattedDate = futureDate.format(formatter);
        inputField.setInputField(enterBillDateLabelAndValue.getKey(),formattedDate);
    }
    public void clickUpdate()
    {
        buttons.clickButton(clickUpdateLabelAndValue.getKey());
    }
    public void verifyUpdatedDate()
    {
        bcElements.verifyUpdatedDate(formattedDate);

    }



}
