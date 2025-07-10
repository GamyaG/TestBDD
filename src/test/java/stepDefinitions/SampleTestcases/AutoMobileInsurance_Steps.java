package stepDefinitions.SampleTestcases;

import io.cucumber.java.en.*;
import pageobjects.sampletestcases.InsuredData;
import pageobjects.sampletestcases.ProductData;
import pageobjects.sampletestcases.Quote;
import pageobjects.sampletestcases.VehicleData;

public class AutoMobileInsurance_Steps {
    VehicleData vehicleData;
    InsuredData insuredData;
    ProductData productData;
    Quote quote;

    public AutoMobileInsurance_Steps(VehicleData vehicleData, InsuredData insuredData, ProductData productData,Quote quote)
    {
        this.vehicleData=vehicleData;
        this.insuredData=insuredData;
        this.productData=productData;
        this.quote=quote;
    }

    @Given("user navigates to the sample tricentis page")
    public void user_navigates_to_the_sample_tricentis_page() {
        vehicleData.navigateToSampleTricentisURL();

    }
    @When("user select automobile as product")
    public void user_select_automobile_as_product() {
        vehicleData.selectProduct();

    }
    @When("user provides the vehicle information")
    public void user_provides_the_vehicle_information() {
        vehicleData.vehicleDetails();

    }
    @When("user submits the insured’s personal and contact details")
    public void user_submits_the_insured_s_personal_and_contact_details() {
        insuredData.enterInsuredData();

    }
    @When("user selects the appropriate insurance coverage and product options")
    public void user_selects_the_appropriate_insurance_coverage_and_product_options() {
        productData.enterProductData();

    }
    @When("user select the price options")
    public void user_select_the_price_options() {
        quote.selectPrice();

    }
    @When("user proceed with quote")
    public void user_proceed_with_quote() {
        quote.sendQuote();

    }
    @Then("system should confirm the quote creation is successful")
    public void system_should_confirm_the_quote_creation_is_successful() {
        quote.verifyQuoteSuccessMessage();

    }

    @When("user select truck as product")
    public void userSelectTruckAsProduct() {
        vehicleData.selectTruckProduct();

    }

    @And("user provides the vehicle information for truck product")
    public void userProvidesTheVehicleInformationForTruckProduct() {
        vehicleData.enterVehicleDetailsForTruckProduct();
    }

    @And("user selects the appropriate insurance coverage and product options for truck product")
    public void userSelectsTheAppropriateInsuranceCoverageAndProductOptionsForTruckProduct() {
        productData.enterProductDataForTruckProduct();
    }

    @When("user select motorcycle as product")
    public void userSelectMotorcycleAsProduct() {
        vehicleData.selectMotorcycleProduct();
    }

    @And("user provides the vehicle information for motorcycle")
    public void userProvidesTheVehicleInformationForMotorcycle() {
        vehicleData.vehicleDetailsForMotorCycle();
    }

    @And("user selects the appropriate insurance coverage and product options for motorcycle")
    public void userSelectsTheAppropriateInsuranceCoverageAndProductOptionsForMotorcycle() {
        productData.enterProductDataForTruckProduct();
    }

    @When("user select camper as product")
    public void userSelectCamperAsProduct() {
        vehicleData.selectCamperProduct();
    }

    @And("user provides the vehicle information for camper product")
    public void userProvidesTheVehicleInformationForCamperProduct() {
        vehicleData.enterVehicleDetailsForTruckProduct();
    }

    @And("user selects the appropriate insurance coverage and product options for camper")
    public void userSelectsTheAppropriateInsuranceCoverageAndProductOptionsForCamper() {
        productData.enterProductDataForTruckProduct();
    }

    @And("user provides the vehicle information for Benz")
    public void userProvidesTheVehicleInformationForBenz() {
        vehicleData.vehicleDetailsForBenz();

    }

    @And("user provides the vehicle information for Ford")
    public void userProvidesTheVehicleInformationForFord() {
        vehicleData.vehicleDetailsForFord();
    }

    @And("user provides the vehicle information for mazda")
    public void userProvidesTheVehicleInformationForMazda() {
        vehicleData.vehicleDetailsForMazda();
    }

    @And("user provides the vehicle information for Porsche")
    public void userProvidesTheVehicleInformationForPorsche() {
        vehicleData.vehicleDetailsForPorsche();

    }
}
