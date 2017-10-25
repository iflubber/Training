package learn.java.samples;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int factorial = 1;
		
		int i = 1;
		while(i<=n) {
			factorial *= i;
			i++;
		}
		System.out.println("The factorial of " + n + " is: " + factorial);
	}

}
