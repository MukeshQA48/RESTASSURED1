package com.qa.Tests;

import org.apache.http.HttpResponse;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_PostRequest 
{

	@Test
	void createEmployee()
	{
		
		//1.Specify the base URI..
		RestAssured.baseURI="https://reqres.in";
		
		
		//2.Request the Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//3.Request the payLoad
		JSONObject jsonObject=new JSONObject();
		
		jsonObject.put("name", "Srinivas");
		jsonObject.put("job", "QA");
		
		httpRequest.header("Content-Type","application/json");
		httpRequest.body(jsonObject.toJSONString());
		
		//4.Response
		Response httpResponse=httpRequest.request(Method.POST,"/api/users");
		
		String responseBody=httpResponse.getBody().asString();
		System.out.println("response body is "+responseBody);
		
		//validating status code
		int statusCode=httpResponse.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		
	}
	
	
	
	
	
	
	
	
}
