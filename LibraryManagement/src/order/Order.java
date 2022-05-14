package order;

public class Order 
{

	private int id;
	private int customerId;
	private int bookId;
	private String orderDate;
	private String returnDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "id : " + id + "\n customerId : " + customerId + "\n bookId : " + bookId + "\n orderDate : " 
	+ orderDate+ "\n returnDate : " + returnDate;
	}
	
	
}
