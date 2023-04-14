package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
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

//// -----------------name="img" 1개일 때 ----------------------
//	@PostMapping(value="upload", produces = "text/html; charset=UTF-8")
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, //서버로 가 
//						 @ModelAttribute UserImageDTO userImageDTO, //dto로 가고 
//						 HttpSession session) { //spring에게 session 객체좀 주세요.하는거다. 
//		//가상 폴더 
//		//String filePath_lier = "/Applications/study/Spring/workspace/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
//		
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		System.out.println("실제 폴더 = " + filePath);
////		/Applications/study/Spring/workspace/Spring/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/chapter06_SpringWebMaven/WEB-INF/storage
//		
//		String fileName = img.getOriginalFilename();
//		System.out.println("파일명 = " + fileName);
//		
//		File file = new File(filePath, fileName); //파일 생성 
//		//File file_lier = new File(filePath_lier, fileName);
//		
//		try {
//			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier)); //파일 복사 
//			img.transferTo(file); //파일 이동 
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		userImageDTO.setImage1(fileName);
//		
//		//UserService --> UserDAO __> userMapper.xml(저장시키기)
//		
//		return "<img src='../storage/" + fileName + "' width=300' height='300' />";
//	}
	
	
//	// -----------------name= "img" 2개 이상 일 때 ----------------------
//	@PostMapping(value="upload" , produces = "text/html; charset=UTF-8")
//    @ResponseBody
//    public String upload(@RequestParam MultipartFile[] img,
//                         @ModelAttribute UserImageDTO userImageDTO,
//                         HttpSession session){
//       
//       //가상 폴더
//       String filePath_lier = "/Applications/study/Spring/workspace/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage";
////			//진짜 폴더
//       String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//       System.out.println("실제 폴더 = " + filePath);
//       
//       String fileName;
//       File file;
//       
//       if(img[0] != null) {
//          fileName = img[0].getOriginalFilename();
//          file = new File(filePath, fileName);
//          
//          try {
//             img[0].transferTo(file);
//          } catch (IOException e) {
//             e.printStackTrace();
//          } //실제 경로에 파일을 복사해라
//       }
//       
//       if(img[1] != null) {
//          fileName = img[1].getOriginalFilename();
//          file = new File(filePath, fileName);
//          
//          try {
//             img[1].transferTo(file);
//          } catch (IOException e) {
//             e.printStackTrace();
//          } //실제 경로에 파일을 복사해라
//       }
//       
//       return "이미지 등록 완료";
//    }
	
// ----------------- 한 번에 여러개의 파일을 선택  ----------------------
		@PostMapping(value="upload", produces = "text/html; charset=UTF-8")
		@ResponseBody
		public String upload(@RequestParam("img[]") List<MultipartFile> list, //서버로 가 
							 @ModelAttribute UserImageDTO userImageDTO, //dto로 가고 
							 HttpSession session) { //spring에게 session 객체좀 주세요.하는거다. 
				
			String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
			System.out.println("실제 폴더 = " + filePath);
				
			String fileName; 
			File file; //파일 생성 
			
			for(MultipartFile img : list) {
				fileName = img.getOriginalFilename();
				file = new File(filePath, fileName);
				
				try {
					img.transferTo(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //파일 이동 
			} //for
				
			return "이미지 등록 완료";	
					
			}

}
