package runner;


import java.util.List;

import java.util.Scanner;

import book.BookingInfo;
import hotel.HotelInfo;
import logic.Hotel;


public class Runner {
	static Scanner scanner=new Scanner(System.in);
	 static Hotel reader=new Hotel();
	
	public void details() {
		System.out.println("1. ADD HOTELS");
		System.out.println("2. HOTEL DETAILS");
		System.out.println("3. SORT BY NAME");
		System.out.println("4. SORT BY RATING");
		System.out.println("5. SORT BY ROOMS");
		System.out.println("6. GET HOTELS BY PLACE");
		System.out.println("7. USER BOOKED EDTAILS");
		System.out.println("8. EXIT");
	}
	
	
	
	public boolean addHotel() {
		System.out.println("Enter the name of the hotel");
		String name=scanner.nextLine();
		System.out.println("Enter the location of the hotel");
		String location=scanner.nextLine();
		System.out.println("Enter the available rooms");
		int room=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the price per room");
		double price=scanner.nextDouble();
		System.out.println("Enter the rating from (0-5)");
		float rate=scanner.nextFloat();
		
		HotelInfo hotel=new HotelInfo();
		
		hotel.setLocation(location);
		hotel.setName(name);
		hotel.setPrice(price);
		hotel.setRating(rate);
		hotel.setRooms(room);
		
		return reader.addHotel(hotel);	
	}
	
	/*public int addUsers() {
		
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the location");
		String location=scanner.nextLine();
		
		System.out.println("Enter mobile number");
		long mobile=scanner.nextLong();
		
		User user=new User();
		
		user.setLocation(location);
		user.setMobileNumber(mobile);
		user.setUserName(name);
		
		return reader.addUser(user);
		
		
	}*/
	
	
public static void main(String[] args) {
	
	
	Runner runner=new Runner();
	
	boolean flag=true;
	runner.details();
	while(flag)
	{
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		boolean result=runner.addHotel();
		if(result)
		{
			System.out.println("Hotel added successfully");
		}
		else
		{
			System.out.println("OOps something went wrong!");
		}
		
	}
	
	case 2:
	{
		 List<HotelInfo> result=reader.getHotelData();
		 for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		
		break;
	}
	case 3:
	{
		List<HotelInfo> result=reader.sortByName();
		for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		
		break;
	}
	
	case 4:
	{
		List<HotelInfo> result=reader.sortByRating();
		for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		break;
	}
	case 5:
	{
		List<HotelInfo> result=reader.sortByRooms();
		for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		break;
	}
	case 6:
	{
		System.out.println("Enter the location to search");
		String location=scanner.nextLine();
		List<HotelInfo> result=reader.getLocaation(location);
		if(result.isEmpty())
		{
			System.out.println("No hotels available");
		}
		for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		break;
	}
	case 7:
	{
		List<BookingInfo> result=reader.getBookingDetails();
		for(int i=0;i<result.size();i++)
		 {
			 System.out.println(result.get(i));
		 }
		break;
	}
	case 8:
	{
		flag=false;
	}
	}
	}
}
}
