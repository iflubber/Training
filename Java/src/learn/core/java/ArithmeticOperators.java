package learn.core.java;

public class ArithmeticOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = 29;
		int number2 = 10;
		
		int sum, difference, product, quotient, remainder;
		
		sum = number1 + number2;
		difference = number1 - number2;
		product = number1 * number2;
		quotient = number1 / number2;
		remainder = number1 % number2;
		
		System.out.println("For " + number1 + " and " + number2 + ", the result of:");
		System.out.println("Addition is: " + sum);
		System.out.println("Subtraction is: " + difference);
		System.out.println("Multiplication is: " + product);
		System.out.println("Division is: quotient=" + quotient + " and remainder=" + remainder);
		
		System.out.println(number1 + " when incremented by 1 results to: " + (++number1));
		System.out.println(number1 + " when decremenred by 1 results to: " + (--number1));
		
		System.out.println("The negation of " + number2 + " results into " + (-number2));
		
		//some magic
		System.out.println(number2++);
		System.out.println(number2);
		
		//what do you think the following will result into?
		System.out.println(number1 + number2 - number1 * number2 / number1 % number2);
	}

}
