Feature: SignUp and Purchase Product

  Scenario:TC-001 create a new user credentials
    Given I am on the home page
    Then Navigate to SignUp page
    And create an account with random username

  Scenario:TC-002 Sign In with newly created user credentials
    Given I am on the Sign In Page
    When Login using newly created credentials
    Then I shall see Product page with successful login

  Scenario:TC-003 Add product to Online Cart and checkout
    Given I am on the product home page
    When I add product to cart and checkout
    Then I shall be able to Buy the product