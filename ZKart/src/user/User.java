package user;

import java.io.Serializable;

public class User implements Serializable
{

	private String mailId;
	private String name;
	private int age;
	private String gender;
	private long mobile;
	private String password;
	private String type;
	private String code;
	private int transaction;
	
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getTransaction() {
		return transaction;
	}
	public void setTransaction(int transaction) {
		this.transaction = transaction;
	}
	@Override
	public String toString() {
		return "mailId : " + mailId + ", name : " + name + ", age : " + age + ", gender : " + gender + ", mobile : "
				+ mobile + ", password : " + password + ", type : " + type + ", code : " + code ;
	}
	
	
}
