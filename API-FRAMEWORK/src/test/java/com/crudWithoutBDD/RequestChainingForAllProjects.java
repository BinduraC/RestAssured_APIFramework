package com.crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class RequestChainingForAllProjects {

	@Test
	public void requestChainingTest() {
		//creating json body
		JSONObject jsonObject = new JSONObject();
		/*{
					  "createdBy": "string",
					  "projectName": "string",
					  "status": "string",
					  "teamSize": 0
					}*/
		jsonObject.put("createdBy", "sadsaa1");
		jsonObject.put("projectName", "ecostIDEx");
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
		String pID = response.jsonPath().get("projectId");

		Response lstResponse = reqSpec.get("http://localhost:8084/projects");
		
		List<Object> lst = lstResponse.jsonPath().get("projectId");

		for(int i=0;i<lst.size();i++) {
			String projID = (String)lst.get(i);
			if(projID.equals(pID)) {
				given().
				pathParam("projectID", pID)
				.when()
				.get("http://localhost:8084/projects/{projectID}")
				.then().assertThat()
				.statusCode(200)
				.log().equals(jsonObject.get("projectId"));

			}
		}
	}
}