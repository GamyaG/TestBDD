package pages;
import org.openqa.selenium.Alert;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;
public class RewritePolicyPage extends BasePage{
  public String  rewritePolicyPage ;
  public AbstractMap.SimpleEntry<String,String> waitPolicyInfoScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> selectOrganizationTypeLabelAndValue;
    public AbstractMap.SimpleEntry<String,String>  clickNextLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> goCommercialPropertyLineScreenExist;
    public AbstractMap.SimpleEntry<String,String> outsideObjectsAndStructureLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickElectronicEquipmentBreakdownLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> electronicEquipmentBreakdownLimitLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickQuoteLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> quoteScreenExistsLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> clickIssuePolicyLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> verifyRewriteFullTermBoundLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> viewYourPolicyLabelAndValue;
  public RewritePolicyPage()
  {
      pageElementsSetup();
      rewritePolicyPage="Rewrite Policy";

  }
  public void readTestDataForRewritePolicyPage() throws IOException {
      waitPolicyInfoScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"PolicyInfoScreenExists");
      selectOrganizationTypeLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"SelectOrganizationType");
      clickNextLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ClickNext");
      goCommercialPropertyLineScreenExist=commonFunctions.getLabelAndValue(rewritePolicyPage,"GoCommercialPropertyLineScreenExist");
      outsideObjectsAndStructureLimitLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"OutsideObjectsAndStructureLimit");
      clickElectronicEquipmentBreakdownLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ClickElectronicEquipmentBreakdown");
      electronicEquipmentBreakdownLimitLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ElectronicEquipmentBreakdownLimit");
      clickQuoteLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ClickQuote");
      quoteScreenExistsLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"QuoteScreenExists");
      clickIssuePolicyLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ClickIssuePolicy");
      verifyRewriteFullTermBoundLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"VerifyRewriteFullTermBound");
      viewYourPolicyLabelAndValue=commonFunctions.getLabelAndValue(rewritePolicyPage,"ViewYourPolicy");

  }
  public void waitForPolicyInfoScreen()
  {
      label.waitForScreenHeading(waitPolicyInfoScreenExistsLabelAndValue.getKey());
  }
  public void selectOrganization()
  {
      dropDown.selectDropDown(selectOrganizationTypeLabelAndValue.getKey(),selectOrganizationTypeLabelAndValue.getValue());
  }
  public void clickNext()
  {
      buttons.clickButton(clickNextLabelAndValue.getKey());
  }
  public void goCommercialPropertyScreen()
  {
      label.waitForScreenHeading(goCommercialPropertyLineScreenExist.getKey());
  }
  public void modifyObjectAndStructureLimit()
  {
      inputField.setLimitInputField(outsideObjectsAndStructureLimitLabelAndValue.getKey(),outsideObjectsAndStructureLimitLabelAndValue.getValue());
  }
  public void clickElectronicEquipmentBreakdown()
  {
      checkbox.selectCheckbox(clickElectronicEquipmentBreakdownLabelAndValue.getKey());
  }
  public void enterElectronicEquipmentBreakdownLimit()
  {
      inputField.setLimitInputField(electronicEquipmentBreakdownLimitLabelAndValue.getKey(),electronicEquipmentBreakdownLimitLabelAndValue.getValue());
  }
  public void clickQuote()
  {
      buttons.clickButton(clickQuoteLabelAndValue.getKey());
  }
  public void waitForQuoteScreen()
  {
      label.waitForScreenHeading(quoteScreenExistsLabelAndValue.getKey());
  }
  public void clickIssuePolicy()
  {
      buttons.clickButton(clickIssuePolicyLabelAndValue.getKey());
      Alert alert=getDriver().switchTo().alert();
      alert.accept();
  }
  public void verifyRewriteFullTermBound()
  {
    String value= label.waitForScreenHeading(verifyRewriteFullTermBoundLabelAndValue.getKey());
      Assert.assertEquals(value,"Rewrite Full Term Bound");

  }
}
