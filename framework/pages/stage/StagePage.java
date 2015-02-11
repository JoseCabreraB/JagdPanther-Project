package framework.pages.stage;

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
 * @title  StagePage
 * @author Jose Cabrera
 * @description Is the page that contains information about Stages in a table
 */
public class StagePage {
	
	//declare the instance of Selenium Webdriver
	WebDriver driver;
	
	//The locator of button that is used for go to the Add a New Program form
	@FindBy(id = "j_id_t:j_id_10")
	WebElement createStage;

	//The locator of StagePage Form
	@FindBy(id = "j_id_t:stages_data")
	WebElement tableStage;

	public StagePage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public NewStagePage clickAddNewStageButton() {
		createStage.click();
		return new NewStagePage();
	}
	
	public Boolean isNameinTable(String test) {
		return test.contains(test);
	}
}
