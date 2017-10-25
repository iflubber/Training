package learn.core.java;

public class Conditionals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startN = 1;
		int endN = 1000;
		
		int sumOdd = 0;
		int sumEven = 0;
		
		int n = startN;
		while (n<=endN) {
			if(n%2 == 0)
				sumEven += n;
			else
				sumOdd +=n;
			
			n++;
			
			if(sumEven > 50000)
				System.out.println("Even sum crossed 50000");
			else
				System.out.println("Even sum still less than 50000");
			
			if(sumOdd > 100000)
				System.out.println("Odd sum crossed 100000");
			else if (sumOdd > 200000)
				System.out.println("Odd sum crossed 200000");
			else
				System.out.println("Odd sum is still growing");
		}
		
		System.out.println("The sum of odd numbers between 1 to 1000 is: " + sumOdd);
		System.out.println("The sum of even numbers between 1 to 1000 is: " + sumEven);
		
		char op;
		int n1,n2,result=0;
		
		op = '+';
		n1 = 10;
		n2 = 29;
		switch(op) {
		case '+':
			result = n1 + n2;
			break;
		case '-':
			result = n1 - n2;
			break;
		default:
			System.out.println("Error");
		}
		System.out.println(result);
		
		System.out.println((n1>n2)?n1:n2);
	}

}
