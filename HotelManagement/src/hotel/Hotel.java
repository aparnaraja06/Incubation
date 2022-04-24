package hotel;

public class Hotel {

	private String name;
	private int rooms;
	private String location;
	private float rating;
	public void setRating(float rating) {
		this.rating = rating;
	}

	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return name+" "+rooms+" "+location+" "+rating+" "+price;
	}
}
