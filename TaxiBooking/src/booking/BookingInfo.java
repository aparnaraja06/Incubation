package booking;

public class BookingInfo {
	
	private int customerId;
	private int taxiNum;
	private String fromLocation;
	private String toLocation;
	private double total;
	private String pickupTime;
	private String dropTime;
	
	public String getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}
	public String getDropTime() {
		return dropTime;
	}
	public void setDropTime(String dropTime) {
		this.dropTime = dropTime;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getTaxiNum() {
		return taxiNum;
	}
	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "customerId : " + customerId + ", taxiNum : " + taxiNum + ", fromLocation : " + fromLocation
				+ ", toLocation : " + toLocation + ", total : " + total +" pickup time : "+pickupTime+" drop time : "
				+dropTime;
	}
	
	

}
