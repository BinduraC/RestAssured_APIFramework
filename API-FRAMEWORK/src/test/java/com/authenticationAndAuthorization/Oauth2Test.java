package com.authenticationAndAuthorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {
	
	@Test
	public void oauth2Test() {
		//creat a request to generate access token
		Response resp = given()
		.formParam("client_id", "arunee")
		.formParam("client_secret", "49fee4a0cd83e1f2858698a49ec98938")
		.formParam("grant_type", "client_credentials")
		.formParam("rediret_uri", "http://arunee.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		//capture the access token from the response of the above request
		String token = resp.jsonPath().get("access_token");
		System.out.println(token);
		
		//create another request and use the token to acess the APIs
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 3790)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count")
		.then()
		.log()
		.all();
	}

}
