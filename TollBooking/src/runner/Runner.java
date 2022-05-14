package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import logic.TollBook;
import operation.Operation;
import ticket.Ticket;
import vehicle.Vehicle;

public class Runner {
	
	
	
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		TollBook reader=new TollBook();
		
		List<Character> place=new ArrayList<>();
		place.add('A');
		place.add('B');
		place.add('C');
		place.add('D');
		place.add('E');
		place.add('F');
		place.add('G');
		place.add('H');
		
		List<Boolean> vip=new ArrayList<>();
		vip.add(true);
		vip.add(false);
		
		boolean flag=true;
		
		
		while(flag)
		{
			System.out.println("Enter the option");
			System.out.println("1.add toll 2.toll payment 3.toll booking details 4. vehicle paid details");
			int option=scanner.nextInt();
			scanner.nextLine();
			
		switch(option)
		{
		case 1:
		{
			reader.addTolls();
			break;
		}
		
		case 2:
		{
			System.out.println("Enter the vehicle number");
			long number=scanner.nextLong();
			scanner.nextLine();
			
			System.out.println("Enter the type of vehicle");
			String type=scanner.nextLine();
			
			System.out.println(place);
			System.out.println("Choose the starting point");
			int start=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Choose the destination");
			int end=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Is this vehicle a VIP user ?");
			System.out.println("1. yes 2. no");
			int num=scanner.nextInt();
			scanner.nextLine();
			
			boolean getVip=vip.get(num-1);
			
			String alphabets=reader.getPlace(place);
			String temp1=reader.getDistance(place.get(start-1), place.get(end-1),alphabets);
			List<Character> distance1=reader.shortestDistance(temp1);
			
		    //char[] arr=alphabets.toCharArray();
			char character=place.get(start-1);
			int index=place.indexOf(character);
			String reverse=reader.reverse(alphabets);
			String temp2=reader.rotatePlace(reverse, alphabets.length()-(index+1));

			String shortest=reader.getDistance(place.get(start-1), place.get(end-1),temp2);
			List<Character> distance2=reader.shortestDistance(shortest);
			
			
			List<Character> distance=reader.getShortestRoute(distance1, distance2);

			distance.remove(0);
			
			Vehicle vehicle=new Vehicle();
			
			vehicle.setNum(number);
			vehicle.setType(type);
			vehicle.setStart(place.get(start-1));
			vehicle.setDestination(place.get(end-1));
			vehicle.setVip(getVip);
			
			double total=0;
			
			for(int i=0;i<distance.size();i++)
			{
				char now=distance.get(i);
				int toll_num=reader.getTollNum(now);
				
				Ticket ticket=reader.bookTicket(vehicle, toll_num);
				
				double amount=ticket.getAmount();
				total+=amount;
				System.out.println(ticket);
			}

		System.out.println("Total amount paid : "+total);
		
		break;
		}
		
		case 3:
		{
			Map<Integer,List<Ticket>> result=reader.getBookingDetails();
			
			for(Integer key : result.keySet())
			{
				System.out.println("Toll Number : "+key);
				System.out.println("Booking : "+result.get(key));
			}
		//	System.out.println(result);
			
			break;
		}
		
		case 4:
		{
			Map<Long,List<Ticket>> result=reader.getvehicleDetails();
			for(Long key : result.keySet())
			{
				System.out.println("Vehicle Number : "+key);
				System.out.println("Ticket : "+result.get(key));
			}
			//System.out.println(result);
			
			break;
		}
		
		case 5:
		{
			flag=false;
		}
		}
		}
	}

}
