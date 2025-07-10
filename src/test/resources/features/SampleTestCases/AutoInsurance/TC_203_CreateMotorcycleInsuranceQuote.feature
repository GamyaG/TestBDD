@QuoteCreation
@QuoteSmoke
Feature: Quote creation for automobile
  @TC_203_QuoteCreation
  Scenario: User creates motorcycle insurance quote
    Given user navigates to the sample tricentis page
    When user select motorcycle as product
    And user provides the vehicle information for motorcycle
    And user submits the insured’s personal and contact details
    And user selects the appropriate insurance coverage and product options for motorcycle
    And user select the price options
    And user proceed with quote
    Then system should confirm the quote creation is successful