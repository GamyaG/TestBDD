package pageobjects.sampletestcases;

import helper.DropDownHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BasePO;
import utils.JsonDataReader;

public class VehicleData extends BasePO {
    DropDownHelper dropDownHelper;
    JsonDataReader jsonDataReader;
    public VehicleData(DropDownHelper dropDownHelper)
    {
        this.dropDownHelper=dropDownHelper;
        jsonDataReader=new JsonDataReader("src//main//resources//JSONFiles//Tricentis.json");
    }
    @FindBy(xpath = "//*[@id=\"nav_automobile\"]")
    WebElement automobileProduct;
    @FindBy(xpath = "//*[@id=\"nav_truck\"]")
    WebElement truck;
    @FindBy(xpath = "//*[@id=\"nav_motorcycle\"]")
    WebElement motorcycle;
    @FindBy(xpath = "//*[@id=\"make\"]")
    WebElement make;
    @FindBy(xpath = "//*[@id=\"engineperformance\"]")
    WebElement enginePerformance;
    @FindBy(xpath = "//*[@id=\"dateofmanufacture\"]")
    WebElement dateOfManufacture;
    @FindBy(xpath = "//*[@id=\"numberofseats\"]")
    WebElement numberOfSeats;
    @FindBy(xpath = "//*[@id=\"fuel\"]")
    WebElement fuelType;
    @FindBy(xpath = "//*[@id=\"listprice\"]")
    WebElement listPrice;
    @FindBy(xpath = "//*[@id=\"licenseplatenumber\"]")
    WebElement licensePlateNumber;
    @FindBy(xpath = "//*[@id=\"annualmileage\"]")
    WebElement annualMileage;
    @FindBy(xpath = "//*[@id=\"nextenterinsurantdata\"]")
    WebElement next;
    @FindBy(xpath = "//*[@id=\"payload\"]")
    WebElement payload;
    @FindBy(xpath = "//*[@id=\"totalweight\"]")
    WebElement totalWeight;
    @FindBy(xpath = "//*[@id=\"model\"]")
    WebElement model;
    @FindBy(xpath = "//*[@id=\"cylindercapacity\"]")
    WebElement cylinderCapacity;
    @FindBy(xpath = "//*[@id=\"numberofseatsmotorcycle\"]")
    WebElement numberOfSeatsForMotorcycle;
    @FindBy(xpath = "//*[@id=\"nav_camper\"]")
    WebElement camper;

    public void navigateToSampleTricentisURL()
    {
        navigateToURL("https://sampleapp.tricentis.com/101/");
    }
    public void selectProduct()
    {
        clickButton(automobileProduct);
    }
    public void vehicleDetails()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make"));
        setInputField(enginePerformance,jsonDataReader.getNestedString("VehicleDetails","EnginePerformance"));
        setInputField(dateOfManufacture,jsonDataReader.getNestedString("VehicleDetails","DateOfManufacture"));
        waitFor(numberOfSeats);
        dropDownHelper.SelectUsingVisibleValue(numberOfSeats,jsonDataReader.getNestedString("VehicleDetails","NumberOfSeats"));
        waitFor(fuelType);
        dropDownHelper.SelectUsingVisibleValue(fuelType,jsonDataReader.getNestedString("VehicleDetails","FuelType"));
        setInputField(listPrice,jsonDataReader.getNestedString("VehicleDetails","ListPrice"));
        setInputField(licensePlateNumber,jsonDataReader.getNestedString("VehicleDetails","LicensePlateNumber"));
        setInputField(annualMileage,jsonDataReader.getNestedString("VehicleDetails","AnnualMileage"));
        clickButton(next);

    }
    public void selectTruckProduct()
    {
        clickButton(truck);
    }
    public void enterVehicleDetailsForTruckProduct()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","Make"));
        setInputField(enginePerformance,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","EnginePerformance"));
        setInputField(dateOfManufacture,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","DateOfManufacture"));
        waitFor(numberOfSeats);
        dropDownHelper.SelectUsingVisibleValue(numberOfSeats,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","NumberOfSeats"));
        waitFor(fuelType);
        dropDownHelper.SelectUsingVisibleValue(fuelType,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","FuelType"));
        setInputField(payload,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","Payload"));
        setInputField(totalWeight,jsonDataReader.getNestedString("VehicleDetailsForTruckProduct","TotalWeight"));
        setInputField(listPrice,jsonDataReader.getNestedString("VehicleDetails","ListPrice"));
        setInputField(licensePlateNumber,jsonDataReader.getNestedString("VehicleDetails","LicensePlateNumber"));
        setInputField(annualMileage,jsonDataReader.getNestedString("VehicleDetails","AnnualMileage"));
        clickButton(next);
    }
    public void selectMotorcycleProduct()
    {
        clickButton(motorcycle);
    }
    public void vehicleDetailsForMotorCycle()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make"));
        waitFor(model);
        dropDownHelper.SelectUsingVisibleValue(model,jsonDataReader.getNestedString("VehicleDetails","Model"));
        setInputField(cylinderCapacity,jsonDataReader.getNestedString("VehicleDetails","CylinderCapacity"));
        setInputField(enginePerformance,jsonDataReader.getNestedString("VehicleDetails","EnginePerformance"));
        setInputField(dateOfManufacture,jsonDataReader.getNestedString("VehicleDetails","DateOfManufacture"));
        waitFor(numberOfSeatsForMotorcycle);
        dropDownHelper.SelectUsingVisibleValue(numberOfSeatsForMotorcycle,jsonDataReader.getNestedString("VehicleDetails","NumberOfSeats"));
        setInputField(listPrice,jsonDataReader.getNestedString("VehicleDetails","ListPrice"));
        setInputField(annualMileage,jsonDataReader.getNestedString("VehicleDetails","AnnualMileage"));
        clickButton(next);

    }
    public void selectCamperProduct()
    {
        clickButton(camper);
    }
    public void make1()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make1"));
    }
    public void make2()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make2"));
    }
    public void make3()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make3"));
    }
    public void make4()
    {
        waitFor(make);
        dropDownHelper.SelectUsingVisibleValue(make,jsonDataReader.getNestedString("VehicleDetails","Make4"));
    }
    public void vehicleDetailsForBenz()
    {
        make1();
       vehicleInformation();

    }
    public void vehicleDetailsForFord()
    {
        make2();
        vehicleInformation();
    }
    public void vehicleDetailsForMazda()
    {
        make3();
        vehicleInformation();
    }
    public void vehicleDetailsForPorsche()
    {
        make4();
        vehicleInformation();

    }
    public void vehicleInformation()
    {
        setInputField(enginePerformance,jsonDataReader.getNestedString("VehicleDetails","EnginePerformance"));
        setInputField(dateOfManufacture,jsonDataReader.getNestedString("VehicleDetails","DateOfManufacture"));
        waitFor(numberOfSeats);
        dropDownHelper.SelectUsingVisibleValue(numberOfSeats,jsonDataReader.getNestedString("VehicleDetails","NumberOfSeats"));
        waitFor(fuelType);
        dropDownHelper.SelectUsingVisibleValue(fuelType,jsonDataReader.getNestedString("VehicleDetails","FuelType"));
        setInputField(listPrice,jsonDataReader.getNestedString("VehicleDetails","ListPrice"));
        setInputField(licensePlateNumber,jsonDataReader.getNestedString("VehicleDetails","LicensePlateNumber"));
        setInputField(annualMileage,jsonDataReader.getNestedString("VehicleDetails","AnnualMileage"));
        clickButton(next);
    }


}
