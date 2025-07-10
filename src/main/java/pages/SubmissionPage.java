package pages;

import java.io.IOException;
import java.util.AbstractMap;

public class SubmissionPage extends BasePage{
    public String submissionPage;
    public AbstractMap.SimpleEntry<String, String> clickNewSubmissionLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> waitSubmissionScreenLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectGoCommercialProductLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectUSAPersonalAutoProductLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectHomeownersProductLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectSmallLineOfBusinessLabelAndValue;
    public AbstractMap.SimpleEntry<String, String> selectCommercialUmbrellaAndExcessLiabilityLabelAndValue;
    public SubmissionPage() throws IOException {
        pageElementsSetup();
        submissionPage="Submission";
    }
    public void readTestDataForSubmissionPage() throws IOException {

        clickNewSubmissionLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"NewSubmissionClick");
        waitSubmissionScreenLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"NewSubmissionScreen");
        selectGoCommercialProductLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"SelectGoCommercialProduct");
        selectUSAPersonalAutoProductLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"SelectUSAPersonalAutoProduct");
        selectHomeownersProductLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"SelectHomeownersProduct");
        selectSmallLineOfBusinessLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"SelectSmallLineOfBusiness");
        selectCommercialUmbrellaAndExcessLiabilityLabelAndValue=commonFunctions.getLabelAndValue(submissionPage,"SelectCommercialUmbrellaAndExcessLiability");



    }

    public void clickNewSubmission()
    {
        buttons.clickButton(clickNewSubmissionLabelAndValue.getKey());
    }
    public void waitForNewSubmissionScreen()
    {
        label.waitForScreenHeading(waitSubmissionScreenLabelAndValue.getKey());
    }
    public void selectGoCommercialProduct()
    {
        buttons.clickTableButton(selectGoCommercialProductLabelAndValue.getKey());
    }
    public void selectUSAPersonalAuto()
    {
        buttons.clickTableButton(selectUSAPersonalAutoProductLabelAndValue.getKey());
    }
    public void selectHomeOwnersProduct()
    {
        buttons.clickTableButton(selectHomeownersProductLabelAndValue.getKey());
    }
    public void selectSmallBusiness()
    {
        buttons.clickTableButton(selectSmallLineOfBusinessLabelAndValue.getKey());
    }
    public void selectCommercialUmbrellaProduct()
    {
        buttons.clickTableButton(selectCommercialUmbrellaAndExcessLiabilityLabelAndValue.getKey());
    }
}
