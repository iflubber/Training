package learn.java.samples;

import java.util.Scanner;

public class CheckVowelsDigits {
	int vowelCount=0;
	int digitCount=0;
	
	int countVowels(String text){
		char[] characters = text.toCharArray();
		for(char ch: characters){
			switch(ch){
			case 'a':
				vowelCount++;
				break;
			case 'e':
				vowelCount++;
				break;
			case 'i':
				vowelCount++;
				break;
			case 'o':
				vowelCount++;
				break;
			case 'u':
				vowelCount++;
				break;
			case 'A':
				vowelCount++;
				break;
			case 'E':
				vowelCount++;
				break;
			case 'I':
				vowelCount++;
				break;
			case 'O':
				vowelCount++;
				break;
			case 'U':
				vowelCount++;
				break;
			default:
				break;	
			}
		}
		return 0;
	}
	
	int countDigits(String text){
		char[] characters = text.toCharArray();
		for(char ch: characters){
			switch(ch){
			case '0':
				digitCount++;
				break;
			case '1':
				digitCount++;
				break;
			case '2':
				digitCount++;
				break;
			case '3':
				digitCount++;
				break;
			case '4':
				digitCount++;
				break;
			case '5':
				digitCount++;
				break;
			case '6':
				digitCount++;
				break;
			case '7':
				digitCount++;
				break;
			case '8':
				digitCount++;
				break;
			case '9':
				digitCount++;
				break;
			default:
				break;	
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		CheckVowelsDigits obj = new CheckVowelsDigits();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a String:");
		String text = in.next();
		obj.countVowels(text);
		obj.countDigits(text);
		
		System.out.printf("Number of Vowels: %d (%.2f%%)", obj.vowelCount, (obj.vowelCount / (double)text.length())*100);
		System.out.println();
		System.out.printf("Number of Digits: %d (%.2f%%)", obj.digitCount, (obj.digitCount / (double)text.length())*100);
	}

}
