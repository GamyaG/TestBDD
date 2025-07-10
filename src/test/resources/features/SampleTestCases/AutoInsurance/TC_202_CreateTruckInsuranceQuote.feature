@QuoteCreation
Feature: Quote creation for automobile
  @TC_202_QuoteCreation
  Scenario: User creates a truck insurance quote
    Given user navigates to the sample tricentis page
    When user select truck as product
    And user provides the vehicle information for truck product
    And user submits the insured’s personal and contact details
    And user selects the appropriate insurance coverage and product options for truck product
    And user select the price options
    And user proceed with quote
    Then system should confirm the quote creation is successful