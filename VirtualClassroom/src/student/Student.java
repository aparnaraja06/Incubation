package student;

import user.User;

public class Student extends User
{

	private int grade;
	private String section;
	private String batch;
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	@Override
	public String toString() {
		return super.toString()+"\n grade : " + grade + "\n section : " + section + "\n batch : " + batch;
	}
	
	
	
}
