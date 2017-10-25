package learn.java.samples;

import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int secret;
		int guess;
		int attempts = 0;
		boolean success = false;
		
		secret = (int)Math.random()*100;
		
		Scanner in = new Scanner(System.in);
		
		while(!success) {
			++attempts;
			System.out.println("Enter your guess (between 0 and 99):");
			guess = in.nextInt();
			
			if(guess == secret) {
				System.out.println("Bang on!");
				success = true;
			}else if(guess < secret) {
				System.out.println("Hint: Try higher!");
			} else {
				System.out.println("Hint: Try lower!");
			}
		}
		System.out.println("You got the guess right in " + attempts + " attempts. Congratulations!");
	}
}
