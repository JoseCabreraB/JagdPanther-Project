package framework.pages.applicant;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.period.PeriodDetailsPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  NewApplicantPage
 * @author Jose Cabrera
 * @description Is the page that is used for add applicants to a Period
 */
public class NewApplicantPage {

	//declare the instance of Selenium Webdriver
	WebDriver driver;

	@FindBy(id = "j_id_t:ci") 
	WebElement txtCI;

	@FindBy(id = "j_id_t:name") 
	WebElement txtName;

	@FindBy(id = "j_id_t:lastName") 
	WebElement txtLastName;

	@FindBy(id = "j_id_t:email") 
	WebElement txtEmail;

	@FindBy(id = "j_id_t:cellphone") 
	WebElement txtCell;

	@FindBy(id = "j_id_t:j_id_1d") 
	WebElement createButton;

	public NewApplicantPage(){
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}
	public void setCI(String ci){
		txtCI.sendKeys(ci);
	}

	public void setName(String name){
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setLastName(String lastName){
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}

	public void setEMail(String eMail){
		txtEmail.clear();
		txtEmail.sendKeys(eMail);
	}

	public void setCell(String cellphone){
		txtCell.clear();
		txtCell.sendKeys(cellphone);
	}

	public PeriodDetailsPage clickSaveButton(){
		createButton.click();
		return new PeriodDetailsPage();
	}

	public PeriodDetailsPage createApplicant(String ci, String name, String lastName, String eMail, String cellphone){
		setCI(ci);
		setName(name);
		setLastName(lastName);
		setEMail(eMail);
		setCell(cellphone);
		return clickSaveButton();
	}
}
