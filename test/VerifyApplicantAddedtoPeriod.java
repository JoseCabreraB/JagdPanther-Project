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
import framework.utils.Randoms;
import framework.utils.ReadExcel;
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
	public Randoms ran = new Randoms();
	String name = ran.generateRandomString();
	String title = ran.generateRandomString();
	DataConnection delete = new DataConnection();
	
	@BeforeTest
	public void preconditions() throws Exception{
		ReadExcel read = new ReadExcel("C:\\Users\\Jose Cabrera\\workspace\\jagdpanther01\\src\\framework\\utils",
				"testStages.xlsx");
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
				.createApplicant("1234", "name", "lastName", "jos@jos.com", "75625632");
		Assert.assertTrue(periods.getAllAplicants().contains("name"));
	}
	
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}
}
