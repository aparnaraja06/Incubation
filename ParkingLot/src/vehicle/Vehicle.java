package vehicle;

public class Vehicle {
             
	private long Number;
	private String type;
	private long ticketNumber;
	private boolean isPaid=false;
	
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public long getNumber() {
		return Number;
	}
	public void setNumber(long number) {
		Number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	
	public String toString()
	{
		return Number+" "+type;
	}
}
