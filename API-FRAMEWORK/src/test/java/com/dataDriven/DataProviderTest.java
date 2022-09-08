package com.dataDriven;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericUtilities.ExcelUtility;
import com.POJOclasses.Project;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class DataProviderTest{
	
	@Test(dataProvider = "getProjectDetails")
	public void testData(String createdBy, String projectName, String status, String teamSize) {
		System.out.println("createdBy"+createdBy+" and projectName "+projectName);
		System.out.println("status"+status+" and teamSize "+teamSize);
		int ts = (Integer.parseInt(teamSize));
		Project projectObj = new Project(createdBy,projectName,status,ts);

		given()
				.body(projectObj).contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat()
			.statusCode(201)
		.contentType(ContentType.JSON)
		.log()
		.all();
	}
	
	
	@DataProvider
	public Object[][] getProjectDetails() throws EncryptedDocumentException, FileNotFoundException, IOException{
		ExcelUtility elib = new ExcelUtility();
		int rowCnt = elib.getLastRowNumFromExcel("Sheet1");
		Object[][] objarr = new Object[4][4];
		
		
		
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++) {
				objarr[i][j] = elib.getDataFromExcel("Sheet1", i, j);
				
			}
			
		}
		/*Object[][] objarr = new Object[4][4];
		objarr[0][0] = "";
		objarr[0][1] = "10000";
		objarr[0][2] = "10000";
		objarr[0][3] = "10000";
		
		objarr[0][0] = "";
		objarr[0][1] = "10000";
		objarr[0][2] = "10000";
		objarr[0][3] = "10000";
		
		objarr[0][0] = "";
		objarr[0][1] = "10000";
		objarr[0][2] = "10000";
		objarr[0][3] = "10000";
				
		objarr[0][0] = "";
		objarr[0][1] = "10000";
		objarr[0][2] = "10000";
		objarr[0][3] = "10000";*/
		System.out.println("objarr.length is "+objarr.length);
		
		return objarr;
	}

}
