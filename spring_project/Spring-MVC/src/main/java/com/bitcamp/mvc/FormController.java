package com.bitcamp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/form") //value 지워주고 맵핑만 놔둠
public class FormController {
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String getForm() {
		//반환하는 문자열은 view name
		return "form/form";		//WEB-INT/views/form/form.jsp
	}
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public ModelAndView getParam( @RequestParam("uid") String uid,@RequestParam("pw") String pw) {
		
		//getParam("cool", "123");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("form/data"); // /WEB-INF/views/form/data.jsp
		view.addObject("uid", uid);
		view.addObject("pw", pw);
		
		return view;
	}
}
