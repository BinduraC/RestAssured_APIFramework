package com.crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class AddProjectTest {
	
	@Test
	public void createProjectWithBDDTest() {
		
		//creating json body
		JSONObject jobj = new JSONObject();
		/*{
		  "createdBy": "string",
		  "projectName": "string",
		  "status": "string",
		  "teamSize": 0
		}*/
		jobj.put("createdBy", "Ganesh");
		jobj.put("projectName", "FiveStar");
		jobj.put("status", "created");
		jobj.put("teamSize", 4);
		
		given()
			.body(jobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
		.contentType(ContentType.JSON)
		.assertThat().statusCode(201)
		.log().all();
		
		
	}

}
