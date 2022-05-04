package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import booking.BookingInfo;
import operations.TaxiOperation;
import taxi.TaxiInfo;

public class Runner {
	
	public static void main(String[] args)
	{
		
	Scanner scanner=new Scanner(System.in);
	TaxiOperation reader=new TaxiOperation();
	
	System.out.println("Enter the number of taxis");
	int number=scanner.nextInt();
	scanner.nextLine();
	
	reader.addDefaultTaxi(number);
	
	boolean flag=true;
	
	while(flag)
	{
	System.out.println("Enter the option");
	System.out.println("1.booking 2.change status 3.booking details 4.exit");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{

		List<String> points=reader.getPoints();
		System.out.println("choose the from location");
		System.out.println("1.A 2.B 3.C 4.D 5.E 6.F");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int temp=num-1;
		String from=points.get(temp);
		List<TaxiInfo> list=reader.getTaxi(from);
		TaxiInfo taxi=null;
		//System.out.println("List is "+list);
		if(list==null)
		{
			taxi=reader.getAdjacent(temp-1,temp+1);
			System.out.println("Allocated near by taxi : "+taxi);
			
			if(taxi==null)
			{
				System.out.println("No taxis avaiable ");
			}
		}
		else
		{
		 taxi=list.get(0);
		}
		
		//String fromLocation=taxi.getFromLocation();
		System.out.println("Choose destination");
		System.out.println("1.A 2.B 3.C 4.D 5.E 6.F");
		int num1=scanner.nextInt();
		scanner.nextLine();
		
		String to=points.get(num1-1);
		
		long millis=System.currentTimeMillis();
		String time=reader.getTime(millis);
		
		int taxi_num=reader.getTaxiNumber(taxi);
		taxi.setStatus("Booked");
		
		
		BookingInfo book=new BookingInfo();
		
		book.setFromLocation(from);
		book.setToLocation(to);
		book.setTaxiNum(taxi_num);
		book.setPickupTime(time);
		
		reader.bookTaxi(book, taxi);
		reader.bookDetails(book);
		
		System.out.println("Allocated taxi Number : "+taxi_num);
		
		break;
		
	}
	
	case 2:
	{
		System.out.println("Enter the taxi number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		
		
		List<BookingInfo> list=reader.getBookingInfo(num);
		
		BookingInfo book=list.get(list.size()-1);
		
		String from=book.getFromLocation();
		String to=book.getToLocation();
		
        String status="Free";
		
		
		TaxiInfo taxi=reader.changeStatus(status, num,to);
		
		int distance=reader.calculateDistance(from, to);
		
		double amount=reader.calculateCost(distance);
		
		double price=taxi.getPrice();
		taxi.setPrice(price*amount);
		
		long millis=System.currentTimeMillis();
		String time=reader.getTime(millis);
		
		book.setDropTime(time);
		book.setTotal(amount);
		
		reader.bookDetails(book);
		
		break;
		
	}
	
	case 3:
	{
		System.out.println("Taxi Details ");
		Map<Integer,List<BookingInfo>> map=reader.getTaxiDetails();
		
		System.out.println(map);
		
		break;
	}
	
	case 4:
	{
		flag=false;
	}
	}
	}
	}
}
