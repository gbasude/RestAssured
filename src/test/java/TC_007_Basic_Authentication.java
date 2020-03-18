import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_007_Basic_Authentication {
@Test
void basicAuthentication() {
	 //Get base URL
	RestAssured.baseURI = ("https://restapi.demoqa.com/authentication/CheckForAuthentication");
	
	//Basic authentication
	PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
	authScheme.setUserName("ToolsQA");
	authScheme.setPassword("TestPassword");
	
	RestAssured.authentication = authScheme; 
	
	//Create request object
	RequestSpecification httpsRequest = RestAssured.given();
	Response response = httpsRequest.request(Method.GET, "/");
	
	String responseBody = response.getBody().asString();
	System.out.println("Response body is "+ responseBody);
	
	int responseCode = response.getStatusCode();
	Assert.assertEquals(responseCode, 200);
	
	String  responseLine = response.getStatusLine();
	Assert.assertEquals(responseLine, "HTTP/1.1 200 OK");
	
	Assert.assertTrue(responseBody.contains("OPERATION_SUCCESS"));
	
	
	
	
	
	
}
}
