package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	@Autowired
	private HelloService service;
	
	@RequestMapping("/error/null")
	public String getPage() {
		
		System.out.println(service.getGreetin());
		
		return "index";
	}
	
	//5:00
	@ExceptionHandler(NullPointerException.class)
	public String handleNullpointerException(NullPointerException e) {
		return "error/null";
	}
}
