package com.waysToPost;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

public class AddProjectWithJSONobject {

	@Test
	public void addProject() {

		//creating json body
		JSONObject jobj = new JSONObject();
		/*{
		  "createdBy": "string",
		  "projectName": "string",
		  "status": "string",
		  "teamSize": 0
		}*/
		jobj.put("createdBy", "Ganesh");
		jobj.put("projectName", "Bourbonia");
		jobj.put("status", "created");
		jobj.put("teamSize", 4);
		
		given()
			.contentType(ContentType.JSON)
			.body(jobj)									//pre-condition
		.when()
			.post("http://localhost:8084/addProject")	//action
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.assertThat().statusCode(201)				//validation
			.log().all();
	}	
	
}
