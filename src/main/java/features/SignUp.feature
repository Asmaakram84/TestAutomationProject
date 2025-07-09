Feature: Signup to Owasp Application

  Background:
    Given User is on owasp Main Login page

  Scenario:  When New User is on Register Now Page
    When I click on the Main Login button
    And I click on the RegisterNow button
    And I Enter Email Address
    And I click Agree Button
    And I click on the continue button
    Then  I should be successfully registered
    When I enter the First Name
    And I enter Last name
    When I enter the account password
    And I click Agree Button
    When I click on Captcha
    And I click on the Create Account Button
    Then  I should be successfully registered
