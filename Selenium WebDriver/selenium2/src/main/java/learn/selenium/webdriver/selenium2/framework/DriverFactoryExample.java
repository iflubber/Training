package learn.selenium.webdriver.selenium2.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactoryExample {
	protected WebDriver driver;
	
	public DriverFactoryExample() {
		initialize();
	}
	
	public DriverFactoryExample(String browserType) {
		initialize(browserType);
	}
	
	public void initialize() {
		if(driver==null)
			createNewDriverInstance();
	}
	
	public void initialize(String browserType) {
		if(driver==null)
			createNewDriverInstance(browserType);
	}
	
	private void createNewDriverInstance() {
		driver = new FirefoxDriver();
	}
	
	private void createNewDriverInstance(String browserType) {
		switch (browserType) {
		case "firefox":
			System.out.println("Opening firefox driver");
			driver = new FirefoxDriver();
		case "chrome":
			System.out.println("Opening chrome driver");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		case "IE":
			System.out.println("Opening IE driver");
			System.setProperty("webdriver.ie.driver", "C:\\Users\\iflubber\\Desktop\\Training\\Selenium WebDriver\\drivers\\IE32\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = new FirefoxDriver();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void destroyDriver() {
		driver.quit();
		driver = null;
	}
}
