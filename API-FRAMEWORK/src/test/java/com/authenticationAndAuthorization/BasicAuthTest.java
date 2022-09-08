package com.authenticationAndAuthorization;

import org.testng.annotations.Test;

import com.GenericUtilities.JavaUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicAuthTest {
	
	@Test
	public void basicAuthTest() {
		JavaUtility jLib = new JavaUtility();
		Project proectPOJO = new Project("ramya", "usalogs"+jLib.getRandomNum(), "completed", 4);
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.body(proectPOJO)
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/login")
		
		//.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(202)
		.and()
		.contentType(ContentType.JSON)
		.and()
		.log()
		.all();
		
	}

}
