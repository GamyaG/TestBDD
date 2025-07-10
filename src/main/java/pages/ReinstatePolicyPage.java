package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class ReinstatePolicyPage extends BasePage{
    String reinstatePolicyPage;
    @FindBy(xpath = "//*[@id=\"JobComplete-JobCompleteScreen-JobCompleteDV-ViewPolicy\"]/div/div/div[2]")
    WebElement viewPolicy;
    public AbstractMap.SimpleEntry<String,String> startReinstatementScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> selectReasonLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickQuoteLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> quoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickReinstateLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> verifyReinstatementBoundScreenLabelAndValue;
    public ReinstatePolicyPage()
    {
        pageElementsSetup();
        reinstatePolicyPage="Reinstate Policy";
    }
    public void readTestDataForReinstatePage() throws IOException {
        startReinstatementScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"StartReinstatementScreenExists");
        selectReasonLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"SelectReason");
        clickQuoteLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"ClickQuote");
        quoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"QuoteScreenExists");
        clickReinstateLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"ClickReinstate");
        verifyReinstatementBoundScreenLabelAndValue=commonFunctions.getLabelAndValue(reinstatePolicyPage,"VerifyReinstatementBoundScreen");
    }
    public void waitForStartReinstatementScreen()
    {
        label.waitForScreenHeading(startReinstatementScreenExistsLabelAndValue.getKey());
    }
    public void selectReason()
    {
        dropDown.selectDropDown(selectReasonLabelAndValue.getKey(),selectReasonLabelAndValue.getValue());
    }
    public void clickQuote()
    {
        buttons.clickButton(clickQuoteLabelAndValue.getKey());
    }
    public void waitForQuoteScreen()
    {
        label.waitForScreenHeading(quoteScreenExistsLabelAndValue.getKey());
    }
    public void clickReinstate()
    {
        buttons.clickButton(clickReinstateLabelAndValue.getKey());
        Alert alert=getDriver().switchTo().alert();
        alert.accept();
    }
    public void verifyReinstateBoundScreen()
    {
        label.waitForScreenHeading(verifyReinstatementBoundScreenLabelAndValue.getKey());
        waitFor(viewPolicy);
        Assert.assertTrue(viewPolicy.isDisplayed());
        System.out.println(viewPolicy.getText());
    }

}
