package com.weinnig.webservices.restfulwebservices.helloworld;

import com.weinnig.webservices.restfulwebservices.Beans.Bean;

public class HelloWorldBean extends Bean {
	
	private String message;
	
	public HelloWorldBean(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("HelloWorldBean [message=%s]", this.message);
	}
}
