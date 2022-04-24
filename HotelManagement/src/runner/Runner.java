package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import hotel.Hotel;
import operations.HotelOperations;
import user.User;

public class Runner {
public static void main(String[] args) {
	
	Scanner scanner=new Scanner(System.in);
	HotelOperations reader=new HotelOperations();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		Map<Object, Hotel> result=reader.getHotelData();
		System.out.println(result);
		break;
	}
	case 2:
	{
		Map<Object,Hotel> result=reader.sortByName();
		System.out.println(result);
		break;
	}
	
	case 3:
	{
		Map<Object,Hotel> result=reader.sortByRating();
		System.out.println(result);
		break;
	}
	case 4:
	{
		Map<Object,Hotel> result=reader.sortByRooms();
		System.out.println(result);
		break;
	}
	case 5:
	{
		Hotel result=reader.getLocaation("Bangalore");
		System.out.println(result);
		break;
	}
	case 6:
	{
		List<User> result=reader.getUsers();
		System.out.println(result);
		break;
	}
	}
}
}
