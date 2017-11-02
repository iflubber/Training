package learn.selenium.webdriver.selenium2.basic;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Synchronization {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		//Launch the web application in Firefox
		driver.get("http://automationpractice.com/index.php");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Set implicit timeouts
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Fetch and print the title of the page
		System.out.println("You have launched: " + driver.getTitle() + " and it's complete url is: " + driver.getCurrentUrl());
		
		driver.findElement(By.linkText("Sign in")).click();
		
		//explicit wait - webdriver wait
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("Login"));
		
		driver.findElement(By.id("email")).sendKeys("abc_123@xyz.com");
		driver.findElement(By.id("passwd")).sendKeys("Test123456");
		driver.findElement(By.id("SubmitLogin")).click();
		
		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver d) {
				return d.getTitle().contains("My account");
			}
		});
		
		WebElement searchField = driver.findElement(By.id("search_query_top"));
		searchField.sendKeys("Dress");
		
		WebElement search = driver.findElement(By.cssSelector("button.btn.btn-default.button-search"));
		search.click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement search_result = fluentWait.until(new Function<WebDriver,WebElement>(){
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath("//span[contains(.,'results have been found.')]"));
			}
		});
		
		System.out.println(search_result.getText());
		
		driver.findElement(By.className("icon-th-list")).click();
		(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.product_list.row.list")));
		System.out.println("Switched to List view");
	}

}
