package pages.BC;

import pages.BasePage;

import java.io.IOException;
import java.util.AbstractMap;

public class AccountBCPage extends BasePage {
    public String accountBCPage;

    public AbstractMap.SimpleEntry<String, String> enterAccountLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> waitForAccountSummaryScreenExistsLabelAndValue;
    public AccountBCPage()
    {
        pageElementsSetup();
        accountBCPage="Account";
    }
    public void readTestDataForAccountBCPage() throws IOException {
        enterAccountLabelAndValue=commonFunctions.getLabelAndValue(accountBCPage,"EnterAccountNumber");
        waitForAccountSummaryScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(accountBCPage,"AccountScreenExists");
    }
    public void clickAccountDropdownIcon()
    {
        bcElements.clickAccountDropdown();
    }
    public void enterAccount()
    {
        inputField.setInputField(enterAccountLabelAndValue.getKey(),enterAccountLabelAndValue.getValue());
        bcElements.clickAccountSearchIcon();
    }
    public void enterAccountForDue()
    {
        inputField.setInputField(enterAccountLabelAndValue.getKey(),enterAccountLabelAndValue.getValue());
        bcElements.clickAccountSearchIcon();
    }
    public void verifyAccount()
    {
        label.waitForScreenHeading(waitForAccountSummaryScreenExistsLabelAndValue.getKey());
    }




}
