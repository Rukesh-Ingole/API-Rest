package RestApi;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.mapper.factory.Jackson1ObjectMapperFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_Post_Creat {
	@Test
	public void PostUserDetails()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		RequestSpecification httprequest = RestAssured.given();
		
		JSONObject requestParms = new JSONObject();
		
		requestParms.put("name", "morpheus");
		requestParms.put("job", "leader");
		requestParms.put("id", "278");
		requestParms.put("createdAt", "2022-06-03T06:43:49.009Z");
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParms.toJSONString());
		
		Response response=httprequest.request(Method.POST,"/api/users");
		
		String responsebody = response.getBody().asString();
		Assert.assertEquals(responsebody.contains("morpheus"), true);
		System.out.println("Respponse Body Is  : "+responsebody);
		
		int statuscode = response.getStatusCode();
		System.out.println("Status code is : "+statuscode);
		Assert.assertEquals(statuscode, 201);
		
		String statuslione = response.getStatusLine();
		System.out.println("Status line is :"+statuslione);
		Assert.assertEquals(statuslione, "HTTP/1.1 201 Created");
		
		//Validating headers
		String contenetype = response.header("Content-Type");
		System.out.println(contenetype);
		Assert.assertEquals(contenetype, "application/json; charset=utf-8");
		
		String connection = response.header("Connection");
		System.out.println(connection);
		Assert.assertEquals(connection,"keep-alive");
		
		//String name = response.jsonPath().get("name");
		//System.out.println(name);
		
		Headers allheader = response.headers();
		for (Header header : allheader) {
			System.out.println(header.getName()+"==========="+header.getValue());
			
			
			
		}
		
	}

}
