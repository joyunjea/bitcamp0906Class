package com.bitcamp.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import domain.SearchType;

@Controller
public class SearchController {
	
	@RequestMapping("/search/search1")
	public void getForm1() {
		
	}
	
	@RequestMapping("/search/search2")
	public void getForm2() {
		
	}
	
	@RequestMapping("/search/search3")
	public void getForm3() {
		
	}
	
	//검색 타입
	//@ModelAttribute : 메소드가 반환하는 객체를 view에 전달
	@ModelAttribute("searchType")
	public List<SearchType> getSearchType(){
		List<SearchType> list = new ArrayList<SearchType>();
		list.add(new SearchType(1,"아이디"));
		list.add(new SearchType(2, "이름"));
		list.add(new SearchType(3, "이름+아이디gg"));
		//[SearchType [value=1, text=아이디], SearchType [value=2, text=이름], SearchType [value=3, text=이름+아이디]]
		//${searchType}는 위의 형식으로 출력됨
		return list;

	}
	
	//인기검색어
	@ModelAttribute("keywords")
	public String[] getkeywords() {
		return new String[] {"COOL", "HOT", "SON"};
		//${searchType}는   COOL HOT SON형식으로 출력됨
	}
}
