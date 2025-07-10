package pages.CC;

import pages.BasePage;

public class SearchAddressBook extends BasePage {
    public SearchAddressBook()
    {
        pageElementsSetup();
    }
    public void clickSearchAddressBookDropdown()
    {
        ccElements.clickAddressBookDropdown();
    }
    public void clickAddressBookSearch()
    {
        ccElements.clickAddressBookSearch();
    }
    public void waitForSearchAddressBookPage()
    {
        label.waitForScreenHeading("Search Address Book");
    }
    public void enterFirstNameOrLastname()
    {
        inputField.setInputField("Name/Last Name","Sample");
    }
    public void clickSearch()
    {
        buttons.clickButton("Search");
    }
    public void verifySearchContact()
    {
        ccElements.verifySearchContactDetailsLoaded();
    }
}
