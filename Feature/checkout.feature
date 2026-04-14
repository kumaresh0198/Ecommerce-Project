Feature: Checkout Process

  
  Scenario: Complete order successfully
    Given the user has product in cart
    When the user proceeds to checkout
    And the user enters billing address
    And clicks continue button
    Then the order should be placed successfully