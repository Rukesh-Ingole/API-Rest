package DataDriven;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class dataDrriven_AddNewEmployees {
	@Test(dataProvider="empdataprovider")
	public void postNewEmployees(String ename, String ejob)
	{
		RestAssured.baseURI="https://reqres.in";
		
		RequestSpecification httprequest = RestAssured.given();
		//here we created data which we can send along with the post request
		JSONObject requestparams = new JSONObject();
		
		requestparams.put("name", ename);
		requestparams.put("job",ejob);
		
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestparams.toJSONString());
		
		Response response = httprequest.request(Method.POST,"/api/users");
		
		//Capturing response body to perform validation
		String responsebody = response.getBody().asString();
		System.out.println("Respnse body is : =="+responsebody);
	    Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(ejob), true);
		
		
		int statuscode = response.statusCode();
		Assert.assertEquals(statuscode, 201);
		
	}
	@DataProvider(name="empdataprovider")
	String [][]  getEmpData() throws IOException
	//D:\manishsirjava\APTestingRest\src\test\java\DataDriven\EMPData.xlsx
	{
		String path= "D:\\manishsirjava\\APTestingRest\\src\\test\\java\\DataDriven\\EMPData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet2");
		int colcount =  XLUtils.getCellCount(path, "Sheet2", 1);
		
		String empdata[][] = new String[rownum][colcount]; 
		for (int i = 1; i <= rownum; i++) 
		{
			for (int j = 0; j < colcount; j++)
			{
				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}
		
		
		//String empdata[][] = {{"Deph","Instrucotor"},{"XYZ","Machinshop"},{"ABC","Pailot"}};
		return(empdata);
	}

}
