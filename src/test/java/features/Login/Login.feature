Feature: User login
  As a registered user
  I want to log in to the application
  So that I can access my account

  Scenario: Successful login
    Given User is on the login page
    When User enters valid username "admin" and password "admin" and click on login button
    Then User should be redirected to the home page
