package com.crudWithBDD;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UpdateProjectUsingBDD {

	@Test
	public void updateProjectTest() {
		//creating json body
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("createdBy", "Ganesh");
		jsonObject.put("projectName", "FiveStar1");
		jsonObject.put("status", "created");
		jsonObject.put("teamSize", 4);
		
		given()
			.body(jsonObject)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_2602")
		.then()
			.assertThat()
			.contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
	

}
