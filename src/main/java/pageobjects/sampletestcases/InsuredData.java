package pageobjects.sampletestcases;

import helper.DropDownHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePO;
import utils.JsonDataReader;
import utils.RandomGenerator;

public class InsuredData extends BasePO {
    DropDownHelper dropDownHelper;
    JsonDataReader jsonDataReader;
    public InsuredData(DropDownHelper dropDownHelper)
    {
        this.dropDownHelper=dropDownHelper;
        jsonDataReader=new JsonDataReader("src//main//resources//JSONFiles//Tricentis.json");
    }
    @FindBy(xpath = "//*[@id=\"firstname\"]")
    WebElement firstname;
    @FindBy(xpath = "//*[@id=\"lastname\"]")
    WebElement lastname;
    @FindBy(xpath = "//*[@id=\"birthdate\"]")
    WebElement birthDate;
    @FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[2]/span")
    WebElement gender;
    @FindBy(xpath = "//*[@id=\"streetaddress\"]")
    WebElement streetAddress;
    @FindBy(xpath = "//*[@id=\"country\"]")
    WebElement country;
    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    WebElement zipcode;
    @FindBy(xpath = "//*[@id=\"city\"]")
    WebElement city;
    @FindBy(xpath = "//*[@id=\"occupation\"]")
    WebElement occupation;
//    @FindBy(xpath = "//*[@id=\"speeding\"]")
//    WebElement hobbies;
    @FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[1]/span")
    WebElement hobbies;
    @FindBy(xpath = "//*[@id=\"nextenterproductdata\"]")
    WebElement next;
    public void enterInsuredData()
    {
        setInputField(firstname, jsonDataReader.getNestedString("InsuredData","Firstname"));
        setInputField(lastname,jsonDataReader.getNestedString("InsuredData","Lastname"));
        setInputField(birthDate,jsonDataReader.getNestedString("InsuredData","BirthDate"));
        clickButton(gender);
        setInputField(streetAddress,jsonDataReader.getNestedString("InsuredData","StreetAddress"));
        waitFor(country);
        dropDownHelper.SelectUsingVisibleValue(country,jsonDataReader.getNestedString("InsuredData","Country"));
        setInputField(zipcode,jsonDataReader.getNestedString("InsuredData","Zipcode"));
        setInputField(city,jsonDataReader.getNestedString("InsuredData","City"));
        waitFor(occupation);
        dropDownHelper.SelectUsingVisibleValue(occupation,jsonDataReader.getNestedString("InsuredData","Occupation"));
        waitFor(hobbies);
        waitForWebElementAndClick(hobbies);
        clickButton(next);



    }

}
