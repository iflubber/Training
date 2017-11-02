package learn.selenium.webdriver.selenium2.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageClassExample {
	WebDriver driver;
	
	String searchField = "lst-ib";
	By searchButton = By.id("btnK");
	
	public PageClassExample(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeText(String searchKey) {
		driver.findElement(By.id(searchField)).sendKeys(searchKey);
	}
	
	public void clickButton() {
		driver.findElement(searchButton).click();
	}
}
