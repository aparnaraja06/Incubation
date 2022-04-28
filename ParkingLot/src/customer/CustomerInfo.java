package customer;

public class CustomerInfo {

	private int customerId;
	private long vehicleNum;
	private double amount;
	private String name;
	private long mobileNum;
	private String location;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(long vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String toString() {
		return customerId+" "+vehicleNum+" "+amount;
	}
}
