package order;

import java.io.Serializable;

public class Order implements Serializable
{

	private String mailId;
	private int productId;
	private int orderId;
	private String type;
	private String model;
	private String brand;
	private String date;
	private double total;
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "mailId : " + mailId + ", productId : " + productId + ", orderId : " + orderId + ", type : " + type
				+ ", model : " + model + ", brand : " + brand + ", date : " + date + ", total : " + total;
	}
	
	
}
