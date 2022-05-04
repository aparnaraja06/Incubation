package customer;

public class CustomerInfo {
	
	private String name;
	private int id;
	private String gender;
	private String location;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "name : " + name + ", id : " + id + ", gender : " + gender + ", location : " + location
				+ ", mobile : " + mobile;
	}
	
	
	
	

}
