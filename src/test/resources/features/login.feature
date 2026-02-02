Feature: Sample feature

  Scenario: Sample scenario
    Given I am on the login page
    When I enter username "student" and password "Password123"
    And I click login
    Then I should see the dashboard