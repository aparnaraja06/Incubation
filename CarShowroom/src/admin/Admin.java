package admin;

import user.User;

public class Admin extends User
{

	private String password;
	private String branch;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n password : " + password + "\n branch : " + branch;
	}
}
