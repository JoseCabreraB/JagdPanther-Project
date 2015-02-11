package framework.pages.applicant;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.webdriver.SeleniumDriverManager;

/**
 * @title  ApplicantPage
 * @author Jose Cabrera
 * @description This page contains information about applicants in a table 	
 */
public class ApplicantPage {

	//declare the instance of Selenium Webdriver
	WebDriver driver;
	
	//The locator of button that is used for edit Applicants
	@FindBy(id = "j_id_t:applicants:0:j_id_1g")
	WebElement applicantsEditButton;

	public ApplicantPage() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public Boolean isEditEnabled() {
		return applicantsEditButton.isDisplayed();
	}
}
