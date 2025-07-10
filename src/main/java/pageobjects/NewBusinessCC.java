package pageobjects;

import pages.BasePage;
import pages.CC.*;
import utils.TestRunConfig;

import java.io.IOException;

public class NewBusinessCC extends BasePage {
    SearchORCreatePolicyPage searchORCreatePolicyPage;
    ClaimPage claimPage;
    StepSecondBasicInformation stepSecondBasicInformation;
    AddClaimInformation addClaimInformation;
    ServicesPage servicesPage;
    SaveAndAssignClaim saveAndAssignClaim;
    SearchClaims searchClaims;
    SearchRecoveries searchRecoveries;
    CreateRecovery createRecovery;
    AddNotes addNotes;
    SearchAddressBook searchAddressBook;
    SearchChecks searchChecks;

    public NewBusinessCC(SearchORCreatePolicyPage searchORCreatePolicyPage, ClaimPage claimPage, StepSecondBasicInformation stepSecondBasicInformation, AddClaimInformation addClaimInformation, ServicesPage servicesPage,SaveAndAssignClaim saveAndAssignClaim,SearchClaims searchClaims,SearchRecoveries searchRecoveries,CreateRecovery createRecovery,AddNotes addNotes,SearchAddressBook searchAddressBook,SearchChecks searchChecks)
    {
        pageElementsSetup();
        this.searchORCreatePolicyPage=searchORCreatePolicyPage;
        this.claimPage=claimPage;
        this.stepSecondBasicInformation=stepSecondBasicInformation;
        this.addClaimInformation=addClaimInformation;
        this.servicesPage=servicesPage;
        this.saveAndAssignClaim=saveAndAssignClaim;
        this.searchClaims=searchClaims;
        this.searchRecoveries=searchRecoveries;
        this.createRecovery=createRecovery;
        this.addNotes=addNotes;
        this.searchAddressBook=searchAddressBook;
        this.searchChecks=searchChecks;

    }
    public void navigateToCCURL()
    {
        navigateToURL(TestRunConfig.BASE_URL1);
    }
    public void enterValidCredentials()
    {
        inputField.setInputField("Username","su");
        inputField.setInputField("Password","gw");
        buttons.clickButton("Log In");

    }
    public void createNewFNOL()
    {
        claimPage.clickClaimDropdown();
        claimPage.clickNewClaim();
        try {
            searchORCreatePolicyPage.readTestDataForSearchOrCreatePolicy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        searchORCreatePolicyPage.waitForSearchOrCreatePolicyScreen();
                searchORCreatePolicyPage.selectCreateUnverifiedPolicy();
                searchORCreatePolicyPage.enterPolicyNumber();
                searchORCreatePolicyPage.selectType();
                searchORCreatePolicyPage.selectTypeOfClaim();
                searchORCreatePolicyPage.enterLossDate();
                searchORCreatePolicyPage.enterEffectiveDate();
                searchORCreatePolicyPage.enterExpirationDate();
                searchORCreatePolicyPage.clickNameDropdown();
                searchORCreatePolicyPage.clickNewPerson();
                searchORCreatePolicyPage.waitForNewPerson();
                searchORCreatePolicyPage.enterLastname();
                searchORCreatePolicyPage.clickUpdate();
                searchORCreatePolicyPage.clickNext();
        stepSecondBasicInformation.waitForStep2BasicInformation();
        stepSecondBasicInformation.selectName();
        stepSecondBasicInformation.selectRelationToInsured();
        stepSecondBasicInformation.clickNext();
        addClaimInformation.waitForAddClaimInformation();
                addClaimInformation.selectLossCause();
                addClaimInformation.enterCity();
                addClaimInformation.selectState();
                addClaimInformation.clickNext();
        try {
            servicesPage.readTestDataForServicesPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        servicesPage.waitForServicePage();
        servicesPage.clickNext();
        saveAndAssignClaim.waitForSaveAndAssignClaimScreen();
                saveAndAssignClaim.clickFinish();






    }
    public void verifyFNOLAddedSuccessfully()
    {
        saveAndAssignClaim.verifyClaimScreen();

    }
    public void searchPolicyInClaims()
    {
        searchClaims.clickSearchDropdown();
        searchClaims.clickClaim();
        searchClaims.clickSimpleSearch();
        searchClaims.waitForSearchClaimScreen();
        searchClaims.enterPolicyNumber();
        searchClaims.clickSearch();

    }
    public void verifyClaimDetailsLoadedSuccessfully()
    {
        searchClaims.verifyPolicyClaim();
    }
    public void searchForClaim()
    {
        claimPage.clickClaimDropdown();
        claimPage.enterClaim();
    }
    public void verifyClaimLoadedSuccessfully()
    {
        claimPage.verifyClaimSummaryDetailsLoaded();
    }
    public void createRecovery()
    {
        claimPage.clickActions();
        claimPage.moveToOther();
        claimPage.clickRecovery();
        createRecovery.waitForCreateRecoveryScreen();
        createRecovery.selectPayer();
        createRecovery.selectReserveLine();
        createRecovery.selectRecoveryCategory();
        createRecovery.enterAmount();
        createRecovery.clickUpdate();
        createRecovery.waitForTransactionScreen();
        createRecovery.verifyRecoveryLoaded();


    }
    public void searchRecovery()
    {
        searchRecoveries.waitForSearchRecoveriesScreen();
        searchRecoveries.enterClaimNumber();
        searchRecoveries.clickSearch();
    }
    public void verifyRecoveriesLoaded()
    {
        searchRecoveries.verifySearchRecoveriesLoaded();
    }
    public void createNote()
    {
        addNotes.clickNote();
        addNotes.waitForNotesScreen();
        addNotes.clickNewNote();
        addNotes.selectTopic();
        addNotes.selectRelatedTo();
        addNotes.enterText();
        addNotes.clickUpdate();
    }
    public void verifyNoteLoaded()
    {
        addNotes.verifyNoteAdded();
    }
    public void searchContact()
    {
        searchAddressBook.clickSearchAddressBookDropdown();
        searchAddressBook.clickAddressBookSearch();
        searchAddressBook.waitForSearchAddressBookPage();
        searchAddressBook.enterFirstNameOrLastname();
        searchAddressBook.clickSearch();


    }
    public void verifyContactDetailsLoaded()
    {
        searchAddressBook.verifySearchContact();
    }
    public void searchCheck()
    {
       searchClaims.clickSearchDropdown();
       searchClaims.clickCheck();
       searchChecks.waitForSearchChecks();
       searchChecks.enterClaimNumber();
       searchChecks.clickSearch();
    }
    public void verifyCheckLoaded()
    {
        searchChecks.verifyCheckLoaded();
    }



}
