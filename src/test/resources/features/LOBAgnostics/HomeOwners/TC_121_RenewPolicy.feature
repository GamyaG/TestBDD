Feature:Policy Renewal for Home Owners
  @TC_121_RenewalPolicy_HOP
  Scenario: TC_121_RenewalPolicy_HOP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And User loads the Home Owners policy and initiates a renewal transaction
    And User edits the transaction and adds and updates coverages for home owners
    And User proceeds to the Quote page and requests a quote
    And User performs renewal on home owners policy
    Then User verifies renewal is processed and Renewal Renewing text is displayed