package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service //@Component로 써도 됨. service객체로 빈을 잡아주는거다. 
@Scope("prototype")
public class UserInsertService implements UserService {
	@Autowired //생성된 bean들 중에서 UserDTO라는 타입을 찾아서 자동으로 매핑.
	private UserDTO userDTO;
	@Autowired
	private UserDAO userDAO; 
	
	
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
