package test;

/**
 * Created by Jose Cabrera
 * 1/28/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.registereduser.RegisteredUserPage;

/**
 * @title  SeeApplicants
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Registered Users are created correctly
 */
public class VerifyNewRegisteredUserCreated {
	public NavigationPage navigationPage = new NavigationPage();
	DataConnection delete = new DataConnection();
	@DataProvider(name = "Users")
	/***
	 * 
	 * @return Object[][] that contain information of Registered Users
	 **/
	public Object[][] dataUsers(){
		Object[][] Usersarray = {{"006","23","21","user1@user.com"},
				{"004","24","21","user2@user.com"},
				{"009","25","21","user3@user.com"}};
		return(Usersarray);
	}
	
	@Test(dataProvider = "Users")
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
