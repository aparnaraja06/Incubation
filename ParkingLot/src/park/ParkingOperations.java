package park;


import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import space.ParkingSpace;
import ticket.Ticket;
import validate.Validate;
import vehicle.Vehicle;

public class ParkingOperations {
	private int ticket=1000;
	
	Validate validator=new Validate();
	
	List<ParkingSpace> emptySpace=new ArrayList<>();
	List<ParkingSpace> filledSpace=new ArrayList<>();
	Map<Integer,Ticket> ticketMap=new HashMap<>();
	
	public ParkingOperations() {
		addDefaultFloors();
			}
	
	public int generateTicket() {
		return ++ticket;
	}
	
	
	public void addDefaultFloors() {
		String[] type= {"Compact","Large","HandiCapped","Electric","TwoWheeler"};
		
		int k=0;
		for(int i=0;i<6;i++)
		{
			for(int j=1;j<=10;j++)
			{
			 if((j%type.length-1)==0)
			 {
				 k=0;
			 }
          ParkingSpace space=new ParkingSpace();
			
			
			space.setFloorNumber(i);
			space.setNumber(j);
			space.setType(type[k]);
			
			emptySpace.add(space);
			k++;
			}
		}
		
		
	}
	
	public List<ParkingSpace> getFloorDetails()
	{
		return emptySpace;
		
	}
	
	public String getSpaceType(String type)throws CustomException
	{
	    validator.validate(type);
	    
		switch(type.toLowerCase())
		{
		case "car":
		{
			return "Compact";
		}
		
		case "van":
		{
			return "Large";
		}
		
		case "twowheeler":
		{
			return "TwoWheeler";
		}
		
		case "handicapped":
		{
			return "HandiCapped";
		}
		case "electric":
		{
			return "Electric";
		}
		
		}
		return "Large";
	}
	
	
	public List<ParkingSpace> getSpace(String type,int floor_num)throws CustomException
	{
		validator.validate(type);
		validator.validate(floor_num);
		
		String temp=getSpaceType(type);
		List<ParkingSpace> list=new ArrayList<>();
		
		for(int i=0;i<emptySpace.size();i++)
		{
			ParkingSpace space=emptySpace.get(i);
			String getType=space.getType();
			int floor=space.getFloorNumber();
			
			if(getType.equals(temp) && floor_num==floor)
			{
				list.add(space);
			}
		}
		
		return list;
	}
	
	public ParkingSpace bookSlot(ParkingSpace space)throws CustomException
	{
		validator.validate(space);
		
		int number=space.getNumber();
		
		for(int i=0;i<emptySpace.size();i++)
		{
			ParkingSpace spacee=emptySpace.get(i);
			validator.validate(spacee);
			int spaceNum=spacee.getNumber();
			
			if(number==spaceNum)
			{
				filledSpace.add(space);
				emptySpace.remove(space);
			}
		}
		
		return space;
	}
	
	public Ticket getTicket(ParkingSpace space,Vehicle vehicle)throws CustomException
	{
		validator.validate(vehicle);
		validator.validate(space);
		
		int ticket_num=generateTicket();
		int floor=space.getFloorNumber();
		int number=space.getNumber();
		long vehicleNum=vehicle.getNumber();
		long timee=System.currentTimeMillis();
		String time=getTime(timee);
		
		Ticket ticket=new Ticket();
		
		ticket.setTicketNumber(ticket_num);
		ticket.setEntryTime(time);
		ticket.setFloorNumber(floor);
		ticket.setSpaceNumber(number);
		ticket.setVehicleNum(vehicleNum);
		
		ticketMap.put(ticket_num, ticket);
		
		return ticket;
	}
	
	
	public Ticket getTicketByNum(int ticket_num)throws CustomException
	{
		validator.validate(ticket_num);
		
		Ticket ticket=ticketMap.get(ticket_num);
		
		return ticket;
	}
	
	public boolean updateSpace(Ticket ticket)throws CustomException
	{
		validator.validate(ticket);
		
		int number=ticket.getSpaceNumber();
		
		for(int i=0;i<filledSpace.size();i++)
		{
			ParkingSpace space=filledSpace.get(i);
			validator.validate(space);
			int spaceNum=space.getNumber();
			
			if(number==spaceNum)
			{
				filledSpace.remove(i);
				emptySpace.add(space);
			}
			
		}
		
		return true;
	}
	
	public int checkVehicle(int ticket_num,long vehicleNum)throws CustomException
	{
		
		validator.validate(ticket_num);
		validator.validate(vehicleNum);
		
		Ticket ticket=getTicketByNum(ticket_num);
		long vehicle=ticket.getVehicleNum();
		
		boolean result=false;
		if(vehicleNum==vehicle)
		{
		  result=updateSpace(ticket);
		}
		
		int hour=calculateHours(ticket);
		
	    return hour;
		
		
	}
	
	public int calculateHours(Ticket ticket)throws CustomException
	{
		
		validator.validate(ticket);
		
		String entry=ticket.getEntryTime();
		long time=System.currentTimeMillis();
		String exit=getTime(time);
		
		String entry_time=entry.replace(String.valueOf(':'), "");
		String exit_time=exit.replace(String.valueOf(':'), "");
		
		int time1=Integer.parseInt(entry_time);
		int time2=Integer.parseInt(exit_time);
		
		int total=Math.abs(time1-time2);
		
		
		String result=String.valueOf(total);
	;
		if(result.length()!=6)
		{
			result=String.format("%04d", total);
		}
		
		String first=result.substring(0, 2);
		int hours=Integer.parseInt(first);
		
		return hours;
		
		
	}
	
	
	
	public String getTime(long millis)throws CustomException {
		
		validator.validate(millis);
		
		String pattern="HH:mm:ss";
		
		SimpleDateFormat formatter= new SimpleDateFormat(pattern);
		
		Date date=new Date(millis);
		
		String time=formatter.format(date);
		
		  return time;
	}
	
	
	public double calculateCost(int hours)throws CustomException
	{
		validator.validate(hours);
		
		double amount=0.0;
		
		if(hours<=1)
		{
			amount=4;
			return amount;
		}
		else if(hours==2)
		{
			amount=4+3.5;
		}
		else
		{
			amount=4+(hours-1)*3.5;
		}
		
		return amount;
		
	}
	
	
	
}
