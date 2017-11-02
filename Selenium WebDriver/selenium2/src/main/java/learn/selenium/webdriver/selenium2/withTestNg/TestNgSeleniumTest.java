package learn.selenium.webdriver.selenium2.withTestNg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgSeleniumTest {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @BeforeClass(alwaysRun=true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.co.in/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test (groups= {"group1","group2"},dependsOnMethods={"testGoogleSearch2"})//(dataProvider="searchKeys")
//	  public void testGoogleSearch1(String searchKey) throws Exception {
	  public void testGoogleSearch1() throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys("selenium ide");
	    driver.findElement(By.cssSelector("div.sbibtd")).click();
	    driver.findElement(By.name("btnK")).click();
	    Reporter.log("Google Search: selenium");
	  }

	  @Test //(dependsOnGroups= {"group1"})//(priority=0)//(enabled=false)//(dataProvider="searchKeys")
	  @Parameters({"searchKey"})
	  public void testGoogleSearch2(String searchKey, String str) throws Exception {
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("lst-ib")).clear();
	    driver.findElement(By.id("lst-ib")).sendKeys(searchKey);
	    driver.findElement(By.cssSelector("div.tsf-p")).click();
	    driver.findElement(By.name("btnK")).click();
	    Reporter.log("Google Search: " + searchKey);
	  }

	  @AfterClass(alwaysRun=true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	  
	  @DataProvider(name="searchKeys")
	  public static Object[][] searchStrings() {
		  return new Object[][] {{"selenium grid","test"},{"selenium rc","test"}};
	  }
}
