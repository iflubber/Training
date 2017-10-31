package learn.core.java;

interface printable{  
	void print();  
}  

public class InterfaceSample implements printable{  
	public void print(){
		System.out.println("Hello");
	}  
	  
	public static void main(String args[]){  
	InterfaceSample obj = new InterfaceSample();  
		obj.print();  
	}  
}  