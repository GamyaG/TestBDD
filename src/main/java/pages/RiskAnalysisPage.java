package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.AbstractMap;

public class RiskAnalysisPage extends BasePage{
 public String riskAnalysisPage;
// @FindBy(xpath = "//div[@role='heading' and contains(.,'Risk Approval Details')]")
// WebElement riskApprovalDetailsPage;
// @FindBy(xpath = "//div[@role='button' and contains(., 'OK')]")
// WebElement ok;
 @FindBy(xpath = "//*[@id='SubmissionWizard-Job_RiskAnalysisScreen-RiskAnalysisCV-RiskEvaluationPanelSet-1-UWIssueRowSet-Approve']")
 WebElement approve;

 public AbstractMap.SimpleEntry<String,String> waitForRiskAnalysisScreenLabelAndValue;
 public AbstractMap.SimpleEntry<String,String> clickQuoteLabelAndValue;
 public AbstractMap.SimpleEntry<String,String> policyReviewScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickOkLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>clickBackLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>quoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> riskApprovalDetailsScreenExistsLabelAndValue;
    public RiskAnalysisPage() throws IOException {
        pageElementsSetup();
        riskAnalysisPage="RiskAnalysis";
        //readTestDataForRiskAnalysisPage();
    }
    public void readTestDataForRiskAnalysisPage() throws IOException {
        waitForRiskAnalysisScreenLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"RiskAnalysisScreenExists");
        clickQuoteLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"ClickQuote");
        policyReviewScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"PolicyReviewScreenExists");
        clickNextLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"ClickNext");
        clickBackLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"ClickBack");
        quoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"QuoteScreenExists");
        clickOkLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"ClickOk");
        riskApprovalDetailsScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(riskAnalysisPage,"RiskApprovalDetailsScreenExists");
    }
    public void waitForRiskAnalysisScreen()
    {
        label.waitForScreenHeading(waitForRiskAnalysisScreenLabelAndValue.getKey());
    }
    public void clickQuote()
    {
        buttons.clickButton(clickQuoteLabelAndValue.getKey());

    }
    public void clickOk()
    {
        buttons.clickButton(clickOkLabelAndValue.getKey());
    }
    public void clickNext()
    {
        buttons.clickButton(clickNextLabelAndValue.getKey());
    }
    public void clickBack()
    {
        buttons.clickButton(clickBackLabelAndValue.getKey());
    }
    public void policyReviewScreen()
    {
        label.waitForScreenHeading(policyReviewScreenExistsLabelAndValue.getKey());
    }
    public void waitForQuoteScreen()
    {
        label.waitForScreenHeading(quoteScreenExistsLabelAndValue.getKey());
    }
    public void waitForRiskAnalysisDetailScreen()
    {
        label.waitForScreenHeading(riskApprovalDetailsScreenExistsLabelAndValue.getKey());

    }
    public void acceptUnderWriterIssue()
    {
        waitForQuoteScreen();
        clickBack();
        policyReviewScreen();
        clickBack();
        waitForRiskAnalysisScreen();
        waitForWebElementAndClick(approve);
        waitForRiskAnalysisDetailScreen();
        clickOk();
        waitForRiskAnalysisScreen();
        clickNext();
        policyReviewScreen();
        clickNext();
    }
}
