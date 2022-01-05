package com.bitcamp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//HelloService service = new HelloService();
	
	@Autowired	//주소값을 일치시켜주는 기능
	HelloService service;	//주입 받아야함
	
	
	public HelloController(HelloService service) {
		this.service=service;
		
	}
	//사용자 요청 uri 등록 : 실행할 메소드 정의
	//http://localhost:8080/mvc/hello
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		ModelAndView view = new ModelAndView(); //디폴트생성자
		//view name 지정
		view.setViewName("hello/hello"); //hello폴더안의 hello     setViewName는 view경로를 지정해주는 메소드
			//	/WEB-INF/views/hello/hello.jsp
		// view에 전달할 결과 데이터 설정
		view.addObject("greeting", service.getGreetin()); // (식별할수있는이름, 전달할 데이터)	
		return view;										//addObject는 view에서 출력할 데이터를 추가								
	}
	
	
	
}
