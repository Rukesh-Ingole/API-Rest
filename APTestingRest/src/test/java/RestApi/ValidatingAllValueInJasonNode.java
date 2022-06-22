package RestApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidatingAllValueInJasonNode {
@Test
	public void ValidateAllValueInJason()
	{
	RestAssured.baseURI = "https://reqres.in";
	
	RequestSpecification httprequest = RestAssured.given();
	
	Response response = httprequest.request(Method.GET,"/api/users?page=2");
	
	//String responsebody = response.getBody().asString();
	//Assert.assertEquals(responsebody.contains("2"), true);
	
	JsonPath jsonpath = response.jsonPath();
	System.out.println(jsonpath.get("page"));
	System.out.println(jsonpath.get("per_page"));
	System.out.println(jsonpath.get("total"));
	System.out.println(jsonpath.get("total_pages"));
	//System.out.println(jsonpath.get("last_name"));
	//System.out.println(jsonpath.get("avatar"));
	//System.out.println(jsonpath.get("support"));
	//System.out.println(jsonpath.get("url"));
	
	
	//Assert.assertEquals(jsonpath.get("first_name"), "Janet");
			
	}
}
