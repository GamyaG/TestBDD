Feature: Search for a Policy
  @TC_131_SearchPolicy
  Scenario: TC_131_SearchPolicy
    Given User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And User creates personal Account
    And User creates commercial policy
    And User searches for the policy with policy number
    Then User verify policy details are loaded successfully
