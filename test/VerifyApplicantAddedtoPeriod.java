package test;

/**Created by Jose Cabrera
 * 1/27/15
 * 
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	private ReadXMLFile excelFile = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\framework\\webdriver\\config.xml");
	private String excelFilePath = System.getProperty("user.dir")+excelFile.read("datasource","excelpath");
	private String excelName = excelFile.read("datasource","workflowsource");
	private List<Map<String,String>> Applicant;
	DataConnection delete = new DataConnection();
	private ReadExcel read;
	@BeforeTest
	public void preconditions() throws Exception{
		read = new ReadExcel(excelFilePath,excelName);
		BDpreconditions.createProgramsByBD(read.readExcelHowMap("Programs"));
		BDpreconditions.createPeriodByBD(read.readExcelHowMap("Periods"));
	}
	
	@Test
	public void testVerifyNewApplicantCreated() throws IOException {
		Applicant=read.readExcelHowMap("Applicants");
		String ci = Applicant.get(0).get("ci");
		String name = Applicant.get(0).get("name");
		String lastName = Applicant.get(0).get("lastname");
		String email = Applicant.get(0).get("email");
		String cell = Applicant.get(0).get("cell");
		PeriodDetailsPage periods=navigationPage
				.clickPeriodsLink()
				.clickEditButton()
				.clickApplicantButton()
				.clickNewApplicantButton()
				.createApplicant(ci, name, lastName, email, cell);
		Assert.assertTrue(periods.getAllAplicants().contains(name));
	}
	
	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}
}
