package pages;

import java.io.IOException;
import java.util.AbstractMap;

public class LocationPage extends BasePage {
    public String locationPage;
    public AbstractMap.SimpleEntry<String,String> waitForLocationScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickAddLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> addressOfLocationLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> cpBuildingScreenExistsLabelAndValue;

    public AbstractMap.SimpleEntry<String,String> buildingDescriptionLabelAndValue;

    public AbstractMap.SimpleEntry<String,String> clickOkLabelAndValue;

    public AbstractMap.SimpleEntry<String,String> addBuildingDescription2LabelAndValue;

    public AbstractMap.SimpleEntry<String,String> addBuildingDescription3LabelAndValue;



    public LocationPage() throws IOException {
        pageElementsSetup();
        locationPage="Location";

    }
    public void readTestDataForLocationPage() throws IOException {
        waitForLocationScreenLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"LocationScreenExist");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"ClickNext");
        clickAddLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"ClickAdd");
        addressOfLocationLabelAndValue =commonFunctions.getLabelAndValue(locationPage,"AddressOfLocation");
        cpBuildingScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"CPBuildingScreenExists");
        buildingDescriptionLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"BuildingDescription");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(locationPage,"ClickOk");
        addBuildingDescription2LabelAndValue=commonFunctions.getLabelAndValue(locationPage,"AddBuildingDescription2");
        addBuildingDescription3LabelAndValue=commonFunctions.getLabelAndValue(locationPage,"AddBuildingDescription3");


    }
    public void waitForLocationScreen()
    {
        label.waitForScreenHeading(waitForLocationScreenLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickAdd()
    {
        buttons.clickButton(clickAddLabelAndValue.getKey());
    }
    public void selectAddressOfLocation()
    {
        dropDown.selectDropDown(addressOfLocationLabelAndValue.getKey(),addressOfLocationLabelAndValue.getValue());
    }
    public void waitForCPBuildingScreen()
    {
        label.waitForScreenHeading(cpBuildingScreenExistsLabelAndValue.getKey());
    }
    public void enterBuildingDescription()
    {
        inputField.setInputField(buildingDescriptionLabelAndValue.getKey(),buildingDescriptionLabelAndValue.getValue());
    }
    public void clickOK()
    {
        buttons.clickButton(clickOkLabelAndValue.getKey());
    }
    public void addBuildingDescription2()
    {
        inputField.setInputField(addBuildingDescription2LabelAndValue.getKey(),addBuildingDescription2LabelAndValue.getValue());
    }
    public void addBuildingDescription3()
    {
        inputField.setInputField(addBuildingDescription3LabelAndValue.getKey(),addBuildingDescription3LabelAndValue.getValue());
    }

}
