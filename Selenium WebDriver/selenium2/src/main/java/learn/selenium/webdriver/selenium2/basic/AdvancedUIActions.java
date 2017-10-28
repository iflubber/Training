package learn.selenium.webdriver.selenium2.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdvancedUIActions {

	public static void main(String[] args) throws InterruptedException {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://demoqa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Draggable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.titleContains("Draggable"));
		
		Actions dragAction = new Actions(driver);
		dragAction.clickAndHold(driver.findElement(By.id("draggable"))).build().perform();
		dragAction.moveByOffset(100, 100).build().perform();
		dragAction.release().perform();
		
		driver.findElement(By.linkText("Droppable")).click();
		wait.until(ExpectedConditions.titleContains("Droppable"));
		
		Actions dragDropAction = new Actions(driver);
		dragDropAction.dragAndDrop(driver.findElement(By.id("draggableview")), driver.findElement(By.id("droppableview"))).build().perform();
		
		driver.findElement(By.linkText("Selectable")).click();
		wait.until(ExpectedConditions.titleContains("Selectable"));
		
		Actions keyAction = new Actions(driver);
		keyAction.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[2]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
										.keyUp(Keys.CONTROL)
										.build().perform();
		
		driver.findElement(By.linkText("Sortable")).click();
		wait.until(ExpectedConditions.titleContains("Sortable"));
		
		int h = driver.findElement(By.id("sortable")).getSize().height;
		
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
