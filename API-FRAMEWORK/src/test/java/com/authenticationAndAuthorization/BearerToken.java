package com.authenticationAndAuthorization;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.GenericUtilities.JavaUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void bearerTokenTest() {
		JavaUtility jLib = new JavaUtility();
		JSONObject jobj = new JSONObject();
		jobj.put("name", "RestAssuredAPI"+jLib.getRandomNum());
		
		Response resp = given()
		.auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("https://api.github.com/user/repos");
		
		resp.then().assertThat().statusCode(201)
		.and()
		.contentType(ContentType.JSON);
		
		System.out.println(resp.getTime());
		System.out.println(resp.getStatusCode());
	}

}
