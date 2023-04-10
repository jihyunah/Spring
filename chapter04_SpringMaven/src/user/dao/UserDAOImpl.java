package user.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.bean.UserDTO;



@Repository //@Component 써도 되지만, db와 연동하는 bean이기에 repository 씀. 
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	private DataSource dataSource;
	
	@Autowired
	public void setDS(DataSource dataSource) { //final이라 override가 안되어서 다른 이름의 메소드로 함. 
		setDataSource(dataSource); //JdbcDAoSupport(부모)에 있는 setDataSource() 메소드를 호출 
	}
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(:name,:id,:pwd)"; //이렇게 ?자리에 이름을 부여할 수 있음.  -> 헷갈리는걸 방지함. 
		
		Map<String, String> map = new HashedMap<String, String>(); //얘네는 꼭 map으로 들어와야함.
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map); //insert없다. update로 입력과 수정 모두 한다. 
		
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); //한 줄당 dto에게 매핑을 해주겠다. 
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=?";
		try {
			return getJdbcTemplate().queryForObject(sql,
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
					id); //queryForObject 하면 하나만 가져온다.
			
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id ";
		getNamedParameterJdbcTemplate().update(sql, map); //sql과 map을 준다. 
		
	}

	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=:id";
		getJdbcTemplate().update(sql, id); //delete가 없어서 update로 대신함.
		
	}

	
}