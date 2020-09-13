package com.employee.e2e.utils;

import java.net.MalformedURLException;
import java.net.URL;

import io.restassured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.employee.e2e.models.*;

import org.json.JSONObject;

 
public class RestApiUtils {
	 RequestSpecification httpRequest ;
	
	public RestApiUtils(String uri) {
		RestAssured.baseURI = uri;
		httpRequest = RestAssured.given();
	}
	
	public Response callRest(HttpEnum httpMethod,String reqParams,EndPointsEnum apiEndPoint){
		
		switch(httpMethod){
		case  GET :
			return callGetRequest(reqParams,apiEndPoint);
		case  POST :
			callPostRequest();
		case  PUT :
			callPutRequest();
		case  PATCH :
			callPatchRequest();
		default:
			return null;
		}	
	}
		
	private void callPatchRequest() {
		// TODO Auto-generated method stub
		
	}

	private void callPutRequest() {
		// TODO Auto-generated method stub

	}

	private void callPostRequest() {
		RestAssured.baseURI = "http://dummy.restapiexample.com";
		RequestSpecification httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "konggk3");
		requestParams.put("salary", 45121);
		requestParams.put("age", 27);

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response createResponse = httpRequest.post("/api/v1/create");

		String responseBody = createResponse.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		System.out.println(createResponse.contentType());
		JsonPath jsonPath = createResponse.jsonPath();
		
	}

	private Response callGetRequest(String reqParams, EndPointsEnum apiEndPoint) {
		Response getResponse = null ;
		try {			
			getResponse = httpRequest.get(apiEndPoint.getUrl());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getResponse;
	} 

}
