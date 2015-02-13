package test;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.pages.LoginPage;
import framework.utils.ReadXMLFile;

/**
 * @title  JagdPantherSuite
 * @author Jose Cabrera
 * @description Is the page that contains information about the before and AfterSuite  	
 */
public class JagdPantherSuite {
	public LoginPage loginPage = new LoginPage();
	
	@BeforeSuite
	public void init() {
		ReadXMLFile read = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\framework\\webdriver\\config.xml");
		loginPage.login(read.read("login", "user"),
				read.read("login", "password"));
	}

	@AfterSuite
	public void quit() throws SQLException {
		loginPage.quit();
	}
}
