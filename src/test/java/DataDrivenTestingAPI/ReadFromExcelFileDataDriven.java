package DataDrivenTestingAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReadFromExcelFileDataDriven {
	public class DataProviderPostNewEmployees1 {
		@Test(dataProvider = "empdataprovider")
		void postNewEmployees(String ename, String eage, String esal) {
			RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

			RequestSpecification httpRequest = RestAssured.given();

			JSONObject requestParams = new JSONObject();

			requestParams.put("name", "ename");
			requestParams.put("salary", "eage");
			requestParams.put("age", "esal");

			httpRequest.header("Content-Type", "application/json");
			httpRequest.body(requestParams.toJSONString());
			Response response = httpRequest.request(Method.POST, "/create");

			String responseBody = response.getBody().asString();
			//Print response body
			System.out.println("This is response body " + responseBody);

			Assert.assertEquals(responseBody.contains("ename"), true);
			Assert.assertEquals(responseBody.contains("eage"), true);
			Assert.assertEquals(responseBody.contains("esal"), true);

			int respCode = response.getStatusCode();
			Assert.assertEquals(respCode, 200);
		}

		@DataProvider(name = "empdataprovider")
		String[][] getEmpData() {
			String empdata[][] = { { "abc123", "10000", "41" }, { "abc12", "20000", "45" }, { "abc13", "30000", "50" } };

			return empdata;

		}

	}


}
