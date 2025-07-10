package pages;

import com.aventstack.extentreports.model.Report;
import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Reports;

import java.io.IOException;
import java.util.AbstractMap;

public class RenewalSBP extends BasePage{
    Reports reports=new Reports();
    public String renewalSBP;
    public AbstractMap.SimpleEntry<String,String> policyInfoScreenExistLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>smallBusinessScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectBusinessTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickSmallBusinessLineCoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectGeneralLiabilityCheckboxLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectGeneralLiabilityOccurrenceLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectGeneralLiabilityAggregateLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectGeneralLiabilityDeductibleLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectMedicalExpenseLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectPersonalAndAdvertisingInjuryLiabilityCheckboxLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectPersonalAndAdvertisingInjuryLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectPersonalAndAdvertisingInjuryDeductibleLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickBackLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickEditPolicyTransactionLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>viewQuoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickBindOptionsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickRenewLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>renewalDataEntryScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectRenewalCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>renewalRenewingScreenExistsLabelAndValue;
    @FindBy(xpath = "//*[@id=\"JobComplete-JobCompleteScreen-ttlBar\"]/div[1]/div")
    WebElement renewalRenewingScreen;
    @FindBy(xpath = "//*[@id=\"JobComplete-JobCompleteScreen-JobCompleteDV-ViewJob\"]/div/div/div[2]")
    WebElement renewalNumber;
    @FindBy(xpath = "//*[@id=\"JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy\"]/div/div/div[2]")
    WebElement renewalPolicyNumber;
    public RenewalSBP()
    {
        pageElementsSetup();
        renewalSBP="RenewalForSBP";
    }
    public void readTestDataForRenewalSBP() throws IOException {
        policyInfoScreenExistLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"PolicyInfoScreenExist");
        smallBusinessScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SmallBusinessScreenExists");
        selectBusinessTypeLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectBusinessType");
        clickSmallBusinessLineCoveragesLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickSmallBusinessLineCoverages");
        selectGeneralLiabilityCheckboxLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectGeneralLiabilityCheckbox");
        selectGeneralLiabilityOccurrenceLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectGeneralLiabilityOccurrenceLimit");
        selectGeneralLiabilityAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectGeneralLiabilityAggregateLimit");
        selectGeneralLiabilityDeductibleLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectGeneralLiabilityDeductible");
        selectMedicalExpenseLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectMedicalExpense");
        selectPersonalAndAdvertisingInjuryLiabilityCheckboxLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectPersonalAndAdvertisingInjuryLiabilityCheckbox");
        selectPersonalAndAdvertisingInjuryLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectPersonalAndAdvertisingInjuryLimit");
        selectPersonalAndAdvertisingInjuryDeductibleLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectPersonalAndAdvertisingInjuryDeductible");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickNext");
        clickBackLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickBack");
        clickEditPolicyTransactionLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickEditPolicyTransaction");
        viewQuoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ViewQuoteScreenExists");
        clickBindOptionsLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickBindOptions");
        clickRenewLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickRenew");
        renewalDataEntryScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"RenewalDataEntryScreenExists");
        selectRenewalCodeLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"SelectRenewalCode");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"ClickOk");
        renewalRenewingScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalSBP,"RenewalRenewingScreenExists");


    }
    public void waitForPolicyInfoScreen()
    {
        label.waitForScreenHeading(policyInfoScreenExistLabelAndValue.getKey());
    }
    public void waitForSmallBusinessScreen()
    {
        label.waitForScreenHeading(smallBusinessScreenExistsLabelAndValue.getKey());
    }
    public void selectBusinessType()
    {
        dropDown.selectDropDown(selectBusinessTypeLabelAndValue.getKey(),selectBusinessTypeLabelAndValue.getValue());
    }
    public void clickSmallBusinessCoverages()
    {
        tab.clickButton(clickSmallBusinessLineCoveragesLabelAndValue.getKey());
    }
    public void selectGeneralLiabilityCheckbox()
    {
        checkbox.selectCheckbox(selectGeneralLiabilityCheckboxLabelAndValue.getKey());
    }
    public void selectGeneralLiabilityOccurrenceLimit()
    {
        dropDown.selectDropDown(selectGeneralLiabilityOccurrenceLimitLabelAndValue.getKey(),selectGeneralLiabilityOccurrenceLimitLabelAndValue.getValue());
    }
    public void selectGeneralLiabilityAggregateLimit()
    {
        dropDown.selectDropDown(selectGeneralLiabilityAggregateLimitLabelAndValue.getKey(),selectGeneralLiabilityAggregateLimitLabelAndValue.getValue());
    }
    public void selectGeneralLiabilityDeductibleLimit()
    {
        dropDown.selectDropDown(selectGeneralLiabilityDeductibleLabelAndValue.getKey(),selectGeneralLiabilityDeductibleLabelAndValue.getValue());
    }
    public void selectMedicalExpenses()
    {
        dropDown.selectDropDown(selectMedicalExpenseLabelAndValue.getKey(),selectMedicalExpenseLabelAndValue.getValue());
    }
    public void selectPAICheckbox()
    {
        checkbox.selectCheckbox(selectPersonalAndAdvertisingInjuryLiabilityCheckboxLabelAndValue.getKey());
    }
    public void selectPAILimit()
    {
        dropDown.selectDropDown(selectPersonalAndAdvertisingInjuryLimitLabelAndValue.getKey(),selectPersonalAndAdvertisingInjuryLimitLabelAndValue.getValue());
    }
    public void selectPAIDeductible()
    {
        dropDown.selectDropDown(selectPersonalAndAdvertisingInjuryDeductibleLabelAndValue.getKey(),selectPersonalAndAdvertisingInjuryDeductibleLabelAndValue.getValue());
    }
    public void clickNext() {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickBack()
    {
        buttons.clickButton(clickBackLabelAndValue.getKey());
    }
    public void clickEditPolicyTransaction()
    {
        buttons.clickButton(clickEditPolicyTransactionLabelAndValue.getKey());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitForViewQuoteScreen()
    {
        label.waitForScreenHeading(viewQuoteScreenExistsLabelAndValue.getKey());
    }
    public void clickBindOptions()
    {
        buttons.clickButton(clickBindOptionsLabelAndValue.getKey());
    }
    public void clickRenew()
    {
        menuItem.clickMenuItem(clickRenewLabelAndValue.getKey());
    }
    public void waitForRenewalDataEntryScreen()
    {
        label.waitForScreenHeading(renewalDataEntryScreenExistsLabelAndValue.getKey());
    }
    public void selectRenewal()
    {
        dropDown.selectDropDown(selectRenewalCodeLabelAndValue.getKey(), selectRenewalCodeLabelAndValue.getValue());
    }
    public void clickOk()
    {
        buttons.clickButton(clickOkLabelAndValue.getKey());
        Alert alert=getDriver().switchTo().alert();
        alert.accept();
    }
    public void waitForRenewalRenewing()
    {
        label.waitForScreenHeading(renewalRenewingScreenExistsLabelAndValue.getKey());
    }
    public void verifyRenewalScreen()
    {
        waitFor(renewalRenewingScreen);
        Assert.assertTrue(renewalRenewingScreen.isDisplayed());
        waitFor(renewalNumber);
        reports.extentInfo(renewalNumber.getText());
        waitFor(renewalPolicyNumber);
        reports.extentInfo(renewalPolicyNumber.getText());

    }




}
