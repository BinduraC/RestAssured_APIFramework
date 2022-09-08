package com.GenericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {

	public JavaUtility jLib = new JavaUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public RestAssuredLibrary restLib = new RestAssuredLibrary();
	public FileUtility fLib = new FileUtility();

	@BeforeSuite
	public void bsConfig() throws SQLException
	{

		dbLib.connectToDB("projects");
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{

		dbLib.closeDB();

	}
}
