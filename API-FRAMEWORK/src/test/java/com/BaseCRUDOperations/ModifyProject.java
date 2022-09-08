package com.BaseCRUDOperations;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;

import org.testng.annotations.Test;

import com.GenericUtilities.FileUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;

public class ModifyProject {
	
	@Test
	public void modifyProject() throws IOException {
	
	FileUtility fLib = new FileUtility();
	
	Project project = new Project("Suvarna","Britannia151","created",5);
	
	baseURI = "http://localhost:8084";
	port = 8084;
	given()
		.contentType(ContentType.JSON)
		.body(project)
	.when()
		.put("/projects/TY_PROJ_3603")
	.then()
		.assertThat().contentType(ContentType.JSON)
		.and()
		.assertThat().statusCode(200)
		.log().all();

	}
}
