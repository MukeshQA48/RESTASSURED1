package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_GetRequest 
{

	@Test
	void GetSuperMarkets()
	{
		//1.Specify the base uri....
		RestAssured.baseURI="http://dummy.restapiexample.com";
		
		//2.Get the Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//3.Response
		Response httpResponse=httpRequest.request(Method.GET,"/api/v1/employee/1");
		
		//printing the Response body
		String responseBody=httpResponse.getBody().asString();
		System.out.println(responseBody);
		
		//validating statusCodes
		int statusCode=httpResponse.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//validating headers
		String contentType=httpResponse.header("Content-Type");
		System.out.println("content type is "+contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		
		//validating headers
		String server=httpResponse.header("Server");
		System.out.println("Server is "+server);
		Assert.assertEquals(server, "nginx/1.16.0");
	}
	
	
	
	
	
	
	
	
	
}
