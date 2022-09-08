package com.waysToPost;

import com.GenericUtilities.JavaUtility;
import com.POJOclasses.Project;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AddProjectpostWithPojoClassTest {

	@Test
	public void addProject() {
		JavaUtility jLib= new JavaUtility();
		Project project = new Project("Suvarna","Britannia"+jLib.getRandomNum(),"created",5);
		
		given()
			.contentType(ContentType.JSON)
			.body(project)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.assertThat().statusCode(201)
			.log().all();
	}	

}
