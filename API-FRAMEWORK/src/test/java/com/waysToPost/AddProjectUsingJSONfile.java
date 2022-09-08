package com.waysToPost;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectUsingJSONfile {
	
	@Test
	public void addProjUsingJSONfile() {
		String baseURI = "http://localhost";
		int port =8084;
		
		given()
		.body(new File("./src/test/resources/restassuredjasonfile.json"))
		.baseUri(baseURI)
		.port(port)
		.contentType(ContentType.JSON)
	.when()
		.post("/addProject")
	.then()
	.contentType(ContentType.JSON)
	.assertThat().statusCode(201)
	.log().all();
	}

}
