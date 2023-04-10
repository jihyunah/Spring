package user.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		
		System.out.println("수정 할 아이디 입력 : ");
		String id = scan.next();
		
		//DB
			//new 해서 빈을 생성하지 않기 때문에, 위에서 @setter로 DAOImpl 값 가져옴.
		
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO == null) {
			System.out.println("찾고자하는 아이디가 없습니다.");
			return;
		}
		
		System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
			
		System.out.println();
		System.out.println("수정 할 이름 입력 : ");
		String name = scan.next();
		System.out.println("수정 할 비밀번호 입력 : ");
		String pwd = scan.next();
		
		Map<String, String> map = new HashedMap<String, String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.update(map);
		
		System.out.println("DB의 내용을 수정하였습니다.");
		
		
		
		
		
	}

}

//수정 할 아이디 입력 : angel
//찾고자하는 아이디가 없습니다. 
//
//수정 할 아이디 입력 : hong
//홍길동   hong    111
//
//수정 할 이름 입력 :
//수정 할 비밀번호 입력 :
//	
//DB의 내용을 수정하였습니다. 