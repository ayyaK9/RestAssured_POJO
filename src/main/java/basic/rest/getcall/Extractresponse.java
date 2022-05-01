package basic.rest.getcall;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Extractresponse {

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
			   .header("Authorization", "Bearer "+bearearToken)
			   .body(requestBody).
		when()
				.post("/user/repos").
		then().assertThat().statusCode(201).and().and()
			  .contentType(ContentType.JSON).
		extract().response();
		
		
		String res = response.asString();
		System.out.println(res);
		JsonPath responseJson = new JsonPath(res);
		
		System.out.println("Node ID : "+responseJson.get("node_id"));
		System.out.println("Name    : "+responseJson.get("name"));
		System.out.println("login   : "+responseJson.get("owner.login"));
	}
}
