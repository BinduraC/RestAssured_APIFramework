package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


/**
 * 
 * @author Bindura
 *
 */
public class DataBaseUtility {
	
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	
	/**
	 * this method is used to connect to DataBase
	 * @param DBname
	 */
	public void connectToDB(String DBname) {
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			connection=DriverManager.getConnection(IConstants.DBurl+DBname,IConstants.DBusername, IConstants.DBpassword);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method is used to close the database connection
	 */
	public void closeDB() {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * this method is used to execute select query
	 * @param query
	 * @param colNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String query, int colNum, String expectedData) throws SQLException {
		result = connection.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			if(result.getString(colNum).equals(expectedData)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("data is present");
			return flag;
		}else {
			System.out.println("data is not present");
			return flag;
		}
	}
	
	/**
	 * this method will execute the query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String query) throws SQLException {
		int result = connection.createStatement().executeUpdate(query);
		return result;
	}
	/**
	 * this method will execute the query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		result = connection.createStatement().executeQuery(query);
		return result;
	}
}
