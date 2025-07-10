package pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class CancelPage extends BasePage{
    public String cancelPage;
    @FindBy(xpath = "//*[@id=\"CancellationWizard-CancellationWizard_QuoteScreen-JobWizardToolbarButtonSet-BindOptions-CancelNow\"]/div")
    WebElement cancelNow;
    @FindBy(xpath = "//*[@id=\"PolicyFile_Summary-PolicyOverviewDashboard-PolicyDetailsDetailViewTile-Badge\"]")
    WebElement statusOfPolicy;
    public AbstractMap.SimpleEntry<String, String> waitForCancelPolicyScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectSourceLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectReasonLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickStartCancellationLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> confirmationScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickBindOptionsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> cancellationBoundScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> clickPolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> policySummaryExistsLabelAndValue;


    public CancelPage()
    {
        pageElementsSetup();
        cancelPage="Cancel Policy";
    }
    public void readTestDataForCancelPage() throws IOException {
        waitForCancelPolicyScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"CancelPolicyScreenExists");
        selectSourceLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"SelectSource");
        selectReasonLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"SelectReason");
        clickStartCancellationLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"ClickStartCancellation");
        confirmationScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"ConfirmationScreenExists");
        clickBindOptionsLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"ClickBindOptions");
        cancellationBoundScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"CancellationBoundScreenExists");
        clickPolicyLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"ClickPolicy");
        policySummaryExistsLabelAndValue=commonFunctions.getLabelAndValue(cancelPage,"PolicySummaryExists");
    }
    public void waiForCancelPolicyScreen()
    {
        label.waitForScreenHeading(waitForCancelPolicyScreenExistsLabelAndValue.getKey());
    }
    public void selectSource()
    {
        dropDown.selectDropDown(selectSourceLabelAndValue.getKey(),selectSourceLabelAndValue.getValue());
    }
    public void selectResource()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dropDown.selectDropDown(selectReasonLabelAndValue.getKey(),selectReasonLabelAndValue.getValue());
    }
    public void clickStartCancellation()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        buttons.clickButton(clickStartCancellationLabelAndValue.getKey());
    }
    public void waitForConfirmationScreen()
    {
        label.waitForScreenHeading(confirmationScreenExistsLabelAndValue.getKey());
    }
    public void clickBindOptions()
    {
        buttons.clickButton(clickBindOptionsLabelAndValue.getKey());
    }
    public void clickCancelNow()
    {
        waitForWebElementAndClick(cancelNow);
        Alert alert=getDriver().switchTo().alert();
        alert.accept();
    }
    public void waitForCancellationBoundScreen()
    {
        label.waitForScreenHeading(cancellationBoundScreenExistsLabelAndValue.getKey());
    }
    public void clickPolicy()
    {
        textLink.clickTextLink(clickPolicyLabelAndValue.getKey());
    }
    public void verifyPolicyStatus()
    {
        label.waitForScreenHeading(policySummaryExistsLabelAndValue.getKey());
        waitFor(statusOfPolicy);
        Assert.assertEquals(statusOfPolicy.getText(),"Canceled");
    }

}
