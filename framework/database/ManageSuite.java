package framework.database;

import java.util.*;

import framework.utils.ReadExcel;


public class ManageSuite {
	protected static List<Map<String,String>> programxls;
	protected static List<Map<String,String>> stagesxls;
	protected static List<Map<String,String>> usersxls;
	public static DataConnection preconditions = new DataConnection();
	
	public ManageSuite() throws Exception 
	{
		ReadExcel read = new ReadExcel("C:\\Users\\Jose Cabrera\\workspace\\jagdpanther01\\src\\framework\\utils",
				"testStages.xlsx");
		programxls =read.readExcelHowMap("Programs");
		stagesxls = read.readExcelHowMap("Stages");
		createStagesByBD(stagesxls);
		createProgramsByBD(programxls);
	}
    public static void createProgramsByBD(List<Map<String, String>> programsXLS) throws Exception
    {
        System.out.println("Starting to create Programs......");
        int counterid = 30;
        for (Map<String, String> programInfo : programsXLS)
        {
        	counterid++;
            preconditions.CreateProgram(counterid,programInfo.get("programName"), programInfo.get("programTitle"),programInfo.get("programDescription"));
        }
        System.out.println("Finishing the creation of Programs......");
    }
    public static void createStagesByBD(List<Map<String, String>> stagesXLS) throws Exception
    {
        System.out.println("Starting to create Stages......");
        int counterid = 30;
        for (Map<String, String> stageInfo : stagesXLS)
        {
        	counterid++;
            preconditions.CreateStage(counterid, stageInfo.get("name"), stageInfo.get("title"),stageInfo.get("description"));
        }
        System.out.println("Finishing the creation of Stages......");
    }
}
