@QuoteCreation
Feature: Quote creation for automobile
  @TC_204_QuoteCreation
  Scenario: User creates a camper insurance quote
    Given user navigates to the sample tricentis page
    When user select camper as product
    And user provides the vehicle information for camper product
    And user submits the insured’s personal and contact details
    And user selects the appropriate insurance coverage and product options for camper
    And user select the price options
    And user proceed with quote
    Then system should confirm the quote creation is successful