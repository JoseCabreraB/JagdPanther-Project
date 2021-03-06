package test;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.common.ConstantsConf;
import framework.pages.LoginPage;

/**
 * @title  JagdPantherSuite
 * @author Jose Cabrera
 * @description Is the page that contains information about the before and AfterSuite  	
 */
public class JagdPantherSuite {
	public LoginPage loginPage = new LoginPage();
	
	@BeforeSuite
	public void init() {
		loginPage.login(ConstantsConf.USER,ConstantsConf.PASSWORD);
	}

	@AfterSuite
	public void quit() throws SQLException {
		loginPage.quit();
	}
}
