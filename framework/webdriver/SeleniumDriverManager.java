package framework.webdriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.log4testng.Logger;
import org.openqa.selenium.TakesScreenshot;

import framework.common.ConstantsConf;

import java.util.concurrent.TimeUnit;
import java.io.File;

/**
 * Manages the web browser
 */
public class SeleniumDriverManager
{
	private static SeleniumDriverManager manager = null;
	private String driverPath=System.getProperty("user.dir");
	private String driverName = ConstantsConf.DRIVERNAME;
	private WebDriver driver;
	private WebDriverWait wait;

	protected SeleniumDriverManager() {
		initializeDriver();
	}

	/**
	 * Select a browser
	 */
	private void initializeDriver() {
		switch(driverName){
			case "chrome":System.setProperty("webdriver.chrome.driver",driverPath+"\\lib\\chromedriver.exe");
			driver = new ChromeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			default: driver = new FirefoxDriver();break;
			case "ie":System.setProperty("webdriver.ie.driver",driverPath+"\\lib\\IEDriverServer32.exe");
			driver = new InternetExplorerDriver();break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ConstantsConf.IMPLICIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(ConstantsConf.EXPLICIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, ConstantsConf.EXPLICIT, 100);
	}

	public static SeleniumDriverManager getManager() {
		if(manager == null) {
			manager = new SeleniumDriverManager();
		}
		return manager;
	}

	/**
	 * Get the Web driver
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	/**
	 * Set to null the webdriver
	 */
	public void quitDriver()     {
		try {
			driver.quit();
		} catch (Exception e) {
			Logger.getLogger(getClass()).error("Unable to quit the webdriver" , e);
		}
		driver = null;
	}
	public static void takesnapShot(WebDriver webdriver,String fileWithPath) throws Exception {
		TakesScreenshot scrShot=((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File (fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
	}
}