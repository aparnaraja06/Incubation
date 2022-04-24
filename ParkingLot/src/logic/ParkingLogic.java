package logic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import floor.Floor;
import park.ParkingOperations;
import ticket.Ticket;
import vehicle.Vehicle;

public class ParkingLogic {

	ParkingOperations park = new ParkingOperations();

	public Ticket addVehicle(Vehicle vehicle, int floor_num) {
		return park.addVehicle(vehicle, floor_num);
	}

	public int getFreeSpace(String type, int floor_num) {
		return park.getFreeSpace(type, floor_num);
	}

	public List<Floor> getFloorDetails() {
		return park.getFloorDetails();
	}

	public boolean bookSlot(String type, int floor_num, int change) {
		return park.bookSlot(type, floor_num, change);
	}

	public LocalTime getTime() {
		return park.getTime();
	}

	public Ticket getTicket(int ticket_num, Vehicle vehicle, int floor_num) {
		return park.getTicket(ticket_num, vehicle, floor_num);
	}

	public Ticket getTicketByVehicleNum(long vehicle_num) {
		return park.getTicketByVehicleNum(vehicle_num);
	}

	public Vehicle getVehicleByTicket(int ticket_num) {
		return park.getVehicleByTicket(ticket_num);
	}

	public LocalTime getTime(long vehicle_num) {
		return park.getTime(vehicle_num);
	}

	public double calculateCost(long hours) {
		return park.calculateCost(hours);
	}

	public Map<Integer, Floor> updateSpaces(Ticket ticket) {
		return park.updateSpaces(ticket);
	}
}
