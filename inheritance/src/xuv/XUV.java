package xuv;
import car.Car;

public class XUV extends Car{
	private int seat;
	private int airBag;
	private String model;
	private String color;
	static private String check="Zoho";
	
	public XUV() {
		super(check);
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public int getAirBag() {
		return airBag;
	}
	public void setAirBag(int airBag) {
		this.airBag = airBag;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString() {
		return "String : "+ check;
	}
}
