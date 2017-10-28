package learn.selenium.webdriver.selenium2.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ComboBox {

	public static void main(String[] args) throws InterruptedException {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		//Launch the web application in Firefox
		driver.get("http://demos.telerik.com/kendo-ui/combobox/cascadingcombobox");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("span.k-widget.k-combobox.k-header.k-combobox-clearable")).click();
		driver.findElement(By.cssSelector("input.k-input.sessioncamexclude[role='combobox']")).sendKeys("Beverages" + Keys.ENTER);

		driver.findElement(By.cssSelector("ul#fieldlist li:nth-child(2)  span.k-widget.k-combobox.k-header.k-combobox-clearable")).click();
		driver.findElement(By.cssSelector("ul#fieldlist li:nth-child(2)  span.k-widget.k-combobox.k-header.k-combobox-clearable span.k-select")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("ul#products_listbox li:nth-child(1)")).click();
	}

}
