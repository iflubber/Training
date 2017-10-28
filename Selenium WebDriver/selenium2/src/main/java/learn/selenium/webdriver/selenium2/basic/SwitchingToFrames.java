package learn.selenium.webdriver.selenium2.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchingToFrames {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_hide_p");
		
		//Maximize the browser
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("Tryit"));
		
//		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.tagName("button")).click();
		
		driver.switchTo().defaultContent();
	}

}
