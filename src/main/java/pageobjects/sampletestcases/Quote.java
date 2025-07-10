package pageobjects.sampletestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.BasePO;
import utils.JsonDataReader;

public class Quote extends BasePO {
    JsonDataReader jsonDataReader;
    public Quote()
    {
        jsonDataReader=new JsonDataReader("src//main//resources//JSONFiles//Tricentis.json");
    }

    @FindBy(xpath = "//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span")
    WebElement selectPriceOption;
    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement email;
    @FindBy(xpath = "//*[@id=\"phone\"]")
    WebElement phone;
    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement username;
    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"confirmpassword\"]")
    WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"nextsendquote\"]")
    WebElement next;
    @FindBy(xpath = "//*[@id=\"sendemail\"]")
    WebElement send;
    @FindBy(xpath = "/html/body/div[4]/h2")
    WebElement successMessage;
    public void selectPrice()
    {
        clickButton(selectPriceOption);
        clickButton(next);

    }
    public void sendQuote()
    {
        setInputField(email,jsonDataReader.getNestedString("Quote","Email"));
        setInputField(phone,jsonDataReader.getNestedString("Quote","Phone"));
        setInputField(username,jsonDataReader.getNestedString("Quote","Username"));
        String passwordValue=jsonDataReader.getNestedString("Quote","Password");
        setInputField(password,passwordValue);
        setInputField(confirmPassword,passwordValue);
        clickButton(send);
    }
    public void verifyQuoteSuccessMessage()
    {
        waitFor(successMessage);
        String actualMessage = successMessage.getText();
        String expectedMessage = jsonDataReader.getNestedString("Quote","SuccessMessage");
        Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch!");

    }


}
