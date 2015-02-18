package framework.utils;

import org.testng.annotations.DataProvider;


public class DataProviders {
	private static ReadXMLFile excel=new ReadXMLFile(System.getProperty("user.dir")+"\\src\\config.xml");
	private static String filePath = System.getProperty("user.dir")+excel.read("datasource","excelpath");
	private static String fileName = excel.read("datasource","datadrivensource");
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
	 * This method return an Object with data to create Applicants
	 * @return
	 */
	@DataProvider(name = "ApplicantData")
	public static Object[][] applicantData(){
		return new Object[][]{
				{"10001","NameApplicant","LastNameApplicant","Name1@LastName.com","777777771"},
				{"10002","NameApplicante","LastNameApplicant","Name1@LastName2.com","777777772"}
		};
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
		return new Object[][] {
				{"1234","userName1","userLastName1","user@lastName1.com"},
				{"1235","userName2","userLastName2","user@lastName2.com"}
		};
	}
} 
