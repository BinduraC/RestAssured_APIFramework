package com.Parameter;

import static io.restassured.RestAssured.*;

public class FormParameterForGITTest {
	
	public void parametersTest() {
		
		baseURI = "https://api.github.com";
		
		given()
		.pathParam("username", "BinduraC")
		.queryParam("per_page", 30)
		.queryParam("page", 1)
		
		.when()
		.get("/users/{username}/repos")
		
		.then()
			.assertThat().statusCode(200).log().all();
	}

}
