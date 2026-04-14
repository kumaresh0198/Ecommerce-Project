Feature: Product Test

  
  Scenario: Add product to cart
    Given the user is logged in
    When the user selects menswear category
    And the user applies filter option
    And the user adds product to cart
    Then the product should be added to cart