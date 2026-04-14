Feature: Login Functionality

 
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters "demo@demo.com" and "demo"
    And clicks the login button
    Then the user should be navigated to the home page