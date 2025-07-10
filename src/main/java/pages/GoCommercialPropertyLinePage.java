package pages;

import java.io.IOException;
import java.util.AbstractMap;

public class GoCommercialPropertyLinePage extends BasePage{
    public String goCommercialPropertyLinePage;
    public AbstractMap.SimpleEntry<String, String> waitGoCommercialPropertyLineScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickOutsideObjectsAndStructuresCheckboxLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> outsideObjectsAndStructuresLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> outsideObjectsAndStructuresDeductibleLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickEachLossCausedByWindCheckboxLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> eachLossCausedByWindLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> eachLossCausedByWindDeductibleLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;







    public GoCommercialPropertyLinePage() throws IOException {
        pageElementsSetup();
        goCommercialPropertyLinePage="GoCommercialPropertyLine";
        //readTestDataForGoCommercialPropertyLinePage();


    }
    public void readTestDataForGoCommercialPropertyLinePage() throws IOException {
        waitGoCommercialPropertyLineScreenLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"GoCommercialPropertyLineScreenExist");
        clickOutsideObjectsAndStructuresCheckboxLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"ClickOutsideObjectsAndStructuresCheckbox");
        outsideObjectsAndStructuresLimitLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"OutsideObjectsAndStructuresLimit");
        outsideObjectsAndStructuresDeductibleLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"OutsideObjectsAndStructuresDeductible");
        clickEachLossCausedByWindCheckboxLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"ClickEachLossCausedByWindCheckbox");
        eachLossCausedByWindLimitLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"EachLossCausedByWindLimit");
        eachLossCausedByWindDeductibleLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"EachLossCausedByWindDeductible");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(goCommercialPropertyLinePage,"ClickNext");


    }
    public void waitForGoCommercialPropertyScreen()
    {
        label.waitForScreenHeading(waitGoCommercialPropertyLineScreenLabelAndValue.getKey());
    }
    public void clickOutsideObjectAndStructureCheckbox()
    {
        checkbox.selectCheckbox(clickOutsideObjectsAndStructuresCheckboxLabelAndValue.getKey());

    }
    public void enterOutsideObjectAndStructureLimit()
    {
        inputField.setLimitInputField(outsideObjectsAndStructuresLimitLabelAndValue.getKey(),outsideObjectsAndStructuresLimitLabelAndValue.getValue());
    }
    public void enterOutsideObjectAndStructureDeductible()
    {
        inputField.setDeductibleInputField(outsideObjectsAndStructuresDeductibleLabelAndValue.getKey(),outsideObjectsAndStructuresDeductibleLabelAndValue.getValue());
    }
    public void clickEachLossCausedByWindCheckbox()
    {
        checkbox.selectCheckbox(clickEachLossCausedByWindCheckboxLabelAndValue.getKey());
    }
    public void enterEachLossCausedByWindLimit()
    {
        inputField.setLimitInputField(eachLossCausedByWindLimitLabelAndValue.getKey(),eachLossCausedByWindLimitLabelAndValue.getValue());
    }
    public void enterEachLossCausedByWindDeductible()
    {
        inputField.setDeductibleInputField(eachLossCausedByWindDeductibleLabelAndValue.getKey(),eachLossCausedByWindDeductibleLabelAndValue.getValue());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }

}
