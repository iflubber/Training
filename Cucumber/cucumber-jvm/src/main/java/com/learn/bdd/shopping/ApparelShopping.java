package com.learn.bdd.shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.Before;

public class ApparelShopping {
	static WebDriver driver;
	
	@Before("@selenium")
	public static void setup() {
		driver = new FirefoxDriver();
	}
	
	public static void launchApp(String URL) {
		driver.get("http://" + URL);
		driver.manage().window().maximize();
	}
	
	public static void selectApparelCategory(String apparelType) {
		driver.findElement(By.xpath(".//*[@id='block_top_menu']/ul/li[3]/a")).click();
	}
	
	public static String verifySearchResult() {
		return driver.findElement(By.xpath("//span[@class='heading-counter']")).getText();
	}
	
	public static void selectSize(String size) {
		driver.findElement(By.name("layered_id_attribute_group_1")).click();
	}
}
