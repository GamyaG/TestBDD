package stepDefinitions.CC;

import io.cucumber.java.en.*;
import pageobjects.NewBusinessCC;

public class SearchCheck_Steps {
    NewBusinessCC newBusinessCC;
    public SearchCheck_Steps(NewBusinessCC newBusinessCC)
    {
        this.newBusinessCC=newBusinessCC;

    }
    @And("User search the check")
    public void user_search_the_check() {
        newBusinessCC.searchCheck();

    }
    @Then("the check details are loaded")
    public void the_check_details_are_loaded() {
        newBusinessCC.verifyCheckLoaded();

    }


}
