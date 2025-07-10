package pages.CC;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageelements.RadioButton;
import pages.BasePage;

public class SaveAndAssignClaim extends BasePage {
    private final Logger logger = LoggerFactory.getLogger(SaveAndAssignClaim.class);
    public String saveAndAssignClaim;
    @FindBy(xpath = "//*[@id=\"NewClaimSaved-NewClaimSavedScreen-NewClaimSavedDV-Header\"]")
    WebElement retrieveClaimNumber;
    public SaveAndAssignClaim()
    {
        pageElementsSetup();
        saveAndAssignClaim="SaveAndAssignClaim";
    }
    public void waitForSaveAndAssignClaimScreen()
    {
        label.waitForScreenHeading("Step 5 of 5: Save and Assign Claim");
    }
    public void clickFinish()
    {
        buttons.clickButton("Finish");
    }
    public void verifyClaimScreen()
    {
        label.waitForScreenHeading("New Claim Saved");
        String ClaimNumber=retrieveClaimNumber.getText();
        logger.info(ClaimNumber);
        Assert.assertTrue(retrieveClaimNumber.isDisplayed());
    }

}
