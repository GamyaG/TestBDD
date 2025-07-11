Feature:Policy Renewal for Commercial Umbrella
  @TC_125_RenewalPolicy_CUP
  @cup
  Scenario: TC_125_RenewalPolicy_CUP
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And User loads the Commercial Umbrella policy and initiates a renewal transaction
    And User edits the transaction and adds and updates coverages for commercial umbrella
    And User proceeds to the Quote page and requests a quote
    And User performs renewal on commercial umbrella policy
    Then User verifies renewal is processed and Renewal Renewing text is displayed