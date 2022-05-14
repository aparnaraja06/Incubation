package ticket;

public class Ticket {
	
	private int ticket_num;
	private char start;
	private char destination;
	private String type;
	private double amount;
	private long vehicle_num;
	
	public long getVehicle_num() {
		return vehicle_num;
	}
	public void setVehicle_num(long vehicle_num) {
		this.vehicle_num = vehicle_num;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getTicket_num() {
		return ticket_num;
	}
	public void setTicket_num(int ticket_num) {
		this.ticket_num = ticket_num;
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
	@Override
	public String toString() {
		return " ticket_num : " + ticket_num + "\n start : " + start + "\n destination : " + destination + "\n "
				+ "type : "+ type + "\n amount : " + amount+"\n vehicle Number : "+vehicle_num;
	}
	
	
	

}
