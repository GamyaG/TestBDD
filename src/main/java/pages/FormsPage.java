package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.AbstractMap;

public class FormsPage extends BasePage{
    public String formsPage;
    public FormsPage()
    {
        pageElementsSetup();
        formsPage="Forms";
    }
    public AbstractMap.SimpleEntry<String,String> clickFormLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> formsScreenExistLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> form1LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> form2LabelAndValue;
    public AbstractMap.SimpleEntry<String,String> form1DescriptionLabelAndValue;
    public AbstractMap.SimpleEntry<String,String> form2DescriptionLabelAndValue;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-FormsScreen-FormsDV-FormsLV-0-FormNumber\"]/div/div")
    WebElement form1No;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-FormsScreen-FormsDV-FormsLV-1-FormNumber\"]/div/div")
    WebElement form2No;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-FormsScreen-FormsDV-FormsLV-0-Description\"]/div/div")
    WebElement form1Description;
    @FindBy(xpath = "//*[@id=\"SubmissionWizard-FormsScreen-FormsDV-FormsLV-1-Description\"]/div/div")
    WebElement form2Description;
    public void readTestDataForFormsPage() throws IOException {
        clickFormLabelAndValue=commonFunctions.getLabelAndValue(formsPage,"ClickForm");
        formsScreenExistLabelAndValue=commonFunctions.getLabelAndValue(formsPage,"FormsScreenExist");
        form1LabelAndValue=commonFunctions.getLabelAndValue(formsPage,"Form1");
        form2LabelAndValue=commonFunctions.getLabelAndValue(formsPage,"Form2");
        form1DescriptionLabelAndValue=commonFunctions.getLabelAndValue(formsPage,"Form1Description");
        form2DescriptionLabelAndValue=commonFunctions.getLabelAndValue(formsPage,"Form2Description");
    }
    public void clickForms()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        menuItem.clickMenuItem(clickFormLabelAndValue.getKey());
    }
    public void waitForFormScreen()
    {

        label.waitForScreenHeading(formsScreenExistLabelAndValue.getKey());
    }
    public void verifyForm1()
    {
        Assert.assertEquals(form1LabelAndValue.getValue(),form1No.getText());
    }
    public void verifyForm2()
    {
        Assert.assertEquals(form2LabelAndValue.getValue(),form2No.getText());
    }
    public void verifyForm1Description()
    {
        Assert.assertEquals(form1DescriptionLabelAndValue.getValue(),form1Description.getText());
    }
    public void verifyForm2Description()
    {
        Assert.assertEquals(form2DescriptionLabelAndValue.getValue(),form2Description.getText());
    }
}
