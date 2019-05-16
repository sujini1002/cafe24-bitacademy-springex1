package com.cafe24.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("email","tgif@gmail.com");
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String  hello3(Model model) { //모델을 직접받아서 속성에 객체를 넣어줌
		model.addAttribute("email", "aufcl@naver.com");
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello4")
	public String  hello4(Model model,@RequestParam("email") String email,@RequestParam String name) { 
		//Dispatcher의 doGet에서 request에 있는 email이란 이름의 값을 호출된 컨트롤러 메소드의 매개변수에 넣어준다(파싱)
		//여러개의 값이 들어갈때는 value="email"을 명시해야한다.
		//어노테이션의 value 생략시 매개변수이름으로 doGet의 request에서 값을 찾아 호출된 컨트롤러 메소드의 매개변수에 넣어준다.
		model.addAttribute("email", email);
		System.out.println("hello4 이름은 :"+name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	//톰캣의 기술이 침투 된 코드 "비추천"
	@RequestMapping("/hello5")
	public String  hello5(Model model,HttpServletRequest request) { 
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
}
