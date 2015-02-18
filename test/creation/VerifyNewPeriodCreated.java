package test.creation;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.database.BDpreconditions;
import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.period.PeriodDetailsPage;
import framework.utils.DataProviders;
import framework.utils.ReadExcel;
import framework.utils.ReadXMLFile;

/**
 * @title  Verify if a new period is created correctly
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Period is created correctly
 */
public class VerifyNewPeriodCreated {
	private DataConnection delete = new DataConnection();
	private ReadXMLFile excelFile = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\config.xml");
	private String excelFilePath = System.getProperty("user.dir")+excelFile.read("datasource","excelpath");
	private String excelName = excelFile.read("datasource","workflowsource");
	private ReadExcel read;
	/**
	 * Description:This test case is to verify that a period can be created 
	 * @param name
	 * @param startDate
	 */
	@BeforeTest
	public void preconditions() throws Exception{
		read = new ReadExcel(excelFilePath,excelName);
		BDpreconditions.createProgramsByBD(read.readExcelHowMap("Programs"));
	}
	@Test(dataProvider = "PeriodData",groups = "Acceptance", dataProviderClass = DataProviders.class)
	public void createPeriod(String startDate, String name, String programid) throws Exception {
		NavigationPage start = new NavigationPage();
		@SuppressWarnings("unused")
		PeriodDetailsPage detailPage = start
				.clickProgramsLink()
				.clickDetailProgram()
				.clickPeriodButton()
				.clickAddNewPeriodButton()
				.setPeriodName(name)
				.setStartPeriodDate(startDate);
		Assert.assertEquals(delete.getName("jp_period",name), name);
	}

	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}
}