Feature: Capturing first notice of loss
  @claimcenter
  @TC_301_fnol
  Scenario: TC_301_fnol
    Given User launches the URL of GuideWire Claim Center
    When User enters valid credentials and logs into Claim Center
    When User creates new FNOL
    Then the FNOL is added successfully