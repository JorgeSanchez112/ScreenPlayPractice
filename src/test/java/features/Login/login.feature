Feature: User login
  As a user
  I want to log in to the application
  So that I can access my account

Scenario: Colin logs in with Colin's valid credentials
Given "Colin" is on the login page
When "Colin" logs in with valid credentials
Then "Colin" should be presented on the home page with his name "admin" in a message