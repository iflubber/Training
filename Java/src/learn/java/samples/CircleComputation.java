package learn.java.samples;

public class CircleComputation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double radius, area, circumference;
		final double PI = 3.14159265;
		
		radius = 1.8;
		
		area = PI * radius * radius;
		circumference = 2.0 * PI * radius;
		
		System.out.println("Area with radius of " + radius + " cm is: " + area + " sq.cm");
		System.out.println("Circumference with radius of " + radius + " cm is: " + circumference + " cm");
	}

}
