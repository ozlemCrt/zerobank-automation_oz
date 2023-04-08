Feature: Account Summary

  Scenario: Verify page elements
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    Then The user should see page title "Zero - Account Summary"
    Then The user should see account type:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then The user should see columns in the "Credit Accounts" table
      | Account     |
      | Credit Card |
      | Balance     |




