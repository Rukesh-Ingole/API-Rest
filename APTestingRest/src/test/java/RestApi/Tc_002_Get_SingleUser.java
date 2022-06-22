package RestApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Tc_002_Get_SingleUser {
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/api/users/2");
		
		String responsebody = response.getBody().asString();
		System.out.println("Respose bod is : "+responsebody);
		
		int statuscode = response.statusCode();
		System.out.println("Status code is : "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
		String statusline =response.statusLine();
		System.out.println("Status line is : "+statusline);
		
	}

}
