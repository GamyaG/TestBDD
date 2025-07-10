package pageobjects.sampletestcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePO;

public class GoogleSearchFunctionalityPO extends BasePO {
    String enteredData;
    @FindBy(xpath = "//*[@id=\"APjFqb\"]")
    WebElement textSearch;
    @FindBy(xpath = "//input[@value='Google Search'][1]")
    WebElement searchBtn;
    @FindBy(xpath = "//textarea[@aria-label='Search']")
    WebElement result;

    public void navigateToGoogleURL()
    {
        navigateToURL("https://www.google.co.in/");
        System.out.println("Navigate to Google URL has completed");
    }
    public void enterSearchQuery(String query)
    {
        enteredData=query;
        sendKeys(textSearch,query);
        textSearch.sendKeys(Keys.TAB);
    }
    public void clickSearchButton()
    {
        clickButton(searchBtn);
    }
    public void verifySearchResults()
    {

//        assert result.getText().contains(enteredData);
    }

}
