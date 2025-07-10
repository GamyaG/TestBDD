package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class PolicyPage extends BasePage{
    @FindBy(xpath = "//*[@id=\"TabBar-PolicyTab-PolicyTab_PolicyRetrievalItem_Button\"]")
    WebElement policySearchIcon;
    @FindBy(xpath = "//div[@role='menuitem' and .//div[@aria-label='New Transaction'] and not(.//div[contains(@class, 'gw-shortcutKey')])]")
    WebElement newTransaction;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-CancelPolicy\"]/div")
    WebElement cancelPolicy;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-ChangePolicy\"]/div")
    WebElement changePolicy;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-ReinstatePolicy\"]/div")
    WebElement reinstatePolicy;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-RewriteFullTerm\"]/div")
    WebElement reWriteFullTerm;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-RenewPolicy\"]/div")
    WebElement renewPolicy;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-PolicyDetailsDetailViewTile_DV-PolicyNumber\"]")
    WebElement verifyPolicyNumber;
    public String policyPage;
    public AbstractMap.SimpleEntry<String, String> policyDropDownClickLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterPolicyNumberLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> waitForPolicySummaryScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNewTransactionLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickCancelPolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickRenewPolicyLabelAndValue;

    public PolicyPage() throws IOException {
        pageElementsSetup();
        policyPage="Policy";


    }
    public void readTestDataForPolicyPage() throws IOException {
        policyDropDownClickLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"PolicyDropDownClick");
        enterPolicyNumberLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"EnterPolicyNumber");
        waitForPolicySummaryScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"PolicySummaryScreenExists");
        clickNewTransactionLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"ClickNewTransaction");
        clickCancelPolicyLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"ClickCancelPolicy");
        clickRenewPolicyLabelAndValue=commonFunctions.getLabelAndValue(policyPage,"ClickRenewPolicy");

    }
    public void clickPolicyDropdown()
    {

        buttons.clickDropdownIconButton(policyDropDownClickLabelAndValue.getKey());
    }
    public void enterPolicyNumber(String policyNumber)
    {
        inputField.setInputField(enterPolicyNumberLabelAndValue.getKey(),policyNumber);
        waitForWebElementAndClick(policySearchIcon);
    }

    public void waitForPolicySummaryScreen()
    {
        label.waitForScreenHeading(waitForPolicySummaryScreenExistsLabelAndValue.getKey());
    }
    public void clickNewTransaction()
    {
        waitForWebElementAndClick(newTransaction);

    }
    public void clickCancelPolicy()
    {
        waitForWebElementAndClick(cancelPolicy);
    }
    public void clickChangePolicy()
    {
        waitForWebElementAndClick(changePolicy);

    }
    public void clickReinstatePolicy()
    {
        waitForWebElementAndClick(reinstatePolicy);
    }
    public void clickReWritePolicy()
    {
        waitForWebElementAndClick(reWriteFullTerm);
    }
    public void clickRenewPolicy()
    {
        waitForWebElementAndClick(renewPolicy);
        //menuItem.clickMenuItem(clickRenewPolicyLabelAndValue.getKey());
    }
    public void verifyPolicyDetails()
    {
        waitForPolicySummaryScreen();
        waitFor(verifyPolicyNumber);
        Assert.assertTrue(verifyPolicyNumber.isDisplayed());



    }
}
