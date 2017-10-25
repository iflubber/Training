package learn.core.java;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class IO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Using Scanner
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int n = scan.nextInt();
		
		System.out.println("Enter a decimal number: ");
		double d = scan.nextDouble();
		
		System.out.println("Enter a string: ");
		String s = scan.next();
		
		System.out.printf("%s, Sum of %d & %.2f is %.2f%n", s,n,d,n+d);
		
		scan = new Scanner(System.in);
		System.out.println("Enter a statement: ");
		String str = scan.nextLine();
		
		System.out.printf("%s%n", str);
		
		//Using Stream Readers
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter some text:");
		String str2 = br.readLine();
		System.out.println("Enter a number:");
		int i = Integer.parseInt(br.readLine());
		
		System.out.println(str2 + " " + i);
		
		
		DataInputStream dis = new DataInputStream(System.in);
		System.out.println("Enter a character:");
		i = dis.read();
		System.out.println(i);
		
		scan.close();
		br.close();
		dis.close();
		
		//Using Console Note: doesn't work in every IDE (Eclipse, NetBeans)
//		Console console = System.console();
//		System.out.println("Enter some text:");
//		String s = console.readLine();
//		int i = Integer.parseInt(console.readLine());
//		System.out.println(s + " " + i);
		
		
		//input via GUI prompt
		String radius;
		double r, area;
		radius = JOptionPane.showInputDialog("Enter the circle radius (in cm)");
		r = Double.parseDouble(radius);
		area = Math.PI * r * r;
		System.out.println("Area of the circle: " + area + " sq.cm");
		
		//To read from file replace System.in with new File("file.csv")
	}

}
