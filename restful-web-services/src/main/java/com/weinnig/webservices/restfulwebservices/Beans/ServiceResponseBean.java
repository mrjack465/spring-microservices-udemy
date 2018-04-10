package com.weinnig.webservices.restfulwebservices.Beans;

public class ServiceResponseBean extends Bean {
	private int statusCode;
	private Bean result;
	private String message;
	
	public ServiceResponseBean() {
		this.statusCode = 200;
		this.result = new Bean();
		this.message = "Operation successful";
	}
	
	public ServiceResponseBean(int statusCode, Bean result, String message) {
		this.statusCode = statusCode;
		this.result = result;
		this.message = message;
	}
	
	public void setStatusCode(int status) {
		this.statusCode = status;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setResult(Bean b) {
		this.result = b;
	}
	
	public int getStatusCode() {
		return this.statusCode;
	}
	
	public Bean getResult() {
		return this.result;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return String.format("ServiceResponseBean [statusCode=%s, result=%s, message=%s]", 
				this.statusCode, this.result.toString(), this.message);
			
	}
}
