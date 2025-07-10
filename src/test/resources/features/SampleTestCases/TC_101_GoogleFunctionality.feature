Feature: Google Search Functionality

  @SearchFunctionality
  Scenario: Search for Selenium WebDriver on Google
    Given the user is on the Google homepage
    When the user enters "Javascript" in the search bar
    And the user clicks the Google Search button
    Then search results related to the query should be displayed