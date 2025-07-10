Feature: Google Search Functionality

  @SearchFunctionality3
  Scenario: Search for Selenium WebDriver on Google
    Given the user is on the Google homepage
    When the user enters "Java" in the search bar
    And the user clicks the Google Search button
    Then search results related to the query should be displayed