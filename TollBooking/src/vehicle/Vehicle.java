package vehicle;

public class Vehicle {
	
	private long num;
	private char start;
	private char destination;
	private String type;
	private String tolls;
	private boolean isVip=false;
	
	
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
	public char getStart() {
		return start;
	}
	public void setStart(char start) {
		this.start = start;
	}
	public char getDestination() {
		return destination;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTolls() {
		return tolls;
	}
	public void setTolls(String tolls) {
		this.tolls = tolls;
	}
	@Override
	public String toString() {
		return "num : " + num + ", start : " + start + ", destination : " + destination + ", type : " + type
				+ ", tolls : " + tolls + ", Vip : "+isVip;
	}
	

}
