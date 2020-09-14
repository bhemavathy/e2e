package com.employee.test.e2e.functionaltest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.employee.e2e.constants.Constant;
import com.employee.e2e.constants.EndPointsEnum;
import com.employee.e2e.constants.HttpEnum;
import com.employee.e2e.init.E2EInitializer;
import com.employee.e2e.models.Employee;
import com.employee.e2e.utils.ReadExcelUtility;
import com.employee.e2e.utils.RestApiUtils;

public class EmployeE2ETest extends E2EInitializer{
	
	@Test(dataProvider = "loadEmployeeDetails" ,dataProviderClass=E2EInitializer.class)
	public void e2eEmployeeTest(String testCaseName,String id,String name,String age,String salary){
		//E2E Functional Test Cases 
		RestApiUtils restapi = new RestApiUtils(Constant.URL);
		//1.Get Employee
		Response getEmployeeResponse = restapi.callRest(HttpEnum.GET, "", EndPointsEnum.GETALLEMPLOYESS);
			JsonPath jsonPathEvaluator = getEmployeeResponse.jsonPath();
			String actualValue = jsonPathEvaluator.get("data[0].employee_name");
			String ExpectedValue = "Tiger Nixon1" ;
			
		Assert.assertEquals(actualValue, ExpectedValue);
		//2.Create Employee 
	//	Response getPostResponse = restapi.callRest(HttpEnum.POST, "", EndPointsEnum.POST);
		//JsonPath jsonPathEvaluator1 = getEmployeeResponse.jsonPath();
		//3.PUT Employee
		
		//4.Patch Employee
		
		//5.Delete Employee
	}

	
}
