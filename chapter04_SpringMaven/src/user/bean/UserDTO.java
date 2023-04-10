package user.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UserDTO {
	private String name;
	private String id;
	private String pwd;
	
	
	public String getName() {
		return name;
	}
	@Autowired
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	@Autowired
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	@Autowired
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
