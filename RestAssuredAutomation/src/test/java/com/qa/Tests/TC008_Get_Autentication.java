package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC008_Get_Autentication
{

	@Test
	void checkAutentication()
	{
		//1.Specify the baseURI
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		
		//authentication
		PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
		authScheme.setUserName("ToolsQA");
		authScheme.setPassword("TestPassword");
		RestAssured.authentication=authScheme;
		
		//2.Request the Object
		RequestSpecification httpRequest=RestAssured.given();
		
		//3.Response
		Response httpResponse=httpRequest.request(Method.GET,"/");
		
		//4.printing the responseBody...
		String responseBody=httpResponse.getBody().asString();
		System.out.println("responseBody is "+responseBody);
		
		//validating status code
		int statusCode=httpResponse.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
