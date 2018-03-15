package learn.java.samples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileScanner {
	static int integer;
	static double decimal;
	static String text;
	
	public static void main(String[] args) {
        String fileName = "in.txt";

        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(new File(fileName));

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                try{
                	integer = Integer.parseInt(line);
                	System.out.println("The integer read is " + integer);
                }catch(NumberFormatException nfe){
                	try{
                		decimal = Double.parseDouble(line);
                		System.out.println("The floating point number read is " + decimal);
                	}catch(NumberFormatException nfex){
                		text = line;
                		System.out.println("The string read is \"" + text + "\"");
                	}
                }
            }   

            bufferedReader.close();   
            
            System.out.println("Hi! " + text + ", the sum of " + integer + " and " + decimal + " is " + (integer + decimal));
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
 	}
}
