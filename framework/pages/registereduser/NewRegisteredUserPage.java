package framework.pages.registereduser;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.registereduser.NewRegisteredUserPage;
import framework.pages.registereduser.RegisteredUserPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  CreateRegisteredUserPage
 * @author Jose Cabrera
 * @description Is the page that is used for create Registered Users
 */
public class NewRegisteredUserPage  {

	//declare the instance of Selenium Webdriver
	WebDriver driver;

	//The locator used for find an inputCI TextBox
	@FindBy(id = "j_id_t:inputCi")
	WebElement txtCI;

	//The locator used for find an inputName TextBox
	@FindBy(id = "j_id_t:inputName")
	WebElement txtName;

	//The locator used for find an inputLastName TextBox
	@FindBy(id = "j_id_t:inputLastName")
	WebElement txtLastName;

	//The locator used for find an inputEmail TextBox
	@FindBy(id = "j_id_t:inputEmail")
	WebElement txtEmail;

	//
	@FindBy(id = "j_id_t:j_id_1d")
	WebElement createButton;

	public NewRegisteredUserPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
	}

	public RegisteredUserPage createButton() {
		createButton.click();
		return new RegisteredUserPage();
	}

	public void setCI(String ci) {
		txtCI.clear();
		txtCI.sendKeys(ci);
	}

	public void setName(String name){
		txtName.clear();
		txtName.sendKeys(name);
	}

	public void setLastName(String lastName) {
		txtLastName.clear();
		txtLastName.sendKeys(lastName);
	}

	public void setEmail(String emails) {
		txtEmail.clear();
		txtEmail.sendKeys(emails);
	}
	
	/**
	 * 
	 * @param ci
	 * @param name
	 * @param lastName
	 * @param email
	 * @return
	 */
	public RegisteredUserPage create(String ci, String name, String lastName,String email){
		setCI(ci);
		setName(name);
		setLastName(lastName);
		setEmail(email);
		return createButton();			
	}
}