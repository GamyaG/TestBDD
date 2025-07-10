package pages.CC;

import pages.BasePage;

public class SearchClaims extends BasePage {
    String policyNumber="8901022416";
    public SearchClaims()
    {
        pageElementsSetup();
    }

    public void clickSearchDropdown()
    {
        ccElements.clickSearchDropIcon();

    }
    public void clickCheck()
    {
        ccElements.clickChecks();
    }
    public void clickClaim()
    {

        ccElements.clickSearchClaim();
    }
    public void clickSimpleSearch()
    {
        ccElements.clickSimpleSearch();

    }
    public void waitForSearchClaimScreen()
    {
        label.waitForScreenHeading("Search Claims");
    }
    public void enterPolicyNumber()
    {
        inputField.setInputField("Policy #","8901022416");
    }
    public void clickSearch()
    {
        buttons.clickButton("Search");
    }
    public void verifyPolicyClaim()
    {
        ccElements.verifyRelatedClaimAndPolicy();

    }


}
