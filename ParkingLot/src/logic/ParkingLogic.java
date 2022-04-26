package logic;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import floor.Floor;
import park.ParkingOperations;
import space.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public class ParkingLogic {

	ParkingOperations park = new ParkingOperations();

	

	public List<ParkingSpace> getSpace(String type, int floor_num) throws CustomException {
		return park.getSpace(type, floor_num);
	}

	public List<ParkingSpace> getFloorDetails() {
		return park.getFloorDetails();
	}

	public ParkingSpace bookSlot(ParkingSpace space) throws CustomException {
		return park.bookSlot(space);
	}

	public Ticket getTicket(ParkingSpace space, Vehicle vehicle) throws CustomException {
		return park.getTicket(space, vehicle);
	}

	public Ticket getTicketByNum(int ticket_num) throws CustomException {
		return park.getTicketByNum(ticket_num);
	}

	public int checkVehicle(int ticket_num,long vehicleNum) throws CustomException {
		return park.checkVehicle(ticket_num, vehicleNum);
	}

	public double calculateCost(int hours) throws CustomException {
		return park.calculateCost(hours);
	}

	public boolean updateSpace(Ticket ticket) throws CustomException {
		return park.updateSpace(ticket);
	}
}
