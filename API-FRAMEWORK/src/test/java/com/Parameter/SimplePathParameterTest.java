package com.Parameter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SimplePathParameterTest {
	
	@Test
	public void getSingleProject() {
		
		//pre requisites
		baseURI = "http://localhost";
		port = 8084;
		
		given().pathParam("pid", "TY_PROJ_2402")
		//Actions
		.when()
		.get("/projects/{pid}")
		//validations
		.then()
		.log().all();
	}

}
