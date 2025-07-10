package pages;

import java.io.IOException;
import java.util.AbstractMap;

public class PolicyInfoPage extends BasePage{
    public String policyInfoPage;
    public AbstractMap.SimpleEntry<String, String> waitPolicyInfoScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectOrganizationTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;

    public PolicyInfoPage() throws IOException {
        pageElementsSetup();
        policyInfoPage="Policy Info";
        //readTestDataForPolicyInfoPage();


    }
    public void readTestDataForPolicyInfoPage() throws IOException {
        waitPolicyInfoScreenLabelAndValue=commonFunctions.getLabelAndValue(policyInfoPage,"PolicyInfoScreenExist");
        selectOrganizationTypeLabelAndValue=commonFunctions.getLabelAndValue(policyInfoPage,"SelectOrganizationType");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(policyInfoPage,"ClickNext");

    }
    public void waitForPolicyInfoScreen()
    {
        label.waitForScreenHeading(waitPolicyInfoScreenLabelAndValue.getKey());
    }
    public void selectOrganizationType()
    {
        dropDown.selectDropDown(selectOrganizationTypeLabelAndValue.getKey(),selectOrganizationTypeLabelAndValue.getValue());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }

}
