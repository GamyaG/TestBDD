Feature:Policy Renewal for Small Business
  @TC_117_RenewalPolicy_SBP
  @sbp
  Scenario: TC_117_RenewalPolicy_SBP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And User loads the Small Business policy and initiates a renewal transaction
    And User edits the transaction
    And User adds and updates coverages for Small Business
    And User proceeds to the Quote page and requests a quote
    And User performs renewal on small business policy
    Then User verifies renewal is processed and Renewal Renewing text is displayed