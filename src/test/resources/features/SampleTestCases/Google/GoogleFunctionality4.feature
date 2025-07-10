Feature: Google Search Functionality4

  @SearchFunctionality
  Scenario: Search for Selenium WebDriver on Google
    Given the user is on the Google homepage
    When the user enters "Generative AI" in the search bar
    And the user clicks the Google Search button
    Then search results related to the query should be displayed