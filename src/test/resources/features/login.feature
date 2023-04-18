Feature: Login Scenerio
@pozitiveTest
  Scenario: Login with valid credentials
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "username" and "password"
  And The user taps on back button
  Then The user that "username" is visible on the board

@negativeTest
  Scenario Outline: Login with invalid credentials
    Given The user go to the relevant site
    When The user click signin button
    And The user logs in using "<loginName>" and "<password>"
    Then The user should see message :"<message>"
    Examples:
      | loginName | password | message                          |
      |           | password | Login and/or password are wrong. |
      | username  |          | Login and/or password are wrong. |
      | user      | password | Login and/or password are wrong. |
      | username  | 12345    | Login and/or password are wrong. |
      | us123name | password | Login and/or password are wrong. |




