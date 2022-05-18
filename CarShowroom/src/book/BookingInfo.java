package book;

public class BookingInfo 
{

	private int bookId;
	private int customerId;
	private int carId;
	private double amount;
	private String orderDate;
	private String branch;
	private String city;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "\n bookId : " + bookId + "\n customerId : " + customerId + "\n carId : " + carId + "\n amount : "
				+ amount + "\n orderDate : " + orderDate + "\n branch : " + branch + "\n city : " + city;
	}
	
	
}
