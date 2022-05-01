package basic.rest.getcall;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Deletegithubrepo {

	@Test 
	public void createGitHubRepo() {

		String baseUri = "https://api.github.com";
		String bearearToken = "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";
		String requestBody = "{\n" + 
		   		"    \"name\":\"API-PostMan-Repo90\",\n" + 
		   		"    \"description\":\"Description-API-PostMan-Repo\"\n" + 
		   		"}";
		
		

		RestAssured.baseURI = baseUri;
	Response response =	given().header("Content-type", "application/JSON")   //Response is an interface
			   .header("Authorization", "Bearer "+bearearToken).
			   
		when()
				.delete("/repos/ayyaK9/API-PostMan-Repo4").
		then().assertThat().statusCode(204).and().
			  
		extract().response();
		

	}
}
