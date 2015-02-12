package framework.pages.period;

/**Created by Jose Cabrera
 * 1/24/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.webdriver.SeleniumDriverManager;

/**
 * @title  PeriodPage
 * @author Jose Cabrera
 * @description Is the page that contains information about period in a table 	
 */
public class PeriodPage {
	@FindBy(id = "j_id_t:programs:0:j_id_17") 
	WebElement editButton;

	//declare the instance of Selenium Webdriver
	WebDriver driver;

	public PeriodPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public PeriodDetailsPage clickEditButton(){
		editButton.click();
		return new PeriodDetailsPage();
	}

}
