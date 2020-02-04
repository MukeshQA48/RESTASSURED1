package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Get_validatingJsonResponse 
{

	@Test
	void getWeatherDetails()
	{
		
		        //1.Specify the baseURI
				RestAssured.baseURI="https://reqres.in";
				
				//2.Request the object
				RequestSpecification httpRequest=RestAssured.given();
				
				//3.Response
				Response httpResponse=httpRequest.request(Method.GET,"/api/users?page=2");
				
				//4.printing the response
				String responseBody=httpResponse.getBody().asString();
				System.out.println("Response body is "+responseBody);
		
                //validating Json Response
				Assert.assertEquals(responseBody.contains("Michael"), true);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
