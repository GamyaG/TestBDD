package pageobjects.sampletestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePO;

public class Progressive_Auto_Insurance_PO extends BasePO {
    @FindBy(xpath="//*[@id=\"NameEdit_embedded_questions_list_FirstName\"]")
    WebElement FirstName;
    @FindBy(xpath="//*[@id=\"NameEdit_embedded_questions_list_LastName\"]")
    WebElement LastName;
    @FindBy(xpath="//*[@id=\"NameEdit_embedded_questions_list_PrimaryEmailAddress\"]")
    WebElement PrimaryMailAddress;

    @FindBy(xpath="//*[text()='Continue']")
    WebElement Continue_Button;
    @FindBy(xpath="//*[@id=\"AddressEdit_embedded_questions_list_MailingAddress\"]")
    WebElement StreetName;
    @FindBy(xpath="//*[@id=\"AddressEdit_embedded_questions_list_City\"]")
    WebElement City;
    @FindBy(xpath="//*[text()='Ok, start my quote']")
    WebElement Ok_StartMyQuoteButton;
    @FindBy(xpath="//*[text()='Add another vehicle?']")
    WebElement AddVehicleButton;
    @FindBy(xpath="//*[text()='Enter by VIN']")
    WebElement EnterByVin;

    public void enterFirstName(String fname) {
    }

}
