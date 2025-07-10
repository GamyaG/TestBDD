package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class QuotePage extends BasePage{
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-SubmissionWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-BindAndIssue\"]/div")
    WebElement issuePolicy;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-SubmissionWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-BindOnly\"]/div")
    WebElement bindOnly;
    @FindBy(xpath = "//*[@id=\"JobComplete-JobWizardInfoBar-PolicyNumber\"]/div[2]")
    WebElement capturePolicyNumber;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-SubmissionWizard_QuoteScreen-Quote_SummaryDV-PolicyPeriod\"]/div")
    WebElement policyPeriod;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-SubmissionWizard_QuoteScreen-Quote_SummaryDV-Insured\"]/div")
    WebElement primaryNameInsured;

    public String quotePage;
    public AbstractMap.SimpleEntry<String,String> waitForQuoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickBindOptionsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickBindOnlyLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickIssuePolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> waitForSubmissionBoundScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> verifySubmissionNumber;
    public AbstractMap.SimpleEntry<String, String> clickIssuePolicyForChangePolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickPremiumLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> costDetailScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickReturntoQuoteLabelAndValue;

    public QuotePage() throws IOException {
        pageElementsSetup();
        quotePage="Quote";
       // readTestDataForQuotePage();

    }
    public void readTestDataForQuotePage() throws IOException {
        waitForQuoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"QuoteScreenExists");
        clickBindOptionsLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickBindOptions");
        clickBindOnlyLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickBindOnly");
        clickIssuePolicyLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickIssue");
        waitForSubmissionBoundScreenLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"SubmissionScreenExists");
        clickIssuePolicyForChangePolicyLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickIssuePolicyForChangePolicy");
        clickPremiumLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickPremium");
        costDetailScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"CostDetailScreenExists");
        clickReturntoQuoteLabelAndValue=commonFunctions.getLabelAndValue(quotePage,"ClickReturntoQuote");

    }
    public void waitForQuotePage()
    {

        label.waitForScreenHeading(waitForQuoteScreenExistsLabelAndValue.getKey());
    }
    public void clickBindOptions()
    {

        buttons.clickButton(clickBindOptionsLabelAndValue.getKey());
    }
    public void clickBindOnly()
    {
        waitFor(bindOnly);
        waitForWebElementAndClick(bindOnly);
        Alert alert=getDriver().switchTo().alert();
        alert.accept();


    }
    public void clickIssuePolicy()
    {
        waitForWebElementAndClick(issuePolicy);
        Alert alert=getDriver().switchTo().alert();
        alert.accept();
    }
    public void waitForSubmissionBoundScreen()
    {
        label.waitForScreenHeading(waitForSubmissionBoundScreenLabelAndValue.getKey());
    }
    public void clickIssuePolicyForChangePolicy()
    {
        buttons.clickButton(clickIssuePolicyForChangePolicyLabelAndValue.getKey());
        Alert alert=getDriver().switchTo().alert();
        alert.accept();

    }
    public void verifyQuoteScreen(String firstName ,String lastName)
    {
        waitForQuotePage();
        waitFor(policyPeriod);
        waitFor(primaryNameInsured);
        String primaryName=firstName+" "+lastName;
        Assert.assertEquals(primaryNameInsured.getText(),primaryName);




    }
    public String capturePolicyNumber()
    {
        waitFor(capturePolicyNumber);
        System.out.println(capturePolicyNumber.getText());
        return capturePolicyNumber.getText();
    }
    public void clickPremium()
    {
        buttons.clickButton(clickPremiumLabelAndValue.getKey());
    }
    public void waitForCostDetailScreen()
    {
        label.waitForScreenHeading(costDetailScreenExistsLabelAndValue.getKey());
    }
    public void clickReturnToQuote()
    {

        textLink.clickTextLink(clickReturntoQuoteLabelAndValue.getKey());
    }
}
