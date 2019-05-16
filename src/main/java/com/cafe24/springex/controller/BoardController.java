package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping 중에 메소드단독 맵핑

@Controller
public class BoardController {
	
	@ResponseBody
	@RequestMapping("/board/view/{no}")
	public String view(@PathVariable(value="no")Long no) {
		
		return "BoardController:view("+no+")";
	}
	
	@ResponseBody
	@RequestMapping("/board/update")
	public String update(@RequestParam("name")String name) {
		System.out.println("====="+name+"==========");
		return "BoardControllerupdate:update()";
	}
	
	@ResponseBody
	@RequestMapping("/board/write")
	public String write(@RequestParam(value="n",required = true,defaultValue = "")String name,
			@RequestParam(value="age",required = true,defaultValue = "0")int age) { //request의 모든 값은 스트링 자동으로 형변화
		System.out.println("====="+name+"==========");
		System.out.println("====="+age+"==========");
		return "BoardControllerwrite:write()";
	}
}
