Feature: Adding Multiple Drivers to a Policy
  @TC_108_AddMultipleDrivers
  @smoke
  Scenario: TC_108_AddMultipleDrivers
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And User Select USA Personal Auto as Product
    And  User enters the mandatory fields in the Policy Info screen
    And User adds USA Personal Auto Standard Coverages
    And User adds multiple drivers
    And User proceeds to quote the policy
    And User chooses to issue the policy
    Then User reviews the bound submission and confirms the policy transaction status