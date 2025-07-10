package pages.CC;

import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class StepSecondBasicInformation extends BasePage {

    public StepSecondBasicInformation()
    {
        pageElementsSetup();
    }
    public void waitForStep2BasicInformation()
    {
        label.waitForScreenHeading("Step 2 of 5: Basic information");
    }
    public void selectName()
    {
        dropDown.selectDropDownByIndex("Name",1);
    }
    public void selectRelationToInsured()
    {
        dropDown.selectDropDown("Relation to Insured","Self/Insured");
    }
    public void clickNext()
    {
        buttons.clickButton("Next");
    }

}
