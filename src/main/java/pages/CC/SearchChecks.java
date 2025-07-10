package pages.CC;

import pages.BasePage;

public class SearchChecks extends BasePage {
    public SearchChecks()
    {
        pageElementsSetup();
    }
    public void waitForSearchChecks()
    {
        label.waitForScreenHeading("Search Checks");
    }
    public void enterClaimNumber()
    {
        inputField.setInputField("Claim Number","000-00-004253");
    }
    public void clickSearch()
    {
        buttons.clickButton("Search");
    }
    public void verifyCheckLoaded()
    {
        ccElements.verifyCheck();
    }
}
