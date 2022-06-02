package customer;

import java.io.Serializable;

public class Customer implements Serializable {
	
	private int id;
	private String username;
	private String name;
	private String password;
	private long mobile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "id : " + id + ", username : " + username + ", password : " + password + ", mobile : " + mobile+""
				+ ", name : "+name;
	}
	
	

}
