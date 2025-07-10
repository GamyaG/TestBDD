package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class RenewalCUPPage extends BasePage {
    public String renewalCUPPage;
    @FindBy(xpath = "//*[@id=\"WebMessageWorksheet-WebMessageWorksheetScreen-WebMessageWorksheet_ClearButton\"]/div")
    WebElement clear;
    public AbstractMap.SimpleEntry<String, String> policyInfoScreenExistLabelAndValue;
   
    public AbstractMap.SimpleEntry<String, String> commercialUmbrellaAndExcessLiabilityScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickUmbrellaCoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectOccurrenceLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectAggregateLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectProductAndCompletedOperationsAggregateLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectUmbrellaCoverageFormLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectSelfInsuredRetentionLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickExcessLiabilityCoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectOccurrenceLimitForELLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectAggregateLimitForELLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectProductAndCompletedOperationsAggregateLimitELLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectExcessLiabilityCoverageFormLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> underlyingPoliciesScreenExistsLabelAndValue;
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
    

    public RenewalCUPPage() {
        pageElementsSetup();
        renewalCUPPage = "RenewalForCUP";

    }
    public void readTestDataForRenewalCUPPage() throws IOException {
        policyInfoScreenExistLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"PolicyInfoScreenExist");
        commercialUmbrellaAndExcessLiabilityScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"CommercialUmbrellaAndExcessLiabilityScreenExists");
        selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectUmbrellaLiabilityOrExcessLiability");
        clickUmbrellaCoveragesLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickUmbrellaCoverages");
        selectOccurrenceLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectOccurrenceLimit");
        selectAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectAggregateLimit");
        selectProductAndCompletedOperationsAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectProductAndCompletedOperationsAggregateLimit");
        selectUmbrellaCoverageFormLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectUmbrellaCoverageForm");
        selectSelfInsuredRetentionLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectSelfInsuredRetention");
        clickExcessLiabilityCoveragesLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickExcessLiabilityCoverages");
        selectOccurrenceLimitForELLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectOccurrenceLimitForEL");
        selectAggregateLimitForELLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectAggregateLimitForEL");
        selectProductAndCompletedOperationsAggregateLimitELLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectProductAndCompletedOperationsAggregateLimitEL");
        selectExcessLiabilityCoverageFormLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectExcessLiabilityCoverageForm");
        underlyingPoliciesScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"UnderlyingPoliciesScreenExists");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickNext");
        clickBackLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickBack");
        clickEditPolicyTransactionLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickEditPolicyTransaction");
        viewQuoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ViewQuoteScreenExists");
        clickBindOptionsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickBindOptions");
        clickRenewLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickRenew");
        renewalDataEntryScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"RenewalDataEntryScreenExists");
        selectRenewalCodeLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"SelectRenewalCode");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"ClickOk");
        renewalRenewingScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(renewalCUPPage,"RenewalRenewingScreenExists");
        
        
    }
    public void waitForPolicyInfoScreen()
    {
        label.waitForScreenHeading(policyInfoScreenExistLabelAndValue.getKey());
    }
    public void waitForCommercialUmbrellaAndExcessLiabilityScreen()
    {
        label.waitForScreenHeading(commercialUmbrellaAndExcessLiabilityScreenExistsLabelAndValue.getKey());
    }
    public void selectUmbrellaLiabilityOrExcessLiability()
    {
        dropDown.selectDropDown(selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue.getKey(),selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue.getValue());
    }
    public String retrieveUmbrellaCoveragesData()
    {
        return clickUmbrellaCoveragesLabelAndValue.getValue();
    }
    public void clickUmbrellaCoveragesTab()
    {
        if(clickUmbrellaCoveragesLabelAndValue.getValue().equalsIgnoreCase("Yes")) {
            tab.clickButton(clickUmbrellaCoveragesLabelAndValue.getKey());
        }


    }
    public void clickClear() {
        try {
            if (clear.isDisplayed()) {
                waitForWebElementAndClick(clear);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Clear button is not available for this coverage.");
        }
    }
    public void selectOccurrenceLimit()
    {
        dropDown.selectDropDown(selectOccurrenceLimitLabelAndValue.getKey(),selectOccurrenceLimitLabelAndValue.getValue());
    }
    public void selectAggregateLimit()
    {
        dropDown.selectDropDown(selectAggregateLimitLabelAndValue.getKey(),selectAggregateLimitLabelAndValue.getValue());
    }
    public void selectProductAndCompletedOperationsAggregateLimit()
    {
        dropDown.selectDropDown(selectProductAndCompletedOperationsAggregateLimitLabelAndValue.getKey(),selectProductAndCompletedOperationsAggregateLimitLabelAndValue.getValue());
    }
    public void selectUmbrellaCoverageForm()
    {
        dropDown.selectDropDown(selectUmbrellaCoverageFormLabelAndValue.getKey(),selectUmbrellaCoverageFormLabelAndValue.getValue());
    }
    public void selectSelfInsuredRetention()
    {
        dropDown.selectDropDown(selectSelfInsuredRetentionLabelAndValue.getKey(),selectSelfInsuredRetentionLabelAndValue.getValue());
    }
    public String retrieveExcessLiabilityData()
    {
        return clickExcessLiabilityCoveragesLabelAndValue.getValue();
    }
    public void clickExcessLiabilityCoverages()
    {
        if(clickExcessLiabilityCoveragesLabelAndValue.getValue().equalsIgnoreCase("Yes"));
        {
            buttons.clickButton(clickExcessLiabilityCoveragesLabelAndValue.getKey());
        }


    }
    public void selectOccurrenceLimitForEL()
    {
        dropDown.selectDropDown(selectOccurrenceLimitForELLabelAndValue.getKey(),selectOccurrenceLimitForELLabelAndValue.getValue());
    }
    public void selectAggregateLimitForEL()
    {
        dropDown.selectDropDown(selectAggregateLimitForELLabelAndValue.getKey(), selectAggregateLimitForELLabelAndValue.getValue());
    }
    public void selectProductAndCompletedOperationsAggregateLimitEL()
    {
        dropDown.selectDropDown(selectProductAndCompletedOperationsAggregateLimitELLabelAndValue.getKey(), selectProductAndCompletedOperationsAggregateLimitELLabelAndValue.getValue());
    }
    public void selectExcessLiabilityCoverageForm()
    {
        dropDown.selectDropDown(selectExcessLiabilityCoverageFormLabelAndValue.getKey(), selectExcessLiabilityCoverageFormLabelAndValue.getValue());
    }
    public void underlyingPoliciesScreen()
    {
        label.waitForScreenHeading(underlyingPoliciesScreenExistsLabelAndValue.getKey());

    }
    public void clickNext()
    {
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
}
