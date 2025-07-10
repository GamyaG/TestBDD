package pages;

import helper.DropDownHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.AbstractMap;

public class GWHomeOwnersLinePage extends BasePage{
    public String gwHomeOwnersLinePage;
    DropDownHelper dropDownHelper;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HLLWizardStepGroup-HLLGwHomeownersLineScreen-HLLGwHomeownersLinePanelSet-SectionIICoveragesCovPatterns-CoverageCategoryInputSet-0-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-OptionTermInput\"]/div/div/select")
    WebElement coverageELimit;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HLLWizardStepGroup-HLLGwHomeownersLineScreen-HLLGwHomeownersLinePanelSet-SectionIICoveragesCovPatterns-CoverageCategoryInputSet-1-CoverageInputSet-CovPatternInputGroup-0-CovTermInputSet-OptionTermInput\"]/div/div/select")
    WebElement coverageFLimit;

    @FindBy(xpath = "//*[@id=\"SubmissionWizard-LOBWizardStepGroup-LineWizardStepSet-HLLWizardStepGroup-HLLGwHomeownersLineScreen-_msgs-0\"]/div/div[1]")
    WebElement error;
    public AbstractMap.SimpleEntry<String, String> gwHomeownersLineScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickSectionIICoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickQuoteLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectRefusalTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickCoverageEPersonalLiabilityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectCoverageEPersonalLiabilityLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectPersonalInjuryLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickCoverageFMedicalPaymentsLabelAndValue;
   // public AbstractMap.SimpleEntry<String, String>selectCoverageFMedicalPaymentsLimitLabelAndValue;

    public GWHomeOwnersLinePage(DropDownHelper dropDownHelper)
    {
        pageElementsSetup();
        gwHomeOwnersLinePage="GW Homeowners Line";
        this.dropDownHelper=dropDownHelper;
    }
    public void readTestDataForGWHomeownersLinePage() throws IOException {
        gwHomeownersLineScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"GWHomeownersLineScreenExists");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"ClickNext");
        clickSectionIICoveragesLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"ClickSectionIICoverages");
        clickQuoteLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"ClickQuote");
        selectRefusalTypeLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"SelectRefusalType");
        clickCoverageEPersonalLiabilityLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"ClickCoverageEPersonalLiability");
        selectCoverageEPersonalLiabilityLimitLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"SelectCoverageEPersonalLiabilityLimit");
        selectPersonalInjuryLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"SelectPersonalInjury");
        clickCoverageFMedicalPaymentsLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"ClickCoverageFMedicalPayments");
        //selectCoverageFMedicalPaymentsLimitLabelAndValue=commonFunctions.getLabelAndValue(gwHomeOwnersLinePage,"SelectCoverageFMedicalPaymentsLimit");
    }
    public void waitForGWHomeownersLineScreen()
    {
        label.waitForScreenHeading(gwHomeownersLineScreenExistsLabelAndValue.getKey());
    }
    public void verifyUIErrorMessage()
    {
        Assert.assertTrue(error.isDisplayed());
        System.out.println(error.getText());
        Assert.assertEquals(error.getText(),"Errors located on another page: GW Homeowners Line\n" +
                "Click here to navigate directly to the location, if possible.");


    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickCoverageIITab()
    {
        tab.clickButton(clickSectionIICoveragesLabelAndValue.getKey());
    }
    public void clickQuote()
    {
        buttons.clickButton(clickQuoteLabelAndValue.getKey());
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
        dropDownHelper.SelectUsingVisibleValue(coverageELimit,"500,000");
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
       dropDownHelper.SelectUsingVisibleValue(coverageFLimit,"10,000");

    }

}
