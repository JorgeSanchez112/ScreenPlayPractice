Feature:Home products
  As a user
  I want to see all the products on the application
  So I can do that without sign up.

  Scenario: Johanna can see our products without have an account
    Given "Johanna" is on the home page
    Then "Johanna" should be able to see all the sale products.