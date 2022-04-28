package book;

public class BookingInfo {
	
	private int userId;
	private String userName;
	private String hotelName;
	private int rooms;
	private double cost;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "userId : " + userId + ", userName : " + userName + ", hotelName : " + hotelName + ", "
				+ "rooms : " + rooms + ", cost : " + cost ;
	}
	
	

}
