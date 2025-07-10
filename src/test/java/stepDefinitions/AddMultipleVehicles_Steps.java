package stepDefinitions;

import io.cucumber.java.en.And;
import pageobjects.NewBusiness;

public class AddMultipleVehicles_Steps {
    NewBusiness newBusiness;
    public AddMultipleVehicles_Steps(NewBusiness newBusiness)
    {
        this.newBusiness=newBusiness;
    }

    @And("User adds multiple vehicles")
    public void userAddsMultipleVehicles() {
        newBusiness.addMultipleVehicles();
    }
}
