package passenger;

public class Passenger {
	
	private String name;
	private int age;
	private String gender;
	private String typePreference;
	private String allocatedType;
	private int berthNum;
	
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
	public String getTypePreference() {
		return typePreference;
	}
	public void setTypePreference(String typePreference) {
		this.typePreference = typePreference;
	}
	public String getAllocatedType() {
		return allocatedType;
	}
	public void setAllocatedType(String allocatedType) {
		this.allocatedType = allocatedType;
	}
	public int getBerthNum() {
		return berthNum;
	}
	public void setBerthNum(int berthNum) {
		this.berthNum = berthNum;
	}
	@Override
	public String toString() {
		return "name : " + name + ", age : " + age + ", gender : " + gender + ", typePreference : " + typePreference
				+ ", allocatedType : " + allocatedType + ", berthNum : " + berthNum;
	}
			

}
