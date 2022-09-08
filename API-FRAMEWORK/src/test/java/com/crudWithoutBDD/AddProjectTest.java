package com.crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AddProjectTest {

	@Test
	public void createTest() {

		//creating json body
		JSONObject jsonObject = new JSONObject();
		/*{
			  "createdBy": "string",
			  "projectName": "string",
			  "status": "string",
			  "teamSize": 0
			}*/
		jsonObject.put("createdBy", "sadsaa1");
		jsonObject.put("projectName", "ecos");
		jsonObject.put("status", "completed");
		jsonObject.put("teamSize", 5);
		
		//preconditions(body and content Type
		RequestSpecification reqSpec =  RestAssured.given();
		reqSpec.body(jsonObject);
		reqSpec.contentType(ContentType.JSON);
		
		
		//validation
		Response response = reqSpec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
	}

}
