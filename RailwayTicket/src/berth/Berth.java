package berth;

public class Berth {
	
	private int number;
	private String type;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
		public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		@Override
	public String toString() {
		return " number : " + number + ", type : " + type;
	}
	
	

}
