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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhantomJSTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("phantomjs.binary.path", "C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\drivers\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.phantomjs();
		cap.setJavascriptEnabled(true);
		cap.setCapability("takesScreenshot", true);
		
		//instantiating a Google Chrome WebDriver object
		WebDriver driver = new PhantomJSDriver(cap);
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://demoqa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		takesScreenshot(driver);
		
		driver.findElement(By.linkText("Draggable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.titleContains("Draggable"));
		System.out.println(driver.getTitle());
		takesScreenshot(driver);
		
		Actions dragAction = new Actions(driver);
		dragAction.clickAndHold(driver.findElement(By.id("draggable"))).build().perform();
		dragAction.moveByOffset(100, 100).build().perform();
		dragAction.release().perform();
		takesScreenshot(driver);
		
		driver.findElement(By.linkText("Droppable")).click();
		wait.until(ExpectedConditions.titleContains("Droppable"));
		System.out.println(driver.getTitle());
		takesScreenshot(driver);
		
		Actions dragDropAction = new Actions(driver);
		dragDropAction.dragAndDrop(driver.findElement(By.id("draggableview")), driver.findElement(By.id("droppableview"))).build().perform();
		takesScreenshot(driver);
		
		driver.findElement(By.linkText("Selectable")).click();
		wait.until(ExpectedConditions.titleContains("Selectable"));
		System.out.println(driver.getTitle());
		takesScreenshot(driver);
		
		Actions keyAction = new Actions(driver);
		keyAction.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[2]")))
										.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[4]")))
										.keyUp(Keys.CONTROL)
										.build().perform();
		takesScreenshot(driver);
		
		driver.findElement(By.linkText("Sortable")).click();
		wait.until(ExpectedConditions.titleContains("Sortable"));
		System.out.println(driver.getTitle());
		takesScreenshot(driver);
		
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
		takesScreenshot(driver);
	}

	public static void takesScreenshot(WebDriver driver) {
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\output\\PhantomJSShot_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
