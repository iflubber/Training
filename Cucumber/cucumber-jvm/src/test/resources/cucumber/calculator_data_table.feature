Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  @add	
  Scenario: Add two numbers
    Given I have a calculator
    #demonstrate use of Data Tables
    When I add the following numbers:
    |	number1	|	number2	|
    |	4		|	7		|
    |	8		|	5		|
    |	9		|	3		|	
    Then the results are:
    |	output	|
    |	11		|
    |	13		|
    |	12		|
