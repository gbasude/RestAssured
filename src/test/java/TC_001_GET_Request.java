import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_001_GET_Request {
	
	@Test
	void getWeatherDetails() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		//Create request object
		RequestSpecification httpRequest = RestAssured.given();
		//response object
		Response response = httpRequest.request(Method.GET, "/Fremont");
		String responseBody = response.getBody().asString();
		System.out.println(" Response body is " +responseBody);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		System.out.println("Response line is  "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
