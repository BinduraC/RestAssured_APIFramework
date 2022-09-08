package com.crudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteProjectUsingBDD {

	@Test
	public void deleteProjectTest() {

		given().
		delete("http://localhost:8084/projects/TY_PROJ_403")
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(204)
.log().all();
	}


}
