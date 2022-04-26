package runner;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import customexception.CustomException;

import logic.ParkingLogic;
import space.ParkingSpace;
import ticket.Ticket;
import validate.Validate;
import vehicle.Vehicle;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	ParkingLogic reader=new ParkingLogic();
	Validate validator=new Validate();
	
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
		try
		{
		List<ParkingSpace> floor=reader.getFloorDetails();
		
		System.out.println("Enter the vehicle number");
		long num=scanner.nextLong();
		scanner.nextLine();
		System.out.println(list);
		System.out.println("Choose the type of vehicle");
		int numm=scanner.nextInt();
		validator.validate(numm, list);
		String type=list.get(numm-1);
		System.out.println("Number of available spaces");
		List<ParkingSpace> result=reader.getSpace(type, floor_num);
		System.out.println(result);
		if(result.isEmpty())
		{
			++floor_num;
			if(floor.isEmpty())
			{
				System.out.println("OOps All the floors are filled..wait for sometime");
			}
			break;
		}
		System.out.println("Choose the slot to book");
		int option=scanner.nextInt();
		validator.validate(result,option);
		ParkingSpace space=result.get(option-1);
		ParkingSpace temp=reader.bookSlot(space);
		
		Vehicle vehicle=new Vehicle();
		vehicle.setNumber(num);
		vehicle.setType(type);
		Ticket ticket=reader.getTicket(temp, vehicle);
		System.out.println(ticket);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input type");
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
		
	}
	
	case 2:
	{
		try
		{
		floor_num=0;
		System.out.println("Enter the ticket Number");
		int num=scanner.nextInt();
		scanner.nextLine();
		Ticket ticket=reader.getTicketByNum(num);
		System.out.println("Enter vehicle Number");
		long vehicle=scanner.nextLong();
		scanner.nextLine();
		int hours=reader.checkVehicle(num, vehicle);
		System.out.println("You have been parked for "+hours+" hour");
		double cost=reader.calculateCost(hours);
		System.out.println("Total cost : "+cost);
		boolean result=reader.updateSpace(ticket);
		if(result)
		{
			System.out.println("Space updated successfully");
		}
		else
		{
			System.out.println("OOps! Something went wrong");
		}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input type");
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
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
