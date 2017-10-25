package learn.core.java;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 1;
		int end = 1000;
		
		int sum = 0;
		
		//while loop
		int n = start;
		while(n<=end) {
			sum = sum + n;
			n++;
		}
		
		System.out.println("Sum from while loop: " + sum);
		
		sum = 0;
		//for loop
		for(n=start; n<=end; n++)
			sum+=n;

		System.out.println("Sum from for loop: " + sum);
		
		sum = 0;
		//do...while loop
		n=start;
		do {
			sum+=n;
			n++;
		}while(n<=end);

		System.out.println("Sum from do...while loop: " + sum);
		
		String array[] = {"One", "Two", "Three"};
		 
        //enhanced for loop
        for (String x:array)
        {
            System.out.println(x);
        }
 
        /*for loop for same function
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        */
	}

}
