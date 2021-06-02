package com.cts.simpleapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@Value("${app.max}")
	private int max;
	@Value("${app.min}")
	private int min;

	@GetMapping("/")
	public String sayHello() {
		return "Hello Sir \n"
				+ "Max = "+max+"\n"
						+ "Min = "+min;
	}
	
	
}
