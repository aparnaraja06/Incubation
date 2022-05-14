package operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ticket.Ticket;
import toll.Toll;
import vehicle.Vehicle;

public class Operation {
	
	private int ticketNum=1000;
	private int tollNum=0;
	
	
	Map<Character,Integer> placeMap=new HashMap<>();
    Map<Integer,Map<String,Toll>> tollMap=new HashMap<>();
	Map<Integer,List<Ticket>> bookingMap=new HashMap<>();
	Map<Long,List<Ticket>> vehicleMap=new HashMap<>();
	
	public int generateTicket() {
		
		return ++ticketNum;
	}
	
	public int generateToll() {
		return ++tollNum;
	}
	
	public void addTolls() 
	{
		//int count=0;
		//int i=0;
		String[] type= {"car","van","bus","lorry","truck"};
		double[] amount= {40.00,80.00,120.00,120.00,150.00};
		
		String alphabets="abcdefghijklmnopqrstuvwxyz";
		alphabets=alphabets.toUpperCase();
		
		int j=0;
		for(int i=0;i<8;i++)
		{
			int toll_num=generateToll();
			placeMap.put(alphabets.charAt(j), toll_num);
			j++;
			
			for(int k=0;k<type.length;k++)
			{
			Toll toll=new Toll();
			
			toll.setTollNum(toll_num);
			toll.setType(type[k]);
			toll.setAmount(amount[k]);
			
			Map<String,Toll> tempMap=tollMap.get(toll_num);
			if(tempMap==null)
			{
				tempMap=new HashMap<>();
			}
			
			tempMap.put(type[k], toll);
			tollMap.put(toll_num, tempMap);
			}
			
		}
		
		//System.out.println(tollMap);
		
		//System.out.println(placeMap);
	}
	
	public String getPlace(List<Character> list)
	{
		String temp="";
		
		for(int i=0;i<list.size();i++)
		{
			temp+=list.get(i);
		}
		
		return temp;
	}
	
	public String getDistance(char start,char destination,String alphabets)
	{
		
		//String alphabets="abcdefghijklmnopqrstuvwxyz";
		//alphabets=alphabets.toUpperCase();
		
		int index1=alphabets.indexOf(start);
		int index2=alphabets.indexOf(destination);
		
		String result=alphabets.substring(index1, index2+1);
		
		return result;
	}
	
	public List<Character> shortestDistance(String result)
	{
	
		List<Character> list=new ArrayList<>();
		
		for(int i=0;i<result.length();i++)
		{
			list.add(result.charAt(i));
		}
		
		return list;
	}
	
	
	/*public String rotatePlace(char[] word)
	{
		int length=word.length;
		//char[] arr=new char[length];
		
		for(int i=0;i<length;i++)
		{
			char temp=word[length-1];
			
			for(int j=length-1;j>0;j--)
			{
				word[j]=word[j-1];
			}
			
			word[0]=temp;
		}
		
		String result=new String(word);
		
		return result;
		
	}*/
	
	public String reverse(String word)
	{
		String rev="";
		for(int i=word.length()-1;i>=0;i--) 
		{
			rev+=word.charAt(i);
		}
		
		return rev;
	}
	
	public String rotatePlace(String word,int index)
	{
		//System.out.println("Reverse : "+index);
		String result=word.substring(index)+word.substring(0, index);
		return result;
	}
	
	public List<Character> getShortestRoute(List<Character> list1,List<Character> list2)
	{
		if(list1.size() < list2.size())
		{
			return list1;
		}
		
		return list2;
	}
	
	public int getTollNum(char place)
	{
		return placeMap.get(place);
	}
	
	public Ticket bookTicket(Vehicle vehicle,int toll_num)
	{
		char start=vehicle.getStart();
		char destination=vehicle.getDestination();
		long number=vehicle.getNum();
		String type=vehicle.getType();
		boolean vip=vehicle.isVip();
		
		Map<String,Toll> tempMap=tollMap.get(toll_num);
		Toll toll=tempMap.get(type);
		
		double amount=toll.getAmount();
		if(vip)
		{
			amount=(amount*0.2);
		}
		
		Ticket ticket=new Ticket();
		
		int ticket_num=generateTicket();
		ticket.setTicket_num(ticket_num);
		ticket.setStart(start);
		ticket.setDestination(destination);
		ticket.setType(type);
		ticket.setAmount(amount);
		ticket.setVehicle_num(number);
		
		updateTicket(ticket,toll_num);
		updateVehicle(number,ticket);
		
		return ticket;
		
	}
	
	public void updateTicket(Ticket ticket,int toll_num)
	{
		List<Ticket> list=bookingMap.get(toll_num);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(ticket);
		
		bookingMap.put(toll_num, list);
	}
	
	public void updateVehicle(long number,Ticket ticket)
	{
		List<Ticket> list=vehicleMap.get(number);
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(ticket);
		
		vehicleMap.put(number, list);
	}
	
	public Map<Integer,List<Ticket>> getBookingDetails()
	{
		return bookingMap;
	}
	
	public Map<Long,List<Ticket>> getvehicleDetails()
	{
		return vehicleMap;
	}
	

}
