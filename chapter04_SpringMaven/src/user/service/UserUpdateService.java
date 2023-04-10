package user.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	//@Autowired
	//private UserDTO userDTO = null;
	
	@Autowired
	private UserDAO userDAO = null;
	
	private String name;
	private String id;
	private String pwd;
	
	@Override
	public void execute() {
		//수정 할 아이디 입력 : ???;
		//찾고자 하는 아이디가 없습니다.
		
		//수정할 아이디 입력 : hong;
		//이름	아이디	패스워드
		//???	hong	111
		
		//수정할 이름 입력 : ???
		//수정할 비번 입력 : ???
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정 할 아이디 입력 : ");
		id = scanner.next();
		
		
		//DB
		List<UserDTO> list = userDAO.getUserList();
		int search = 0;
		
		//DB
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
			return; //return이 void인 메소드에서 return을 사용하면 그 메소드를 나가라는 명령어이다.
		}
		System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		
		System.out.println();
		System.out.print("수정할 이름 입력 : ");
		name = scanner.next();
		
		System.out.print("수정할 비밀번호 입력 : ");
		pwd = scanner.next();
		
		Map<String, String> map = new HashedMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("DB의 내용을 수정하였습니다.");
		
		/*
		for(UserDTO userDTO : list) {
			if(userDTO.getId().equals(id)) {
				search = 1;
				
				System.out.println(userDTO.getName() + "\t"
						 + userDTO.getId() + "\t"
						 + userDTO.getPwd());
				System.out.print("수정할 이름 입력 : ");
				name = scanner.next();
				
				System.out.print("수정할 비밀번호 입력 : ");
				pwd = scanner.next();
				
				//데이터
				userDTO.setName(name);
				userDTO.setPwd(pwd);
				
				//DB
				userDAO.update(userDTO);
			}
			
		}
		if(search == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다.");
		} */
	}

}
