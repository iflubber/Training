package learn.selenium.webdriver.selenium2.framework;

import org.openqa.selenium.WebDriver;

import learn.selenium.webdriver.selenium2.framework.util.PropertyReader;

public class TestDriverFactory {
	private WebDriver driver;
	
	public void googleSearch1(String searchKey) {
		driver = new DriverFactoryExample().getDriver();
		new PageClassExample(driver).typeText(searchKey);
		new PageClassExample(driver).clickButton();
		new DriverFactoryExample().destroyDriver();
	}

	public void googleSearch2(String searchKey) {
		driver = new DriverFactoryExample("chrome").getDriver();
		new PageFactoryExample(driver).typeText(searchKey);
		new PageFactoryExample(driver).clickButton();
		new DriverFactoryExample().destroyDriver();
	}

	public void googleSearch3(String searchKey) {
		String browserType = new PropertyReader().readProperty("browser");
		driver = new DriverFactoryExample(browserType).getDriver();
		new PageFactoryExample(driver).typeText(searchKey);
		new PageFactoryExample(driver).clickButton();
		new DriverFactoryExample().destroyDriver();
	}
}
