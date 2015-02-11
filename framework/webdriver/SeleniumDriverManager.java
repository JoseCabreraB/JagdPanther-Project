package framework.webdriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.log4testng.Logger;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;
import java.io.File;

/**
 * Manages the web browser
 */
public class SeleniumDriverManager
{
    private static SeleniumDriverManager manager = null;
    private WebDriver driver;
    private WebDriverWait wait;

    protected SeleniumDriverManager() {
        initializeDriver();
    }
    
    /**
     * Select a browser
     */
    private void initializeDriver() {
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30, 100);
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