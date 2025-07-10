@orangehrm
Feature: OrangeHRM Employee Management
  @add_employee
  Scenario: Logging into OrangeHRM and Adding an Employee
    Given User is on the OrangeHRM login page
    When User logs in with valid credentials
    And User navigates to the Add Employee page
    And User fills in employee details
    And User saves the employee details
    Then User verifies the employee is added successfully

