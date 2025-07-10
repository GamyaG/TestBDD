Feature: Resend invoice for a billed invoice
  @TC_203_Invoice_Billed
  @invoice_billed
  Scenario: TC_203_Invoice_Billed
    Given User launches the URL of GuideWire Billing Center
    When User enters valid credentials and logs into Billing Center
    When User navigates to invoices on billing center home page
    And User resends invoice
    Then the invoice resent confirmation message is displayed
