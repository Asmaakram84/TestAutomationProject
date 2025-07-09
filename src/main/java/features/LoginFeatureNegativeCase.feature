Feature: Login to Owasp Application

  Background:
    Given  User is on owasp Main Login page


  Scenario: Login with invalid credentials
    When I click on the Login button
    And I enter the Invalid user email
    And I enter the user password
    When I click on the login button
    Then  I should not be logged in successfully
