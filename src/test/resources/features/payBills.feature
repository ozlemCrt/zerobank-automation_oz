Feature: Pay Bills Page

  Scenario:successful payment
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Then The user should see page title "Zero - Pay Bills"
    And The user should enter the valid information for the payment process:"Bank of America","Credit Card","200","2023-04-09","payment"
    Then The user should see message text:"The payment was successfully submitted."


  Scenario: Negative Test :empty amount
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Then The user should see page title "Zero - Pay Bills"
    And The user should enter the valid information for the payment process:"Bank of America","Credit Card","","2023-04-12","payment"
    Then The user verify that the message is visible "Please fill out this field."

  Scenario Outline: Negative Test: invalid information in the date box
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Then The user should see page title "Zero - Pay Bills"
    And The user should enter the valid information for the payment process:"<payee>","<account>","<amount>","<date>","<description>"
    Then The user verify that the message is visible "Please fill out this field." in the date box
    Examples:
      | payee       | account  | amount | date       | description |
      | Apple       | Checking | sd123  |            | payment     |
      | Wells Fargo | Loan     | 456*   | hjgkhjl    | payment     |

  Scenario Outline:Enter Invalid information
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Then The user should see page title "Zero - Pay Bills"
    And The user should enter the valid information for the payment process:"<payee>","<account>","<amount>","<date>","<description>"
    Then The user verify that the message is not visible
    Examples:
      | payee       | account   | amount  | date       | description |
      | Apple       | Checking  | sd123   | 2023-04-12 | payment     |
      | Wells Fargo | Loan      | 456*    | 2023-04-12 | payment     |
      | Sprint      | Brokerage | 123-/   | 2023-04-12 | payment     |
      | Sprint      | Loan      | l"23456 | 2023-04-12 | payment     |
