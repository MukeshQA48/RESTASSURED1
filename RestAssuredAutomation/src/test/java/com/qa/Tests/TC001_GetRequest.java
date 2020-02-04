package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GetRequest 
{

	@Test
	void getWeatherDetails()
	{
		
		//1.Specify BaseUri
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//2.Request Object
		RequestSpecification httpRequest=RestAssured.given();
		
		
		//3.Response
		Response httpResponse=httpRequest.request(Method.GET,"/Bangalore");
		
		//print response in console window
		String responseBody=httpResponse.getBody().asString();
		System.out.println("Response Body is"+responseBody);
		
		
		//4.Response Validation..
		//Status code
		int statusCode=httpResponse.getStatusCode();
		System.out.println("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//status Line Validation
		String statusLine=httpResponse.getStatusLine();
		System.out.println("Status Line is "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	
	
	
	
	
	
	
}
