package framework.pages.program;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.common.AbstractNewFormStageOrProgram;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  CreateProgramPage
 * @author Jose Cabrera
 * @description Is the page that is used for create Programs
 */
public class NewProgramPage extends AbstractNewFormStageOrProgram {
	
	//The locator of button that is used for create a new Program
	@FindBy(id = "form:j_id_18")
	WebElement createButton;

	public NewProgramPage(WebDriver driver) {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public ProgramPage clickCreateButton(){
		createButton.click();
		return new ProgramPage();
	}

	/**
	 * This method is used to create a new program
	 * @param name
	 * @param title
	 * @param description
	 * @return
	 */
	public ProgramPage createProgram(String name, String title, String description){
		setName(name);
		setTitle(title);
		setDescription(description);
		return clickCreateButton();
	}
}
