package com.crudWithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class GetProjectTest {

	@Test
	public void getProjectWithBDDTest() {
		given().get("http://localhost:8084/projects/TY_PROJ_402")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
		
		/*Response res  = given().get("http://localhost:8084/projects/TY_PROJ_405");
		Object obj = res.jsonPath().get("TY_PROJ_405");
		System.out.println(obj);*/
	}
}
