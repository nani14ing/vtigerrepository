package com.sdet34l1.genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all common actions related to database
 * @author Admin
 *
 */
public class DataBaseLibrary {
	String data = null;
    static Connection connection;
    static Statement statement;
    
	 /**
	  * this method is used to open database connection initialize and initialize the connection, statement 
	 * @param dBUrl
	 * @param query
	 * @throws SQLException 
	 */
	public void openDBConnection(String dBUrl, String dBUserName, String dBPassWord) throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		connection=DriverManager.getConnection(dBUrl, dBUserName, dBPassWord);
		statement=connection.createStatement();
	}
	
	
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on the database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getDataFromDataBase(String query, String columnName) throws SQLException {
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	
	/**
	 * This method is used to validate the data whether it is present in database or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean validateDataInDataBase(String query,String columnName, String expectedData) throws SQLException {
		ArrayList<String> list = getDataFromDataBase(query, columnName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData)){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	
	/**
	 * this method is used to store/modify/insert/delete the data in database/to do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException
	 */
	public void setdataInDataBase(String query) throws SQLException {
		int result = statement.executeUpdate(query);
		if(result>=1) {
			System.out.println("data modified successfully");
		}
	}
	
	
	public void closeDBConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closing the database connection we got exception");
		}
	}

}










