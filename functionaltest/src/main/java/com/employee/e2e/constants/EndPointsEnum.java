package com.employee.e2e.constants;

public enum EndPointsEnum {	
	GETALLEMPLOYESS("/api/v1/employees"),
	POSTEMPLOYEE("/api/v1/create"),
	PUTEMPLOYEE("/api/v1/update"),
	DELETEEMPLOYEE("/api/v1/delete");
	private String url;
	
	EndPointsEnum(String url){
		this.url = url;
	}
	
	 public String getUrl() {
	        return url;
	 }
}
