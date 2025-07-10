package stepDefinitions.SampleTestcases;

import io.cucumber.java.en.*;
import pageobjects.sampletestcases.GoogleSearchFunctionalityPO;

public class GoogleSearchFunctionality_Steps {
    GoogleSearchFunctionalityPO googleSearchFunctionalityPO;
    public GoogleSearchFunctionality_Steps( GoogleSearchFunctionalityPO googleSearchFunctionalityPO)
    {
        this.googleSearchFunctionalityPO=googleSearchFunctionalityPO;
    }
    @Given("the user is on the Google homepage")
    public void the_user_is_on_the_google_homepage() {
        googleSearchFunctionalityPO.navigateToGoogleURL();


    }
    @When("the user enters {string} in the search bar")
    public void the_user_enters_in_the_search_bar(String query) {
        googleSearchFunctionalityPO.enterSearchQuery(query);

    }
    @When("the user clicks the Google Search button")
    public void the_user_clicks_the_google_search_button() {
        googleSearchFunctionalityPO.clickSearchButton();

    }
    @Then("search results related to the query should be displayed")
    public void search_results_related_to_the_query_should_be_displayed() {
//        googleSearchFunctionalityPO.verifySearchResults();

    }

}
