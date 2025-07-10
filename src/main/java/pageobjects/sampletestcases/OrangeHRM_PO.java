package pageobjects.sampletestcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.BasePO;
import utils.JsonDataReader;
import utils.RandomGenerator;


public class OrangeHRM_PO extends BasePO {
    JsonDataReader jsonDataReader;
    String Firstname;
    String Lastname;
    public OrangeHRM_PO()
    {
        jsonDataReader=new JsonDataReader("src//main//resources//JSONFiles//OrangeHRM.json");
    }
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    WebElement userName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    WebElement password;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    WebElement submit;
    @FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")
    WebElement dashboardScreen;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement PIM;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[3]")
    WebElement addEmployeeTab;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
    WebElement firstName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")
    WebElement lastName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    WebElement employeeId;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement save;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]")
    WebElement verifyProfile;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    WebElement profileName;

    public void launchOrangeHRMURL()
    {
        navigateToURL("https://opensource-demo.orangehrmlive.com/");
    }
    public void loginWithValidCredentials()
    {
        waitFor(userName);
        String Username=jsonDataReader.getString("Username");
        sendKeys(userName,Username);
        String Password=jsonDataReader.getString("Password");
        waitFor(password);
        sendKeys(password,Password);
        waitForWebElementAndClick(submit);
    }
    public void navigateToAddEmployeePage()
    {
        waitFor(dashboardScreen);
        waitForWebElementAndClick(PIM);
    }
    public void fillEmployeeDetails()
    {
        waitForWebElementAndClick(addEmployeeTab);
        Firstname=jsonDataReader.getString("Firstname");
        waitFor(firstName);
        sendKeys(firstName,Firstname);
        Lastname=jsonDataReader.getString("Lastname");
        waitFor(lastName);
        sendKeys(lastName,Lastname);
        String employeeID= RandomGenerator.numeric(4);
        waitFor(employeeId);
        employeeId.clear();
        sendKeys(employeeId,employeeID);
    }
    public void saveEmployeeDetails()
    {
        waitForWebElementAndClick(save);
        waitForInvisibleElement();
    }
    public void verifyEmployeeAdded()
    {
        waitFor(verifyProfile);
        waitFor(profileName);
        String verifyName=Firstname+" "+Lastname;
        System.out.println(verifyName);
        Assert.assertEquals(profileName.getText(),verifyName);
    }

}
