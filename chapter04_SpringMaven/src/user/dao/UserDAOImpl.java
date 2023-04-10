package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lombok.Setter;
import user.bean.UserDTO;


@Repository //Repository는 DB와 연동된 것을 의미
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	
	@Autowired
	public void setDS(DataSource dataSource) { //setDataSource는 final로 override불가능하게 되어있어 
												//이름을 바꿔 setDS라는 이름으로 바꾸어 사용한다.
		setDataSource(dataSource);	//JdbcDaoSupport에 있는 setDataSource() 메소드를 호출
	}
	
	@Override
	public void write(UserDTO userDTO) { //NamedParameterJdbcDaoSupport는 Map으로만 받아야한다.
		String sql = "insert into usertable values(:name,:id,:pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}


	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); 
		//RowMapper은 한줄의 데이터값 중 하나의 데이터들으 한개의 데이터와 매핑하여 넣어준다.
	}
	
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=(:id)";
		try {
			return getJdbcTemplate().queryForObject(
					sql,
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
					id
				);
			
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
		
		
	}

	@Override 
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=(:name), pwd=(:pwd) where id=(:id)";
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}


	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=(:id)";
		
		/*Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		getNamedParameterJdbcTemplate().update(sql, map);*/
		getJdbcTemplate().update(sql, id);
	}


	
	
}

