package taxi;

public class TaxiInfo {
	
	private int taxiNum;
	private String location;
	private double price;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTaxiNum() {
		return taxiNum;
	}
	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
	}
	public String getFromLocation() {
		return location;
	}
	public void setFromLocation(String fromLocation) {
		this.location = fromLocation;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "taxiNum : " + taxiNum + ", fromLocation : " + location + ", price : " + price;
	}
	
	
	

}
