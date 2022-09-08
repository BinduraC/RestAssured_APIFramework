package com.crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProjectTest {

	@Test
	public void updateProjectTest() {
		//creating json body
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("createdBy", "sadsa");
		jsonObject.put("projectName", "ecost2");
		jsonObject.put("status", "completed");
		jsonObject.put("teamSize", 5);

		//preconditions(body and content Type
		RequestSpecification reqSpec =  RestAssured.given();
		reqSpec.body(jsonObject);
		reqSpec.contentType(ContentType.JSON);


		//validation
		Response response = reqSpec.put("http://localhost:8084/projects/TY_PROJ_1802");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();

	}

}
