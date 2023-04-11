package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.SumDTO;
import com.bean.SungJukDTO;

@Controller
@RequestMapping(value = "sungJuk") //반복되는 namespace
public class SungJukController {
	@GetMapping(value="input.do")
	public String input() {
		return "sungJuk/input"; // => /WEB-INF/sum/input.jsp
	}
	
	@PostMapping(value="result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) { //modelMap에 실려 보내겠습니다.
		int tot = sungJukDTO.getKor()+ sungJukDTO.getEng()+sungJukDTO.getMath();
		double avg = tot/3.;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		model.addAttribute("sungJukDTO", sungJukDTO); //성적 dto를 싣어 보낸다. 
		return "sungJuk/result";
	}
}
