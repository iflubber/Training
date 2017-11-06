package com.learn.bdd.calculator;

public class Calculator {
	int number1;
	int number2;
	
    private int result;

    public void add() {
    	result = number1 + number2;
    }
    
    public void add(int arg1, int arg2) {
        result = arg1 + arg2;
    }

    public void subtract(int arg1, int arg2) {
        result = arg1 - arg2;
    }

    public int getResult() {
        return result;
    }
}
