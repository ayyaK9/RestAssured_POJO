package basic.rest.getcall;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Verifypostmethod {
	
	@Test 
	public void verifyPostTrello() {

		String baseUri = "https://api.trello.com";

		System.out.println("Base URI is " + baseUri);

		RestAssured.baseURI = baseUri;
		given().queryParam("name", "Automated Board")
				.queryParam("key", "4e3bdaf3c4d725343797f3555cfe7ccc")
				.queryParam("token", "d43a7f1b539e7158b55a0f06ef146235544e46848ef7da8a74e1ab8f524557f2")
				.header("Content-type", "application/JSON").
		when()
				.post("/1/boards").
		then().assertThat().body("name",  equalTo("Automated Board"));
		
		System.out.println("-------------Post Validation is successfully completed-------------");
	}
}
