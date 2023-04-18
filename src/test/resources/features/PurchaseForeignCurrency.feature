Feature: Purchase Foreign Currency

  Scenario: Available currencies
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Given The user tabs on "Purchase Foreign Currency" pay bill subtitle
    Then Verify that following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar)    |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona)        |
      | Singapore (dollar)    |
      | Thailand (baht)       |
  Scenario: Error message for not selecting currency
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Given The user tabs on "Purchase Foreign Currency" pay bill subtitle
    When  The user tries to calculate cost without selecting a currency
    Then Verify that error message should be displayed
