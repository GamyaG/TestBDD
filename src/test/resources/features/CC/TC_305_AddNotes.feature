Feature: Adding Notes
  @305_AddNotes
  Scenario: Adding notes in a claim center
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
   # And User creates a new FNOL and verifies that it has been added successfully
    And User searches with the claim number the claim summary details are loaded
    And User creates the note
    Then the note is added successfully to claim
