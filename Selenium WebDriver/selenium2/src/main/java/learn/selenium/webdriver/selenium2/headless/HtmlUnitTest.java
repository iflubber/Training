package learn.selenium.webdriver.selenium2.headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class HtmlUnitTest {

	public static void main(String[] args) throws InterruptedException {
		
//		DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
		//instantiating a Google Chrome WebDriver object
		WebDriver driver = new HtmlUnitDriver();
//		WebDriver driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_38);
//		WebDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
//		WebDriver driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER_11);
		
//		driver.setJavascriptEnabled(true);
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://demoqa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Draggable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.titleContains("Draggable"));
		System.out.println(driver.getTitle());
		
//		Actions dragAction = new Actions(driver);
//		dragAction.clickAndHold(driver.findElement(By.id("draggable"))).build().perform();
//		dragAction.moveByOffset(100, 100).build().perform();
//		dragAction.release().perform();
		
		driver.findElement(By.linkText("Droppable")).click();
		wait.until(ExpectedConditions.titleContains("Droppable"));
		System.out.println(driver.getTitle());
		
		Actions dragDropAction = new Actions(driver);
		dragDropAction.dragAndDrop(driver.findElement(By.id("draggableview")), driver.findElement(By.id("droppableview"))).build().perform();
		
		driver.findElement(By.linkText("Selectable")).click();
		wait.until(ExpectedConditions.titleContains("Selectable"));
		System.out.println(driver.getTitle());
		
		Actions keyAction = new Actions(driver);
		keyAction.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[2]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
										.keyUp(Keys.CONTROL)
										.build().perform();
		
		driver.findElement(By.linkText("Sortable")).click();
		wait.until(ExpectedConditions.titleContains("Sortable"));
		System.out.println(driver.getTitle());
		
//		int h = driver.findElement(By.id("sortable")).getSize().height;
		
		int n = (driver.findElements(By.xpath(".//*[@id='sortable']/li"))).size();
		
		Actions builder = new Actions(driver);
		for(int i=1;i<n;i++) {
			Action sort = builder.clickAndHold(driver.findElement(By.xpath(".//*[@id='sortable']/li[" + n + "]")))
								.moveToElement(driver.findElement(By.xpath(".//*[@id='sortable']/li[" + i + "]")))
								.release(driver.findElement(By.xpath(".//*[@id='sortable']/li[" + i + "]")))
								.build();
			sort.perform();
			Thread.sleep(3000);
		}
	}

}
