package ticket;

import java.sql.Time;
import java.time.LocalTime;

public class Ticket {

	private int ticketNumber;
	private int floorNumber;
	private long vehicleNum;
	private int spaceNumber;
	private String entryTime;
	private String type;
	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}
	public long getVehicleNum() {
		return vehicleNum;
	}
	public void setVehicleNum(long vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
	
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}	
	
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String toString() {
		
		return "TicketNumber "+ticketNumber+" Floor Number "+floorNumber+" Space Number "+spaceNumber+" Time "+entryTime;
	}
}
