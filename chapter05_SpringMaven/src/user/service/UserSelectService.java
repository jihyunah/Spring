package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
@Scope("prototype")
public class UserSelectService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		System.out.println();
		
		List<UserDTO> list = userDAO.getUserList();
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
					+ userDTO.getId() + "\t"
					+ userDTO.getPwd());
		}

	}

}
