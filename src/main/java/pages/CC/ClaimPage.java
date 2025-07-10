package pages.CC;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class ClaimPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab\"]/div[3]")
    WebElement claimDropdown;
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab-ClaimTab_FNOLWizard\"]/div")
    WebElement newClaim;
    public ClaimPage()
    {
        pageElementsSetup();
    }
    public void clickClaimDropdown()
    {
        waitForWebElementAndClick(claimDropdown);
    }
    public void clickNewClaim()
    {
        waitForWebElementAndClick(newClaim);
    }
    public void enterClaim()
    {
        inputField.setInputField("Claim #:","000-00-004241");
        ccElements.clickClaimSearchIcon();
    }
    public void verifyClaimSummaryDetailsLoaded()
    {
        label.waitForScreenHeading("Summary");
        ccElements.verifyClaimSummary();

    }
    public void clickActions()
    {
        buttons.clickButton("Actions");
    }
    public void moveToOther()
    {
        ccElements.moveToOther();
    }
    public void clickRecovery()
    {
        ccElements.clickRecovery();
    }






}

