package learn.selenium.webdriver.selenium2.withJunit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class JUnitSeleniumRunner {
	 
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(JUnitSeleniumTest.class);
		System.out.println("Total number of tests " + result.getRunCount());
		System.out.println("Total number of tests failed " + result.getFailureCount());
 
		for(Failure failure : result.getFailures())
		{	
			System.out.println(failure.getMessage());
		}
		System.out.println(result.wasSuccessful());
	}
 
}