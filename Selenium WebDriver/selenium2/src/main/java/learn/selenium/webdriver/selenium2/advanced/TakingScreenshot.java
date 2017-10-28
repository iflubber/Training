package learn.selenium.webdriver.selenium2.advanced;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;

public class TakingScreenshot {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		//Launch the web application in Firefox
		driver.get("http://automationpractice.com");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Fetch and print the title of the page
		System.out.println("You have launched: " + driver.getTitle() + " and it's complete url is: " + driver.getCurrentUrl());
		
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\output\\ErrorShot_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		//****For RemoteWebDriver in Grid
		// RemoteWebDriver does not implement the TakesScreenshot class
		// if the driver does have the Capabilities to take a screenshot
	    // then Augmenter will add the TakesScreenshot methods to the instance
//	    WebDriver augmentedDriver = new Augmenter().augment(driver);
//	    File screenshot = ((TakesScreenshot)augmentedDriver).
//	               getScreenshotAs(OutputType.FILE);
		
		//close the browser
		driver.close();
		
		//quit webdriver
		driver.quit();
	}

}
