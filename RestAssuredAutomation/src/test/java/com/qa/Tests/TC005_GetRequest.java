package com.qa.Tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GetRequest 
{
    @Test
	void getWeatherDetails()
	{
		//1.Specify the baseURI
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//2.Request the object
		RequestSpecification httpRequest=RestAssured.given();
		
		//3.Response
		Response httpResponse=httpRequest.request(Method.GET,"/Amaravati");
		
		//4.printing the response
		String responseBody=httpResponse.getBody().asString();
		System.out.println("Response body is "+responseBody);
		
		//5.printing all headers in console
		Headers allHeaders=httpResponse.headers();
		for(Header header:allHeaders)
		{
			System.out.println(header.getName()+"    "+header.getValue());
			
		}	
		
	}
	
	
	
}
