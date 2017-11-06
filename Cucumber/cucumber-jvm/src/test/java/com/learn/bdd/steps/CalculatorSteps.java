package com.learn.bdd.steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.learn.bdd.calculator.Calculator;

public class CalculatorSteps {

    private Calculator calculator;
    private List<Integer> results;
    
    @Before(order=0)
    public void testBeforeOrder() {
    	System.out.println("-----The very first @Before----");
    }
    
    @Before
    public void setUp() {
        calculator = new Calculator();
        results = new ArrayList<Integer>();
    }
    
    @Given("^I have following texts:(.*)$")
    public void stringList(List<String> texts) {
    	for(String text: texts) {
    		System.out.println(text);
    	}
    }

    @Given("^I have a calculator$")
    public void isCalculatorExist() throws Throwable {
        assertNotNull(calculator);
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void addition(int arg1, int arg2) throws Throwable {
        calculator.add(arg1, arg2);
    }

    @When("^I subtract (\\d+) and (\\d+)$")
    public void subtraction(int arg1, int arg2) throws Throwable {
        calculator.subtract(arg1, arg2);
    }

    @Then("^the result should be (\\d+)$")
    public void output(int result) throws Throwable {
        assertEquals(result, calculator.getResult());
    }

//    @When("^I add the following numbers:$")
//    public void addition(DataTable table) throws Throwable {
//    	//Initialize data table
////    	List<List<String>> data = table.raw();
//    	List<Map<String,Integer>> data = table.asMaps(String.class, Integer.class);
//    	
//    	for(Map<String,Integer> numbers: data) {
////    		calculator.add(Integer.parseInt(numbers.get("number1")), Integer.parseInt(numbers.get("number2")));
//    		calculator.add(numbers.get("number1"), numbers.get("number2"));
//    		results.add(calculator.getResult());
//    	}
//    }

    @When("^I add the following numbers:$")
    public void addition(List<Calculator> data) throws Throwable {
    	//Initialize data table
    	for(Calculator calculator: data) {
    		calculator.add();
    		System.out.println(calculator.getResult());
    		results.add(calculator.getResult());
    	}
    }

    @Then("^the results are:$")
    public void output(DataTable table) throws Throwable {
    	List<Map<String,Integer>> data = table.asMaps(String.class, Integer.class);
    	int i=0;
    	for(Map<String,Integer> output: data) {
    		assertEquals(output.get("output"), results.get(i));
    		i++;
    	}
    }
    
    @After(order=0)
    public void testAfterOrder() {
    	System.out.println("-----The very last @After----");
    }

    @After(order=1)
    public void testAfterOrder1() {
    	System.out.println("-----The 2nd last @After----");
    }
}
