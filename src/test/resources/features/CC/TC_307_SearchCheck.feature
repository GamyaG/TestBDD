Feature: Search Contact
  @307_search_check
  Scenario: Searching for a contact
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    And User search the check
    Then the check details are loaded