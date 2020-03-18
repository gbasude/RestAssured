import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_005_GET_ValidatingDetails {
	@Test
	void weatherDetails() {
		
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 Response response = httpRequest.request(Method.GET, "/Fremont");
		 
		 String responseBody = response.getBody().asString();
		 Assert.assertEquals(responseBody.contains("Fremont"), true);
		 		
		 
	}

}
