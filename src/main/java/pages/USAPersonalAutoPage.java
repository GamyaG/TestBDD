package pages;

import helper.DropDownHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class USAPersonalAutoPage extends BasePage{
    DropDownHelper dropDownHelper;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-UALWizardStepGroup-UALUsaPersonalAutoScreen-UALUsaPersonalAutoPanelSet-LineStandardCoveragesCovPatterns-CoverageCategoryInputSet-1-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-OptionTermInput\"]/div/div/select")
    WebElement medicalLimit;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-UALWizardStepGroup-UALUsaPersonalAutoScreen-UALUsaPersonalAutoPanelSet-LineStandardCoveragesCovPatterns-CoverageCategoryInputSet-3-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-TypekeyTermInput\"]/div/div/select")
    WebElement umbiLimit;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-UALWizardStepGroup-UALUsaPersonalAutoScreen-UALUsaPersonalAutoPanelSet-LineStandardCoveragesCovPatterns-CoverageCategoryInputSet-3-CoverageInputSet-CovPatternInputGroup-2-CovTermInputSet-TypekeyTermInput\"]/div/div/select")
    WebElement stackLimit;
    public AbstractMap.SimpleEntry<String, String> usaPersonalAutoScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickPersonalAutoStandardCoveragesTabLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickMedicalPaymentsCheckboxLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> medicalLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectCoordinateBenefitsLabelAndValue;;
    public AbstractMap.SimpleEntry<String, String> clickUninsuredMotoristBodilyInjuryLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;


    public String usaPersonalAutoPage;
    public USAPersonalAutoPage( DropDownHelper dropDownHelper)
    {
        this.dropDownHelper=dropDownHelper;
        pageElementsSetup();
        usaPersonalAutoPage="USA Personal Auto ";
    }
    public void readTestDataForUSAPersonalAutoPage() throws IOException {
        usaPersonalAutoScreenLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"USAPersonalAutoScreen");
        clickPersonalAutoStandardCoveragesTabLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"ClickPersonalAutoStandardCoveragesTab");
        clickMedicalPaymentsCheckboxLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"ClickMedicalPaymentsCheckbox");
        medicalLimitLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"MedicalLimit");
        clickUninsuredMotoristBodilyInjuryLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"ClickUninsuredMotoristBodilyInjury");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"ClickNext");
        selectCoordinateBenefitsLabelAndValue=commonFunctions.getLabelAndValue(usaPersonalAutoPage,"SelectCoordinateBenefits");


    }
    public void waitForUSAPersonalAutoScreen()
    {
        label.waitForScreenHeading(usaPersonalAutoScreenLabelAndValue.getKey());
    }
    public void clickPersonAutoStandardCoverageTab()
    {
        tab.clickButton(clickPersonalAutoStandardCoveragesTabLabelAndValue.getKey());
    }
    public void clickMedicalPaymentCheckbox()
    {
        checkbox.selectCheckbox(clickMedicalPaymentsCheckboxLabelAndValue.getKey());
    }
    public void enterMedicalPayment()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dropDownHelper.SelectUsingVisibleValue(medicalLimit,"5,000");

    }
    public void selectCoordinateBenefits()
    {
        radioButton.selectRadioButton(selectCoordinateBenefitsLabelAndValue.getKey(),selectCoordinateBenefitsLabelAndValue.getValue());

    }

    public void clickUnderInsuredCheckbox()
    {
        checkbox.selectCheckbox(clickUninsuredMotoristBodilyInjuryLabelAndValue.getKey());
    }
    public void selectUMBILimit()
    {
        dropDownHelper.SelectUsingVisibleValue(umbiLimit,"15/30");
    }
    public void selectStackedLimits()
    {
        dropDownHelper.SelectUsingVisibleValue(stackLimit,"Yes");
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }


}
