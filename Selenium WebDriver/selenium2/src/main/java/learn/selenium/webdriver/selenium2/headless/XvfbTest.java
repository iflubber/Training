package learn.selenium.webdriver.selenium2.headless;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XvfbTest {

	public static void main(String[] args) throws IOException {
		//sudo apt-get install Xvfb firefox
		//Xvfb :1 -screen 0 1024x768x24 &
		// Setup firefox binary to start in Xvfb        
        String Xport = System.getProperty(
                "lmportal.xvfb.id", ":1");
        final File firefoxPath = new File(System.getProperty(
                "lmportal.deploy.firefox.path", "/usr/bin/firefox"));
        FirefoxBinary firefoxBinary = new FirefoxBinary(firefoxPath);
        firefoxBinary.setEnvironmentProperty("DISPLAY", Xport);

        // Start Firefox driver
        WebDriver driver = new FirefoxDriver(firefoxBinary, null);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://google.com/");

        // Take snapshot of browser
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("ffsnapshot.png"));
        driver.quit();	
        
        
//        ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
//                .usingDriverExecutable(new File("/home/Downloads/chromedriver"))
//                .usingAnyFreePort().withEnvironment(ImmutableMap.of("DISPLAY", ":1")).build();
//        chromeDriverService.start();
//        WebDriver driver = new ChromeDriver(chromeDriverService);
    }
}
