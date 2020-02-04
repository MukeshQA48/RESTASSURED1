package com.qa.Tests;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.util.XLUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC010_PostRequest_Excel 
{

	@Test(dataProvider = "empDataProvider")
	void createEmployees(String ename,String ejob)
	{
     //1.Specify the base Uri
		RestAssured.baseURI="https://reqres.in";
		
		//2.create the Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//3.Request the payLoad
		JSONObject requestParam=new JSONObject();
		requestParam.put("name",ename);
		requestParam.put("job",ejob);
		
		httpRequest.header("Content_Type","application/json");
		httpRequest.body(requestParam.toJSONString());
		
		//3.Response
		Response httpResponse=httpRequest.request(Method.POST,"/api/users");
		
		//printing the Json Object
		String responseBody=httpResponse.getBody().asString();
		System.out.println("Response is "+responseBody);
		
		//validating json Response
		int statusCode=httpResponse.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 201);	
	}
	 @DataProvider(name="empDataProvider")
	String[][] getEmployeeDetails() throws IOException
	{
		String path= "D:\\RestAssuredAutomation\\RestAssuredAutomation\\src\\test\\java\\com\\qa\\util\\EmployeeDetails.xlsx";
		//String path=System.getProperty("user.dir")+"/src/test/java/com/qa/util/EmployeeDetails.xlsx";
		int rowCount=XLUtils.getRowCount(path, "Sheet1");
		int colCount=XLUtils.getCellCount(path, "Sheet1", rowCount);
		
		String[][] empdata=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				empdata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return empdata;
		
		
				
	}
		/*String[][] empData= { {"James","Scientist"},{"Abdul","president"} };
		return empData;
	}*/
}
