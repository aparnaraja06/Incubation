package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import berth.Berth;
import operation.RailwayOperation;
import passenger.Passenger;
import ticket.Ticket;

public class Runner {

	
	static Scanner scanner=new Scanner(System.in);
	static RailwayOperation reader=new RailwayOperation();

	public List<String> chooseType()
	{
     List<String> type=new ArrayList<>();
	
	type.add("lower");
	type.add("middle");
	type.add("upper");
	type.add("rac");
	type.add("waiting");
	
	return type;
	}
	public Berth getType(int number,int size)
	{
		List<String> list=chooseType();
		String type=list.get(number);
		List<Berth> temp=reader.checkTypeAvailable(type);
		size=temp.size();
		
		
		if(size!=0 && number<list.size())
		{
			return temp.get(0);
		}
		
		return getType(number+1,size);
		

	}
public static void main(String[] args)
{
	Runner runner =new Runner();
	
	
	System.out.println("Enter the number of berth");
	int numberr=scanner.nextInt();
	scanner.nextLine();
	
	reader.addBerths(numberr);
	boolean flag=true;
	while(flag)
	{
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();

	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the number of members to add");
		int number=scanner.nextInt();
		scanner.nextLine();
		
		List<Passenger> list=new ArrayList<>();
		
		for(int i=0;i<number;i++)
		{
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the gender");
		String gender=scanner.nextLine();
		
		System.out.println("Choose the Berth preference");
		System.out.println("1. lower 2. middle 3.upper");
		int num=scanner.nextInt();
		scanner.nextLine();
		Berth berth=runner.getType(num-1,0);
		String type=berth.getType();
		System.out.println("Allocated type : "+type);
		
		Passenger passenger=new Passenger();
		passenger.setName(name);
		passenger.setAge(age);
		passenger.setGender(gender);
		passenger.setAllocatedType(type);
		
		reader.addPassenger(passenger,berth);
		
		
		list.add(passenger);
		}
		
		
		Ticket ticket=new Ticket();
		
		int ticket_num=reader.bookTicket(list,ticket);
		
		System.out.println("Your ticket number is : "+ticket_num);		
		System.out.println("Successfully booked");	
		
		break;
	}
	
	case 2:
	{
		System.out.println("Enter your ticket number");
		int ticket=scanner.nextInt();
		scanner.nextLine();
		
		boolean result=reader.cancelTicket(ticket);
		if(result)
		{
			System.out.println("Ticket cancelled successfully");
		}
		else
		{
			System.out.println("Something went wrong");
		}
		
		break;
	}
	}
}
}

}
