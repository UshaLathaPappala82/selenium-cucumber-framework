Feature: Login Functionality

  Scenario Outline: Login with different credentials
  
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And user clicks on login button
    Then login should be "<status>" with "<message>"
    
  Examples:
  |  username   |  password    | status     | message  |
  |  student   |  Password123  | success    | Logged In Successfully    |
  |  student1  |  Password123  | failure    | Your username is invalid! |
  |  student   |  password     | failure    | Your password is invalid! |