package learn.selenium.webdriver.selenium2.advanced;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookieManagement {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		//Launch the web application in Firefox
		driver.get("http://automationpractice.com");
		
		//Maximize the browser
//		driver.manage().window().maximize();
		
		//Fetch and print the title of the page
		System.out.println("You have launched: " + driver.getTitle() + " and it's complete url is: " + driver.getCurrentUrl());

		Set<Cookie> allCookies = driver.manage().getCookies();
		System.out.println("Displaying original cookies");
		for(Cookie cookie: allCookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}
		
		driver.manage().addCookie(new Cookie("Selenium","2.0"));
		
		allCookies = driver.manage().getCookies();
		System.out.println("A new cookie added");
		for(Cookie cookie: allCookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}
		
		System.out.println(driver.manage().getCookieNamed("Selenium"));
		
		driver.manage().deleteCookieNamed("Selenium");
		
		allCookies = driver.manage().getCookies();
		System.out.println("New cookie deleted");
		for(Cookie cookie: allCookies) {
			System.out.println(cookie.getName() + ":" + cookie.getValue());
		}
		
	}

}
