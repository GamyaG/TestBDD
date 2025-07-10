package pageobjects;

import helper.DataTable;
import helper.ExcelWriter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;
import utils.TestRunConfig;

import java.io.IOException;

public class NewBusiness extends BasePage {
   public String accountNumber;
   String  policyNumber;
   String firstname;
   String lastname;
   String captureAddress;
   String updatedAddress;
    @FindBy(xpath = "//*[@id=\"Login-LoginScreen-LoginDV-submit\"]/div")
    WebElement login;
    AccountPage accountPage;
    SubmissionPage submissionPage;
    PolicyInfoPage policyInfoPage;
    CPBlanketPage cpBlanketPage;
    LocationPage locationPage;
    RiskAnalysisPage riskAnalysisPage;
    QuotePage quotePage;
    PolicyPage policyPage;
    CancelPage cancelPage;
    ChangePolicyPage changePolicyPage;
    ReinstatePolicyPage reinstatePolicyPage;
    RewritePolicyPage rewritePolicyPage;
    GoCommercialPropertyLinePage goCommercialPropertyLinePage;
    USAPersonalAutoPage usaPersonalAutoPage;
    PersonalVehiclePage personalVehiclePage;
    GWHomeOwnersLinePage gwHomeOwnersLinePage;
    SmallBusinessPage smallBusinessPage;
    RenewalSBP renewalSBP;
    RenewalHOP renewalHOP;
    RenewalCUPPage renewalCUPPage;
    CommercialUmbrellaPage commercialUmbrellaPage;
    public NewBusiness(AccountPage accountPage, SubmissionPage submissionPage, PolicyInfoPage policyInfoPage, GoCommercialPropertyLinePage goCommercialPropertyLinePage,CPBlanketPage cpBlanketPage,LocationPage locationPage,RiskAnalysisPage riskAnalysisPage,QuotePage quotePage,PolicyPage policyPage,  CancelPage cancelPage,ChangePolicyPage changePolicyPage, ReinstatePolicyPage reinstatePolicyPage,RewritePolicyPage rewritePolicyPage,USAPersonalAutoPage usaPersonalAutoPage,PersonalVehiclePage personalVehiclePage, GWHomeOwnersLinePage gwHomeOwnersLinePage,SmallBusinessPage smallBusinessPage,RenewalSBP renewalSBP,RenewalHOP renewalHOP,CommercialUmbrellaPage commercialUmbrellaPage,RenewalCUPPage renewalCUPPage)
    {
        pageElementsSetup();
        this.accountPage=accountPage;
        this.submissionPage=submissionPage;
        this.policyInfoPage=policyInfoPage;
        this.goCommercialPropertyLinePage=goCommercialPropertyLinePage;
        this.cpBlanketPage=cpBlanketPage;
        this.locationPage=locationPage;
        this.riskAnalysisPage=riskAnalysisPage;
        this.quotePage=quotePage;
        this.policyPage=policyPage;
        this.cancelPage=cancelPage;
        this.changePolicyPage=changePolicyPage;
        this.reinstatePolicyPage=reinstatePolicyPage;
        this.rewritePolicyPage=rewritePolicyPage;
        this.usaPersonalAutoPage=usaPersonalAutoPage;
        this.personalVehiclePage=personalVehiclePage;
        this.gwHomeOwnersLinePage=gwHomeOwnersLinePage;
        this.smallBusinessPage=smallBusinessPage;
        this.renewalSBP=renewalSBP;
        this.renewalHOP=renewalHOP;
        this.commercialUmbrellaPage=commercialUmbrellaPage;
        this.renewalCUPPage=renewalCUPPage;
    }

    public void navigateToPCURL()
    {
        navigateToURL(TestRunConfig.BASE_URL);
    }
    public void enterValidCredentials()
    {
        inputField.setInputField("Username","su");
        inputField.setInputField("Password","gw");
        buttons.clickButton("Log In");

    }
    public void createPersonalAccount()
    {
        try {
            accountPage.readTestDataForAccountPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountPage.clickAccountDropdown();
        accountPage.clickNewAccount();
        firstname=  accountPage.enterFirstname();
        lastname=accountPage.enterLastname();
        accountPage.clickSearch();
        accountPage.clickCreateNewAccount();
        accountPage.clickPerson();
        accountPage.enterAddress1();
        accountPage.enterCity();
        accountPage.selectState();
        accountPage.enterZipCode();
        accountPage.selectAddressType();
        accountPage.clickOrganizationIcon();
        accountPage.enterOrganizationName();
        accountPage.ClickOrganizationSearch();
        accountPage.selectCompany();
        accountPage.selectProducerCode();
        accountPage.clickUpdate();
        accountPage.waitForAccountScreen();
    }
    public void verifyAccountDetails()
    {
        try {
            accountPage.readTestDataForAccountPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountPage.verifyAccountSummary();


    }

    public void openAccountAndClickNewSubmission() {
        try {
            accountPage.readTestDataForAccountPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        accountPage.clickAccountDropdown();
        accountPage.clickNewAccount();
      firstname=  accountPage.enterFirstname();
        lastname=accountPage.enterLastname();
        accountPage.clickSearch();
        accountPage.clickCreateNewAccount();
        accountPage.clickPerson();
       accountPage.enterAddress1();
       accountPage.enterCity();
       accountPage.selectState();
       accountPage.enterZipCode();
       accountPage.selectAddressType();
       accountPage.clickOrganizationIcon();
       accountPage.enterOrganizationName();
       accountPage.ClickOrganizationSearch();
       accountPage.selectCompany();
       accountPage.selectProducerCode();
       accountPage.clickUpdate();
       accountPage.waitForAccountScreen();
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.clickNewSubmission();
       submissionPage.waitForNewSubmissionScreen();



    }
    public void selectGoCommercialProduct()
    {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.selectGoCommercialProduct();
    }
    public void enterDetailsPolicyInfo()
    {
        try {
            policyInfoPage.readTestDataForPolicyInfoPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyInfoPage.waitForPolicyInfoScreen();
        policyInfoPage.selectOrganizationType();
        policyInfoPage.clickNext();

    }
    public void addGoCommercialCoverages()
    {
        try {
            goCommercialPropertyLinePage.readTestDataForGoCommercialPropertyLinePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        goCommercialPropertyLinePage.waitForGoCommercialPropertyScreen();
        goCommercialPropertyLinePage.clickOutsideObjectAndStructureCheckbox();
        goCommercialPropertyLinePage.enterOutsideObjectAndStructureLimit();
        goCommercialPropertyLinePage.enterOutsideObjectAndStructureDeductible();
        goCommercialPropertyLinePage.clickEachLossCausedByWindCheckbox();
        goCommercialPropertyLinePage.enterEachLossCausedByWindLimit();
        goCommercialPropertyLinePage.enterEachLossCausedByWindDeductible();
        goCommercialPropertyLinePage.clickNext();

    }
    public void addCpBlanket()
    {
        try {
            cpBlanketPage.readTestDataForCPBlanketPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cpBlanketPage.waitForCpBlanketScreen();
        cpBlanketPage.clickAdd();
        cpBlanketPage.selectLocation();
        cpBlanketPage.clickOk();
        cpBlanketPage.clickNext();
    }
    public void proceedNextInLocation()
    {
        try {
            locationPage.readTestDataForLocationPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        locationPage.waitForLocationScreen();
        locationPage.clickNext();

    }
    public void createCommercialPolicy()
    {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.clickNewSubmission();
        submissionPage.waitForNewSubmissionScreen();
        selectGoCommercialProduct();
        enterDetailsPolicyInfo();
        addGoCommercialCoverages();
        addCpBlanket();
        proceedNextInLocation();
        clickQuote();
        clickIssuePolicy();
        verifySubmissionBoundScreen();


    }

    public void clickQuote()
    {
        try {
            riskAnalysisPage.readTestDataForRiskAnalysisPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        riskAnalysisPage.waitForRiskAnalysisScreen();
        riskAnalysisPage.clickQuote();
        riskAnalysisPage.acceptUnderWriterIssue();


    }
    public void clickBindPolicy()
    {
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.waitForQuotePage();
        quotePage.clickBindOptions();
        quotePage.clickBindOnly();

    }
    public void clickIssuePolicy()
    {
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.waitForQuotePage();
        quotePage.clickBindOptions();
        quotePage.clickIssuePolicy();
    }
    public String verifySubmissionBoundScreen()
    {
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.waitForSubmissionBoundScreen();
      policyNumber=  quotePage.capturePolicyNumber();
        System.out.println("Generated PolicyNumber"+policyNumber);
        writeDataToExcel();
      return policyNumber;
    }

    public void searchPolicy()
    {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickPolicyDropdown();
        policyPage.enterPolicyNumber(policyNumber);
        policyPage.waitForPolicySummaryScreen();
    }
    public void verifyPolicyDetails()
    {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.verifyPolicyDetails();
    }
    public void startNewTransaction()
    {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickNewTransaction();
    }
    public void cancelPolicy()
    {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickCancelPolicy();
    }
    public void enterRequiredDataCancelScreen()
    {
        try {
            cancelPage.readTestDataForCancelPage();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        cancelPage.waiForCancelPolicyScreen();
        cancelPage.selectSource();
        cancelPage.selectResource();


    }
    public void clickCancelNow()
    {
        try {
            cancelPage.readTestDataForCancelPage();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        cancelPage.clickStartCancellation();
        cancelPage.waitForConfirmationScreen();
        cancelPage.clickBindOptions();
        cancelPage.clickCancelNow();

    }
    public void verifyPolicyCancellationStatus()
    {
        try {
            cancelPage.readTestDataForCancelPage();
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
        cancelPage.waitForCancellationBoundScreen();
        cancelPage.clickPolicy();
        cancelPage.verifyPolicyStatus();

    }
    public void changePolicyTransaction() {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickChangePolicy();
        try {
            changePolicyPage.readTestDataForChangePolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       changePolicyPage.waitForStartPolicyChangeScreen();
        changePolicyPage.clickNext();
        changePolicyPage.waitForPolicyInfoScreen();
       // changePolicyPage.captureAddress();
        changePolicyPage.clickPolicyAddress();
        changePolicyPage.clickNewAddress();
        changePolicyPage.waitForAddressDetailScreen();
        changePolicyPage.enterAddress1();
        changePolicyPage.enterCity();
        changePolicyPage.selectState();
        changePolicyPage.enterZipCode();
        changePolicyPage.selectAddressType();
        changePolicyPage.clickOk();
        changePolicyPage.waitForPolicyInfoScreen();
     captureAddress=   changePolicyPage.captureAddress();
        changePolicyPage.clickQuote();
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.clickIssuePolicyForChangePolicy();
        changePolicyPage.waitForPolicyBoundScreen();
        changePolicyPage.clickPolicy();
        changePolicyPage.waitForPolicySummaryScreen();
        updatedAddress=   changePolicyPage.captureUpdatedAddress();







    }
    public void verifyAddressUpdated()
    {
        try {
            changePolicyPage.readTestDataForChangePolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        changePolicyPage.verifyChangeInAddress(captureAddress,updatedAddress);
    }
    public void writeDataToExcel()
    {
        String[] rowData={firstname,lastname,"New York",policyNumber};
        DataTable dataTable = new DataTable();
        dataTable.addRow(rowData);
        try {
            ExcelWriter.writeExcel("src/main/resources/WorkBooks/PolicyNumbersData.xlsx", dataTable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void cancelPolicyTransaction()
    {
        cancelPolicy();
        enterRequiredDataCancelScreen();
        clickCancelNow();
        verifyPolicyCancellationStatus();
    }
    public void reinstatePolicyTransaction()  {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickNewTransaction();
        policyPage.clickReinstatePolicy();
        try {
            reinstatePolicyPage.readTestDataForReinstatePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        reinstatePolicyPage.waitForStartReinstatementScreen();
        reinstatePolicyPage.selectReason();
        reinstatePolicyPage.clickQuote();
        reinstatePolicyPage.waitForQuoteScreen();
        reinstatePolicyPage.clickReinstate();



    }
    public void verifyReinstateBound()
    {
        try {
            reinstatePolicyPage.readTestDataForReinstatePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        reinstatePolicyPage.verifyReinstateBoundScreen();
    }
    public void rewritePolicyTransaction()
    {
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickNewTransaction();
        policyPage.clickReWritePolicy();
        try {
            rewritePolicyPage.readTestDataForRewritePolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        rewritePolicyPage.waitForPolicyInfoScreen();
        rewritePolicyPage.selectOrganization();
        rewritePolicyPage.clickNext();
        rewritePolicyPage.goCommercialPropertyScreen();
        rewritePolicyPage.modifyObjectAndStructureLimit();
        rewritePolicyPage.clickQuote();
        rewritePolicyPage.waitForQuoteScreen();
        rewritePolicyPage.clickIssuePolicy();
        rewritePolicyPage.verifyRewriteFullTermBound();

    }
    public void selectPremiumAndBackToQuoteScreen()
    {
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.clickPremium();
        quotePage.waitForCostDetailScreen();
        quotePage.clickReturnToQuote();
    }
    public void verifyQuoteSubmission()
    {
        try {
            quotePage.readTestDataForQuotePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        quotePage.verifyQuoteScreen(firstname,lastname);
    }
    public void addMultipleLocation()
    {
        try {
            cpBlanketPage.readTestDataForCPBlanketPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cpBlanketPage.waitForCpBlanketScreen();
        cpBlanketPage.clickAdd();
        cpBlanketPage.selectLocation();
        cpBlanketPage.clickOk();
        cpBlanketPage.waitForCpBlanketScreen();
        cpBlanketPage.clickAdd();
        cpBlanketPage.clickLocationDropdown();
        cpBlanketPage.clickNewLocation();
        cpBlanketPage.waitForLocationScreen();
        cpBlanketPage.enterAddress1();
        cpBlanketPage.enterCity();
        cpBlanketPage.selectState();
        cpBlanketPage.enterZipCode();
        cpBlanketPage.clickOk();
        cpBlanketPage.waitForCPBlanketSubScreen();
        cpBlanketPage.clickOk();
        cpBlanketPage.waitForCpBlanketScreen();
        cpBlanketPage.clickAdd();
        cpBlanketPage.clickLocationDropdown();
        cpBlanketPage.clickNewLocation();
        cpBlanketPage.enterAddress1forLoc3();
        cpBlanketPage.enterCityForLoc3();
        cpBlanketPage.enterStateForLoc3();
        cpBlanketPage.enterZipcodeForLoc3();
        cpBlanketPage.clickOk();
        cpBlanketPage.waitForCPBlanketSubScreen();
        cpBlanketPage.clickOk();
        cpBlanketPage.waitForCpBlanketScreen();
        cpBlanketPage.clickNext();

    }
    public void selectPersonalAuto() {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.selectUSAPersonalAuto();
    }
    public void addsUSAPersonalAutoStandardCoverages()
    {
        try {
            usaPersonalAutoPage.readTestDataForUSAPersonalAutoPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        usaPersonalAutoPage.waitForUSAPersonalAutoScreen();
        usaPersonalAutoPage.clickPersonAutoStandardCoverageTab();
        usaPersonalAutoPage.clickMedicalPaymentCheckbox();
        usaPersonalAutoPage.enterMedicalPayment();
        usaPersonalAutoPage.selectCoordinateBenefits();
        usaPersonalAutoPage.clickUnderInsuredCheckbox();
        usaPersonalAutoPage.selectUMBILimit();
        usaPersonalAutoPage.selectStackedLimits();
        usaPersonalAutoPage.clickNext();

    }
    public void addDriverVehicleDetails()
    {
        try {
            personalVehiclePage.readTestDataForPersonalVehiclePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.enterAnnualMillage();
        personalVehiclePage.selectBodyType();
        personalVehiclePage.enterYear();
        personalVehiclePage.selectPrimaryUse();
        personalVehiclePage.clickVehicleDriver();
        personalVehiclePage.clickAdd();
        personalVehiclePage.clickDropdown();
        personalVehiclePage.selectNewPerson();
        personalVehiclePage.waitForNewInvolvedPartyScreen();
        personalVehiclePage.enterFirstname();
        personalVehiclePage.enterLastname();
        personalVehiclePage.enterAddress1();
        personalVehiclePage.enterCity();
        personalVehiclePage.selectState();
        personalVehiclePage.enterZipCode();
        personalVehiclePage.selectAddressType();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickNext();


    }
    public void addMultipleDrivers()
    {
        try {
            personalVehiclePage.readTestDataForPersonalVehiclePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.enterAnnualMillage();
        personalVehiclePage.selectBodyType();
        personalVehiclePage.enterYear();
        personalVehiclePage.selectPrimaryUse();
        personalVehiclePage.clickVehicleDriver();
        personalVehiclePage.clickAdd();
        personalVehiclePage.clickDropdown();
        personalVehiclePage.selectNewPerson();
        personalVehiclePage.waitForNewInvolvedPartyScreen();
        personalVehiclePage.enterFirstname();
        personalVehiclePage.enterLastname();
        personalVehiclePage.enterAddress1();
        personalVehiclePage.enterCity();
        personalVehiclePage.selectState();
        personalVehiclePage.enterZipCode();
        personalVehiclePage.selectAddressType();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.clickDropdown2();
        personalVehiclePage.clickNewPerson1();
        personalVehiclePage.waitForNewInvolvedPartyScreen();
        personalVehiclePage.enterFirstname();
        personalVehiclePage.enterLastname();
        personalVehiclePage.enterAddressForDriver2();
        personalVehiclePage.enterCityForDriver2();
        personalVehiclePage.selectState();
        personalVehiclePage.enterZipCodeForDriver2();
        personalVehiclePage.selectAddressType();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.clickDropdown3();
        personalVehiclePage.clickNewPerson2();
        personalVehiclePage.waitForNewInvolvedPartyScreen();
        personalVehiclePage.enterFirstname();
        personalVehiclePage.enterLastname();
        personalVehiclePage.enterAddressForDriver3();
        personalVehiclePage.enterCityForDriver3();
        personalVehiclePage.selectState();
        personalVehiclePage.enterZipCodeForDriver3();
        personalVehiclePage.selectAddressType();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickNext();

    }
    public void addMultipleVehicles()
    {
        try {
            personalVehiclePage.readTestDataForPersonalVehiclePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.enterAnnualMillage();
        personalVehiclePage.selectBodyType();
        personalVehiclePage.enterYear();
        personalVehiclePage.selectPrimaryUse();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickAdd();
        personalVehiclePage.enterAnnualMileageForVeh2();
        personalVehiclePage.selectBodyTypeForVeh2();
        personalVehiclePage.enterYearForVeh2();
        personalVehiclePage.selectPrimaryUseForVeh2();
        personalVehiclePage.clickOk();
        personalVehiclePage.waitForPersonalVehicleScreen();
        personalVehiclePage.clickNext();


    }
    public void addMultipleBuildings()
    {
        try {
            locationPage.readTestDataForLocationPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        locationPage.waitForLocationScreen();
        locationPage.clickAdd();
        locationPage.waitForLocationScreen();
        locationPage.selectAddressOfLocation();
        locationPage.clickAdd();
        locationPage.waitForCPBuildingScreen();
        locationPage.enterBuildingDescription();
        locationPage.clickOK();
        locationPage.waitForLocationScreen();
        locationPage.clickAdd();
        locationPage.waitForCPBuildingScreen();
        locationPage.addBuildingDescription2();
        locationPage.clickOK();
        locationPage.waitForLocationScreen();
        locationPage.clickAdd();
        locationPage.waitForCPBuildingScreen();
        locationPage.addBuildingDescription3();
        locationPage.clickOK();
        locationPage.waitForLocationScreen();
        locationPage.clickOK();
        locationPage.clickNext();






    }
    public void selectHomeOwnersLine()
    {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.selectHomeOwnersProduct();
    }
    public void proceedWithoutCompletingHomeownersInfo() {
        try {
            gwHomeOwnersLinePage.readTestDataForGWHomeownersLinePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gwHomeOwnersLinePage.waitForGWHomeownersLineScreen();
        gwHomeOwnersLinePage.clickNext();
        gwHomeOwnersLinePage.clickCoverageIITab();
        gwHomeOwnersLinePage.clickQuote();

    }
    public void verifyErrorMessagesOnCoveragesScreen()
    {
        try {
            gwHomeOwnersLinePage.readTestDataForGWHomeownersLinePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gwHomeOwnersLinePage.verifyUIErrorMessage();
    }
    public void selectSmallBusinessProduct()
    {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.selectSmallBusiness();
    }
    public void addsSmallBusinessCoverages()
    {
        try {
            smallBusinessPage.readTestDataForSmallBusinessPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        smallBusinessPage.waitForSmallBusinessScreen();
        smallBusinessPage.selectBusinessType();
        smallBusinessPage.clickSmallBusinessCoverages();
        smallBusinessPage.selectGeneralLiabilityCheckbox();
        smallBusinessPage.selectGeneralLiabilityOccurrenceLimit();
        smallBusinessPage.selectGeneralLiabilityAggregateLimit();
        smallBusinessPage.selectGeneralLiabilityDeductibleLimit();
        smallBusinessPage.selectMedicalExpenses();
        smallBusinessPage.selectPAICheckbox();
        smallBusinessPage.selectPAILimit();
        smallBusinessPage.selectPAIDeductible();
        smallBusinessPage.clickNext();



    }
    public void initiateSmallBusinessPolicyRenewal()
    {
        openAccountAndClickNewSubmission();
        selectSmallBusinessProduct();
        enterDetailsPolicyInfo();
        addsSmallBusinessCoverages();
        clickQuote();
        clickIssuePolicy();
      policyNumber=  verifySubmissionBoundScreen();
        searchPolicy();
        startNewTransaction();
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickRenewPolicy();

    }
    public void initiatesHomeOwnersPolicyRenewal()
    {
        openAccountAndClickNewSubmission();
        selectHomeOwnersLine();
        enterDetailsPolicyInfo();
        addHomeownersCoverages();
        clickQuote();
        clickIssuePolicy();
        policyNumber=  verifySubmissionBoundScreen();
        searchPolicy();
        startNewTransaction();
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickRenewPolicy();

    }
    public void initiatesCommercialUmbrellaPolicyRenewal()
    {
        openAccountAndClickNewSubmission();
        selectCommercialUmbrellaProduct();
        enterDetailsPolicyInfo();
        addCommercialUmbrellaCoverages();
        clickQuote();
        clickIssuePolicy();
        policyNumber=  verifySubmissionBoundScreen();
        searchPolicy();
        startNewTransaction();
        try {
            policyPage.readTestDataForPolicyPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        policyPage.clickRenewPolicy();


    }

    public void editTransactionForSmallBusiness()
    {
        try {
            renewalSBP.readTestDataForRenewalSBP();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalSBP.waitForPolicyInfoScreen();
        renewalSBP.clickNext();
        renewalSBP.waitForSmallBusinessScreen();
        renewalSBP.clickBack();
        renewalSBP.waitForPolicyInfoScreen();
        renewalSBP.clickEditPolicyTransaction();

        renewalSBP.clickNext();
        renewalSBP.waitForSmallBusinessScreen();

    }
    public void addUpdateCoveragesForSBP()
    {
        try {
            renewalSBP.readTestDataForRenewalSBP();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalSBP.waitForSmallBusinessScreen();
        renewalSBP.selectBusinessType();
        renewalSBP.clickSmallBusinessCoverages();
        renewalSBP.selectGeneralLiabilityOccurrenceLimit();
        renewalSBP.selectGeneralLiabilityAggregateLimit();
        renewalSBP.selectGeneralLiabilityDeductibleLimit();
        renewalSBP.selectMedicalExpenses();
        renewalSBP.selectPAILimit();
        renewalSBP.selectPAIDeductible();
        renewalSBP.clickNext();
    }
  public void renewalPolicyForSBP()
  {
      try {
          renewalSBP.readTestDataForRenewalSBP();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      renewalSBP.waitForViewQuoteScreen();
      renewalSBP.clickBindOptions();
      renewalSBP.clickRenew();
      renewalSBP.waitForRenewalDataEntryScreen();
      renewalSBP.selectRenewal();
      renewalSBP.clickOk();
      renewalSBP.waitForRenewalRenewing();

  }
  public void verifyRenewalScreen()
  {
      renewalSBP.verifyRenewalScreen();
  }
  public void addHomeownersCoverages()
  {
      try {
          gwHomeOwnersLinePage.readTestDataForGWHomeownersLinePage();
      } catch (IOException e) {
          throw new RuntimeException(e);
      }
      gwHomeOwnersLinePage.waitForGWHomeownersLineScreen();
      gwHomeOwnersLinePage.selectRefusalType();
      gwHomeOwnersLinePage.clickCoverageIITab();
      gwHomeOwnersLinePage.clickCoverageEPersonalLiabilityCheckbox();
      gwHomeOwnersLinePage.selectCoverageELimit();
      gwHomeOwnersLinePage.selectPersonalInjury();
      gwHomeOwnersLinePage.clickCoverageFMedicalPaymentCheckbox();
      gwHomeOwnersLinePage.selectCoverageFMedicalPaymentLimit();
      gwHomeOwnersLinePage.clickNext();
  }
    public void editTransactionAndUpdateHomeOwnersCoverages() {
        try {
            renewalHOP.readTestDataForRenewalHOP();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalHOP.waitForPolicyInfoScreen();
        renewalHOP.clickNext();
        renewalHOP.waitForGWHomeownersLineScreen();
        renewalHOP.clickBack();
        renewalHOP.waitForPolicyInfoScreen();
        renewalHOP.clickEditPolicyTransaction();
        renewalHOP.clickNext();
        renewalHOP.waitForGWHomeownersLineScreen();
        renewalHOP.selectRefusalType();
        renewalHOP.clickCoverageIITab();
        renewalHOP.selectCoverageELimit();
        renewalHOP.selectPersonalInjury();
        renewalHOP.selectCoverageFMedicalPaymentLimit();
        renewalHOP.clickNext();


    }
    public void editTransactionAndUpdateCommercialUmbrellaCoverages()  {

        try {
            renewalCUPPage.readTestDataForRenewalCUPPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalCUPPage.waitForPolicyInfoScreen();
        renewalCUPPage.clickNext();
        renewalCUPPage.waitForCommercialUmbrellaAndExcessLiabilityScreen();
        renewalCUPPage.clickBack();
        renewalCUPPage.waitForPolicyInfoScreen();
        renewalCUPPage.clickEditPolicyTransaction();
        renewalCUPPage.clickNext();
        renewalCUPPage.waitForCommercialUmbrellaAndExcessLiabilityScreen();
        renewalCUPPage.selectUmbrellaLiabilityOrExcessLiability();
        renewalCUPPage.clickClear();
        if(renewalCUPPage.retrieveUmbrellaCoveragesData().equalsIgnoreCase("Yes"))
        {
            renewalCUPPage.clickUmbrellaCoveragesTab();
            renewalCUPPage.selectOccurrenceLimit();
            renewalCUPPage.selectAggregateLimit();
            renewalCUPPage.selectProductAndCompletedOperationsAggregateLimit();
            renewalCUPPage.selectUmbrellaCoverageForm();
            renewalCUPPage.selectSelfInsuredRetention();
            renewalCUPPage.clickClear();

        } else if (renewalCUPPage.retrieveExcessLiabilityData().equalsIgnoreCase("Yes")) {
            renewalCUPPage.clickExcessLiabilityCoverages();
            renewalCUPPage.selectOccurrenceLimitForEL();
            renewalCUPPage.selectAggregateLimitForEL();
            renewalCUPPage.selectProductAndCompletedOperationsAggregateLimitEL();
            renewalCUPPage.selectExcessLiabilityCoverageForm();

        }
        renewalCUPPage.clickNext();
        renewalCUPPage.underlyingPoliciesScreen();
        renewalCUPPage.clickNext();

    }

    public void renewalPolicyForHOP()
    {
        try {
            renewalHOP.readTestDataForRenewalHOP();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalHOP.waitForViewQuoteScreen();
        renewalHOP.clickBindOptions();
        renewalHOP.clickRenew();
        renewalHOP.waitForRenewalDataEntryScreen();
        renewalHOP.selectRenewal();
        renewalHOP.clickOk();
        renewalHOP.waitForRenewalRenewing();

    }
    public void renewalPolicyForCUP()
    {
        try {
            renewalCUPPage.readTestDataForRenewalCUPPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        renewalCUPPage.waitForViewQuoteScreen();
        renewalCUPPage.clickBindOptions();
        renewalCUPPage.clickRenew();
        renewalCUPPage.waitForRenewalDataEntryScreen();
        renewalCUPPage.selectRenewal();
        renewalCUPPage.clickOk();
        renewalCUPPage.waitForRenewalRenewing();

    }
    public void selectCommercialUmbrellaProduct()
    {
        try {
            submissionPage.readTestDataForSubmissionPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        submissionPage.selectCommercialUmbrellaProduct();

    }
    public void addCommercialUmbrellaCoverages()
    {
        try {
            commercialUmbrellaPage.readTestDataForCommercialUmbrellaPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        commercialUmbrellaPage.waitForCommercialUmbrellaAndExcessLiabilityScreen();
        commercialUmbrellaPage.selectUmbrellaLiabilityOrExcessLiability();
        commercialUmbrellaPage.clickClear();
        if(commercialUmbrellaPage.retrieveUmbrellaCoveragesData().equalsIgnoreCase("Yes"))
        {
            commercialUmbrellaPage.clickUmbrellaCoveragesTab();
            commercialUmbrellaPage.selectOccurrenceLimit();
            commercialUmbrellaPage.selectAggregateLimit();
            commercialUmbrellaPage.selectProductAndCompletedOperationsAggregateLimit();
            commercialUmbrellaPage.selectUmbrellaCoverageForm();
            commercialUmbrellaPage.selectSelfInsuredRetention();
            commercialUmbrellaPage.clickClear();

        } else if (commercialUmbrellaPage.retrieveExcessLiabilityData().equalsIgnoreCase("Yes")) {
            commercialUmbrellaPage.clickExcessLiabilityCoverages();
            commercialUmbrellaPage.selectOccurrenceLimitForEL();
            commercialUmbrellaPage.selectAggregateLimitForEL();
            commercialUmbrellaPage.selectProductAndCompletedOperationsAggregateLimitEL();
            commercialUmbrellaPage.selectExcessLiabilityCoverageForm();

        }
        commercialUmbrellaPage.clickNext();
        commercialUmbrellaPage.underlyingPoliciesScreen();
        commercialUmbrellaPage.clickNext();
    }






}
