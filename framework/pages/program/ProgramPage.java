package framework.pages.program;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.program.NewProgramPage;
import framework.pages.program.ProgramDetailPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  ProgramPage
 * @author Jose Cabrera
 * @description Is the page that contains information about programs in a table
 */
public class ProgramPage {

	//declare the instance of Selenium Webdriver
	WebDriver driver;

	@FindBy(id="j_id_y:programs:0:j_id_18") 
	WebElement buttonEdit;

	//The locator of button that is used for go to the Add a New Program form
	@FindBy(id = "j_id_y:j_id_1a")
	WebElement addNewProgramButton;

	//The locator of ProgramsTable
	@FindBy(id = "j_id_y:programs_data")
	WebElement namesPrograms;

	public ProgramPage() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public NewProgramPage clickAddNewProgramButton() {
		addNewProgramButton.click();
		return new NewProgramPage(driver);
	}

	public ProgramDetailPage clickDetailProgram(){
		buttonEdit.click();
		return new ProgramDetailPage();
	}
	public Boolean isNameEnabled(String name) {
		return namesPrograms.getText().contains(name);
	}
}
