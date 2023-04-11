package com.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller //일반 java 파일이 아닌, dispatcher와 연결된 controller 라는 거를 알려준다.
public class HelloController {
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //여기서 사용자가 만든 콜백 메소드 . 호출안해도 Spring이 자동호출해줌.
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring !!");
		//mav.setViewName("hello"); //파일명 지정
		mav.setViewName("/view/hello"); //xml 파일에서 prefix를 없앴기 때문에 폴더명까지 지정.
		//http://localhost:8088/chapter06/view/hello.jsp 호출 된다. 
		
		return mav; //다시 dispatcher로 간다. 
	}
	
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result2", "Have a nice day!!");
		mav.setViewName("/WEB-INF/view2/hello2"); //web-inf에는 외부에서 들어올 수 없다. 
		//http://localhost:8088/chapter06/WEB-INF/view2/hello2.jsp --> 들어갈 수 없다. --> web-inf에 저장하는 것이 기본이다. 
		
		return mav;
	}
	
	@RequestMapping(value="/hello3.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody //얘를 써주면 String return값이 단순 문자열이 된다. 
	public String hello3() {
		//return "Welcome"; //파일명 Welcome.jsp로 인식한다.
		return "안녕하세요"; //한글 깨짐 현상 --> produces = "text/html; charset=UTF-8"로 해결 
	}
	
	//스프링에서는 return 타입이 String이면 단순 문자열이 아니라, 파일명으로 인식한다.  
	//스프링은 Welcome.jsp 파일을 찾는다.
	//만약 단순 문자열로 웹 브라우저에 나타내려면 @ResponseBody를 써야한다.
}

/*

콜백 메소드 
- 어떤 때가 되면 운영체제, 스프링에 의해서 호출되는 메소드 


http://localhost:8088/Context명(project명)/hello.do

DispatcherServlet
	⬇ HandlerMapping (둘을 연결해줌)️
helloController.java

*/