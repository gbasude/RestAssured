import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC_006_GET_ExtractValuesofEchNodeInJson {
	@Test
	void extractValues() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";
		
		RequestSpecification httpsRequest = RestAssured.given();
		
		Response response = httpsRequest.request(Method.GET, "/Fremont");
		
		String responseBody = response.getBody().asString();
		
		JsonPath jsonPath = response.jsonPath();
		
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));
		
		Assert.assertEquals("15.12 Degree celsius", jsonPath.get("Temperature"));
		
	}

}
