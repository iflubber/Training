package learn.core.java;

public class ConditionalOperators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 29;
		int n2 = 10;
		
		System.out.println(n1 < n2); //false
		System.out.println(n1 > n2); //true
		System.out.println(n1 == n2); //false
		System.out.println(n1 <= n2); //false
		System.out.println(n1 >= n2); //true
		System.out.println(n1 != n2); //true
		
		//combining conditions
		System.out.println(n1 >=1 && n1 <=100); //true
		System.out.println(n1 > 1 || n1 > 100); //true
		System.out.println(!(n1 > n2)); //false
	}

}
