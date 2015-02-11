package framework.pages.applicant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.period.PeriodDetailsPage;
import framework.webdriver.SeleniumDriverManager;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */

/**
 * @title  NewApplicantPage
 * @author Jose Cabrera
 * @description Is the page that is used for add applicants to a Period
 */
public class NewApplicantPage {
	
	//declare the instance of Selenium Webdriver
		WebDriver driver;
		
	@FindBy(id = "j_id_t:ci") 
	WebElement textBoxCI;
	
	@FindBy(id = "j_id_t:name") 
	WebElement textBoxName;
	
	@FindBy(id = "j_id_t:lastName") 
	WebElement textBoxLastName;
	
	@FindBy(id = "j_id_t:email") 
	WebElement textBoxEMail;
	
	@FindBy(id = "j_id_t:cellphone") 
	WebElement textBoxCellphone;
	
	@FindBy(id = "j_id_t:j_id_1d") 
	WebElement buttonSave;
	
	public NewApplicantPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	public NewApplicantPage setCI(String ci){
		textBoxCI.sendKeys(ci);
		return this;
	}
	
	public NewApplicantPage setName(String name){
		textBoxName.sendKeys(name);
		return this;
	}
	
	public NewApplicantPage setLastName(String lastName){
		textBoxLastName.sendKeys(lastName);
		return this;
	}
	
	public NewApplicantPage setEMail(String eMail){
		textBoxEMail.sendKeys(eMail);
		return this;
	}
	
	public NewApplicantPage setCellphone(String cellphone){
		textBoxCellphone.sendKeys(cellphone);
		return this;
	}
	
	public PeriodDetailsPage clickSaveButton(){
		buttonSave.click();
		return new PeriodDetailsPage();
	}
	
	public PeriodDetailsPage createApplicant(String ci, String name, String lastName, String eMail, String cellphone){
		setCI(ci);
		setName(name);
		setLastName(lastName);
		setEMail(eMail);
		setCellphone(cellphone);
		return clickSaveButton();
	}
}
