package product;

import java.io.Serializable;

public class Product implements Serializable
{

	private int id;
	private String type;
	private String brand;
	private String model;
	private double amount;
	private int discount;
	private int stock;
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "id : " + id + ", type : " + type + ", brand : " + brand + ", model : " + model + ", amount : " + amount
				+ ", discount : " + discount+", stock : "+stock;
	}
	
	
}
