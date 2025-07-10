Feature: Invoice Due
  @TC_204_invoice_due
  Scenario: TC_204_invoice_due
    Given User launches the URL of GuideWire Billing Center
    When User enters valid credentials and logs into Billing Center
    When User navigates to invoices on billing center home page
    And User changes the invoice billed date
    Then the invoice billed date is updated