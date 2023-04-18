package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController3 {
	@Autowired
	UserService userService;
	
	@PostMapping(value="communityWrite")
	@ResponseBody //다시 바로 ajax로 간다. 이동 x 
	public void communityWrite(@ModelAttribute UserDTO userDTO) {
//		userService.communityWrite(userDTO);
		
	}
	
	@GetMapping(value="communityList")
	//page 번호 아무 말 없으면, 무적권 1로 매기자 라는 것임. <페이징 처리>
	public String communityList(@RequestParam(required = false, defaultValue = "1") String pg, Model model) { 
		//DB를 거치지 않고 바로 화면에 틀만 띄운다.
		
		
		//pg 값 들고 다녀야 하는데, 가져가려면 model, modelMap, modelAndView 중에 하나 사용해야함. 
		model.addAttribute("pg", pg);
		return "user/list";
	}
}
