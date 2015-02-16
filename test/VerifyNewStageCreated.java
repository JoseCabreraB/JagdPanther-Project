package test;

/**Created by Jose Cabrera
 * 1/25/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.stage.StagePage;
import framework.utils.ReadExcel;
import framework.utils.ReadXMLFile;

/**
 * @title  SeeApplicants
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Stage is created correctly
 */
public class VerifyNewStageCreated {
	public NavigationPage navigationPage = new NavigationPage();
	public ReadXMLFile excel=new ReadXMLFile(System.getProperty("user.dir")+"\\src\\framework\\webdriver\\config.xml");
	DataConnection delete = new DataConnection();
	
	@DataProvider(name = "Stages")
	/***
	 * 
	 * @return Object[][] that contain information of stages
	 * @throws IOException if a excel file can not read
	 */
	public Object[][] createStage() throws Exception {
		ReadExcel read = new ReadExcel(System.getProperty("user.dir")+excel.read("datasource","excelpath"),
				excel.read("datasource","datadrivensource"));
		Object[][] data = read.readExcelObject("Stages");
		return data;
	}
	
	@Test(dataProvider = "Stages")
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
