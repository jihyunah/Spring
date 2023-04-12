package user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//public class UserController {
//	@RequestMapping(value="/user/writeForm/", method = RequestMethod.GET)
//	public String writeForm() {
//		return "user/writeForm";
//	}

@RequestMapping(value="user")
	public class UserController {
		@GetMapping(value="writeForm")
		public String writeForm() {
			return "user/writeForm";
	}
}
