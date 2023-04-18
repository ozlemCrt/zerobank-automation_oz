Feature: Verify Account Activity page elements


  Scenario:Account Activity
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    Then The user should see page title "Zero - Account Activity"
    Then The user should see the default tab "Savings" in the account menu
    Then The user should see tabs in the account menu
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then  The user should see columns in the table
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |


