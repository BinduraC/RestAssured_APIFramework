package com.waysToPost;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class AddProjectUsingHAshMap {

	@Test
	public void createProjectWithBDDTest() {

		//creating json body
		HashMap hmobj = new HashMap();
		/*{
		  "createdBy": "string",
		  "projectName": "string",
		  "status": "string",
		  "teamSize": 0
		}*/
		hmobj.put("createdBy", "Ganesh");
		hmobj.put("projectName", "FiveStarSaturday4");
		hmobj.put("status", "created");
		hmobj.put("teamSize", 4);

		given()
			.baseUri("http://localhost")
			.port(8084)
			.body(hmobj)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.contentType(ContentType.JSON)
			.assertThat().statusCode(201)
			.log().all();


	}


}
