package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

import static utils.RandomGenerator.firstName;
import static utils.RandomGenerator.lastName;

public class PersonalVehiclePage extends BasePage{
    public String personalVehiclePage;
    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-0-PolicyDriver-PolicyDriverMenuIcon\"]/div[1]")
    WebElement dropdownBtn;
    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-1-PolicyDriver-PolicyDriverMenuIcon\"]/div[1]")
    WebElement dropdownBtn2;
    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-2-PolicyDriver-PolicyDriverMenuIcon\"]/div[1]")
    WebElement dropdownBtn3;


    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-0-PolicyDriver-1-ContactType\"]/div")
    WebElement newPerson;
    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-1-PolicyDriver-1-ContactType\"]/div")
    WebElement newPerson1;
    @FindBy(xpath = "//*[@id=\"UALPersonalVehiclePopup-UALPersonalVehiclePanelSet-UALVehicleDriverListPanelSet-2-PolicyDriver-1-ContactType\"]/div")
    WebElement newPerson2;
    public AbstractMap.SimpleEntry<String, String> personalVehicleScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickAddLabelAndValue;

    public AbstractMap.SimpleEntry<String, String> enterAnnualMileageLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectBodyTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterYearLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectPrimaryUseLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickVehicleDriverLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> newInvolvedPartyScreenExistLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterAddress1LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterCityLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterStateLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterZIPCodeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectAddressTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterAddressForDriver2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterCityForDriver2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterZipcodeForDriver2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterCityForDriver3LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterAddressForDriver3LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterZipcodeForDriver3LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterAnnualMileageforVeh2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> enterYearForVeh2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectBodyTypeForVeh2LabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectPrimaryUseForVeh2LabelAndValue;


    public PersonalVehiclePage()
    {
        pageElementsSetup();
        personalVehiclePage="Personal Vehicle";
    }
    public void readTestDataForPersonalVehiclePage() throws IOException {
        personalVehicleScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"PersonalVehicleScreenExists");
        clickAddLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"ClickAdd");
        enterAnnualMileageLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterAnnualMileage");
        selectBodyTypeLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"SelectBodyType");
        enterYearLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterYear");
        selectPrimaryUseLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"SelectPrimaryUse");
        clickVehicleDriverLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"ClickVehicleDriver");
        newInvolvedPartyScreenExistLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"NewInvolvedPartyScreenExist");
        enterAddress1LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterAddress1");
        enterCityLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterCity");
        enterStateLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterState");
        enterZIPCodeLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterZIPCode");
        selectAddressTypeLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"SelectAddressType");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"ClickOk");
        enterAddressForDriver2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterAddressForDriver2");
        enterCityForDriver2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterCityForDriver2");
        enterZipcodeForDriver2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterZipcodeForDriver2");
        enterAddressForDriver3LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterAddressForDriver3");
        enterCityForDriver3LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterCityForDriver3");
        enterZipcodeForDriver3LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterZipcodeForDriver3");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"ClickNext");
        enterAnnualMileageforVeh2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterAnnualMileageforVeh2");
        selectBodyTypeForVeh2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"SelectBodyTypeForVeh2");
        enterYearForVeh2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"EnterYearForVeh2");
        selectPrimaryUseForVeh2LabelAndValue=commonFunctions.getLabelAndValue(personalVehiclePage,"SelectPrimaryUseForVeh2");

    }
    public void waitForPersonalVehicleScreen()
    {
        label.waitForScreenHeading(personalVehicleScreenExistsLabelAndValue.getKey());
    }
    public void clickAdd()
    {
        buttons.clickButton(clickAddLabelAndValue.getKey());
    }
    public void enterAnnualMillage()
    {
        inputField.setInputField(enterAnnualMileageLabelAndValue.getKey(),enterAnnualMileageLabelAndValue.getValue());
    }
    public void selectBodyType()
    {
        dropDown.selectDropDown(selectBodyTypeLabelAndValue.getKey(),selectBodyTypeLabelAndValue.getValue());
    }
    public void enterYear()
    {
        inputField.setInputField(enterYearLabelAndValue.getKey(),enterYearLabelAndValue.getValue());
    }
    public void selectPrimaryUse()
    {
        dropDown.selectDropDown(selectPrimaryUseLabelAndValue.getKey(),selectPrimaryUseLabelAndValue.getValue());
    }
    public void clickVehicleDriver()
    {
        tab.clickButton(clickVehicleDriverLabelAndValue.getKey());

    }
    public void clickDropdown()
    {

        waitForWebElementAndClick(dropdownBtn);
    }
    public void selectNewPerson()
    {
        waitForWebElementAndClick(newPerson);
    }
    public void waitForNewInvolvedPartyScreen()
    {
        label.waitForScreenHeading(newInvolvedPartyScreenExistLabelAndValue.getKey());
    }
    public void enterFirstname()
    {
        inputField.setInputField("First name",firstName());
    }
    public void enterLastname()
    {
        inputField.setInputField("Last name",lastName());
    }

    public void enterAddress1()
    {
        inputField.setInputField(enterAddress1LabelAndValue.getKey(),enterAddress1LabelAndValue.getValue());
    }
    public void enterCity()
    {
        inputField.setInputField(enterCityLabelAndValue.getKey(),enterCityLabelAndValue.getValue());
    }
    public void selectState()
    {
        dropDown.selectDropDown(enterStateLabelAndValue.getKey(),enterStateLabelAndValue.getValue());
    }
    public void enterZipCode()
    {
        inputField.setInputField(enterZIPCodeLabelAndValue.getKey(),enterZIPCodeLabelAndValue.getValue());
    }
    public void selectAddressType()
    {
        dropDown.selectDropDown(selectAddressTypeLabelAndValue.getKey(),selectAddressTypeLabelAndValue.getValue());
    }
    public void clickOk()
    {
        buttons.clickButton(clickOkLabelAndValue.getKey());
    }
    public void enterAddressForDriver2()
    {
        inputField.setInputField(enterAddressForDriver2LabelAndValue.getKey(),enterAddressForDriver2LabelAndValue.getValue());
    }
    public void enterCityForDriver2()
    {
        inputField.setInputField(enterCityForDriver2LabelAndValue.getKey(),enterCityForDriver2LabelAndValue.getValue());
    }
    public void enterZipCodeForDriver2()
    {
        inputField.setInputField(enterZipcodeForDriver2LabelAndValue.getKey(),enterZipcodeForDriver2LabelAndValue.getValue());
    }
    public void enterAddressForDriver3()
    {
        inputField.setInputField(enterAddressForDriver3LabelAndValue.getKey(),enterAddressForDriver3LabelAndValue.getValue());
    }
    public void enterCityForDriver3()
    {
        inputField.setInputField(enterCityForDriver3LabelAndValue.getKey(),enterCityForDriver3LabelAndValue.getValue());
    }
    public void enterZipCodeForDriver3()
    {
        inputField.setInputField(enterZipcodeForDriver3LabelAndValue.getKey(),enterZipcodeForDriver3LabelAndValue.getValue());
    }
    public void clickDropdown2()
    {
        waitForWebElementAndClick(dropdownBtn2);
    }
    public void clickDropdown3()
    {
        waitForWebElementAndClick(dropdownBtn3);
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickNewPerson1()
    {
        waitForWebElementAndClick(newPerson1);
    }
    public void clickNewPerson2()
    {
        waitForWebElementAndClick(newPerson2);
    }
    public void enterAnnualMileageForVeh2()
    {
        inputField.setInputField(enterAnnualMileageforVeh2LabelAndValue.getKey(),enterAnnualMileageforVeh2LabelAndValue.getValue());
    }
    public void selectBodyTypeForVeh2()
    {
       dropDown.selectDropDown(selectBodyTypeForVeh2LabelAndValue.getKey(),selectBodyTypeForVeh2LabelAndValue.getValue());
    }
    public void enterYearForVeh2()
    {
        inputField.setInputField(enterYearForVeh2LabelAndValue.getKey(),enterYearForVeh2LabelAndValue.getValue());
    }
    public void selectPrimaryUseForVeh2()
    {
        dropDown.selectDropDown(selectPrimaryUseForVeh2LabelAndValue.getKey(),selectPrimaryUseForVeh2LabelAndValue.getValue());
    }



}
