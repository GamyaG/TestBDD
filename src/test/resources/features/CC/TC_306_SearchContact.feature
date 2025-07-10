Feature: Search Contact
  @306_search_contact
  Scenario: Searching for a contact
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    When User searches the contact
    Then the search contact details are loaded