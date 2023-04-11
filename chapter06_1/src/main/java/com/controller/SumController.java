package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {
		//@RequestMapping(value="/input.do", method=RequestMethod.GET)
		@GetMapping(value="/input.do")
		public String input() {
			return "sum/input"; // => /WEB-INF/sum/input.jsp
		}
		
		//@RequestMapping(value="/result.do", method=RequestMethod.POST)
//		@PostMapping(value="/result.do")
//		public String result() {	
//			return "sum/result"; // => /WEB-INF/sum/result.jsp
//		}
		
//		@PostMapping(value="/result.do")
//		public ModelAndView result(@RequestParam int x, 
//								   @RequestParam int y) { //데이터를 받아간다. 	
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("x", x);
//			mav.addObject("y", y);
//			mav.setViewName("sum/result");
//			
//			return mav; // => /WEB-INF/sum/result.jsp
//		}
		
//		@PostMapping(value="/result.do")
//		public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x, //값이 안들어갔을 때를 방지하여 0을 넣어놓기.
//								   @RequestParam(required = false, defaultValue = "0") String y) { //데이터를 받아간다. 	
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("x", x);
//			mav.addObject("y", y);
//			mav.setViewName("sum/result");
//			
//			return mav; // => /WEB-INF/sum/result.jsp
//		}
		
		@PostMapping(value="/result.do")
		public String result(@RequestParam Map<String, String> map, ModelMap modelMap) { //modelMap에 실려 보내겠습니다.
			modelMap.put("x", map.get("x"));
			modelMap.put("y", map.get("y"));
			return "sum/result";
		}
	
}















