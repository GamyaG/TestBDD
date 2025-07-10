package pages;

import helper.DropDownHelper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class RenewalHOP extends BasePage{
    public String renewalHOP;
    DropDownHelper dropDownHelper;
    @FindBy(xpath = "//*[@id=\"RenewalWizard-LOBWizardStepGroup-LineWizardStepSet-HLLWizardStepGroup-HLLGwHomeownersLineScreen-HLLGwHomeownersLinePanelSet-SectionIICoveragesCovPatterns-CoverageCategoryInputSet-0-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-OptionTermInput\"]/div/div/select")
    WebElement coverageELimit;
    @FindBy(xpath = "//*[@id=\"RenewalWizard-LOBWizardStepGroup-LineWizardStepSet-HLLWizardStepGroup-HLLGwHomeownersLineScreen-HLLGwHomeownersLinePanelSet-SectionIICoveragesCovPatterns-CoverageCategoryInputSet-1-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-OptionTermInput\"]/div/div/select")
    WebElement coverageFLimit;
    public AbstractMap.SimpleEntry<String,String> policyInfoScreenExistLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> gwHomeownersLineScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickSectionIICoveragesLabelAndValue;

    public AbstractMap.SimpleEntry<String, String>selectRefusalTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickCoverageEPersonalLiabilityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectCoverageEPersonalLiabilityLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectPersonalInjuryLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickCoverageFMedicalPaymentsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> coverageFMedicalLimitLabelAndValue;;
    public AbstractMap.SimpleEntry<String, String>clickBackLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickEditPolicyTransactionLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>viewQuoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickBindOptionsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickRenewLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>renewalDataEntryScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectRenewalCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>renewalRenewingScreenExistsLabelAndValue;
    public RenewalHOP(DropDownHelper dropDownHelper)
    {
        pageElementsSetup();
        renewalHOP="RenewalForHOP";
        this.dropDownHelper=dropDownHelper;
    }
    public void readTestDataForRenewalHOP() throws IOException {
        gwHomeownersLineScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"GWHomeownersLineScreenExists");
        clickSectionIICoveragesLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickSectionIICoverages");
        selectRefusalTypeLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectRefusalType");
        clickCoverageEPersonalLiabilityLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickCoverageEPersonalLiability");
        selectCoverageEPersonalLiabilityLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectCoverageEPersonalLiabilityLimit");
        selectPersonalInjuryLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectPersonalInjury");
        clickCoverageFMedicalPaymentsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickCoverageFMedicalPayments");
        clickSectionIICoveragesLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickSectionIICoverages");
        selectRefusalTypeLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectRefusalType");
        clickCoverageEPersonalLiabilityLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickCoverageEPersonalLiability");
        selectCoverageEPersonalLiabilityLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectCoverageEPersonalLiabilityLimit");
        selectPersonalInjuryLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectPersonalInjury");
        clickCoverageFMedicalPaymentsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickCoverageFMedicalPayments");
        policyInfoScreenExistLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"PolicyInfoScreenExist");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickNext");
        clickBackLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickBack");
        clickEditPolicyTransactionLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickEditPolicyTransaction");
        viewQuoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ViewQuoteScreenExists");
        clickBindOptionsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickBindOptions");
        clickRenewLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickRenew");
        renewalDataEntryScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"RenewalDataEntryScreenExists");
        selectRenewalCodeLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"SelectRenewalCode");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"ClickOk");
        renewalRenewingScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"RenewalRenewingScreenExists");
        coverageFMedicalLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalHOP,"CoverageFMedicalLimit");
    }
    public void waitForGWHomeownersLineScreen()
    {
        label.waitForScreenHeading(gwHomeownersLineScreenExistsLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickCoverageIITab()
    {
        tab.clickButton(clickSectionIICoveragesLabelAndValue.getKey());
    }
    public void selectRefusalType()
    {
        dropDown.selectDropDown(selectRefusalTypeLabelAndValue.getKey(),selectRefusalTypeLabelAndValue.getValue());
    }
    public void clickCoverageEPersonalLiabilityCheckbox()
    {
        checkbox.selectCheckbox(clickCoverageEPersonalLiabilityLabelAndValue.getKey());
    }
    public void selectCoverageELimit()
    {
        waitFor(coverageELimit);
        dropDownHelper.SelectUsingVisibleValue(coverageELimit,selectCoverageEPersonalLiabilityLimitLabelAndValue.getValue());
    }
    public void selectPersonalInjury()
    {
        radioButton.selectRadioButton(selectPersonalInjuryLabelAndValue.getKey(),selectPersonalInjuryLabelAndValue.getValue());
    }
    public void clickCoverageFMedicalPaymentCheckbox()
    {
        checkbox.selectCheckbox(clickCoverageFMedicalPaymentsLabelAndValue.getKey());
    }
    public void selectCoverageFMedicalPaymentLimit()
    {
        waitFor(coverageFLimit);
        dropDownHelper.SelectUsingVisibleValue(coverageFLimit,coverageFMedicalLimitLabelAndValue.getValue());

    }
    public void waitForPolicyInfoScreen()
    {
        label.waitForScreenHeading(policyInfoScreenExistLabelAndValue.getKey());
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


}
