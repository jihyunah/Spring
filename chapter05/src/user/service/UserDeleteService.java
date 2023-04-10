package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {
	@Setter
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("삭제 할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
			//new 해서 빈을 생성하지 않기 때문에, 위에서 @setter로 DAOImpl 값 가져옴.
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자하는 아이디가 없습니다.");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println("DB의 내용을 삭제하였습니다.");
	}

}
