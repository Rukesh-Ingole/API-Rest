package RestApi;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_004_AllHeaders {
	@Test
	public void printAllHeaders()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/api/unknown");
		
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		Headers allheader = response.headers();
		for (Header header : allheader) 
		{
		System.out.println(header.getName()+"======="+header.getValue());	
		}
		
	}
	

}
