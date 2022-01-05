package com.bitcamp.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import domain.RegRequest;

@Controller
@RequestMapping("/member/reg")		//써주게되면 아래 메소드의 매핑부분에 value = "/member/reg"를 생략가능
public class MemberRegController {
	
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String getRegForm() {
		return "member/regForm";
	}
	
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String memberReg(
		
		HttpServletRequest request,
		@RequestParam("uid") String uid,
		@RequestParam("pw") String pw,
		@RequestParam("uname") String uname,
		@ModelAttribute("reg") RegRequest regRequest		//@ModelAttribute 사용으로 속성이름을"reg"로 표현
		) {
		
		System.out.println("request: " + request.getParameter(uid));
		System.out.println("request: " + request.getParameter(pw));
		System.out.println("request: " + request.getParameter(uname));
		
		System.out.println("@RequestParam : " + uid);
		System.out.println("@RequestParam : " + pw);
		System.out.println("@RequestParam : " + uname);
		
		System.out.println(regRequest);

		return "member/reg";
	}

}
