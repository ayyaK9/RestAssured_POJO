package basic.rest.jsonval;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JSONRes {
	
	
	@Test 
	public void verifyResponseBody() {

		String baseUri = "https://api.trello.com";

		System.out.println("Base URI is " + baseUri);

		RestAssured.baseURI = baseUri;
		
		Response jsonResponse = given().param("key", "4e3bdaf3c4d725343797f3555cfe7ccc")
				.param("token", "d43a7f1b539e7158b55a0f06ef146235544e46848ef7da8a74e1ab8f524557f2").
				
		when()
				.get("/1/boards/3bDs4Pu8").
		then().assertThat().statusCode(200).and().log().all(). //log().all().  // Validate status code
				contentType(ContentType.JSON).and(). // Validate return content type
				body("name", equalTo("FirstBoard")).and(). // Validate Body
				body("id", equalTo("6263d61d66bcbf7d06e6b8b5")).extract().response();
		
		JsonPath responseBody = new JsonPath(jsonResponse.asString());
		
		System.out.println("---------------------------------------------------------");
		
		System.out.println(responseBody.get("prefs.backgroundImageScaled[4].width"));
		int sizeofArray = responseBody.get("prefs.backgroundImageScaled.size()");
		
		for (int i=0;i<sizeofArray;i++)
		{
			int width = responseBody.get("prefs.backgroundImageScaled["+i+"].width");
			int height = responseBody.get("prefs.backgroundImageScaled["+i+"].height");
			System.out.println("width is : "+width+" height is : "+height);
		}
		
	}
}
