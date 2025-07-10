package pageobjects.sampletestcases;

import helper.DropDownHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePO;
import utils.JsonDataReader;

public class ProductData extends BasePO {
    DropDownHelper dropDownHelper;
    JsonDataReader jsonDataReader;
    public ProductData(DropDownHelper dropDownHelper)
    {
        this.dropDownHelper=dropDownHelper;
        jsonDataReader=new JsonDataReader("src//main//resources//JSONFiles//Tricentis.json");
    }
    @FindBy(xpath = "//*[@id=\"startdate\"]")
    WebElement startDate;
    @FindBy(xpath = "//*[@id=\"insurancesum\"]")
    WebElement insuranceSum;
    @FindBy(xpath = "//*[@id=\"meritrating\"]")
    WebElement meritRating;
    @FindBy(xpath = "//*[@id=\"damageinsurance\"]")
    WebElement damageInsurance;
    @FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span")
    WebElement optionalProduct;
    @FindBy(xpath = "//*[@id=\"courtesycar\"]")
    WebElement courtesyCar;
    @FindBy(xpath = "//*[@id=\"nextselectpriceoption\"]")
    WebElement next;
    @FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[3]/div[4]/p/label[1]/span")
    WebElement euroProtection;
    public void enterProductData()
    {
        setInputField(startDate,jsonDataReader.getNestedString("ProductData","StartDate"));
        waitFor(insuranceSum);
        dropDownHelper.SelectUsingVisibleValue(insuranceSum,jsonDataReader.getNestedString("ProductData","InsuranceSum"));
        waitFor(meritRating);
        dropDownHelper.SelectUsingVisibleValue(meritRating,jsonDataReader.getNestedString("ProductData","MeritRating"));
        waitFor(damageInsurance);
        dropDownHelper.SelectUsingVisibleValue(damageInsurance,jsonDataReader.getNestedString("ProductData","DamageInsurance"));
        clickButton(optionalProduct);
        waitFor(courtesyCar);
        dropDownHelper.SelectUsingVisibleValue(courtesyCar,jsonDataReader.getNestedString("ProductData","CourtesyCar"));
        clickButton(next);

    }
    public void enterProductDataForTruckProduct()
    {
        setInputField(startDate,jsonDataReader.getNestedString("ProductData","StartDate"));
        waitFor(insuranceSum);
        dropDownHelper.SelectUsingVisibleValue(insuranceSum,jsonDataReader.getNestedString("ProductData","InsuranceSum"));
        waitFor(damageInsurance);
        dropDownHelper.SelectUsingVisibleValue(damageInsurance,jsonDataReader.getNestedString("ProductData","DamageInsurance"));
        clickButton(euroProtection);
        clickButton(next);

    }

}
