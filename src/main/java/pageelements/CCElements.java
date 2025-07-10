package pageelements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.BasePO;
import pages.BasePage;

import javax.swing.*;

public class CCElements extends BasePO {
    @FindBy(xpath = "//*[@id=\"TabBar-SearchTab\"]/div[3]")
    WebElement searchDropIcon;
    @FindBy(xpath = "//*[@id=\"TabBar-SearchTab-Search_ClaimSearchesGroup\"]/div[1]")
    WebElement searchClaim;
    @FindBy(xpath = "//*[@id=\"TabBar-SearchTab-Search_ClaimSearchesGroup-ClaimSearchesGroup_SimpleClaimSearch\"]/div")
    WebElement simpleSearch;
    @FindBy(xpath = "//*[@id=\"SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchResultsLV-0-ClaimNumber_button\"]")
    WebElement verifyClaimNumber;
    @FindBy(xpath = "//*[@id=\"SimpleClaimSearch-SimpleClaimSearchScreen-SimpleClaimSearchResultsLV-0-PolicyID\"]/div/div")
    WebElement verifyPolicyNumber;
    @FindBy(xpath = "//*[@id=\"Claim-ClaimInfoBar-PolicyNumber\"]/div[2]")
    WebElement verifyClaimPolicySummaryScreen;
    @FindBy(xpath = "//*[@id=\"ClaimSummary-ClaimSummaryScreen-LossDate\"]/div/div")
    WebElement verifyLossClaimScreen;
    @FindBy(xpath = "//*[@id=\"TabBar-ClaimTab-ClaimTab_FindClaim_Button\"]")
    WebElement claimSearchIcon;
    @FindBy(xpath = "//*[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewTransaction-ClaimMenuActions_NewOtherTrans\"]/div[1]")
    WebElement other;
    @FindBy(xpath = "//*[@id=\"Claim-ClaimMenuActions-ClaimMenuActions_NewTransaction-ClaimMenuActions_NewOtherTrans-ClaimMenuActions_NewTransaction_RecoverySet\"]/div")
    WebElement recovery;
    @FindBy(xpath = "//*[@id=\"ClaimFinancialsTransactions-ClaimFinancialsTransactionsScreen-TransactionsLVRangeInput\"]/div/div/select")
    WebElement recoveriesVerify;
    @FindBy(xpath = "//*[@id=\"l--3\"]")
    WebElement verifyAmount;
    @FindBy(xpath = "//*[@id=\"TabBar-SearchTab-Search_RecoverySearch\"]/div")
    WebElement clickSearchRecovery;
    @FindBy(xpath = "//*[@id=\"RecoverySearch-RecoverySearchScreen-RecoverySearchResultsLV--label\"]")
    WebElement verifySearchRecoveries;
    @FindBy(xpath = "//*[@id=\"l--43\"]")
    WebElement verifyRecoveryAmount;
    @FindBy(xpath = "//*[@id=\"Claim-MenuLinks-Claim_ClaimNotes\"]/div")
    WebElement notes;
    @FindBy(xpath = "//*[@id=\"ClaimNotes-NotesSearchScreen-ClaimNotesLV--label\"]")
    WebElement verifyNote;
    @FindBy(xpath = "//*[@id=\"ClaimNotes-NotesSearchScreen-ClaimNotesLV-0-Topic\"]/div/div")
    WebElement verifytopic;
    @FindBy(xpath = "//*[@id=\"TabBar-AddressBookTab\"]/div[3]")
    WebElement clickAddressBook;
    @FindBy(xpath = "//*[@id=\"TabBar-AddressBookTab-AddressBook_AddressBookSearch\"]/div")
    WebElement addressBookSearch;
    @FindBy(xpath = "//*[@id=\"AddressBookSearch-AddressBookSearchScreen-AddressBookSearchLV-0-DisplayName_button\"]")
    WebElement verifySearchContactName;
    @FindBy(xpath = "//*[@id=\"TabBar-SearchTab-Search_PaymentSearch\"]/div")
    WebElement clickChecks;
    @FindBy(xpath = "//*[@id=\"PaymentSearch-PaymentSearchScreen-CheckSearchResultsLV-0-PayTo_button\"]")
    WebElement verifyCheckName;
    public void clickSearchDropIcon()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitForWebElementAndClick(searchDropIcon);
    }
    public void clickSearchClaim()
    {
        Actions action = new Actions(getDriver());
        action.moveToElement(searchClaim).build().perform();

    }
    public void clickSimpleSearch()
    {
        waitForWebElementAndClick(simpleSearch);
    }
    public void verifyRelatedClaimAndPolicy()
    {
        Assert.assertTrue(verifyClaimNumber.isDisplayed());
        Assert.assertTrue(verifyPolicyNumber.isDisplayed());
    }
    public void verifyClaimSummary()
    {
        Assert.assertTrue(verifyClaimPolicySummaryScreen.isDisplayed());
        Assert.assertTrue(verifyLossClaimScreen.isDisplayed());
    }
    public void clickClaimSearchIcon()
    {
        waitForWebElementAndClick(claimSearchIcon);
    }
    public void moveToOther()
    {
        Actions a = new Actions(getDriver());
        JavascriptExecutor exe = (JavascriptExecutor) getDriver();
        exe.executeScript("arguments[0].scrollIntoView()", other);
        a.moveToElement(other).pause(1000).perform();


    }
    public void clickRecovery()
    {
        waitForWebElementAndClick(recovery);
    }
    public void verifyRecoveries()
    {
        Assert.assertEquals(recoveriesVerify.getText(),"Recoveries");
        Assert.assertTrue(verifyAmount.isDisplayed());
    }
    public void clickSearchRecovery()
    {
        waitForWebElementAndClick(clickSearchRecovery);
    }
    public void verifySearchRecoveriesLoaded()
    {
        Assert.assertEquals(verifySearchRecoveries.getText(),"Search Results");
        Assert.assertTrue(verifyRecoveryAmount.isDisplayed());

    }
    public void clickNotes()
    {
        waitForWebElementAndClick(notes);
    }
    public void verifyNoteAdded()
    {
        Assert.assertTrue(verifyNote.isDisplayed());
        Assert.assertTrue(verifytopic.isDisplayed());
    }
    public void clickAddressBookDropdown()
    {
        waitForWebElementAndClick(clickAddressBook);
    }
    public void clickAddressBookSearch()
    {
        waitForWebElementAndClick(addressBookSearch);
    }
    public void verifySearchContactDetailsLoaded()
    {
        Assert.assertTrue(verifySearchContactName.isDisplayed());
    }
    public void clickChecks()
    {
        waitForWebElementAndClick(clickChecks);
    }
    public void verifyCheck()
    {
        Assert.assertTrue(verifyCheckName.isDisplayed());
    }




}
