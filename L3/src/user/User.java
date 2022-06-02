package user;

public class User 
{

	private String mail;
	private long mobile;
	private String name;
	private long aadhar;
	private String password;
	private double initialAmount;
	private String type;
	//private Account account;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}
	@Override
	public String toString() {
		return "mail : " + mail + ", mobile : " + mobile + ", name : " + name + ", aadhar : " + aadhar + ", password : "
				+ password + ", initialAmount : " + initialAmount;
	}
	
	
}
