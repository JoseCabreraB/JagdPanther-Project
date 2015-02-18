package test;

/**Created by Jose Cabrera
 * 1/27/15
 * 
 */
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import framework.pages.navigation.NavigationPage;
import framework.utils.ReadExcel;
import framework.utils.ReadXMLFile;
import framework.database.BDpreconditions;
import framework.database.DataConnection;

/**
 * @title  Verify if a new program is created correctly
 * @author Jose Cabrera
 * @description Is the page that contains information about 
 * Test that verify if a Program is created correctly
 */

public class VerifyApplicantIsModified {
	public NavigationPage navigationPage = new NavigationPage();
	private ReadXMLFile excelFile = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\config.xml");
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
}
