package com.crudWithoutBDD;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetAllProjectsTest {

	@Test
	public void fetchAllProjectsTest() {
		//preconditions(body and content Type
		RequestSpecification reqSpec =  RestAssured.given();

		//validation
		Response response = reqSpec.get("http://localhost:8084/projects");
		
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();

	}

}
