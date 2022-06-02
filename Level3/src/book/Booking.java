package book;

import java.io.Serializable;

public class Booking implements Serializable{
	
	private String username;
	private int id;
	private int orderNum;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "username : " + username + ", id : " + id + ", orderNum : " + orderNum;
	}
	
	

}
