package stepDefinitions.SampleTestcases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.BasePO;
import pageobjects.sampletestcases.Progressive_HomePage_Validation;

public class Progressive_Insurance_Steps extends BasePO {
    Progressive_HomePage_Validation progressive_homePage_validation;
    public Progressive_Insurance_Steps(Progressive_HomePage_Validation progressive_homePage_validation){
        this.progressive_homePage_validation=progressive_homePage_validation;
    }

    @Given("the user is on the Progressive Insurance homepage")
    public void theUserIsOnTheProgressiveInsuranceHomepage() {
        navigateToURL("https://www.progressive.com/");

    }

    @Then("the user should see {string} text")
    public void theUserShouldSeeText(String expectedText) throws InterruptedException {
        switch (expectedText) {

            case "Select a product to quote":
                progressive_homePage_validation.validateSelectProductQuoteText(expectedText);
                break;
            case "Explore Products":
                progressive_homePage_validation.validateExploreProductsText(expectedText);
                break;
            case "Claims":
                progressive_homePage_validation.validateClaimsText(expectedText);
                break;
            case "About Us":
                progressive_homePage_validation.validateAboutUsText(expectedText);
                break;
            case "A leading auto insurance company, trusted since 1937":
                progressive_homePage_validation.validateHeadingTagText(expectedText);
                break;
            case "Log In":
                progressive_homePage_validation.validateLogInText(expectedText);
                break;
            default:
                throw new IllegalArgumentException("Unexpected text: " + expectedText);
        }
    }
}
