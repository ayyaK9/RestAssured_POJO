package basic.rest.getcall;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateGitHubRepo {

	@Test 
	public void createGitHubRepo() {

		String baseUri = "https://api.github.com";
		String bearearToken = "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";
		

		RestAssured.baseURI = baseUri;
		given().header("Content-type", "application/JSON")
			   .header("Authorization", "Bearer "+bearearToken)
			   .body("{\n" + 
			   		"    \"name\":\"API-PostMan-Repo2\",\n" + 
			   		"    \"description\":\"Description-API-PostMan-Repo\"\n" + 
			   		"}").
		when()
				.post("/user/repos").
		then().assertThat().statusCode(201)
			  .assertThat().body( "name",  equalTo("API-PostMan-Repo2"));
		
		System.out.println("-------------Post Validation is successfully completed-------------");
	}
	
}
