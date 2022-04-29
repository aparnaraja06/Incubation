package operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import berth.Berth;
import passenger.Passenger;
import ticket.Ticket;

public class RailwayOperation {
	
	private int ticketNum=1000;
	 //int racNum=0;
	
	Map<String,List<Berth>> freeSpace=new HashMap<>();
	Map<Integer,Passenger> filledSpace=new HashMap<>();
	Map<Integer,List<Passenger>> ticketMap=new HashMap<>();
	Map<String,List<Passenger>> waitingMap=new HashMap<>();
	
	private int generateTicketNumber() {
		return ++ticketNum;
	}
	
	public void addBerths(int number)
	{
		String[] type= {"upper","middle","lower","rac"};
		
		int k=0;
		for(int i=0;i<number;i++)
		{
			if(i%type.length==0)
			{
				k=0;
			}
			
			List<Berth> list=freeSpace.get(type[k]);
			
			Berth berth=new Berth();
			
			berth.setNumber(i+1);
			berth.setType(type[k]);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(berth);
			
			freeSpace.put(type[k], list);
			
			k++;
		}
	}
	
	public List<Berth> checkTypeAvailable(String type)
	{
		System.out.println("freespace in "+freeSpace);
		List<Berth> list=freeSpace.get(type);
		return list;
		
	}
	
	public Map<String,List<Berth>> showDetails(){
		return freeSpace;
	}
	
	public void addPassenger(Passenger temp,Berth berth)
	{
		
		String type=temp.getAllocatedType();
		
		if(!type.equals("waiting"))
		{
		 boolean result =bookBerth(temp,berth);
		  
		}
		
		if(type.equals("waiting"))
		{
			String result= checkType(type,temp);
		}

		
		
	}
		
	public boolean bookBerth(Passenger passenger,Berth berth)
	{
		//int count=0;
		String type=passenger.getAllocatedType();
		
		//String check=checkType(type,passenger);
		
		int number=berth.getNumber();
		
		if(type.equals("rac"))
		{
			passenger.setBerthNum(number);
			checkType(type,passenger);
			
		}
		
		else
		{
		
		List<Berth> list=freeSpace.get(type);
		
		list.remove(berth);
		
		
		passenger.setBerthNum(number);
	
		
	    filledSpace.put(number, passenger);
		}
	
		//System.out.println("Filled space : "+filledSpace);
		
		return true;
		
	}
	
	
	
	public String checkType(String type,Passenger passenger)
	{
		if(type.equals("rac") || type.equals("waiting"))
		{
			List<Passenger> list=waitingMap.get(type);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(passenger);
			
			waitingMap.put(type, list);
		}
		
		return type;
	}
		
	public int bookTicket(List<Passenger> list,Ticket ticket)
	{
		int ticket_num=generateTicketNumber();
		
		ticketMap.put(ticket_num, list);
		
		return ticket_num;
	}
	
	/*public boolean updateDetails(List<Passenger> list,int ticket_num) {
		
		List<Ticket> listt=ticketMap.get(ticket_num);
		
		for(int i=0;i<list.size();i++)
		{
		    Passenger passenger=list.get(i);
		    
			Ticket ticket=listt.get(i);
			
			String type=ticket.getType();
			
			List<Passenger> temp=passengerMap.get(ticket_num);
			
			if(temp==null)
			{
				temp=new ArrayList<>();
			}
			
			temp.add(passenger);
			
		}
		
		return true;
	}*/
	
	public boolean cancelTicket(int ticket_num)
	{
		List<Passenger> list=ticketMap.get(ticket_num);
		
		//int count=list.size();
		
		for(int i=0;i<list.size();i++)
		{
			Passenger passenger=list.get(i);
			
			int number=passenger.getBerthNum();
			String type=passenger.getAllocatedType();
			if(type.equals("rac"))
			{
			moveRAC(type,number);
			}
			else if(type.equals("waiting"))
			{
			moveWaiting(type,number);
			}
			
			//filledSpace.get(number);
		}
		
			return true;
		
	}
	
	public void moveRAC(String type,int number)
	{
		List<Passenger> list=waitingMap.get(type);
	
			Passenger passenger=list.get(0);
			
			filledSpace.put(number, passenger);
		
	}
	
	public void moveWaiting(String type,int number)
	{
		List<Passenger> list=waitingMap.get(type);
		
		for(int i=0;i<number;i++)
		{
			Passenger passenger=list.get(i);
			
			List<Passenger> temp=waitingMap.get("rac");
			
			if(temp==null)
			{
				temp=new ArrayList<>();
			}
			
			temp.add(passenger);
			
			waitingMap.put("rac", temp);
		}
	}

}
