package com.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //일반 java 파일이 아닌, dispatcher와 연결된 controller 라는 거를 알려준다.
public class HelloController {
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //여기서 사용자가 만든 콜백 메소드 . 호출안해도 Spring이 자동호출해줌.
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring !!");
		//mav.setViewName("hello"); //파일명 지정
		mav.setViewName("/view/hello"); //xml 파일에서 prefix를 없앴기 때문에 폴더명까지 지정.
		
		return mav; //다시 dispatcher로 간다. 
	}
}

/*

콜백 메소드 
- 어떤 때가 되면 운영체제, 스프링에 의해서 호출되는 메소드 


http://localhost:8088/Context명(project명)/hello.do

DispatcherServlet
	⬇ HandlerMapping (둘을 연결해줌)️
helloController.java

*/