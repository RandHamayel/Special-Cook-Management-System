Feature: Billing System
  As a system user
  I want to handle financial transactions
  So that payments are processed correctly

  Scenario Outline: Generate customer invoice for different order types
    Given an order is completed with <orderType>
    And the payment method is <paymentMethod>
    When the billing system processes it
    Then a PDF invoice should be generated
    And emailed to the customer

    Examples:
      | orderType      | paymentMethod |
      | physical goods | credit card   |
      | digital items  | PayPal        |
      | subscription   | bank transfer, |

  Scenario: Monthly financial report
    Given it's the end of the month
    When the administrator generates reports
    Then the system should create revenue breakdown
    And show comparison to previous month

  Scenario: Failed payment handling
    Given the following failed transactions:
      | Customer ID | Amount | Reason        |
      | C001        | 120.00 | Card expired  |
      | C002        | 80.50  | Insufficient funds |
      | C003        | 45.00  | Network error |
    When the system retries after 24 hours
    Then it should notify the customer
    And suspend delivery until resolved
