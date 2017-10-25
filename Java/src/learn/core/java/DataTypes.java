package learn.core.java;

public class DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte a = 127; //8 bit i.e. 2^7 to 2^7-1 [-128,127]
		short b = -32768; //16 bit [-32768,32767]
		int c = 2147483647; //32 bit [-2147483648,2147483647] - default
		long d = -9223372036854775808L; //64 bit [-9223372036854775808,9223372036854775807]
		
		float e = 3.123456F; //32 bit 6-7 decimal point, in 10^-45,10^38
		double f = 3.123456789; //64 bit 14-15 decimal point, in 10^-324,10^308 - default
		
		char g = 'x'; //16 bit [0,65535] unicode
		char h = 65;
		char i = '\n';
		
		String s = "Hello";
		
		boolean j = true;
		
		double k = c;
		int l = (int) f;
		
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.SIZE);
		
		System.out.println(Short.MIN_VALUE);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.SIZE);
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.SIZE);

		System.out.println(Long.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.SIZE);

		System.out.println(Float.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.SIZE);

		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.SIZE);

		System.out.println((int)Character.MIN_VALUE);
		System.out.println((int)Character.MAX_VALUE);
		System.out.println(Character.SIZE);
		
		
		int sum = 0;
		double avg;
		int n = 1;
		while(n<=100) {
			sum += n;
			++n;
		}
		avg = sum / 100;
		System.out.println(avg);
		
		avg = (double)sum / 100;
		System.out.println(avg);
		
		avg = sum / (double)100;
		System.out.println(avg);
		
		avg = sum / 100.0;
		System.out.println(avg);
		
		
		int[] numbers;
		int marks[];
		
		marks = new int[5];
		
		int[] integers = {1,2,3,4,5,6};
		System.out.println(integers[0] + integers[5]);
		System.out.println(integers.length);
		
		int grid[][] = new int[8][4];
	}

}
