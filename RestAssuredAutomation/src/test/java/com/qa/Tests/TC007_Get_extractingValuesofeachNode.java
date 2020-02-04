package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC007_Get_extractingValuesofeachNode 
{
    @Test
	void getWeatherDetails()
	{
		
		//1.Specify the baseURI
				RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
				
				//2.Request the object
				RequestSpecification httpRequest=RestAssured.given();
				
				//3.Response
				Response httpResponse=httpRequest.request(Method.GET,"/Bangalore");
				
				//extracting values from each node
				JsonPath jsonPath=httpResponse.jsonPath();
				
				System.out.println(jsonPath.get("City"));
				System.out.println(jsonPath.get("Temperature"));
				System.out.println(jsonPath.get("Humidity"));
				System.out.println(jsonPath.get("WeatherDescription"));
				System.out.println(jsonPath.get("WindSpeed"));
				
				//validating each node.....
				Assert.assertEquals(jsonPath.get("City"), "Bangalore");
	}
	
	
	
	
	
	
	
	
}
