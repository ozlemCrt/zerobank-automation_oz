Feature:
@wip
  Scenario: Add a new payee
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
    And The user go to "Pay Bills" page
    Given The user tabs on "Add New Payee" pay bill subtitle
    And Creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    When Tabs on add button
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed