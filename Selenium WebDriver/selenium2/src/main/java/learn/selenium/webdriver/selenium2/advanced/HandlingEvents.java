package learn.selenium.webdriver.selenium2.advanced;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingEvents {

	public static void main(String[] args) {
        FirefoxDriver driver = new FirefoxDriver();
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);

		WebDriverEventHandler handler = new WebDriverEventHandler();
		eventDriver.register(handler);
		eventDriver.manage().deleteAllCookies();
		eventDriver.get("http://toolsqa.com/automation-practice-form/");
		WebDriverWait wait = new WebDriverWait(eventDriver,10);
		wait.until(ExpectedConditions.titleContains("Demo Form"));

		//Maximize the browser
//		eventDriver.manage().window().maximize();

		//Text Input
		eventDriver.findElement(By.name("firstname")).sendKeys("Amit");
		eventDriver.findElement(By.name("lastname")).sendKeys("Kumar");
		
		//Radio button
		WebElement gender_male = eventDriver.findElement(By.xpath("//input[@value='Male']"));
		WebElement gender_female = eventDriver.findElement(By.xpath("//input[@value='Female']"));
		if(!gender_male.isSelected())
			gender_male.click();
		System.out.println("Selection check: Male-" + gender_male.isSelected() + " Female-" + gender_female.isSelected());
		
		eventDriver.findElement(By.id("exp-6")).click();
		
		//Checkbox
		eventDriver.findElement(By.id("profession-1")).click();
		
		//File upload
		eventDriver.findElement(By.id("photo")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
		
		//Select dropdown
		Select single_select = new Select(eventDriver.findElement(By.id("continents")));
		List<WebElement> continents = single_select.getOptions();
		System.out.print("Available Continents: ");
		for(WebElement continent: continents) {
			System.out.print(continent.getText() + ",");
		}
		single_select.selectByVisibleText("Australia");
		System.out.println();
		
		Select multi_select = new Select(eventDriver.findElement(By.id("selenium_commands")));
		System.out.println("Multi-select? " + multi_select.isMultiple());
		multi_select.deselectAll();
		multi_select.selectByIndex(0);
		multi_select.selectByVisibleText("Switch Commands");
		multi_select.selectByVisibleText("WebElement Commands");
		
		System.out.println("You first selected: " + multi_select.getFirstSelectedOption().getText());
		List<WebElement> selected_options = multi_select.getAllSelectedOptions();
		for(WebElement selected_option: selected_options) {
			System.out.print(selected_option.getText() + ",");
		}
		
		eventDriver.unregister(handler);
		
		eventDriver.close();
		eventDriver.quit();
	}
}
