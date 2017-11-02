package learn.selenium.webdriver.selenium2.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryExample {
	WebDriver driver;
	
	@FindBy(id="lst-ib")
	private WebElement searchField;
	
	@FindBy(id="btnK")
	private WebElement searchButton;
	
	public PageFactoryExample(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeText(String searchKey) {
		searchField.sendKeys(searchKey);
	}
	
	public void clickButton() {
		searchButton.click();
	}
}
