package test;

/**Created by Jose Cabrera
 * 1/27/15
 * 
 */
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.pages.navigation.NavigationPage;
import framework.pages.period.PeriodDetailsPage;
import framework.utils.ReadExcel;
import framework.utils.ReadXMLFile;
import framework.database.DataConnection;
import framework.database.BDpreconditions;

/**
 * @title  VerifyApplicantAddedtoPeriod
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if an applicant is created correctly
 */
public class VerifyApplicantAddedtoPeriod {
	public NavigationPage navigationPage = new NavigationPage();
	public ReadXMLFile excel=new ReadXMLFile(System.getProperty("user.dir")+"\\src\\framework\\webdriver\\config.xml");
	DataConnection delete = new DataConnection();
	
	@BeforeTest
	public void preconditions() throws Exception{
		ReadExcel read = new ReadExcel(System.getProperty("user.dir")+excel.read("datasource","excelpath"),
				excel.read("datasource","excelnamesource"));
		BDpreconditions.createProgramsByBD(read.readExcelHowMap("Programs"));
		BDpreconditions.createPeriodByBD(read.readExcelHowMap("Periods"));
	}
	
	@Test
	public void testVerifyNewApplicantCreated() {
		 
		PeriodDetailsPage periods=navigationPage
				.clickPeriodsLink()
				.clickEditButton()
				.clickApplicantButton()
				.clickNewApplicantButton()
				.createApplicant("78910", "namessdds", "lastName", "jos@sjos.com", "75625632");
		Assert.assertTrue(periods.getAllAplicants().contains("name"));
	}
	
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}
}
