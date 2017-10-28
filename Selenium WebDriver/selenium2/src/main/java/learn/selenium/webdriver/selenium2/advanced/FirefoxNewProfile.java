package learn.selenium.webdriver.selenium2.advanced;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxNewProfile {

	public static void main(String[] args) {
		//Create a new FirefoxProfile
		FirefoxProfile profile = new FirefoxProfile();
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, profile);

		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver(profile);
//		WebDriver driver = new FirefoxDriver(cap);
		
		//Launch the web application in Firefox
		driver.get("http://automationpractice.com");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Fetch and print the title of the page
		System.out.println("You have launched: " + driver.getTitle() + " and it's complete url is: " + driver.getCurrentUrl());

	}

}
