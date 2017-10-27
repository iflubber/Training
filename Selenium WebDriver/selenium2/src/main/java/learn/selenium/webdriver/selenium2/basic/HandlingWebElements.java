package learn.selenium.webdriver.selenium2.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingWebElements {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		//Maximize the browser
		driver.manage().window().maximize();

		//Text Input
		driver.findElement(By.name("firstname")).sendKeys("Amit");
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		
		//Radio button
		WebElement gender_male = driver.findElement(By.xpath("//input[@value='Male']"));
		WebElement gender_female = driver.findElement(By.xpath("//input[@value='Female']"));
		if(!gender_male.isSelected())
			gender_male.click();
		System.out.println("Selection check: Male-" + gender_male.isSelected() + " Female-" + gender_female.isSelected());
		
		driver.findElement(By.id("exp-6")).click();
		
		//Checkbox
		driver.findElement(By.id("profession-1")).click();
		
		//File upload
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
		
		//Select dropdown
		Select single_select = new Select(driver.findElement(By.id("continents")));
		List<WebElement> continents = single_select.getOptions();
		System.out.print("Available Continents: ");
		for(WebElement continent: continents) {
			System.out.print(continent.getText() + ",");
		}
		single_select.selectByVisibleText("Australia");
		System.out.println();
		
		Select multi_select = new Select(driver.findElement(By.id("selenium_commands")));
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
	}

}
