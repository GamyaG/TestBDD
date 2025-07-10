package pages.CC;

import pages.BasePage;

public class AddClaimInformation extends BasePage {
    public AddClaimInformation()
    {
        pageElementsSetup();
    }
    public void waitForAddClaimInformation()
    {
        label.waitForScreenHeading("Step 3 of 5: Add claim information");
    }
    public void selectLossCause()
    {
        dropDown.selectDropDown("Loss Cause","Explosion");
    }
    public void enterCity()
    {
        inputField.setInputField("City","Dallas");
    }
    public void selectState()
    {
        dropDown.selectDropDown("State","Texas");
    }
    public void clickNext()
    {
        buttons.clickButton("Next");
    }




}
