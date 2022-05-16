package card;

public class Card 
{

	private int customerId;
	private String name;
	private int age;
	private String gender;
	private long mobile;
	private String location;
	private int maxLimit;
	
	public int getMaxLimit() {
		return maxLimit;
	}
	public void setMaxLimit(int maxLimit) {
		this.maxLimit = maxLimit;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "card Number : " + customerId + "\n name : " + name + "\n age : " + age + "\n gender : " + gender
				+ "\n mobile : " + mobile + "\n location : " + location+"\n Maximum Limit : "+maxLimit;
	}
	
	
}
