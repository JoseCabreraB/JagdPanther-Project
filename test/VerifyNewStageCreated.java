package test;

/**Created by Jose Cabrera
 * 1/25/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.stage.StagePage;
import framework.utils.DataProviders;

/**
 * @title  SeeApplicants
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Stage is created correctly
 */
public class VerifyNewStageCreated {
	public NavigationPage navigationPage = new NavigationPage();
	DataConnection delete = new DataConnection();
	
	@Test(dataProvider = "StagesData", dataProviderClass = DataProviders.class)
	public void testVerifyNewStageCreated(String name, String Tittle, String Description) {
		StagePage stage = navigationPage.clickStagesLink()
				.clickAddNewStageButton().create(name, Tittle, Description);
		Assert.assertTrue(stage.isNameinTable(name));
	}
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInStageTable();
	}
}
