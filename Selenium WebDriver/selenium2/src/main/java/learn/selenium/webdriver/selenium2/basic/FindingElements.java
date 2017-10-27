package learn.selenium.webdriver.selenium2.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindingElements {

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
		WebElement searchField = driver.findElement(By.id("search_query_top"));
		searchField.sendKeys("Dress");
		
		WebElement search = driver.findElement(By.cssSelector("button.btn.btn-default.button-search"));
		search.click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();
		
		driver.findElement(By.name("layered_id_attribute_group_1")).click();
		
		driver.findElement(By.partialLinkText("Orange")).click();
		
		driver.findElement(By.linkText("Cotton (1)")).click();
		
		driver.findElement(By.className("product-container")).click();
		driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']")).click();

		Thread.sleep(5000);
		
		List<WebElement> allButtons = driver.findElements(By.tagName("button"));
		System.out.println("There are " + allButtons.size() + " buttons");
		
		driver.findElement(By.name("Submit")).click();
		
		//close the browser
//		driver.close();
		
		//quit webdriver
//		driver.quit();
	}

}
