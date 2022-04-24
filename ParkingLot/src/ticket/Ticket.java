package ticket;

import java.sql.Time;
import java.time.LocalTime;

public class Ticket {

	private int ticketNumber;
	private int floorNumber;
	private String vehicleType;
	private double cost;
	private LocalTime entryTime;
	
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
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
		
	public LocalTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalTime entryTime) {
		this.entryTime = entryTime;
	}
	public String toString() {
		
		return "TicketNumber "+ticketNumber+" Floor Number "+floorNumber+ " cost "+ cost+" Time "+entryTime;
	}
}
