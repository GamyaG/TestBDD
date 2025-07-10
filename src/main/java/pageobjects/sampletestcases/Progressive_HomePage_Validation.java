package pageobjects.sampletestcases;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.BasePO;

public class Progressive_HomePage_Validation extends BasePO {
    @FindBy(xpath = "/ //*[text()='Progressive Insurance')]")
    WebElement ProgressiveInsuranceText;
    @FindBy(xpath = "//*[text()='Select a product to quote']")
    WebElement SelectProductQuote;
    @FindBy(xpath = "//*[contains(text(),'Explore Products')]")
    WebElement ExploreProducts;
    @FindBy(xpath = "//*[contains(text(),'Claims')]")
    WebElement Claims;
    @FindBy(xpath = "//*[contains(text(),'About Us')]")
    WebElement AboutUs;
    @FindBy(xpath = "//*[text()='About us')]")
    WebElement Resources;
    @FindBy(xpath = "//*[contains(text(),'A leading auto insurance company, trusted since 1937')]")
    WebElement Heading_Tag;
    @FindBy(xpath = "//*[contains(text(),'Log In')]")
    WebElement Log_In;


        public void validateProgressiveInsuranceText(String expectedText) {
            String actualText = ProgressiveInsuranceText.getText();
            Assert.assertEquals( expectedText, actualText);
        }


        public void validateSelectProductQuoteText(String expectedText) {
            String actualText = SelectProductQuote.getText();
            Assert.assertEquals( expectedText, actualText);
        }
        public void validateExploreProductsText(String expectedText) {
            String actualText = ExploreProducts.getText();
            Assert.assertEquals( expectedText, actualText);
        }
        public void validateClaimsText(String expectedText) {
            String actualText = Claims.getText();
            Assert.assertEquals( expectedText, actualText);
        }
        public void validateAboutUsText(String expectedText) {
            String actualText = AboutUs.getText();
            Assert.assertEquals( expectedText, actualText);
        }
        public void validateHeadingTagText(String expectedText) {
            String actualText = Heading_Tag.getText();
            Assert.assertEquals( expectedText, actualText);
        }
        public void validateLogInText(String expectedText) {
            String actualText = Log_In.getText();
            Assert.assertEquals( expectedText, actualText);
        }

    }





