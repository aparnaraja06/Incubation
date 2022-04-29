package ticket;

import java.util.List;

import passenger.Passenger;

public class Ticket {
	
	private int ticketNumber;
	private int berthNumber;
	private String date;
	private String fromLocation;
	private String destination;
	private String type;
	
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getBerthNumber() {
		return berthNumber;
	}
	public void setBerthNumber(int berthNumber) {
		this.berthNumber = berthNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
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
		return "ticketNumber : " + ticketNumber + ", berthNumber : " + berthNumber + ", date : " + date
				+ ", fromLocation : " + fromLocation + ", destination : " + destination + ", type : " + type ;
	}
			
	
	
		
	

}
