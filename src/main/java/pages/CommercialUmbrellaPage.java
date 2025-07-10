package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class CommercialUmbrellaPage extends BasePage{
    public String commercialUmbrellaPage;
    public CommercialUmbrellaPage()
    {
        pageElementsSetup();
        commercialUmbrellaPage="CommercialUmbrella";
    }
    @FindBy(xpath = "//*[@id=\"WebMessageWorksheet-WebMessageWorksheetScreen-WebMessageWorksheet_ClearButton\"]/div")
    WebElement clear;
    public AbstractMap.SimpleEntry<String,String>commercialUmbrellaAndExcessLiabilityScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickUmbrellaCoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectOccurrenceLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectAggregateLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectProductAndCompletedOperationsAggregateLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectUmbrellaCoverageFormLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectSelfInsuredRetentionLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickExcessLiabilityCoveragesLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectOccurrenceLimitForELLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectAggregateLimitForELLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectProductAndCompletedOperationsAggregateLimitELLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>selectExcessLiabilityCoverageFormLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>underlyingPoliciesScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickNextLabelAndValue;
    public void readTestDataForCommercialUmbrellaPage() throws IOException {
        commercialUmbrellaAndExcessLiabilityScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"CommercialUmbrellaAndExcessLiabilityScreenExists");
        selectUmbrellaLiabilityOrExcessLiabilityLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectUmbrellaLiabilityOrExcessLiability");
        clickUmbrellaCoveragesLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"ClickUmbrellaCoverages");
        selectOccurrenceLimitLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectOccurrenceLimit");
        selectAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectAggregateLimit");
        selectProductAndCompletedOperationsAggregateLimitLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectProductAndCompletedOperationsAggregateLimit");
        selectUmbrellaCoverageFormLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectUmbrellaCoverageForm");
        selectSelfInsuredRetentionLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectSelfInsuredRetention");
        clickExcessLiabilityCoveragesLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"ClickExcessLiabilityCoverages");
        selectOccurrenceLimitForELLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectOccurrenceLimitForEL");
        selectAggregateLimitForELLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectAggregateLimitForEL");
        selectProductAndCompletedOperationsAggregateLimitELLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectProductAndCompletedOperationsAggregateLimitEL");
        selectExcessLiabilityCoverageFormLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"SelectExcessLiabilityCoverageForm");
        underlyingPoliciesScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"UnderlyingPoliciesScreenExists");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(commercialUmbrellaPage,"ClickNext");

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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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

}
