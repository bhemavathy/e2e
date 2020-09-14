package com.employee.e2e.init;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import com.employee.e2e.constants.Constant;
import com.employee.e2e.models.Employee;
import com.employee.e2e.utils.ReadExcelUtility;
import com.employee.e2e.utils.ReportGenerationUtils;



public class E2EInitializer {
	//Test
	@DataProvider
	public static Object[][] loadEmployeeDetails() throws Exception {
		ReadExcelUtility resdExcelUtility = new ReadExcelUtility();
	Object[][] testObjArray = resdExcelUtility.getTableArray(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
			return testObjArray;	

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		try {
			ReportGenerationUtils  reportGen = new ReportGenerationUtils();
			int status = result.getStatus();

			switch (status) {
			case ITestResult.SUCCESS:
				reportGen.createFile("Success");
				break;
			case ITestResult.FAILURE:
				reportGen.createFile(result.getThrowable().getMessage());
				break;
			case ITestResult.SKIP:
				
				break;
			default:
				throw new RuntimeException("Invalid status");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
