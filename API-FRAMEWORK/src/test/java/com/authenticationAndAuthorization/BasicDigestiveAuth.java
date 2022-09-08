package com.authenticationAndAuthorization;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.testng.annotations.Test;

public class BasicDigestiveAuth {
	
	@Test
	public void basicDigestiveAuth() {
		
		baseURI = "http://localhost";
		port = 8084;
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login").then().assertThat().statusCode(202).log().all();
		
	}

}
