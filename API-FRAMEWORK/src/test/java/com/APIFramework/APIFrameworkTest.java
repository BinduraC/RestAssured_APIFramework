package com.APIFramework;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseAPIClass;
import com.GenericUtilities.BaseClass;
import com.GenericUtilities.EndPointsLibrary;
import com.ObjectRepository.LoginPage;
import com.POJOclasses.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

public class APIFrameworkTest extends BaseAPIClass{
	static WebDriver driver;

	@Test
	public void frameworkTest() throws IOException, SQLException {

		Project project = new Project("Anvi","hcc"+jLib.getRandomNum(),"ongoing",5);

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

		// checking in database
		Reporter.log("Database verification starts", true);

		String query = "select * from project";

		dbLib.executeQuery(query, 1, projectIDFromResponse);

		// deleting data in API

		when().delete(EndPointsLibrary.deleteProject+projectIDFromResponse)
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
		.time(Matchers.lessThan(2000L))
		.log().all();
		Reporter.log("Data deleted from API", true);

		// check data is deleted in gui or not
		// opening the browser
		// entering the url
		// giving valid details and login
		baseClass.launchTheBrowser();
		baseClass.loginToAppln();

		// clicking on projects link
		baseClass.driver.findElement(By.xpath("//a[text()='Projects']")).click();

		// selcting all projectId's for verifying and storing it in one variable
		List<WebElement> projList1 = baseClass.driver.findElements(By.xpath("//td[1]"));

		boolean temp =false;
		int countProject = 0;
		for(WebElement projID:projList1) {
			if(projID.equals(projectIDFromResponse)) {
				temp = true;
			}else {
				temp = false;
			}
			countProject++;
		}
		if(flag=true) {
			Assert.assertTrue(true);
			Reporter.log("<====Project is not present in GUI====>", true);
		}else {
			Reporter.log("<====Project is present in GUI====>", true);
			Assert.assertTrue(false);
		}
		Reporter.log("Total no of projects checked = " + countProject, true);

		baseClass.closeTheBrowser();

		//checking data is deleted in database or not
		Reporter.log("Database verification starts",true);
		dbLib.executeQuery("select * from project", 1, projectIDFromResponse);
	}

}
