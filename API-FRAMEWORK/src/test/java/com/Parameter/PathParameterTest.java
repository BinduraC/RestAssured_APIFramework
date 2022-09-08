package com.Parameter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PathParameterTest {
	
	@Test
	public void pathParameter() throws IOException {
		JavaUtility jLib= new JavaUtility();
		FileUtility fLib = new FileUtility();
		
		Project project = new Project("Suvarna","Britannia"+jLib.getRandomNum(),"created",5);
		
		baseURI = "http://localhost:8084";
		port = 8084;
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post("/addProject");
		
		String projectID = resp.jsonPath().get("projectId");
		
		given().pathParam("pid", projectID)
		//Actions
		.when()
		.get("/projects/{pid}")
		//validations
		.then()
		.log().all();
		
		
	}

}
