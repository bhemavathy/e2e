# Employee E2E API Testing
This Repo Performs End to End API testing for Employee Crud Operations

# Use Case - 
Employee Functional test End to end API testing <br>
	GET employees api - 	http://dummy.restapiexample.com/api/v1/employees <br>
	POST employee api -  	http://dummy.restapiexample.com/api/v1/create <br>
	PUT employee api  -   http://dummy.restapiexample.com/api/v1/update/1 <br>
	Delete employees api -  http://dummy.restapiexample.com/api/v1/delete/1 <br>

	src/main/java
		com.employee.e2e
				models
						Employee
		com.employee.e2e
				utils 	
				    RestApiUtils
				    ExcelReadutility
				    ReportGenerationUtils
		com.employee.e2e
		        init
                  E2EInitializer
    src/test/java
        com.employee.test.e2e.functionaltest
        	     EmployeE2ETest
    


    src/test/resources
    		testdata
    				emptestdata.xlsx
    		suites
    			employee2etest.xml

