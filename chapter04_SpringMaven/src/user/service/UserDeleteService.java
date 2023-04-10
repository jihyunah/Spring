package user.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Component
public class UserDeleteService implements UserService {
	
	//@Autowired
	//private UserDTO userDTO = null;
	
	@Autowired
	private UserDAO userDAO = null;
	
	private String id;
	private String pwd;
	
	@Override
	public void execute() {
		//삭제 할 아이디 입력 : angel
		//찾고자 하는 아이디가 없습니다
		
		//삭제할 아이디 입력 : hong
		//DB의 내용을 삭제하였습니다.
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제 할 아이디 입력 : ");
		id = scanner.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return; //return이 void인 메소드에서 return을 사용하면 그 메소드를 나가라는 명령어이다.
		}
		
		userDAO.delete(id);
		
		System.out.println("DB의 내용을 삭제하였습니다.");
		
		/*
		List<UserDTO> list = userDAO.getUserList();
		int search = 0;
		
		for(UserDTO userDTO : list) {
			if(userDTO.getId().equals(id)) {
				search = 1;

				userDAO.delete(id);
				System.out.println("DB의 내용을 삭제하였습니다.");
			}
			
		}
		if(search == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		}
		*/
	}

}
