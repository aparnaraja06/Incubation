package vehicle;

public class Vehicle {
             
	private long Number;
	private String type;
	private int customerId;
	
	
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getNumber() {
		return Number;
	}
	public void setNumber(long number) {
		Number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
	public String toString()
	{
		return Number+" "+type+" "+customerId;
	}
}
