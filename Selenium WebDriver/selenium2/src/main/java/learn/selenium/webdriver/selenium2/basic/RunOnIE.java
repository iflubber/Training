package learn.selenium.webdriver.selenium2.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunOnIE {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\drivers\\IE32\\IEDriverServer.exe");
		
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		//Capabilities [{browserAttachTimeout=0, ie.enableFullPageScreenshot=true, enablePersistentHover=true, ie.forceCreateProcessApi=false, 
		//ie.forceShellWindowsApi=false, pageLoadStrategy=normal, ignoreZoomSetting=false, ie.fileUploadDialogTimeout=3000, version=11, platform=WINDOWS, 
		//nativeEvents=true, ie.ensureCleanSession=false, elementScrollBehavior=0, ie.browserCommandLineSwitches=, requireWindowFocus=false, 
		//browserName=internet explorer, initialBrowserUrl=http://localhost:1263/, javascriptEnabled=true, ignoreProtectedModeSettings=false, 
		//enableElementCacheCleanup=true, unexpectedAlertBehaviour=dismiss}]

//		cap.setCapability(CapabilityType.BROWSER_NAME, "IE");
//		cap.setCapability("initialBrowserUrl", "http://demoqa.com/");
//		cap.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://demoqa.com/");
//		cap.setCapability("ignoreProtectedModeSettings", true);
//		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		//instantiating an IE WebDriver object
		WebDriver driver = new InternetExplorerDriver(cap);
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://demoqa.com/");
		
		//Maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Draggable")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
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
		keyAction.keyDown(Keys.CONTROL)
					.click(driver.findElement(By.xpath("//ol[@id='selectable']/li[1]")))
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
