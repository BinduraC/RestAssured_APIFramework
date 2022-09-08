package com.staticDynamicRespValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidationGet {

	@Test
	public void dynamicResponse() {

		//pre requisites
		String expectedProjID = "TY_PROJ_2402";

		baseURI = "http://localhost";
		port = 8084;

		//action
		Response resp = when().get("/projects");

		//validation
		boolean flag = false;
		List<String> projIDs = resp.jsonPath().get("projectId");

		for(String projectID : projIDs) {
			if(projectID.equalsIgnoreCase(expectedProjID)) {
				flag =true;
			}
		}
		Assert.assertTrue(flag);
		System.out.println("data verified");
		resp.then().log().all();
	}
}
