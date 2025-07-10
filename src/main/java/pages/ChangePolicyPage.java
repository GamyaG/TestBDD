package pages;

import helper.JavaScriptHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class ChangePolicyPage extends BasePage{
    public String changePolicyPage;
    JavaScriptHelper javaScriptHelper;


    @FindBy(xpath = "//*[@id=\"PolicyChangeWizard-LOBWizardStepGroup-PolicyChangeWizard_PolicyInfoScreen-PolicyChangeWizard_PolicyInfoDV-AccountInfoInputSet-ChangePolicyAddressButton-ChangePolicyAddressButtonMenuIcon\"]/div[1]")
    WebElement policyAddressDropdown;
    @FindBy(xpath = "//*[@id=\"PolicyChangeWizard-LOBWizardStepGroup-PolicyChangeWizard_PolicyInfoScreen-PolicyChangeWizard_PolicyInfoDV-AccountInfoInputSet-ChangePolicyAddressButton-AddAddressMenuItem\"]/div")
    WebElement newAddress;
//    @FindBy(xpath = "//div[@role='menuitem' and .//div[contains(@aria-label, 'New Address')]]")
//    WebElement newAddress;
    @FindBy(xpath = "//*[@id=\"PolicyChangeWizard-LOBWizardStepGroup-PolicyChangeWizard_PolicyInfoScreen-PolicyChangeWizard_PolicyInfoDV-AccountInfoInputSet-PolicyAddressDisplayInputSet-globalAddressContainer-GlobalAddressInputSet-AddressSummary\"]/div/div")
    WebElement currentAddress;
//    @FindBy(xpath = "//*[@id=\"PolicyChangeWizard-LOBWizardStepGroup-PolicyChangeWizard_PolicyInfoScreen-PolicyChangeWizard_PolicyInfoDV-AccountInfoInputSet-PolicyAddressDisplayInputSet-globalAddressContainer-GlobalAddressInputSet-AddressSummary\"]/div/div")
//    WebElement updatedaddress;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-AccountDetailViewTile-AccountDetailViewTile_DV-Address\"]")
    WebElement updatedAddress;
    public AbstractMap.SimpleEntry<String, String> startPolicyChangeScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> policyInfoScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> addressDetailsScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterAddress1LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> cityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectStateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterZIPCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectAddressTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickQuoteLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> waitFotPolicyChangeBoundScreen;
    public AbstractMap.SimpleEntry<String, String> clickPolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> policySummaryExistsLabelAndValue;



    public ChangePolicyPage( JavaScriptHelper javaScriptHelper) throws IOException {
        pageElementsSetup();
        changePolicyPage="Change Policy";
        this.javaScriptHelper=javaScriptHelper;

    }
    public void readTestDataForChangePolicyPage() throws IOException {
        startPolicyChangeScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"StartPolicyChangeScreenExists");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"ClickNext");
        policyInfoScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"PolicyInfoScreenExists");
        addressDetailsScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"AddressDetailsScreenExists");
        enterAddress1LabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"EnterAddress1");
        cityLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"City");
        selectStateLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"SelectState");
        enterZIPCodeLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"EnterZIPCode");
        selectAddressTypeLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"SelectAddressType");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"ClickOk");
        clickQuoteLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"ClickQuote");
        waitFotPolicyChangeBoundScreen=commonFunctions.getLabelAndValue(changePolicyPage,"VerifyPolicyChangeBound");
        clickPolicyLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"ClickPolicy");
        policySummaryExistsLabelAndValue=commonFunctions.getLabelAndValue(changePolicyPage,"PolicySummaryExists");


    }

    public void waitForStartPolicyChangeScreen()
    {
        label.waitForScreenHeading(startPolicyChangeScreenExistsLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void waitForPolicyInfoScreen()
    {
        label.waitForScreenHeading(policyInfoScreenExistsLabelAndValue.getKey());
    }
    public String captureAddress()
    {
        waitFor(currentAddress);
        System.out.println(currentAddress.getText());
        return currentAddress.getText();
    }
    public void clickPolicyAddress()
    {
        waitForWebElementAndClick(policyAddressDropdown);
    }
    public void clickNewAddress()
    {
        waitForWebElementAndClick(newAddress);
    }
    public void waitForAddressDetailScreen()
    {
        label.waitForScreenHeading(addressDetailsScreenExistsLabelAndValue.getKey());
    }
    public void enterAddress1()
    {
        inputField.setInputField(enterAddress1LabelAndValue.getKey(),enterAddress1LabelAndValue.getValue());
    }
    public void enterCity()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        inputField.setInputField(cityLabelAndValue.getKey(),cityLabelAndValue.getValue());
    }

    public void selectState()
    {
        dropDown.selectDropDown(selectStateLabelAndValue.getKey(),selectStateLabelAndValue.getValue());
    }
    public void enterZipCode()
    {
        inputField.setInputField(enterZIPCodeLabelAndValue.getKey(),enterZIPCodeLabelAndValue.getValue());
    }
    public void selectAddressType()
    {
        dropDown.selectDropDown(selectAddressTypeLabelAndValue.getKey(),selectAddressTypeLabelAndValue.getValue());
    }
    public void clickOk()
    {

        buttons.clickButton(clickOkLabelAndValue.getKey());
    }
//    public String updatedAddressInPolicy()
//    {
//        waitFor(updatedaddress);
//        System.out.println(updatedaddress.getText());
//        return updatedaddress.getText();
//
//    }
    public void clickQuote()
    {

        buttons.clickButton(clickQuoteLabelAndValue.getKey());
    }
    public void waitForPolicyBoundScreen()
    {
        label.waitForScreenHeading(waitFotPolicyChangeBoundScreen.getKey());
    }
    public void verifyChangeInAddress(String currentAddress, String updatedAddress)
    {
        Assert.assertNotEquals(currentAddress,updatedAddress);
    }
    public void clickPolicy()
    {
        textLink.clickTextLink(clickPolicyLabelAndValue.getKey());
    }
    public void waitForPolicySummaryScreen()
    {
        label.waitForScreenHeading(policySummaryExistsLabelAndValue.getKey());
    }
    public String captureUpdatedAddress()
    {
        javaScriptHelper.scrollIntoView(updatedAddress);
        waitFor(updatedAddress);

        System.out.println(updatedAddress.getText());
        return updatedAddress.getText();
    }


}
