package basic.rest.jsonval;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Assignment1 {
	@Test 
	public void createGitHubRepo() {

		String baseUri = "https://api.github.com";
		String bearearToken = "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";
		

		RestAssured.baseURI = baseUri;
		Response res = given().header("Content-type", "application/JSON")
			   .header("Authorization", "Bearer "+bearearToken).
			   
		when()
				.get("/user/repos").
		then().assertThat().statusCode(200).
		extract().response();
		
		JsonPath bodyRes = new  JsonPath(res.asString());
		
		System.out.println(bodyRes.get("[0].name"));
		System.out.println(bodyRes.get("[1].name"));
		
			
		
		System.out.println("-------------Post Validation is successfully completed-------------");
	}
}
