package com.responseTimeValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;


public class ResponseTimeValidation {
	
	public void responseTimeValidation() {

		//pre requisites
		baseURI = "http://localhost";
		port = 8084;

		//action
		when().get("/projects")

		//validation
		.then()
		.assertThat().time(Matchers.lessThan(50L), TimeUnit.MILLISECONDS)
		.log().all();
		
		
	}

}
