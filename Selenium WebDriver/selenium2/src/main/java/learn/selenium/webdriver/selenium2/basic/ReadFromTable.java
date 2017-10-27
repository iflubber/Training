package learn.selenium.webdriver.selenium2.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadFromTable {

	public static void main(String[] args) {
		//instantiating a Firefox WebDriver object
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		//Launch the web application in Firefox
		driver.get("http://toolsqa.com/automation-practice-table/");
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Read the headers
		List<WebElement> headers = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead/tr/th"));
		for(WebElement header:headers) {
			System.out.println(header.getText());
		}
		int cols = headers.size();
		System.out.println("No. of data columns: " + cols);
		
		List<WebElement> dataRows = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr"));
		int rows = dataRows.size();
		System.out.println("No. of data rows: " + dataRows.size());
		
		List<Map<String,String>> tableData = new ArrayList<Map<String,String>>();
		Map<String,String> rowData;
		
		for(WebElement dataRow: dataRows) {
			List<WebElement> colData = dataRow.findElements(By.xpath("child::td | child::th"));
			int i=0;
			rowData = new HashMap<String,String>();
			for(WebElement column: colData) {
				rowData.put(headers.get(i).getText(), column.getText());
				i++;
			}
			tableData.add(rowData);
		}
		
		System.out.println(tableData);
		
	}

}
