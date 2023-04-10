package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;


public class UserInsertService implements UserService {
	@Setter
	private UserDTO userDTO;
	@Setter
	private UserDAO userDAO; //부모로 접근해야하기에 userDAOImpl로 접근 안함. 
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		// 데이터 
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("패스워드 입력 : ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB 
		userDAO.write(userDTO); //데이터 가져가라 
		
		System.out.println(name + "님의 정보가 저장되었습니다.");
		
		
		

	}

}
