package test;

import java.sql.SQLException;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import framework.database.DataConnection;
import framework.pages.navigation.NavigationPage;
import framework.pages.period.PeriodDetailsPage;
import framework.pages.period.PeriodPage;
import framework.utils.DataProviders;

/**
 * Title: Verify that a new period can be created in a program
 * @author Asael Calizaya
 *
 */
public class VerifyNewPeriodWasCreated {

	DataConnection delete = new DataConnection();
	/**
	 * Description:This test case is to verify that a period can be created 
	 * @param name
	 * @param startDate
	 */
	@Test(dataProvider = "PeriodData",dataProviderClass = DataProviders.class)
	public void createPeriod(String startDate, String name, String programid) {
		NavigationPage start = new NavigationPage();
		PeriodDetailsPage detailPage = start
				.clickProgramsLink()
				.clickDetailProgram()
				.clickPeriodButton()
				.clickAddNewPeriodButton()
				.setPeriodName(name)
				.setStartPeriodDate(startDate);
		PeriodPage asser=start.clickPeriodsLink(); 
		Assert.assertTrue(asser.isNameEnabled(name));
	}

	@AfterTest
	public void cleanEnvironment() throws SQLException {
		delete.deleteDataInProgramTable();
	}
}