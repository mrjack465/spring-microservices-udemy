package com.weinnig.webservices.restfulwebservices.helloworld;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weinnig.webservices.restfulwebservices.Beans.Bean;
import com.weinnig.webservices.restfulwebservices.Beans.ServiceResponseBean;

// Controller
@RestController
public class HelloWorldController {
	
	// GET
	// URI: /hello-world
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		Date now = new Date();
		return "[ " + now.toString() + " ] Hello World!";
	}
	
	@GetMapping(path="/say/{something}")
	public String saySomething(@PathVariable String something) {
		return "You said: " + "\"" + something + "\"";
	}
	
	@GetMapping(path="/hello-world-bean")
	public Bean getHelloWorldBean() {
		int statusCode = 200;
		HelloWorldBean result = new HelloWorldBean("Hellooo");
		String message = "Operation successful";
		return new ServiceResponseBean(statusCode, result, message);
	}

}
