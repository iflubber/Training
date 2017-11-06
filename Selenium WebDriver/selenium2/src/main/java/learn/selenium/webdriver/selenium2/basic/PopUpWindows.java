package learn.selenium.webdriver.selenium2.basic;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class PopUpWindows {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://demoqa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Frames and windows")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.titleContains("Frames and windows"));

		String baseWindow = driver.getWindowHandle();

		driver.findElement(By.linkText("New Browser Tab")).click();
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		fluentWait.until(new Function<WebDriver,Boolean>(){
			public Boolean apply(WebDriver d) {
				return d.getWindowHandles().size()>1;
			}
		});
		
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String handle: allWindows) {
			driver.switchTo().window(handle);
			driver.findElement(By.linkText("Draggable")).click();
			wait.until(ExpectedConditions.titleContains("Draggable"));
		}
		
		driver.switchTo().window(baseWindow);
		
		driver.findElement(By.linkText("Frames and windows")).click();
		
		wait.until(ExpectedConditions.titleContains("Frames and windows"));

		driver.findElement(By.linkText("Open Seprate New Window")).click();
//		driver.findElement(By.xpath("//a[contains(@id,'ui-id-2')]")).click();
		driver.findElement(By.linkText("Open New Seprate Window")).click();
		
		fluentWait.until(new Function<WebDriver,Boolean>(){
			public Boolean apply(WebDriver d) {
				return d.getWindowHandles().size()>2;
			}
		});
		
		allWindows = driver.getWindowHandles();
		for(String handle: allWindows) {
			driver.switchTo().window(handle);
			if(driver.getTitle().contains("TOOLSQA"))
				break;
		}
		driver.close();
		driver.switchTo().window(baseWindow);
		driver.findElement(By.linkText("Droppable")).click();
	}

}
