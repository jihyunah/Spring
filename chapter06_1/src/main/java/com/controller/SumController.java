package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SumController {
		@RequestMapping(value="/hello.do", method=RequestMethod.GET)
		public ModelAndView sum() {
			ModelAndView mav = new ModelAndView();
			mav.addObject("result", "Hello Spring!!");
			
			return mav;
		}
	
}
