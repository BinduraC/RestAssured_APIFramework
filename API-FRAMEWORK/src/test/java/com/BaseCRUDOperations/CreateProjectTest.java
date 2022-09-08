package com.BaseCRUDOperations;

import org.testng.annotations.Test;

import com.GenericUtilities.FileUtility;
import com.GenericUtilities.JavaUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class CreateProjectTest {
	
	@Test
	public void createProject() throws IOException {
		JavaUtility jLib= new JavaUtility();
		FileUtility fLib = new FileUtility();
		
		Project project = new Project("Suvarna","Britannia"+jLib.getRandomNum(),"created",5);
		
		baseURI = "http://localhost:8084";
		port = 8084;
		given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post("/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.assertThat().statusCode(201)
			.log().all();
	
	
	}

}
