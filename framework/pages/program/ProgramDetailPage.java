package framework.pages.program;

/**Created by Jose Cabrera
 * 1/29/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.period.PeriodDetailsPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  ProgramDetailPage
 * @author Jose Cabrera
 * @description Is the page that contains details about a program
 */
public class ProgramDetailPage {
	//declare the instance of Selenium Webdriver
	WebDriver driver;

	@FindBy(id = "j_id_t:nameInput_display") 
	WebElement programName;

	@FindBy(xpath = "//a[contains(text(),'Periodos')]") 
	WebElement buttonPeriod;

	@FindBy(id = "j_id_t:programTabDetails:j_id_1l") 
	WebElement buttonAddPeriod;

	public ProgramDetailPage() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public ProgramDetailPage clickPeriodButton(){
		buttonPeriod.click();
		return this;
	}

	public PeriodDetailsPage clickAddNewPeriodButton(){
		buttonAddPeriod.click();
		return new PeriodDetailsPage();
	}

	public String getNameProgram(){
		return programName.getText();
	}
}
