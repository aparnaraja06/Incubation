package logic;

import java.util.List;
import java.util.Map;

import operation.Operation;
import ticket.Ticket;
import vehicle.Vehicle;

public class TollBook {
	
	Operation reader=new Operation();
	
	public void addTolls() 
	{
		reader.addTolls();
	}
	
	public String getPlace(List<Character> list)
	{
		return reader.getPlace(list);
	}
	
	public String getDistance(char start,char destination,String alphabets)
	{
		return reader.getDistance(start, destination, alphabets);
	}
	
	public List<Character> shortestDistance(String result)
	{
		return reader.shortestDistance(result);
	}
	
	public String reverse(String word)
	{
		return reader.reverse(word);
	}
	
	public String rotatePlace(String word,int index)
	{
		return reader.rotatePlace(word, index);
	}
	
	public List<Character> getShortestRoute(List<Character> list1,List<Character> list2)
	{
		return reader.getShortestRoute(list1, list2);
	}
	
	public int getTollNum(char place)
	{
		return reader.getTollNum(place);
	}
	
	public Ticket bookTicket(Vehicle vehicle,int toll_num)
	{
		return reader.bookTicket(vehicle, toll_num);
	}
	
	public Map<Integer,List<Ticket>> getBookingDetails()
	{
		return reader.getBookingDetails();
	}
	
	public Map<Long,List<Ticket>> getvehicleDetails()
	{
		return reader.getvehicleDetails();
	}

}
