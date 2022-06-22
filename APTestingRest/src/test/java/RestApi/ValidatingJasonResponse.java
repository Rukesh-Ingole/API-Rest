package RestApi;

import org.apache.poi.ddf.EscherColorRef.SysIndexProcedure;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatingJasonResponse {
	@Test
	public void validateResponse()
	{
	RestAssured.baseURI="https://reqres.in";
	
	RequestSpecification httprequest = RestAssured.given();
	
	Response response = httprequest.request(Method.GET,"/api/unknown/2");
	
	String responsebody = response.getBody().asString();
	System.out.println("Response body is : " +responsebody);
	//validating jason response
	Assert.assertEquals(responsebody.contains("2"), true);
	Assert.assertEquals(responsebody.contains("fuchsia ros"), true);
		
	}

}
