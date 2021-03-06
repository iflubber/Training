package learn.selenium.webdriver.selenium2.advanced;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverEventHandler implements WebDriverEventListener{
	 
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
 
		System.out.println("inside method afterChangeValueOf on " + arg0.toString());
	}
 
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("inside method afterClickOn on " + arg0.toString());
	}
 
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("Find happened on " + arg0.toString()); 
//				+ " Using method " + arg0.toString());
	}
 
	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
 
		System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
	}
 
	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
	}
 
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inside the afterNavigateTo to " + arg0);
	}
 
	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Inside the afterScript to, Script is " + arg0);
	}
 
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
 
		System.out.println("Inside the beforeChangeValueOf method");
	}
 
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("About to click on the " + arg0.toString());
 
	}
 
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		System.out.println("Just before finding element " + arg0.toString());
 
	}
 
	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
 
	}
 
	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub
		System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
 
	}
 
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Just before beforeNavigateTo " + arg0);
	}
 
	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		System.out.println("Just before beforeScript " + arg0);
	}
 
	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		File src= ((TakesScreenshot)arg1).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\output\\ErrorShot_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Exception occured at " + arg0.getMessage());
 
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("Befor page refresh");
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		System.out.println("After page refresh");
	}
 
}
