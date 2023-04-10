package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service //Component라고 사용 가능하다. @Service @Repository
public class UserInsertService implements UserService {
	
	@Autowired //생성된 빈들 중에서 UserDTO 타입을 찾아서 자동으로 매핑해라
	private UserDTO userDTO = null;
	@Autowired
	private UserDAO userDAO = null;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		
		//데이터
		System.out.print("이름을 입력해주세요 : ");
		String name = scanner.next();
		
		System.out.print("아이디를 입력해주세요 : ");
		String id = scanner.next();
		
		System.out.print("비밀번호를 입력해주세요 : ");
		String pwd = scanner.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//DB
		userDAO.write(userDTO);
		
		System.out.println(name + "님의 데이터를 DB에 저장하였습니다.");
	}

}
