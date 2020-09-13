package com.employee.e2e.init;

import io.github.millij.poi.SpreadsheetReadException;
import io.github.millij.poi.ss.reader.XlsReader;
import io.github.millij.poi.ss.reader.XlsxReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.employee.e2e.models.Employee;
import com.employee.e2e.utils.ReadExcelUtility;

public class CheckExcelUtiity {
	
	public Object[][] loadEmployeeDetails() throws Exception {
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("emptestdata.xlsx").getFile());
		System.out.println(file.getAbsolutePath());
		
		ReadExcelUtility resdExcelUtility = new ReadExcelUtility();
		Object[][] testObjArray = resdExcelUtility.getTableArray("/testdata/emptestdata.xlsx",
				"Sheet1");
		
		Employee emp = new Employee();
		//emp.setName(testObjArray[0][3]);
		return (testObjArray);

	}
	
	public List<Employee> readEmployee(){
		final File xlsxFile = new File("testdata/emptestdata.xlsx");
	    final XlsxReader  reader = new XlsxReader ();
	    List<Employee> employees = new ArrayList();
		try {
			employees = reader.read(Employee.class, xlsxFile);
		} catch (SpreadsheetReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public static void main(String[] args) {
		CheckExcelUtiity checkutil = new CheckExcelUtiity();
		try {
			Object[][] testObjArray = checkutil.loadEmployeeDetails();
			System.out.println(testObjArray[0][4]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 List<Employee> employees = new ArrayList();
		 //employees = checkutil.readEmployee();
		// System.out.println("employee " + employees.size());
	}

}
