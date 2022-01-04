package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	
	@RequestMapping(value="/param", method=RequestMethod.POST)
	public String getForm(Model model) {
		model.addAttribute("title", "회원 로그인 폼");
		return "form/loginForm";
		// /WEB-INF/views/                form/loginForm             .jsp;
	}
	
	// 사용자 요청 파라미터 받기 : HttpServletRequest 이용
	@RequestMapping(value = "/getParam1", method = RequestMethod.POST)
	public String getParam1(HttpServletRequest request,Model model) { //데이터를 받을때 필요, 경로를 받을떄도 필요하다
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		model.addAttribute("uid", uid);
		model.addAttribute("pw", pw);
		
		return "form/loginInfo";
	}
	
	// 사용자 요청 파라미터 받기 : @RequestParam 이용 
	@RequestMapping(value = "/getParam2", method = RequestMethod.POST)
	public String getParam2(
			@RequestParam(name = "uid", defaultValue = "test" ) String uid,
			@RequestParam(name = "pw", required = false) String pw,
			@RequestParam(name = "page", defaultValue = "1") int pageNumber,
			Model model) {
		
		
		User user= new User(uid, pw);
		model.addAttribute("me", user);
		
		
	
		
	
		System.out.println(uid + ":" + pw);
		
		return "form/loginInfo";
	}
	
	// Bean 객체를 자동으로 바인딩해주는 Spring Framework
	@RequestMapping(value="/getParam3", method=RequestMethod.POST)
	public String getPararm3(@ModelAttribute("myuser")User user) {		
		return "form/loginInfo";}
	
	
}
