package pages;

import io.cucumber.java.Scenario;

import java.io.IOException;
import java.util.AbstractMap;

public class PricingDetailsPage extends BasePage{
    public String pricingDetailsPage;
    public AbstractMap.SimpleEntry<String, String> pricingDetailsPageExist;
    public AbstractMap.SimpleEntry<String, String> pricingDetailsPageClickLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> includeFormsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> viewFormClickLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> returnToPolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> bindOrIssueLabelAndValue;
    public PricingDetailsPage() throws IOException {
        pageElementsSetup();
        pricingDetailsPage=" Pricing";
        //readPricingDetailsPage();
    }
    public void readPricingDetailsPage() throws IOException {
        pricingDetailsPageExist=commonFunctions.getLabelAndValue(pricingDetailsPage,"PricingPageExist");
        pricingDetailsPageClickLabelAndValue=commonFunctions.getLabelAndValue(pricingDetailsPage,"PricingPageClick");
        includeFormsLabelAndValue=commonFunctions.getLabelAndValue(pricingDetailsPage,"ClickIncludeForms");
        viewFormClickLabelAndValue=commonFunctions.getLabelAndValue(pricingDetailsPage,"ViewFormsButton");
        returnToPolicyLabelAndValue=commonFunctions.getLabelAndValue(pricingDetailsPage,"ReturnToPolicy");
        bindOrIssueLabelAndValue=commonFunctions.getLabelAndValue(pricingDetailsPage,"Bind/IssueClick");
    }
    public void pricingDetailClick()
    {
        textLink.clickTextLink(pricingDetailsPageClickLabelAndValue.getKey());
    }
    public void clickIncludeForms()
    {
        checkbox.selectElementCheckBox(includeFormsLabelAndValue.getKey());
    }
    public void clickViewForms()
    {
        buttons.clickButton(viewFormClickLabelAndValue.getKey());
    }
    public void clickReturnPolicy()
    {
        buttons.clickButton(returnToPolicyLabelAndValue.getKey());
    }
    public void clickBindOrIssue()
    {
        buttons.clickButton(bindOrIssueLabelAndValue.getKey());
    }
}
