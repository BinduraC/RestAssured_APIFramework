package com.requestChaining;

import org.testng.annotations.Test;

import com.GenericUtilities.JavaUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateProjectAndGetProjet {
	
	@Test
	public void requestChaining() {
		JavaUtility jLib = new JavaUtility();
		
		baseURI = "http://localhost";
		port = 8084;
		
		Project projectObj = new Project("sanvi","orsigor"+jLib.getRandomNum(),"ongoing",5);
		
		Response resp = given()
		.body(projectObj)
		.contentType(ContentType.JSON)
		
		
		//Action
		.when()
		.post("/addProject");
		
		String projectID = resp.jsonPath().get("projectId");
		System.out.println("projectID is "+projectID);
		
		given().pathParam("pid", projectID)
		//Actions
		.when()
		.get("/projects/{pid}")
		//validations
		.then()
		.log().all();
		
	}

}
