package learn.core.java;

public class Methods {
	int n1;
	int n2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methods obj = new Methods();
		obj.n1 = 29;
		obj.n2 = 10;
		
		System.out.println(obj.sum(obj.n1,obj.n2));
		System.out.println(obj.sum(obj.n1, obj.n2, "Addition"));
		
		obj.display("One","Two");
		obj.display("One","Two","Three","Four","Five");
	}
	
	int sum(int n1,int n2) {
		return n1+n2;
	}
	
	double sum(double n1, double n2) {
		return n1 + n2;
	}
	
	int sum(int n1, int n2, String msg) {
		System.out.println(msg);
		return n1+n2;
	}
	
	void display(String s1, String s2) {
		System.out.println(s1 + "," + s2);
	}
	
	void display(String...strings) {
		for(String s: strings) {
			System.out.print(s + ",");
		}
	}
	
	int generateRandomInt() {
		return (int)Math.random()*100;
	}
}
