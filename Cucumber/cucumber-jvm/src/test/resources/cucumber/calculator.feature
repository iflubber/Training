Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  @add	
  Scenario: Add two numbers
  	Given I have following texts:one,two,three
    Given I have a calculator
    When I add 2 and 3
    Then the result should be 5
  
  @minus  
  Scenario: Subtract two numbers
    Given I have a calculator
    When I subtract 3 and 2
    Then the result should be 1
  