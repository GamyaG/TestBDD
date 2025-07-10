package pages.CC;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.RandomGenerator;

import java.io.IOException;
import java.util.AbstractMap;

public class SearchORCreatePolicyPage extends BasePage {
    public String searchORCreatePolicyPage;
    public AbstractMap.SimpleEntry<String, String> searchOrCreatePolicyScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectCreateUnverifiedPolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>enterPolicyNumberLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>selectTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>enterLossDateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>enterEffectiveDateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>enterExpirationDateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>newPersonPageExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>enterLastNameLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickUpdateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String>clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectTypeOfClaimLabelAndValue;

    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name-Insured_NameMenuIcon\"]/div[1]")
    WebElement nameDropdownClick;
    @FindBy(xpath = "//*[@id=\"FNOLWizard-FNOLWizard_FindPolicyScreen-FNOLWizardFindPolicyPanelSet-NewClaimPolicyGeneralPanelSet-NewClaimPolicyGeneralDV-Insured_Name-ClaimNewContactPickerMenuItemSet-NewContactPickerMenuItemSet_NewPerson\"]/div")
    WebElement newPerson;
    public SearchORCreatePolicyPage()
    {

        pageElementsSetup();
        searchORCreatePolicyPage="Step1SearchOrCreatePolicy";
    }
    public void readTestDataForSearchOrCreatePolicy() throws IOException {
        searchOrCreatePolicyScreenExistsLabelAndValue =commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"SearchOrCreatePolicyScreenExists");
        selectCreateUnverifiedPolicyLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"SelectCreateUnverifiedPolicy");
        enterPolicyNumberLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"EnterPolicyNumber");
        selectTypeLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"SelectType");
        enterLossDateLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"EnterLossDate");
        enterEffectiveDateLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"EnterEffectiveDate");
        enterExpirationDateLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"EnterExpirationDate");
        newPersonPageExistsLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"NewPersonPageExists");
        enterLastNameLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"EnterLastName");
        clickUpdateLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"ClickUpdate");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"ClickNext");
        selectTypeOfClaimLabelAndValue=commonFunctions.getLabelAndValue(searchORCreatePolicyPage,"SelectTypeOfClaim");


    }
    public void waitForSearchOrCreatePolicyScreen()
    {
        label.waitForScreenHeading(searchOrCreatePolicyScreenExistsLabelAndValue.getKey());
    }
    public void selectCreateUnverifiedPolicy()
    {
        radioButton.selectRadioButtonByAriaLabel(selectCreateUnverifiedPolicyLabelAndValue.getKey());
    }
    public void enterPolicyNumber()
    {
        inputField.setInputField(enterPolicyNumberLabelAndValue.getKey(),enterPolicyNumberLabelAndValue.getValue());
    }
    public void selectType()
    {
        dropDown.selectDropDown(selectTypeLabelAndValue.getKey(),selectTypeLabelAndValue.getValue());
    }
    public void selectTypeOfClaim()
    {
       radioButton.selectRadioButton(selectTypeOfClaimLabelAndValue.getKey(),selectTypeOfClaimLabelAndValue.getValue());
    }
    public void enterLossDate()
    {
        int retryCount = 3; // Number of retries
        while (retryCount > 0) {
            try {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                inputField.setInputField(enterLossDateLabelAndValue.getKey(),enterLossDateLabelAndValue.getValue());
                break; // If successful, break out of the loop
            } catch (StaleElementReferenceException e) {
                // Decrease retry count and attempt again
                retryCount--;
                if (retryCount == 0) {
                    throw e; // If retries are exhausted, throw the exception
                }
                // Optionally, wait before retrying
                try {
                    Thread.sleep(1000); // Wait for 1 second before retry
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                }
            }
        }
    }
    public void enterEffectiveDate()
    {

        inputField.setInputField(enterEffectiveDateLabelAndValue.getKey(),enterEffectiveDateLabelAndValue.getValue());
    }
    public void enterExpirationDate()
    {

        inputField.setInputField(enterExpirationDateLabelAndValue.getKey(),enterExpirationDateLabelAndValue.getValue());
    }
    public void clickNameDropdown()
    {
        waitForWebElementAndClick(nameDropdownClick);
    }
    public void clickNewPerson()
    {
        waitForWebElementAndClick(newPerson);
    }
    public void waitForNewPerson()
    {
        label.waitForScreenHeading(newPersonPageExistsLabelAndValue.getKey());
    }
    public void enterLastname()
    {
        inputField.setInputField(enterLastNameLabelAndValue.getKey(), RandomGenerator.lastName());
    }
    public void clickUpdate()
    {
        buttons.clickButton(clickUpdateLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }

}
