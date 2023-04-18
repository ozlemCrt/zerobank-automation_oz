Feature: Navigating to specific accounts in Accounts Activity

  Scenario: Savings account redirect
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    When The user clicks on "Savings" link on the Account Summary page
    Then The user should see page title "Zero - Account Activity"
    And The user should see the default tab "Savings" in the account menu

  Scenario: Brokerage account redirect
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    When The user clicks on "Brokerage" link on the Account Summary page
    Then The user should see page title "Zero - Account Activity"
    And The user should see the default tab "Brokerage" in the account menu


  Scenario: Checking account redirect
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    When The user clicks on "Checking" link on the Account Summary page
    Then The user should see page title "Zero - Account Activity"
    And The user should see the default tab "Checking" in the account menu

  Scenario: Credit Card account redirect
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    When The user clicks on "Credit Card" link on the Account Summary page
    Then The user should see page title "Zero - Account Activity"
    And The user should see the default tab "Credit Card" in the account menu

  Scenario: Loan account redirect
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Summary" page
    When The user clicks on "Loan" link on the Account Summary page
    Then The user should see page title "Zero - Account Activity"
    And The user should see the default tab "Loan" in the account menu

