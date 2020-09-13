package com.employee.e2e.init;

import org.testng.annotations.DataProvider;

import com.employee.e2e.models.Employee;
import com.employee.e2e.utils.ReadExcelUtility;


public class E2EInitializer {
	//Test
	@DataProvider
	public static Object[][] loadEmployeeDetails() throws Exception {
		ReadExcelUtility resdExcelUtility = new ReadExcelUtility();
	Object[][] testObjArray = resdExcelUtility.getTableArray(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
			return testObjArray;	

	}
}
