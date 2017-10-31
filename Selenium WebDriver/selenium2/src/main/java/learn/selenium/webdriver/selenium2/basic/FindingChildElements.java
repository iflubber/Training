package learn.selenium.webdriver.selenium2.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingChildElements {

	public static void main(String[] args) throws InterruptedException {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		//Launch the web application in Firefox
		driver.get("http://automationpractice.com/index.php");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Fetch and print the title of the page
		System.out.println("You have launched: " + driver.getTitle() + " and it's complete url is: " + driver.getCurrentUrl());
		
		//Find and action on web elements
		
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();

		List<WebElement> sizes = driver.findElements(By.xpath("//ul[@id='ul_layered_id_attribute_group_1']/child::*"));
		for(WebElement size: sizes) {
			System.out.println(size.getText().split("\\(")[0].trim());
		}
	}

}
