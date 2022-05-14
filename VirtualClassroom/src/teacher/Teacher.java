package teacher;

import user.User;

public class Teacher extends User
{

	private String subject;
	private long mobile;
	private String qualification;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n subject : " + subject + "\n mobile : " + mobile + "\n qualification : " + qualification;
	}
}
