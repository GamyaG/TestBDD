package pages.CC;

import pages.BasePage;

public class SearchRecoveries extends BasePage {
    public SearchRecoveries()
    {
        pageElementsSetup();
    }
    public void waitForSearchRecoveriesScreen()
    {
        label.waitForScreenHeading("Search Recoveries");
    }
    public void enterClaimNumber()
    {
        inputField.setInputField("Claim Number","000-00-004241");
    }
    public void clickSearch()
    {
        buttons.clickButton("Search");
    }
    public void verifySearchRecoveriesLoaded()
    {
        ccElements.verifySearchRecoveriesLoaded();

    }
}
