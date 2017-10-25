package learn.core.java.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s1 = new HashSet<String>();
		s1.add("one");
		s1.add("one"); //duplicate not added
		s1.add("two");
		s1.add("three");
		s1.add(null); //null allowed
		System.out.println(s1);
		s1.remove(null);
		System.out.println(s1);
		
		Set<String> s2 = new HashSet<String>();
		s2.add("zero");
		s2.addAll(s1); //union with set1
		System.out.println(s2);
		s2.retainAll(s1);
		System.out.println(s2);//intersection with set1
		
		Set<String> s3 = new LinkedHashSet<String>();
		s3.add("one");
		s3.add("two");
		s3.add("three");
		s3.add(null);
		System.out.println(s3);//order maintained in the insertion order
	}

}
