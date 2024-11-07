Feature: Login Functionality for OrangeHRM demo website

  As a user of OrangeHRM demo
  I want to login into application with my account
  So that I can access the account related features

  Background:
    Given I am on the OrangeHRM demo Login page

    Scenario: Successful login with valid credentials
      Given I have entered valid username and password
      When I click on the login button
      Then I should be logged in successfully

    Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples:
      | username          | password        | error_message       |
      | invalid@email.com | invalidPassword | Invalid credentials |
      | abcd@123.com      | validPassword   | Invalid credentials |
      | valid@email.com   | idPassword      | Invalid credentials |

      Scenario: Navigating to the forgotten password page
        When I click on the forgot password link
        Then I should redirected to the password reset page


