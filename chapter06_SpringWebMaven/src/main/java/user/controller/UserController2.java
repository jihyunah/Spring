package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.service.UserService;



@Controller
@RequestMapping(value = "user")
public class UserController2 {
	@Autowired
	private UserService userService;
	
	//파일 업로드 
	@GetMapping(value="uploadForm")
	public String uploadForm() { //주소로 가라. 
		return "user/uploadForm";
	}
	
	@PostMapping(value="upload")
	@ResponseBody
	public String upload(@RequestParam MultipartFile img, HttpSession session) { //spring에게 session 객체좀 주세요.하는거다. 
		//가상 폴더 
		String filePath_lier = "/Applications/study/Spring/workspace/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
		
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
//		/Applications/study/Spring/workspace/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/chapter06_SpringWebMaven/WEB-INF/storage
		
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName); //파일 생성 
		File file_lier = new File(filePath_lier, fileName);
		
		try {
			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier)); //파일 복사 
			img.transferTo(file);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "<img src='../storage/" + fileName + "' width=300' height='300' />";
	}

}
