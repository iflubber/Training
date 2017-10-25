package learn.core.java.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListWithGenericsSample {

	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();  // List of type String
	      lst.add("alpha");         // compiler checks if argument's type is String
	      lst.add("beta");
	      lst.add("charlie");
	      System.out.println(lst);  // [alpha, beta, charlie]
	 
	      Iterator<String> iter = lst.iterator();   // Iterator of Strings
	      while (iter.hasNext()) {
	         String str = iter.next();  // compiler inserts downcast operator
	         System.out.println(str);
	      }
	 
	      for (String str : lst) {
	         System.out.println(str);
	      }	

	      //List to array
	      Object[] strArray1 = lst.toArray();
	      System.out.println(Arrays.toString(strArray1));   // [alpha, beta, charlie]
	 
	      // Use the generic type verion - Need to specify the type in the argument
	      String[] strArray2 = lst.toArray(new String[0]);
	      strArray2[0] = "delta";   // modify the returned array
	      System.out.println(Arrays.toString(strArray2));   // [delta, beta, charlie]
	      System.out.println(lst);  // [alpha, beta, charlie] - no change in the original list	 
	      
	      
	      //Array as List
	      String[] strs = {"alpha", "beta", "charlie"};
	      System.out.println(Arrays.toString(strs));   // [alpha, beta, charlie]
	 
	      List<String> strlst = Arrays.asList(strs);
	      System.out.println(strlst);  // [alpha, beta, charlie]
	 
	      // Changes in array or list write through
	      strs[0] += "88";
	      strlst.set(2, strlst.get(2) + "99");
	      System.out.println(Arrays.toString(strs)); // [alpha88, beta, charlie99]
	      System.out.println(strlst);  // [alpha88, beta, charlie99]
	 
	      // Initialize a list using an array
	      List<Integer> lstInt = Arrays.asList(22, 44, 11, 33);
	      System.out.println(lstInt);  // [22, 44, 11, 33]	      
	}
}
