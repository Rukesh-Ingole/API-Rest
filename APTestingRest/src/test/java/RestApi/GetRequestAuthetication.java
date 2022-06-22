package RestApi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestAuthetication {
	@Test
	public void getAuthetication()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		//Basic  Authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
		
		RequestSpecification httprequest = RestAssured.given();
		
		Response response = httprequest.request(Method.GET,"/");
		
		String responsebody = response.getBody().asString();
		System.out.println("Response body is : "+responsebody);
		
		int statuscode = response.statusCode();
		System.out.println("Ststus code is : "+statuscode);
	}

}
