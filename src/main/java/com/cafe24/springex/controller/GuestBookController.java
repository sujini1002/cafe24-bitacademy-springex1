package com.cafe24.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping 중에 type단독 맵핑

@RequestMapping("/guestbook/*")
@Controller
public class GuestBookController {
	
	@ResponseBody
	@RequestMapping
	public String list() { //guestbook/list들어오면 호출 됨
		return "GuestBookController:list";
	}
}
