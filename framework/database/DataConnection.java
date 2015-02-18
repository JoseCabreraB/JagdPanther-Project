package framework.database;

/**Created by Jose Cabrera
 * 1/28/15
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import framework.utils.ReadXMLFile;

/**
 * @title  DataConnection
 * @author Jose Cabrera
 * @description Is the page that contains information about the database connection
 * */
public class DataConnection {

	/***
	 ** @param Connection conex : this is the connection by default
	 *  @param Statement statement : Is the instance that permit execute querys 
	 *  @param String dirDB : The address where is located database
	 *  @param String userDB : The user of MySql
	 *  @param String passDB : The password of user of MySql 
	 */
	public static ReadXMLFile db_info = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\framework\\webdriver\\config.xml");
	private static Connection conex = null;
	private static Statement statement;
	private static String DIR_DB = db_info.read("db","dir_db");   
	private static String USER_DB = db_info.read("db","user_db");
	private static String PASS_DB = db_info.read("db","pass_db");
	private String idCondition = "ID > 0";

	/**
	 * This constructor initialize the connection with data base
	 */
	public DataConnection() {
		try {
			String dbClass = "com.mysql.jdbc.Driver";
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(DIR_DB, USER_DB, PASS_DB);
			statement = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void deleteData(String tableName, String condition) throws SQLException{
		try{
			String query = "DELETE FROM " + tableName + " WHERE " + condition;
			statement.execute(query);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (conex != null){
				conex.close();
			}
		}
	}

	/**
	 * This method is used to delete all periods from data base
	 * @throws SQLException
	 */
	public void deleteDataInPeriodTable() throws SQLException {
		deleteData("jp_period",idCondition);
	}

	/**
	 * This method is used to delete all applicants and users from data base 
	 * except the admin user
	 * @throws SQLException
	 */
	public void deleteDataInUserTable() throws SQLException {
		deleteData("login_register",idCondition);
		deleteData("user_period","APPLICANT_"+idCondition);
		deleteData("user_period","APPLICANT_"+idCondition);
		deleteData("message",idCondition);
		deleteData("jp_user","CI != 123");
	}

	/**
	 * This method is to delete all programs from data base 
	 * @throws SQLException
	 */
	public void deleteDataInProgramTable() throws SQLException {
		deleteDataInUserTable();
		deleteDataInPeriodTable();
		deleteData("jp_group","GROUP_"+idCondition);
		deleteData("program",idCondition);
	}

	/**
	 * This method is to delete all Stages from data base 
	 * @throws SQLException
	 */
	public void deleteDataInStageTable() throws SQLException {
		deleteData("stage_value",idCondition);
		deleteData("stage",idCondition);
	}

	/**
	 *  This method is to create a new program
	 * @param id: program ID
	 * @param name: program Name
	 * @param title: program Title
	 * @param description: program Description
	 * @throws SQLException
	 */
	public void CreateProgram(int id, String name, String title, String description) throws SQLException {
		try {
			String query = "INSERT INTO program VALUES ('" + id + "', '" + description + "', '" + name + "', '" + title + "')";
			statement.execute(query);    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conex != null) {
				conex.close();
			}
		}
	}

	/**
	 *  This method is to create a new stage
	 * @param id: stage ID
	 * @param name: stage Name
	 * @param title: stage Title
	 * @param description: stage Description
	 * @throws SQLException
	 */
	public void CreatePeriod(int id, String initDate, String name, String periodState, String programID) throws SQLException {
		try {
			String query = "INSERT INTO jp_period(`ID`, `INITIALDATE`, `NAME`, `PERIODSTATE`, `PROGRAM_ID`) VALUES (" + id + ", '" + initDate + "', '" + name + "', '" + periodState + "', " + programID + ");";
			statement.execute(query);    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conex != null) {
				conex.close();
			}
		}
	}

	/**
	 *  This method is to create a new stage
	 * @param id: period ID
	 * @param initDate: initial date to stage
	 * @param name: period name
	 * @param periodState: period state
	 * @param programID: program Id where the period will be created
	 * @throws SQLException
	 */

	public void CreateStage(int id, String name, String title,
			String description) throws Exception {
		try {
			String query = "INSERT INTO stage VALUES ('" + id + "', '" + description + "', '0', '"+ name + "', '" + title + "', '0')";
			statement.execute(query);    
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conex != null) {
				conex.close();
			}
		}
	}
	
}