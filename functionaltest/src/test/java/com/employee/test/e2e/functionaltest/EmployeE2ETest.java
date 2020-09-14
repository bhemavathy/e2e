package com.employee.test.e2e.functionaltest;

import java.util.HashMap;
import java.util.Map;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.employee.e2e.constants.Constant;
import com.employee.e2e.constants.EndPointsEnum;
import com.employee.e2e.constants.HttpEnum;
import com.employee.e2e.init.E2EInitializer;
import com.employee.e2e.utils.RestApiUtils;

public class EmployeE2ETest extends E2EInitializer {

	@Test(dataProvider = "loadEmployeeDetails", dataProviderClass = E2EInitializer.class)
	public void e2eEmployeeTest(String testCaseName, String id, String name,
			String age, String salary) {
		// E2E Functional Test Cases
		RestApiUtils restapi = new RestApiUtils(Constant.URL);
		Map<String, String> requestParams = prepareRequest(name, age, salary);
		// 1.Get Employee
		Response getEmployeeResponse = restapi.callRest(HttpEnum.GET,
				requestParams, EndPointsEnum.GETALLEMPLOYESS);
		JsonPath jsonPathEvaluator = getEmployeeResponse.jsonPath();
		String actualValue = jsonPathEvaluator.get("data[0].employee_name");
		String ExpectedValue = "Tiger Nixon";
		Assert.assertEquals(actualValue, ExpectedValue);

		// 2.Create Employee
		Response getPostResponse = restapi.callRest(HttpEnum.POST,
				requestParams, EndPointsEnum.POSTEMPLOYEE);
		JsonPath postJsonPathEvaluator = getPostResponse.jsonPath();
		Integer employeeId = postJsonPathEvaluator.get("data.id");
		System.out.println("testCaseName " + testCaseName + " Employee Id " + employeeId);
		Assert.assertFalse((employeeId.equals(null)), " Employee Id Is Created");

		// 3.PUT Employee
		preparePutRequest(requestParams, "salary", "500", employeeId.toString());

		Response getPutResponse = restapi.callRest(HttpEnum.PUT, requestParams,
				EndPointsEnum.PUTEMPLOYEE);
		int statusCode = getPutResponse.getStatusCode();
		System.out.println("testCaseName " + testCaseName + " Put statusCode " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// 4.Delete Employee
		Response getDeleteResponse = restapi.callRest(HttpEnum.DELETE,
				requestParams, EndPointsEnum.DELETEEMPLOYEE);
		int deleteStatusCode = getDeleteResponse.getStatusCode();
		System.out.println("testCaseName " + testCaseName + " DeleteStatusCode " + deleteStatusCode);
		Assert.assertEquals(deleteStatusCode, 200);

	}

	private Map<String, String> prepareRequest(String name, String age,
			String salary) {
		Map<String, String> request = new HashMap<String, String>();
		request.put("name", name);
		request.put("age", age);
		request.put("salary", salary);

		return request;
	}

	private Map<String, String> preparePutRequest(Map<String, String> request,
			String parameterToBeDated, String value, String employeeId) {
		// Map<String,String> request = new HashMap<String,String>();
		request.put(parameterToBeDated, value);
		request.put("id", employeeId);
		return request;
	}

}
