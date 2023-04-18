Feature: Find Transaction Checks
  Scenario: Search Description Test
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    When  Tab on Find Transactions
    When Send "ONLINE" keyword into description input box
    When Tap on find button
    Then Verify that all description results contains "ONLINE"


  Scenario: Search date range
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    Given Tab on Find Transactions
    When The user enters date range from "2012-09-01" to "2012-09-06"
    And Tap on find button
   Then Verify that results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And Verify that the results should be sorted by most recent date

  Scenario: Type-1
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    Given Tab on Find Transactions
    And Tap on find button
    Then  Verify that results table should show at least one result under Deposit
    Then Verify that results table should show at least one result under Withdrawal

  Scenario: Type-2
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    Given Tab on Find Transactions
    When  The user selects type "Deposit" and clicks on Find
    Then Verify that results table should show at least one result under Deposit
    But Verify that results table should show no result under Withdrawal

  Scenario: Type-3
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Account Activity" page
    Given Tab on Find Transactions
    When The user selects type "Withdrawal" and clicks on Find
    Then Verify that results table should show at least one result under Withdrawal
    But Verify that results table should show no result under Deposit

