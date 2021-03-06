package test.creation;

/**Created by Jose Cabrera
 * 1/27/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.pages.navigation.NavigationPage;
import framework.pages.program.ProgramPage;
import framework.utils.Randoms;
import framework.database.DataConnection;

/**
 * @title  Verify if a new program is created correctly
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Program is created correctly
 */
public class VerifyNewProgramCreated {
	public NavigationPage navigationPage = new NavigationPage();
	public Randoms ran = new Randoms();
	String name = ran.generateRandomString();
	String title = ran.generateRandomString();
	DataConnection delete = new DataConnection();
	
	@Test(groups = "Acceptance")
	public void testVerifyNewProgramCreated() {
		navigationPage.clickProgramsLink()
		.clickAddNewProgramButton()
		.createProgram(name, title,name);
		ProgramPage Program = navigationPage.clickProgramsLink();
		Assert.assertTrue(Program.isNameEnabled(name));
	}
	
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}

}
