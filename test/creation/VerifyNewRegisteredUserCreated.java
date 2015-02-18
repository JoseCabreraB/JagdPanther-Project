package test.creation;

/**
 * Created by Jose Cabrera
 * 1/28/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.registereduser.RegisteredUserPage;
import framework.utils.DataProviders;

/**
 * @title  SeeApplicants
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Registered Users are created correctly
 */
public class VerifyNewRegisteredUserCreated {
	public NavigationPage navigationPage = new NavigationPage();
	DataConnection delete = new DataConnection();
	
	@Test(dataProvider = "UsersData", groups = "Acceptance", dataProviderClass = DataProviders.class)
	public void testVerifyNewRegisteredUserCreated(String ci,String name,String lastname,String email ) {
		RegisteredUserPage users = navigationPage.clickRegisteredUsersLink()
				.clickAddNewRegisteredUserButton()
				.create(ci,name,lastname,email);
		Assert.assertTrue(users.isNameinTable(name));
	}
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInUserTable();
	}
}
