package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseConnectionTest {
public static void main(String[] args) throws SQLException 
	{

		//step1: create object for implementation class 
		Driver driver=new Driver();
		
		//step2: register the driver with JDBC
		DriverManager.registerDriver(driver);
		
		//step3: establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet39", "root", "root");
		
		//step4: create statements
		Statement statement = connection.createStatement(); 
		
		//step5: execute query
		ResultSet result = statement.executeQuery("select * from sdet39;");
		
		//step6: validate
		while(result.next())
		{
			System.out.println(result.getString("name"));
		}
		
		//step7: close the connection
		connection.close();

}
}

