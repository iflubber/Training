package learn.java.samples;

import java.util.Scanner;

public class PrintDayInWord {
	int day;
	
	String getDayOfWeekUsingIfElse(){
		if(day==0)
			return "Sunday";
		else if(day==1)
			return "Monday";
		else if(day==2)
			return "Tuesday";
		else if(day==3)
			return "Wednesday";
		else if(day==4)
			return "Thursday";
		else if(day==5)
			return "Friday";
		else if(day==6)
			return "Saturday";
		else
			return "Not a valid day";
	}
	
	String getDayOfWeekUsingSwitch(){
		switch(day){
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "Not a valid day";	
		}
	}
	
	public static void main(String[] args) {
		PrintDayInWord pdiw = new PrintDayInWord();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter day of the week (in numbers between 0 to 6):");
		pdiw.day = in.nextInt();

		System.out.println("Day of the week is '" + pdiw.getDayOfWeekUsingIfElse() + "'");
		System.out.println("Day of the week is '" + pdiw.getDayOfWeekUsingSwitch() + "'");
	}

}
