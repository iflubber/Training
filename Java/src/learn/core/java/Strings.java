package learn.core.java;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello, world!";
		
		System.out.println(s.length());
		System.out.println(s.equals("Hello, World!"));
		System.out.println(s.contains("Hello"));
		System.out.println(s.indexOf(","));
		System.out.println(s.substring(0, 3));
		
		System.out.println((" Hello   ").trim());
		
		String n = "123";
		
		System.out.println(Integer.parseInt(n));
		System.out.println(Double.parseDouble(n));
		System.out.println(String.valueOf(true));
		System.out.println(Integer.valueOf("123"));
		
		Integer o = 123;
		System.out.println(o.doubleValue());
		System.out.println(Double.toString(o));
	}

}
