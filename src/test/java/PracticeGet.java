import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PracticeGet {
	@Test
	void getPrac() {

		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.request(Method.GET, "/San Francisco");

		String respBody = response.getBody().asString();

		System.out.println(respBody);

		int repCode = response.getStatusCode();
		System.out.println("Response code is " + repCode);
		Assert.assertEquals(repCode, 200);

		String resStatus = response.getStatusLine();
		System.out.println("Status Line is  " + resStatus);
		Assert.assertEquals(resStatus, "HTTP/1.1 200 OK");

	}

}
