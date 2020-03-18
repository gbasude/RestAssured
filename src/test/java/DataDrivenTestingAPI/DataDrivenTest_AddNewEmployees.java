package DataDrivenTestingAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddNewEmployees {
	@Test
	void postNewEmployees() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("name","SmithXYZ");
		requestParams.put("salary","9000");
		requestParams.put("age","40");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		Response response = httpRequest.request(Method.POST, "/create");
		
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(responseBody.contains("SmithXYZ"), true);
		Assert.assertEquals(responseBody.contains("9000"), true);
		Assert.assertEquals(responseBody.contains("40"), true);
		
		int respCode = response.getStatusCode();
		Assert.assertEquals(respCode, 200);
	}
	

}
