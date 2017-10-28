package learn.selenium.webdriver.selenium2.advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FileAutoDownload {

	public static void main(String[] args) {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(false);
		profile.setAssumeUntrustedCertificateIssuer(true);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
		profile.setPreference("browser.download.manager.showWhenStarting",false); 
		profile.setPreference("browser.download.dir", "C:\\Users\\iflubber\\Downloads"); 
		profile.setPreference("browser.download.downloadDir","C:\\Users\\iflubber\\Downloads"); 
		profile.setPreference("browser.download.defaultFolder","C:\\Users\\iflubber\\Downloads"); 
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/anytext,text/plain,text/html,application/plain,application/excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/zip");

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		WebDriver driver =  new FirefoxDriver(cap);
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
		driver.findElement(By.linkText("Selenium Automation Hybrid Framework")).click();
//		driver.findElement(By.linkText("Test File to Download")).click();
	}

}
