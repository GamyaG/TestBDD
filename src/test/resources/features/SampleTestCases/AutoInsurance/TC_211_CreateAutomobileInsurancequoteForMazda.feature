@QuoteCreation1
Feature: Quote creation for automobile
  @TC_211_QuoteCreation
  Scenario: User creates an automobile insurance quote
    Given user navigates to the sample tricentis page
    When user select automobile as product
    And user provides the vehicle information for mazda
    And user submits the insured’s personal and contact details
    And user selects the appropriate insurance coverage and product options
    And user select the price options
    And user proceed with quote
    Then system should confirm the quote creation is successful