package framework.utils;

import org.testng.annotations.DataProvider;

import framework.common.ConstantsConf;


public class DataProviders {
	private static String filePath = ConstantsConf.FILEPATH;
	private static String fileName = ConstantsConf.FILENAME;
	private static ReadExcel excelFile;
	
	/**
	 * This method return data from the XLSX files to Create programs
	 * @return
	 * @throws Exception 
	 */
	@DataProvider(name = "ProgramsData")
	public static Object[][] programData() throws Exception {
		excelFile = new ReadExcel(filePath,fileName);
		return excelFile.readExcelObject("Programs");
	}
	
	/**
	 * This method return data from the XLSX files to Create Periods
	 * @return
	 * @throws Exception 
	 */
	@DataProvider(name = "PeriodData")
	public static Object[][] periodData() throws Exception {
		excelFile = new ReadExcel(filePath,fileName);
		return excelFile.readExcelObject("Periods");
	}
	
		/**
	 * This method return data from the XLSX files to Create Stages
	 * @return
	 * @throws Exception 
	 */
	@DataProvider(name = "StagesData")
	public static Object[][] stageData() throws Exception {
		excelFile = new ReadExcel(filePath,fileName);
		return excelFile.readExcelObject("Stages");
	}
	
	/**
	 * This method return an Object with data to create Users
	 * @return
	 */
	@DataProvider(name = "UsersData")
	public static Object[][] userData(){
		return new Object[][] {{"006","23","21","user1@user.com"},
				{"004","24","21","user2@user.com"},
				{"009","25","21","user3@user.com"}};
		
	}
} 
