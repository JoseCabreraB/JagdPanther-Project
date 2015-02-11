package framework.pages.registereduser;

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
 * @title  RegisteredUserPage
 * @author Jose Cabrera
 * @description Is the page that contains information about Registered Users in a table
 */
public class RegisteredUserPage {

	//declare the instance of Selenium Webdriver
	WebDriver driver;
	
	//The locator of button used for Add A New Registered User
	@FindBy(id = "j_id_t:j_id_16")
	WebElement createRegisteredUserButton;
	
	//The locator of Users Form
	@FindBy(id = "j_id_t:AllUserTable_data")
	WebElement usersTable;

	public RegisteredUserPage() {
		this.driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public NewRegisteredUserPage clickAddNewRegisteredUserButton() {
		createRegisteredUserButton.click();
		return new NewRegisteredUserPage();
	}

	public Boolean addIsEnabled() {
		return createRegisteredUserButton.isEnabled();
	}

	public Boolean isNameinTable(String name) {
		
		return usersTable.getText().contains(name);
		
	}
}
