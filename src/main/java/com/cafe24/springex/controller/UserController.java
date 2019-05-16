package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.springex.vo.UserVo;

//@RequestMapping 중에 type+Method

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	//메소드 오버로드
	@RequestMapping(value="/join",method=RequestMethod.GET)
	//@GetMapping("/join")완전 동일
	public String join() {
		return "/WEB-INF/views/join.jsp"; 
	}
	
	@RequestMapping(value= {"/join","/j"},method=RequestMethod.POST)
	public String join(@ModelAttribute UserVo userVo) { //자동으로 모델에 넣어줌 
		System.out.println(userVo);
		if(valid(userVo)) {
			return "/WEB-INF/views/join.jsp";
		}
		return "redirect:/hello"; 
	}
	
	private boolean valid(UserVo userVo) {
		return false;
	}
}
