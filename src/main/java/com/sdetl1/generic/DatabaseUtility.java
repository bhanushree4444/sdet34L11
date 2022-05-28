package com.sdetl1.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * tghis class contains all the data base common actions
 * @author Madhu
 *
 */
public class DatabaseUtility {
	static Connection connection;
	static Statement statement;
	/**
	 * this method used to open data base connection and initialize
	 * @param dBUrl
	 * @param dbUn
	 * @param dBpwd
	 * @throws SQLException
	 */
	public static void openDbConnection(String dBUrl,String dbUn,String dBpwd) throws SQLException {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 connection = DriverManager.getConnection(dBUrl, dbUn, dBpwd);
			statement = connection.createStatement();
	}

/**
 * this method used to get data from data base/to perform DQL operation on data base
 * @param querry
 * @param columnNo
 * @return
 * @throws SQLException
 */
  public static ArrayList<String> getDataFromDb(String querry,String columnNo) throws SQLException {
	  ArrayList<String> list=new ArrayList<>();
	ResultSet result = statement.executeQuery(querry);
	while(result.next()){
	list.add(result.getString(columnNo));
	}
	return list;
}
  /**
   * this method used to validate data whether it is present or not
   * @param querry
   * @param columnName
   * @param expectedData
   * @return
   * @throws SQLException
   */
  public static boolean validateInDb(String querry,String  columnName,String expectedData) throws SQLException {
	   ArrayList<String> list = getDataFromDb(querry, columnName);
	   boolean flag=false;
	   for(String actualData:list) {
		   if(actualData.equalsIgnoreCase(expectedData)) {
			   flag=true;
			   break;
		   }
	   }
	   return flag;
  }
  /**
   * this method used to store/modify/inset/delete the data in database to do DML and DDL actions on data base
   * @param querry
   * @throws SQLException
   */
  public static void setDataIntoDb(String querry) throws SQLException {
	 int result = statement.executeUpdate(querry);
	 if(result>=1) {
		 System.out.println("data entered or modified successfully");
	 }
  }
  /**
   * this method used to colse bata base connection
   */
  public static void colseDBConnection() {
	  try {
		connection.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  
  
  
}