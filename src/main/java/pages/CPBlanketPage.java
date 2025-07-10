package pages;

import org.apache.maven.wagon.events.WagonEvent;
import org.eclipse.jetty.server.Handler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class CPBlanketPage extends BasePage{
    public String cpBlanketPage;
    @FindBy(xpath = "//*[@id=\"CLLCpBlanketPopup-CLLCpBlanketPanelSet-BlanketLocation-BlanketLocationMenuIcon\"]/div[1]")
    WebElement locationDropdown;
    @FindBy(xpath = "//*[@id=\"CLLCpBlanketPopup-CLLCpBlanketPanelSet-BlanketLocation-NewBlanketLocation\"]/div")
    WebElement newLocation;

    public AbstractMap.SimpleEntry<String,String> waitCPBlanketScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickAddLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> selectLocationLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> locationInformationScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterAddress1LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterCityLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterStateLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterZipcodeLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterAddress1ForLoc3LabelAndValue;
    public AbstractMap.SimpleEntry<String,String>  enterCityForLoc3LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterStateLoc3LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> enterZipcodeForLoc3LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> cpBlanketSubScreenExistLabelAndValue;
    public CPBlanketPage() throws IOException {
        pageElementsSetup();
        cpBlanketPage="CpBlanket";
        //readTestDataForCPBlanketPage();

    }
    public void readTestDataForCPBlanketPage() throws IOException {
        waitCPBlanketScreenLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"CpBlanketScreenExist");
        clickAddLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"ClickAdd");
        selectLocationLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"SelectLocation");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"ClickOk");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"ClickNext");
        locationInformationScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"LocationInformationScreenExists");
        enterAddress1LabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterAddress1");
        enterCityLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterCity");
        enterStateLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterState");
        enterZipcodeLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterZipcode");
        enterAddress1ForLoc3LabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterAddress1ForLoc3");
        enterCityForLoc3LabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterCityForLoc3");
        enterStateLoc3LabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterStateLoc3");
        enterZipcodeForLoc3LabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"EnterZipcodeForLoc3");
        cpBlanketSubScreenExistLabelAndValue=commonFunctions.getLabelAndValue(cpBlanketPage,"CPBlanketSubScreenExist");

    }
    public void waitForCpBlanketScreen()
    {
        label.waitForScreenHeading(waitCPBlanketScreenLabelAndValue.getKey());
    }
    public void clickAdd()
    {
        buttons.clickButton(clickAddLabelAndValue.getKey());
    }
    public void selectLocation()
    {
        dropDown.selectDropDown(selectLocationLabelAndValue.getKey(),selectLocationLabelAndValue.getValue());
    }
    public void clickOk()
    {
        buttons.clickButton(clickOkLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void waitForLocationScreen()
    {
        label.waitForScreenHeading(locationInformationScreenExistsLabelAndValue.getKey());
    }
    public void clickLocationDropdown()
    {
        waitForWebElementAndClick(locationDropdown);
    }
    public void clickNewLocation()
    {
        waitForWebElementAndClick(newLocation);
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
        inputField.setInputField(enterZipcodeLabelAndValue.getKey(),enterZipcodeLabelAndValue.getValue());
    }
    public void enterAddress1forLoc3()
    {
        inputField.setInputField(enterAddress1ForLoc3LabelAndValue.getKey(),enterAddress1ForLoc3LabelAndValue.getValue());
    }
    public void enterCityForLoc3()
    {
        inputField.setInputField(enterCityForLoc3LabelAndValue.getKey(),enterCityForLoc3LabelAndValue.getValue());
    }
    public void enterStateForLoc3()
    {
        dropDown.selectDropDown(enterStateLoc3LabelAndValue.getKey(),enterStateLoc3LabelAndValue.getValue());
    }
    public void enterZipcodeForLoc3()
    {
        inputField.setInputField(enterZipcodeForLoc3LabelAndValue.getKey(),enterZipcodeForLoc3LabelAndValue.getValue());
    }
    public void waitForCPBlanketSubScreen()
    {
        label.waitForScreenHeading(cpBlanketSubScreenExistLabelAndValue.getKey());
    }
}
