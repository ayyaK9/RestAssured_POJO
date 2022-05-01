package basic.rest.getcall;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Getmethodautomation {

	public static String baseUri = "https://api.trello.com"; 
	
	//URI = Uniform resource identifier //""" scheme:[//authority]path[?query][#fragment] """
	
	public static void main(String[] args) {
		
		System.out.println("Base URI is "+ baseUri);
		
		RestAssured.baseURI = baseUri;
		given().
			param("key","4e3bdaf3c4d725343797f3555cfe7ccc").
			param("token","d43a7f1b539e7158b55a0f06ef146235544e46848ef7da8a74e1ab8f524557f2").
		when().
			get("/1/boards/3bDs4Pu8").
		then().
			assertThat().statusCode(200).and(). //Validate status code
			contentType(ContentType.JSON).and(). //Validate return content type
			body("name",equalTo("FirstBoard"));  //Validate Body
		System.out.println("Test case completed succesfully");
	}
}
