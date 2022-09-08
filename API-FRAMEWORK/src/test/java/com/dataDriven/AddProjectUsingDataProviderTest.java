package com.dataDriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.POJOclasses.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddProjectUsingDataProviderTest {
	
	@Test(dataProvider="bodyData")
	public void addProject(String createdBy, String projectName, String status, int teamSize) {
		Project projectObj = new Project(createdBy,projectName,status,teamSize);
		
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
	public Object[][] bodyData(){
		Object[][] objarr = new Object[4][4];
		objarr[0][0] = "h";
		objarr[0][1] = "pranvi11";
		objarr[0][2] = "created";
		objarr[0][3] = 1;
		
		objarr[1][0] = "h1";
		objarr[1][1] = "somu11";
		objarr[1][2] = "created";
		objarr[1][3] = 2;
		
		objarr[2][0] = "h2";
		objarr[2][1] = "anvi11";
		objarr[2][2] = "ongoing";
		objarr[2][3] = 3;
				
		objarr[3][0] = "h3";
		objarr[3][1] = "rutvu11";
		objarr[3][2] = "completed";
		objarr[3][3] = 4;
		return objarr;
	}


}
