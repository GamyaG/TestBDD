@ProgressiveInsurance
Feature: Validate Text Fields on the Progressive Insurance Page
@TextValidations @HomePageValidation
  Scenario: Validate presence of specific text fields on the page
    Given the user is on the Progressive Insurance homepage
    Then the user should see "Select a product to quote" text
    And the user should see "Explore Products" text
    And the user should see "Claims" text
    And the user should see "About Us" text
    And the user should see "A leading auto insurance company, trusted since 1937" text
    And the user should see "Log In" text
