package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

import static utils.RandomGenerator.firstName;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"TabBar-AccountTab-AccountTab_NewAccount\"]/div")
    WebElement newAccount;
//    @FindBy(xpath = "//*[@role='menuitem' and .//div[@aria-label='New Account']]")
//    WebElement newAccount;
//    @FindBy(xpath = "//*[@id=\"NewAccount-NewAccountScreen-NewAccountButton-NewAccount_Person\"]/div")
//    WebElement person;
    @FindBy(xpath = "//div[@role='menuitem' and div[@aria-label ='Person']]")
    WebElement person;
    @FindBy(xpath = "//*[@id=\"CreateAccount-CreateAccountScreen-CreateAccountDV-ProducerSelectionInputSet-Producer-SelectOrganization\"]")
    WebElement organizationIcon;
    @FindBy(xpath = "//*[@id=\"AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountNumber\"]/div")
    WebElement captureAccountNo;
    @FindBy(xpath = "//*[@id=\"AccountFile_Summary-AccountSummaryDashboard-AccountDetailsDetailViewTile-AccountDetailsDetailViewTile_DV-AccountHolder_button\"]")
    WebElement accountHolder;
    public String accountPage;
    public AbstractMap.SimpleEntry<String, String> accountDropdownClickLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNewAccountLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> firstnameLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> lastnameLabelAndValue ;
    public AbstractMap.SimpleEntry<String, String> clickSearchLabelAndValue ;
    public AbstractMap.SimpleEntry<String, String> clickCreateNewAccountLabelAndValue ;
    public AbstractMap.SimpleEntry<String, String> clickPersonLabelAndValue ;
    public AbstractMap.SimpleEntry<String, String> address1LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> cityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> stateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> ZIPCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> addressTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> organizationNameLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> organizationSearchLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectCompanyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> producerCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickUpdateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> waitAccountScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickOrganizationSearchIconLabelAndValue;
    public AccountPage() throws IOException {
        pageElementsSetup();
        accountPage = "Account";
    }
    public void readTestDataForAccountPage() throws IOException{
        accountDropdownClickLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"AccountDropdownClick");
        clickNewAccountLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickNewAccount");
        firstnameLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"EnterFirstname");
        lastnameLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"EnterLastname");
        clickSearchLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickSearch");
        clickCreateNewAccountLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickCreateNewAccount");
        clickPersonLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickPerson");
        address1LabelAndValue=commonFunctions.getLabelAndValue(accountPage,"Address1");
        cityLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"City");
        stateLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"State");
        ZIPCodeLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ZIPCode");
        addressTypeLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"AddressType");
        organizationNameLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"OrganizationName");
        organizationSearchLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickOrganizationSearch");
        selectCompanyLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"SelectOrganizationCompany");
        producerCodeLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"SelectProducer Code");
        clickUpdateLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickUpdate");
        waitAccountScreenLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"AccountScreenExists");
        clickOrganizationSearchIconLabelAndValue=commonFunctions.getLabelAndValue(accountPage,"ClickOrganizationSearchIcon");




    }
    public void clickAccountDropdown()
    {
//       waitFor(accountDropdown);
//       waitForWebElementAndClick(accountDropdown);
        buttons.clickDropdownIconButton(accountDropdownClickLabelAndValue.getKey());

    }
    public void clickNewAccount()
    {
        waitForWebElementAndClick(newAccount);
        //menuItem.clickMenuItem(clickNewAccountLabelAndValue.getKey());
    }
    public String enterFirstname()
    {
        String firstnameValue=firstName();
        inputField.setInputField(firstnameLabelAndValue.getKey(),firstnameValue);
        return firstnameValue;
    }
    public String enterLastname()
    {
        inputField.setInputField(lastnameLabelAndValue.getKey(),lastnameLabelAndValue.getValue());
        return lastnameLabelAndValue.getValue();
    }
    public void clickSearch()
    {
        buttons.clickButton(clickSearchLabelAndValue.getKey());
    }
    public void clickCreateNewAccount()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        buttons.clickButton(clickCreateNewAccountLabelAndValue.getKey());
    }
    public void clickPerson()
    {
        //waitForWebElementAndClick(person);
        //menuItem.clickMenuItem("Person");
        menuItem.clickMenuItem(clickPersonLabelAndValue.getKey());
    }
    public void enterAddress1()
    {
        inputField.setInputField(address1LabelAndValue.getKey(),address1LabelAndValue.getValue());
    }
    public void enterCity()
    {
        int retries = 3;  // Number of retries for handling StaleElementReferenceException
        boolean isSuccessful = false;

        for (int i = 0; i < retries; i++) {
            try {
                Thread.sleep(1000);
                inputField.setInputField(cityLabelAndValue.getKey(), cityLabelAndValue.getValue());
                isSuccessful = true;
                break;  // Exit the loop if successful
            } catch (StaleElementReferenceException e) {
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void selectState()
    {
        dropDown.selectDropDown(stateLabelAndValue.getKey(),stateLabelAndValue.getValue());

    }
  public void enterZipCode() {
    int retries = 3;  // Number of retries for handling StaleElementReferenceException
    boolean isSuccessful = false;

    for (int i = 0; i < retries; i++) {
        try {
            Thread.sleep(1000);
            inputField.setInputField(ZIPCodeLabelAndValue.getKey(), ZIPCodeLabelAndValue.getValue());
            isSuccessful = true;
            break;  // Exit the loop if successful
        } catch (StaleElementReferenceException e) {
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    if (!isSuccessful) {
        throw new RuntimeException("Failed to enter ZIP Code after multiple retries due to StaleElementReferenceException.");
    }
}

    public void selectAddressType()
    {
        dropDown.selectDropDown(addressTypeLabelAndValue.getKey(),addressTypeLabelAndValue.getValue());
    }
    public void clickOrganizationIcon() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForWebElementAndClick(organizationIcon);
        //icon.clickSearchIcon(clickOrganizationSearchIconLabelAndValue.getKey());
    }
    public void enterOrganizationName()
    {
        inputField.setInputField(organizationNameLabelAndValue.getKey(),organizationNameLabelAndValue.getValue());
    }
    public void ClickOrganizationSearch()
    {

        buttons.clickButton(organizationSearchLabelAndValue.getKey());
    }
    public void selectCompany()
    {
        buttons.clickTableButton(selectCompanyLabelAndValue.getKey());

    }
    public void selectProducerCode()
    {
        dropDown.selectDropDown(producerCodeLabelAndValue.getKey(),producerCodeLabelAndValue.getValue());
    }
    public void clickUpdate()
    {
        buttons.clickButton(clickUpdateLabelAndValue.getKey());
    }
    public void waitForAccountScreen()
    {
        label.waitForScreenHeading(waitAccountScreenLabelAndValue.getKey());
    }
    public String captureAccountNumber()
    {
        waitFor(captureAccountNo);
        return captureAccountNo.getText();

    }
    public void verifyAccountSummary()
    {
        waitForAccountScreen();
        Assert.assertTrue(captureAccountNo.isDisplayed());
        Assert.assertTrue(accountHolder.isDisplayed());

    }


}
