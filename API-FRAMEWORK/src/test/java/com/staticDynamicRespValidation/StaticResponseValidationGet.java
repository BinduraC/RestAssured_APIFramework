package com.staticDynamicRespValidation;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValidationGet {
	
	@Test
	public void staticResponseGet() {
		//pre requisites
		String expectedProjID = "TY_PROJ_2402";
		
		baseURI = "http://localhost";
		port = 8084;
		//action
		Response resp = when().get("/projects");
		String actualProjId =  resp.jsonPath().get("[0].projectId");
		System.out.println("actualProjId is : "+actualProjId);
		//Assert.assertEquals(actualProjId, expectedProjID );
		
		Assert.assertEquals(actualProjId, expectedProjID);
		//validation
		/*String actualData =  resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actualData, expectedData);
		System.out.println("data verified");*/
		
		resp.then().log().all();
	}

}
