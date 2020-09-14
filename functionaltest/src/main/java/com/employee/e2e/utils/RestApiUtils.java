package com.employee.e2e.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import io.restassured.*;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import com.employee.e2e.constants.EndPointsEnum;
import com.employee.e2e.constants.HttpEnum;
import com.employee.e2e.models.*;

import org.json.JSONObject;
import org.testng.Assert;

public class RestApiUtils {
	RequestSpecification httpRequest;

	public RestApiUtils(String uri) {
		RestAssured.baseURI = uri;
		httpRequest = RestAssured.given();
	}

	public Response callRest(HttpEnum httpMethod,
			Map<String, String> reqParams, EndPointsEnum apiEndPoint) {

		switch (httpMethod) {
		case GET:
			return callGetRequest(reqParams, apiEndPoint);
		case POST:
			return callPostRequest(reqParams, apiEndPoint);
		case PUT:
			return callPutRequest(reqParams, apiEndPoint);
		case PATCH:
			return callPatchRequest(reqParams, apiEndPoint);
		case DELETE:
			return callDeleteRequest(reqParams, apiEndPoint);
		default:
			return null;
		}
	}

	private Response callDeleteRequest(Map<String, String> reqParams,
			EndPointsEnum apiEndPoint) {
		Response response = httpRequest.delete(apiEndPoint.getUrl()
				+ reqParams.get("id"));
		return response;
	}

	private Response callPatchRequest(Map<String, String> reqParams,
			EndPointsEnum apiEndPoint) {
		return null;
	}

	private Response callPutRequest(Map<String, String> reqParams,
			EndPointsEnum apiEndPoint) {
		// create json objects to send the parameters
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", reqParams.get("name"));
		requestParams.put("salary", reqParams.get("salary"));
		requestParams.put("age", reqParams.get("age"));

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response response = httpRequest.put(apiEndPoint.getUrl()
				+ reqParams.get("id"));
		// String responseBody = response.getBody().asString();
		// System.out.println("Response Body is =>  " + responseBody);
		return response;
	}

	private Response callPostRequest(Map<String, String> reqParams,
			EndPointsEnum apiEndPoint) {

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", reqParams.get("name"));
		requestParams.put("salary", reqParams.get("salary"));
		requestParams.put("age", reqParams.get("age"));

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toString());
		Response createResponse = httpRequest.post(apiEndPoint.getUrl());

		// String responseBody = createResponse.getBody().asString();
		// System.out.println("Response Body is =>  " + responseBody);
		return createResponse;
	}

	private Response callGetRequest(Map<String, String> reqParams,
			EndPointsEnum apiEndPoint) {
		Response getResponse = null;
		try {
			getResponse = httpRequest.get(apiEndPoint.getUrl());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getResponse;
	}

}
