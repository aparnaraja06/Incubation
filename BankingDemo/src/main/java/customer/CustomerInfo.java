package customer;

import java.io.Serializable;

public class CustomerInfo implements Serializable {
	private int customerID;
	private String customerName;
	private long mobileNum;
	private String gender;
	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int custID) {
		customerID = custID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String toString() {
		return customerName + " " + gender + " " + mobileNum+" "+active;
	}

}
