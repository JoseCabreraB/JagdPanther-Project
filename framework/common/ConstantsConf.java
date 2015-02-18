package framework.common;

import framework.utils.ReadXMLFile;

public class ConstantsConf {
	public static ReadXMLFile conf = new ReadXMLFile(System.getProperty("user.dir")+"\\src\\config.xml");

	/*DataBase config*/
	public static final String DIR_DB = conf.read("db","dir_db");
	public static final String USER_DB = conf.read("db","user_db");
	public static final String PASS_DB = conf.read("db","pass_db");
	/*DataProviders config*/
	public static final String FILEPATH = System.getProperty("user.dir")+conf.read("datasource","excelpath");
	public static final String FILENAME = conf.read("datasource","datadrivensource");
	/*Login config*/
	public static final String USER = conf.read("login", "user");
	public static final String PASSWORD = conf.read("login", "password");
	public static final String URL = conf.read("login", "url");
	/*Webdriver config*/
	public static final String DRIVERNAME = conf.read("driverconfig", "drivername");
	public static final int IMPLICIT = 30;
	public static final int EXPLICIT = 30;
}
