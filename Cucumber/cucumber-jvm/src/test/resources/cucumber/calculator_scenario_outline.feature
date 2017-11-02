Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  Scenario Outline: Add two numbers
    Given I have a calculator
    When I add <number1> and <number2>
    Then the result should be <output>

Examples:    
| number1 | number2 | output |
| 2		  | 3       | 5      |
| 5       | 6       | 11     |    