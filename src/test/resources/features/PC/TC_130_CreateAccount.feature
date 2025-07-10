Feature: Creating a New Account
  @TC_130_CreateAccount
  Scenario: TC_130_CreateAccount
    Given User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And User provides required details for a Person account
    Then the account summary should display the correct account details
