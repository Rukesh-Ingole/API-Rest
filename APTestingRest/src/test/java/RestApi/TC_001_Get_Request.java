package RestApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_001_Get_Request {
	@Test
	public void getListUserDetails()
	{
		//Sprcify the base URI
		RestAssured.baseURI ="https://reqres.in";
		
		//Request object
		RequestSpecification httprequest =RestAssured.given();
		
		//response object
		Response response = httprequest.request(Method.GET,"/api/users?page=2");
		
		//print reponse in console window
		String responeBody = response.getBody().asString();
		System.out.println("Response body is : "+responeBody);
		
		//Ststus code verification
		int ststuscode=response.getStatusCode();
		System.out.println("Status code is : "+ststuscode);
		Assert.assertEquals(ststuscode, 200);
		
		//Status Line
		String statyusline=response.statusLine();
		System.out.println("Status line is : "+statyusline);
		Assert.assertEquals(statyusline, "HTTP/1.1 200 OK");
		
		
	}

}
