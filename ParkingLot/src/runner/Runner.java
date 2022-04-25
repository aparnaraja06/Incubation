package runner;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import floor.Floor;
import park.ParkingOperations;
import ticket.Ticket;
import vehicle.Vehicle;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	ParkingOperations reader=new ParkingOperations();
	int floor_num=0;
	boolean flag=true;
	while(flag)
	{
	System.out.println("Welcome to the portal");
	System.out.println("Enter your choice 1- entry 2- out 3- exit");
	int choice=scanner.nextInt();
	scanner.nextLine();
	
	List<String> list=new ArrayList<>();
	list.add("Car");
	list.add("Two-Wheeler");
	list.add("Electric");
	list.add("Handi-Capped");
	list.add("Lorry");
	switch(choice)
	{
	
	case 1:
	{
		List<Floor> floor=reader.getFloorDetails();
		
		System.out.println(floor);
		
		System.out.println("Enter the vehicle number");
		long num=scanner.nextLong();
		scanner.nextLine();
		System.out.println(list);
		System.out.println("Choose the type of vehicle");
		int numm=scanner.nextInt();
		String type=list.get(numm-1);
		System.out.println("Number of available spaces");
		int result=reader.getFreeSpace(type, floor_num);
		System.out.println(result);
		if(result==0)
		{
			++floor_num;
			if(floor_num==floor.size()+1)
			{
				System.out.println("OOps All the floors are filled..wait for sometime");
			}
			break;
		}
		/*System.out.println("Do you want to pay Y/N");
		char character=scanner.next().charAt(0);
		scanner.nextLine();
		if(character=='Y')
		{
			System.out.println("Enter the amount");
			double amount=scanner.nextDouble();
		}*/
		
		Vehicle vehicle=new Vehicle();
		vehicle.setNumber(num);
		vehicle.setType(type);
		Ticket ticket=reader.addVehicle(vehicle, floor_num);
		System.out.println(ticket);
	
		break;
		
		
	}
	
	case 2:
	{
		floor_num=0;
		System.out.println("Enter the ticket Number");
		int num=scanner.nextInt();
		scanner.nextLine();
		Vehicle vehicle=reader.getVehicleByTicket(num);
		long vehicle_num=vehicle.getNumber();
		Ticket ticket=reader.getTicketByVehicleNum(vehicle_num);
		System.out.println(ticket);
		reader.updateSpaces(ticket);
		LocalTime entry=reader.getTime(vehicle_num);
		LocalTime exit=reader.getTime();
		long hours=entry.until(exit, ChronoUnit.HOURS);
		double amount=reader.calculateCost(hours);
		System.out.println("Total cost");
		System.out.println(amount);
		break;
	}
	
	case 3:
	{
		flag=false;
	}
	}
	}
	
}
}
