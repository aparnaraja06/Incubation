package park;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import floor.Floor;
import space.ParkingSpace;
import ticket.Ticket;
import vehicle.Vehicle;

public class ParkingOperations {
	private int ticket=1000;
	
	List<Floor> floors=new ArrayList<>();
	Map<Integer,Floor> spaceMap=new HashMap<>();
	Map<Integer,Vehicle> vehicleMap=new HashMap<>();
	Map<Long,Ticket> ticketMap=new HashMap<>();
	
	public ParkingOperations() {
		addDefaultFloors();
			}
	
	public int generateTicket() {
		return ++ticket;
	}
	
	public void addDefaultFloors() {
		int number=6;
		for(int i=0;i<number;i++)
		{
			Floor floor=new Floor();
			floor.setNumber(i);
			floors.add(floor);
			spaceMap.put(i, floor);
		}

	}
	public List<Floor> getFloorDetails(){
		return floors;
	}
	
	/*public Floor getFloorDetails(int floorNum)
	{
		Floor floor=spaceMap.get(floorNum);
		return floor;
		
	}*/
	
	public Ticket addVehicle(Vehicle vehicle,int floor_num)
	{
		int ticket_num=generateTicket();
		String type=vehicle.getType();
		int remove=1;
		boolean result=bookSlot(type,floor_num,remove);
		Ticket ticket=getTicket(ticket_num,vehicle,floor_num);
		vehicleMap.put(ticket_num, vehicle);
		return ticket;	
	}
	
	public int getFreeSpace(String type,int floor_num)
	{
		Floor floor=spaceMap.get(floor_num);
		
		int store=0;
		if(type.equals("Car"))
		{
			store=floor.getCompact();
		}
		else if(type.equals("Two-Wheeler"))
		{
			store=floor.getTwoWheeler();
		}
		else if(type.equals("Lorry"))
		{
			store=floor.getLarge();
		}
		else if(type.equals("Handi-Capped"))
		{
			store=floor.getHandicapped();
		}
		else if(type.equals("Electric"))
		{
			store=floor.getElectric();
		}
		
		return store;
	}
	
	
	
	public boolean bookSlot(String type,int floor_num,int change)
	{
	   Floor floor=spaceMap.get(floor_num);
	   
		switch(type)
		{
		case "Car":
		{
			int compact=floor.getCompact();
			floor.setCompact(compact-change);
			int total=floor.getTotalSpace();
			floor.setTotalSpace(total-change);
			return true;
		}
		
		case "Two-Wheeler":
		{
			int twoWheeler=floor.getTwoWheeler();
			floor.setTwoWheeler(twoWheeler-change);
			int total=floor.getTotalSpace();
			floor.setTotalSpace(total-change);
			return true;
		}
		
		case "Lorry":
		{
			int large=floor.getLarge();
			floor.setLarge(large-change);
			int total=floor.getTotalSpace();
			floor.setTotalSpace(total-change);
			return true;
		}
		
		case "Handi-Capped":
		{
			int handy=floor.getHandicapped();
			floor.setHandicapped(handy-change);
			int total=floor.getTotalSpace();
			floor.setTotalSpace(total-change);
			return true;
		}
		
		case "Electric":
		{
			int electric=floor.getElectric();
			floor.setElectric(electric-change);
			int total=floor.getTotalSpace();
			floor.setTotalSpace(total-change);
			return true;
		}
		default:
		{
		return false;
		}
		}
	}
	
	public LocalTime getTime() {
		return java.time.LocalTime.now();
	}
	
	public Ticket getTicket(int ticket_num,Vehicle vehicle,int floor_num) {
		//pending cost update
		long vehicleNum=vehicle.getNumber();
		String type=vehicle.getType();
		LocalTime time=getTime();
		
		Ticket ticket=new Ticket();
		ticket.setVehicleType(type);
		ticket.setEntryTime(time);
		ticket.setTicketNumber(ticket_num);
		ticket.setFloorNumber(floor_num);
		ticketMap.put(vehicleNum, ticket);
		return ticket;
		
	}
	
	public Ticket getTicketByVehicleNum(long vehicle_num)
	{
		return ticketMap.get(vehicle_num);
	}
	
	public Vehicle getVehicleByTicket(int ticket_num)
	{
		return vehicleMap.get(ticket_num);
	}
	
	public LocalTime getTime(long vehicle_num) {
		
		Ticket ticket=ticketMap.get(vehicle_num);
		return ticket.getEntryTime();
	}
	
	public double calculateCost(long hours)
	{
		double amount=0.0;
		
		if(hours==1)
		{
			amount=hours+4;
			return amount;
		}
		else if(hours==2 || hours==3)
		{
			amount=4+3.5;
		}
		else
		{
			amount=4+(hours-1)*3.5;
		}
		
		return amount;
		
	}
	
	public Map<Integer, Floor> updateSpaces(Ticket ticket) {
		int floor_num=ticket.getFloorNumber();
		String type=ticket.getVehicleType();
		int add=-1;
		
		boolean result=bookSlot(type,floor_num,add);
		
		/*if(result)
		{
			return spaceMap;
		}*/
		return spaceMap;
		
	}
	
	
}
