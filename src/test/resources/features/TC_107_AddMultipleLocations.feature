Feature:Binding Go Commercial Insurance Policies
  @TC_107_AddMultipleLocations
  @pcGCP
  @smoke
  Scenario:TC_107_AddMultipleLocations
    Given  User launches the URL of GuideWire Policy Center cloud
    When  User enters valid credentials and logs into Policy Center cloud
    And  User Open account and initiates a new submission
    And  User Select Go Commercial Property Line of Business
    And  User enters the mandatory fields in the Policy Info screen
    And  User adds Go Commercial Property coverages
    And  User adds Cpblanket with mutiple locations
    And User proceeds next In Location
    And User proceeds to quote the policy
    And User chooses to issue the policy
    And the user reviews the bound submission and confirms the policy transaction status

