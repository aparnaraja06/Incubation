package logic;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import customer.CustomerInfo;
import customexception.CustomException;
import floor.Floor;
import park.ParkingOperations;
import space.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public class ParkingLogic {

	ParkingOperations park = new ParkingOperations();

	

	public List<ParkingSpace> getSpaces( int floor_num,String type) throws CustomException {
		return park.getSpaces(floor_num, type);
	}

	public Collection<List<ParkingSpace>> getFloorDetails(int floor_num)throws CustomException {
		return park.getFloorDetails(floor_num);
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
	
	public void addDetails(int floor,int space)throws CustomException
	{
		park.addDefaultFloors(floor, space);
	}
	
	public double chargingCost(int hours)throws CustomException
	{
		return park.chargingCost(hours);
	}
	
	public CustomerInfo getInfoByMobile(long mobile)
	{
          return park.getInfoByMobile(mobile);
	}
	
	public double setWalletAmount(CustomerInfo customer,double amount)throws CustomException
	{
		return park.setWalletAmount(customer, amount);
	}
	
	/*public int getCustomerId(long vehicle_num)throws CustomException
	{
		return park.getCustomerId(vehicle_num);
	}*/
	
	/*public void validate(int cust_id,long vehicle_num)throws CustomException
	{
		park.validate(cust_id, vehicle_num);
	}*/
	
	public int addCustomerAccount(CustomerInfo customer)
	{
		return park.addCustomerAccount(customer);
	}
	
	public double addWalletBalance(CustomerInfo customer,double amount)throws CustomException
	{
		return park.addWalletAmount(customer, amount);
	}
	
	public double checkWalletBalance(CustomerInfo customer)
	{
		return park.checkWalletBalance(customer);
	}
}
