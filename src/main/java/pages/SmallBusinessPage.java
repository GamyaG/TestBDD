package pages;

import java.io.IOException;
import java.util.AbstractMap;

public class SmallBusinessPage extends BasePage{
    public String smallBusinessPage;
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

    public SmallBusinessPage()
    {
        pageElementsSetup();
        smallBusinessPage="SmallBusiness";

    }
    public void readTestDataForSmallBusinessPage() throws IOException {
        smallBusinessScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SmallBusinessScreenExists");
        selectBusinessTypeLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectBusinessType");
        clickSmallBusinessLineCoveragesLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"ClickSmallBusinessLineCoverages");
        selectGeneralLiabilityCheckboxLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectGeneralLiabilityCheckbox");
        selectGeneralLiabilityOccurrenceLimitLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectGeneralLiabilityOccurrenceLimit");
        selectGeneralLiabilityAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectGeneralLiabilityAggregateLimit");
        selectGeneralLiabilityDeductibleLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectGeneralLiabilityDeductible");
        selectMedicalExpenseLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectMedicalExpense");
        selectPersonalAndAdvertisingInjuryLiabilityCheckboxLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectPersonalAndAdvertisingInjuryLiabilityCheckbox");
        selectPersonalAndAdvertisingInjuryLimitLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectPersonalAndAdvertisingInjuryLimit");
        selectPersonalAndAdvertisingInjuryDeductibleLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"SelectPersonalAndAdvertisingInjuryDeductible");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(smallBusinessPage,"ClickNext");

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

}
