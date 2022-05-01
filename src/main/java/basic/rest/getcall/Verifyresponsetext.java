package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

public class Verifyresponsetext {


	@Test 
	public void verifyResponseBody() {

		String baseUri = "https://api.trello.com";

		System.out.println("Base URI is " + baseUri);

		RestAssured.baseURI = baseUri;
		given().param("key", "4e3bdaf3c4d725343797f3555cfe7ccc")
				.param("token", "d43a7f1b539e7158b55a0f06ef146235544e46848ef7da8a74e1ab8f524557f2")
				//.log().all().
				.log().params().
		when()
				.get("/1/boards/3bDs4Pu8").
		then().assertThat().statusCode(200).and().log().body(). //log().all().  // Validate status code
				contentType(ContentType.JSON).and(). // Validate return content type
				body("name", equalTo("FirstBoard")).and(). // Validate Body
				body("id", equalTo("6263d61d66bcbf7d06e6b8b5"));
		
		
		System.out.println("-------------Body Validation is successfully completed-------------");
	}
	
	
	@Test 
	public void verifyResponseHeaders() {

		String baseUri = "https://api.trello.com";

		System.out.println("Base URI is " + baseUri);

		RestAssured.baseURI = baseUri;
		given().param("key", "4e3bdaf3c4d725343797f3555cfe7ccc")
				.param("token", "d43a7f1b539e7158b55a0f06ef146235544e46848ef7da8a74e1ab8f524557f2").
		when()
				.get("/1/boards/3bDs4Pu8").
		then().assertThat().statusCode(200).and(). // Validate status code
				contentType(ContentType.JSON).and(). // Validate return content type
				header("Referrer-Policy","strict-origin-when-cross-origin").and(). //Validate headers
		        header("X-Trello-Environment","Production");
		
		System.out.println("-------------Headers Validation is successfully completed-------------");
	}
}
