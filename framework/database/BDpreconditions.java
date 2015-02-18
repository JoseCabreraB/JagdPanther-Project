package framework.database;

/**Created by Jose Cabrera
 * 2/9/15
 * 
 */
import java.util.*;

/**
 * @title  BDpreconditions
 * @author Jose Cabrera
 * @description Is the page that contains preconditions that can executed for database 
 * */
public class BDpreconditions {
	public static DataConnection preconditions = new DataConnection();

	public BDpreconditions() throws Exception 
	{	
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
	public static void createPeriodByBD(List<Map<String, String>> periodsXLS) throws Exception
	{
		System.out.println("Starting to create Periods......");
		int counterid = 30;
		for (Map<String, String> periodInfo : periodsXLS)
		{
			counterid++;
			preconditions.CreatePeriod(counterid, periodInfo.get("initialDate"),periodInfo.get("name"), "ACTIVE",periodInfo.get("programID"));
		}
		System.out.println("Finishing the creation of Periods......");
	}
}
