package framework.pages;

/**Created by Jose Cabrera
 * 1/24/15
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.pages.navigation.NavigationPage;
import framework.webdriver.SeleniumDriverManager;

/**
 * @title  CreateStagePage
 * @author Jose Cabrera
 * @description Is the page that is used for login in the application
 */
public class LoginPage {
	//declare the instance of Selenium Webdriver
	protected WebDriver driver;

	//The locator used for find an inputUserName TextBox
	@FindBy(id = "j_id_i:userName")
	WebElement txtUser;
	
	//The locator used for find an inputpassword TextBox
	@FindBy(id = "j_id_i:password")
	WebElement txtPass;
	
	//The locator of button used for log on in the application
	@FindBy(id = "j_id_i:j_id_q")
	WebElement loginButton;
	
	//The locator used for close session in the application
	@FindBy(id = "j_id_d")
	WebElement closeSessionLink;

	public LoginPage() {
		driver = SeleniumDriverManager.getManager().getDriver();
		PageFactory.initElements(driver, this);
		driver.get("http://localhost:8080/");
	}

	public NavigationPage clickLogin() {
		loginButton.click();
		return new NavigationPage();
	}

	public void setUser(String user){
		txtUser.sendKeys(user);
	}

	public void setPass(String pass){
		txtPass.sendKeys(pass);
	}

	public NavigationPage login(String username, String password){
		setUser(username);
		setPass(password);
		return clickLogin();
	}
	
	public Boolean getResult(){
		return closeSessionLink.isEnabled();
	}

	public void quit() {
		driver.quit();
	}
}
