package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import book.BookingInfo;
import car.Car;
import operation.Operation;
import user.User;

public class Runner 
{
	static Scanner scanner=new Scanner(System.in);
	static Operation reader=new Operation();
	
	public void admin()
	{
		System.out.println("Enter the user id");
		int id=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the password ");
		String pass=scanner.nextLine();
		
		boolean result=reader.login(id, pass);
		if(result)
		{
			String branch=reader.getBranch(id);
			
			boolean flag=true;
			
			while(flag)
			{
			System.out.println("Enter the option");
			System.out.println("1.All Car Details 2.Get Car by Name 3.Book Car 4. First Sold Car's city"
					+ "5. Recent Sold Car's city 6.Check Stock 7. 8.Exit");
			int option=scanner.nextInt();
			scanner.nextLine();
			
			switch(option)
			{
			case 1:
			{
				Map<String,List<Car>> details=reader.getCarByBranch(branch);
				
				for(String name:details.keySet())
				{
					List<Car> list=details.get(name);
					System.out.println(list);
				}
				
			}
			
			case 2:
			{
				System.out.println("Choose the model name");
				System.out.println("1. seltos 2.sonet ");
				int num=scanner.nextInt();
				scanner.nextLine();
				if(num==1)
				{
				List<Car> list=reader.getCarByName("seltos", branch);
				System.out.println(list);
				}
				else if(num==2)
				{
					List<Car> list=reader.getCarByName("sonet", branch);
					System.out.println(list);
				}
				break;
			}
			
			case 3:
			{
				System.out.println("Enter the id");
				int car_id=scanner.nextInt();
				scanner.nextLine();
				
				Car car=reader.getCarById(car_id);
				System.out.println(car);
				
				int cust_id=customerDetails();
				
				reader.removeCar(car_id, branch);
				BookingInfo order=reader.placeOrder(cust_id, car);
				
				System.out.println(order);
				break;
				
			}
			
			case 4:
			{
				String city=reader.firstCarSoldCity();
				System.out.println(city);
				break;
			}
			
			case 5:
			{
				String recent=reader.recentCarSoldCity();
				System.out.println(recent);
				break;
			}
			
			case 6:
			{
				Map<String,Map<String,List<Car>>> details=reader.getStockDetails();
				
				for(String city: details.keySet())
				{
					Map<String,List<Car>> tempMap=details.get(city);
					
					for(String type: tempMap.keySet())
					{
						List<Car> list=tempMap.get(type);
						
						if(list.size() < 3)
						{
							System.out.println("City : "+city);
							System.out.println("Model : "+type);
							System.out.println("Number Of Stocks : "+list.size());
						}
					}
				}
				
				break;
				
			}
			
			case 7:
			{
				System.out.println("Cities in the order of which car was sold the most");
				
				List<String> list=reader.sortCities();
				
				for(int i=0;i<list.size();i++)
				{
					String city=list.get(i);
					
					System.out.println(i+1+"  "+city);
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
	
	public int customerDetails()
	{
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the gender");
		String gender=scanner.nextLine();
		
		System.out.println("Enter mobile number");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter location");
		String location=scanner.nextLine();
		
		User user=new User();
		
		user.setAge(age);
		user.setGender(gender);
		user.setLocation(location);
		user.setMobile(mobile);
		user.setName(name);
	
		int cust_id=reader.addCustomer(user);
		
		return cust_id;
	}
	
	public void salesPerson()
	{
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Update sales data 2.Get profit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			int total=reader.getTotalOrder();
			System.out.println("Total Order : "+total);
			
			List<Integer> list=reader.setSalesInWeek();
			System.out.println("Successfully updated ");
			System.out.println(list);
			break;
		}
		
		case 2:
		{
			List<String> list=reader.profitInWeek();
			
			if(list.isEmpty())
			{
				System.out.println("No profit");
			}
			else
			{
			System.out.println(list);
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
	
	public static void main(String[] args)
	{
		
		Runner runner=new Runner();
		
		reader.addDefaultAdmin();
		reader.addDefaultCars();
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Choose the option");
		System.out.println("1.Admin 2.Sales Person");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			runner.admin();
			break;
		}
		case 2:
		{
			runner.salesPerson();
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
