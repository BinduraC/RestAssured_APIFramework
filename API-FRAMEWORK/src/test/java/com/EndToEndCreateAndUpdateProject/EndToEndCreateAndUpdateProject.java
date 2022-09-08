package com.EndToEndCreateAndUpdateProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseAPIClass;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.EndPointsLibrary;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.SQLException;
import java.util.List;

public class EndToEndCreateAndUpdateProject extends BaseAPIClass{

	@Test
	public void createVerifyUpdateVerifyGUIandDBTest() throws SQLException {
		Project project = new Project("kalpana1","restassured1"+jLib.getRandomNum(),"ongoing1",5);

		baseURI = "http://localhost";
		port = 8084;

		Response response = given()
				.body(project)
				.contentType(ContentType.JSON)
				.when().post("/addProject");

		String projectIDFromResponse = response.jsonPath().get("projectId");
		response.then().assertThat().statusCode(201).log().all();
		// Validating in GUI

		// launching the browser
		// entering url
		// entering valid details in field
		BaseClass baseClass = new BaseClass();
		baseClass.launchTheBrowser();
		baseClass.loginToAppln();

		// clicking on projects link
		baseClass.driver.findElement(By.xpath("//a[text()='Projects']")).click();

		// selcting all projectId's for verifying and storing it in one variable
		List<WebElement> projList = baseClass.driver.findElements(By.xpath("//td[1]"));

		boolean flag = false;
		int count = 0;
		//verification
		for(WebElement projID: projList) {
			if(projectIDFromResponse.equals(projID)) {
				flag = true;
			}
			count++;
		}
		if(flag=true) {
			Assert.assertTrue(true);
			Reporter.log("<====Project is present in GUI====>", true);
		}else {
			Reporter.log("<====Project is not present in GUI====>", true);
			Assert.assertTrue(false);
		}

		Reporter.log("Total no of projects checked = " + count, true);

		baseClass.closeTheBrowser();

		//getting project details using API
		given().pathParam("pid", projectIDFromResponse)
		//Actions
		.when()
		.get("/projects/{pid}")
		//validations
		.then()
		.log().all();

		//updating details
		project.setCreatedBy("bindu1");
		project.setProjectName("precious1");
		given()
		.body(project)
		.contentType(ContentType.JSON)
		.when()
		.put(EndPointsLibrary.updateProject+projectIDFromResponse)
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();

		// Validating in GUI

		// launching the browser
		// entering url
		// entering valid details in field
		baseClass.launchTheBrowser();
		baseClass.loginToAppln();

		// clicking on projects link
		baseClass.driver.findElement(By.xpath("//a[text()='Projects']")).click();

		// selcting all projectId's for verifying and storing it in one variable
		List<WebElement> projList1 = baseClass.driver.findElements(By.xpath("//td[1]"));

		boolean flag1 = false;
		int count1 = 0;
		//verification
		for(WebElement projID: projList1) {
			if(projectIDFromResponse.equals(projID)) {
				flag1 = true;
			}
			count1++;
		}
		if(flag1=true) {
			Assert.assertTrue(true);
			Reporter.log("<====Project is present in GUI====>", true);
		}else {
			Reporter.log("<====Project is not present in GUI====>", true);
			Assert.assertTrue(false);
		}

		Reporter.log("Total no of projects checked = " + count1, true);

		baseClass.closeTheBrowser();

		//checking data is deleted in database or not
		Reporter.log("Database verification starts",true);
		dbLib.executeQuery("select * from project", 1, projectIDFromResponse);
	}

}
