import org.apache.commons.collections4.Get;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_003_ValidatingHeaders {
	@Test
	void validatingHeaders() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		RequestSpecification  httpRequest = RestAssured.given();
		
		  //Response object
		Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		String responseBody = response.asString();
		
		System.out.println("Response Body is " + responseBody);
		
		String contentType = response.header("Content-Type"); // capture details of Content-Type header
		
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		String contentEncoding = response.header("Content-Encoding"); // capture details of Content-Encoding  header
		
		Assert.assertEquals(contentEncoding, "gzip");
		 //get all headers from response
		Headers allHeaders = response.headers();
		for(Header header : allHeaders) {
		System.out.println(header.getName() +"  " + header.getValue());
			
		}
		
	}

}
