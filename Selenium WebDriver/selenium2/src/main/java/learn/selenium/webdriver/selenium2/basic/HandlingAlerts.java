package learn.selenium.webdriver.selenium2.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingAlerts {

	public static void main(String[] args) throws InterruptedException {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		//Launch the web application in Firefox
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		
		//Maximize the browser
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("Tryit"));
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.tagName("button")).click();
		
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		wait.until(ExpectedConditions.titleContains("TOOLSQA"));
		
		WebElement element = driver.findElement(By.xpath("//button[contains(.,'Simple Alert')]"));
//        ((JavascriptExecutor) driver).executeScript(
//                "arguments[0].scrollIntoView();", element);
        
		element.click();
		element.click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		while(isAlertPresent(driver)) {}
		
		driver.findElement(By.xpath("//button[contains(.,'Confirm Pop up')]")).click();
		driver.findElement(By.xpath("//button[contains(.,'Confirm Pop up')]")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.dismiss();
		
		while(isAlertPresent(driver)) {}
		
		driver.findElement(By.xpath("//button[contains(.,'Prompt Pop up')]")).click();		
//		driver.findElement(By.xpath("//button[contains(.,'Prompt Pop up')]")).click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Yes");
		alert.accept();
	}

	  private static boolean isAlertPresent(WebDriver driver) {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }
}
