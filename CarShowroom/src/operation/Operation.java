package operation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.Admin;
import book.BookingInfo;
import car.Car;
import sort.SortCities;
import user.User;

public class Operation 
{
	
	private int customerId=100;
	private int carId=0;
	private int orderId=1000;
	
	Map<String,List<String>> cityMap=new HashMap<>();
	Map<String,Map<String,List<Car>>> branchMap=new HashMap<>();
	Map<Integer,Car> carMap=new HashMap<>();
	Map<Integer,User> userMap=new HashMap<>();
	List<BookingInfo> orderList=new ArrayList<>();
	List<Integer> salesList=new ArrayList<>();
	
	private int generateCustomerId()
	{
		return ++customerId;
	}
	
	private int generateCarId()
	{
		return ++carId;
	}
	
	private int generateOrderId()
	{
		return ++orderId;
	}
	
	public void addDefaultAdmin()
	{
		
		String[] name= {"Admin1","Admin2","Admin3","Admin4","Admin5","Admin6","Admin7","Admin8"};
		int[] age= {22,33,44,55,23,43,34,35};
		String[] gender= {"male","male","female","female","male","male","male","male"};
		long[] mobile= {8123784264L,8271343474L,8724824368L,8732648273L,8713481248L,8236487264L,9237482683L,
				9236748683L};
		String[] location= {"trichy","madurai","coimbatore","chennai","trichy","madurai","coimbatore","chennai"};
		String[] pass= {"pass","pass","pass","pass","pass","pass","pass","pass"};
		String[] branch= {"srirangam","mellur","gandhipuram","annanagar","goldenrock","avaniapuram",
				"peelamedu","kknagar"};
		
		for(int i=0;i<name.length;i++)
		{
			
			int id=generateCustomerId();
			
			User user=new Admin();
			Admin admin=(Admin)user;
			
			admin.setAge(age[i]);
			admin.setBranch(branch[i]);
			admin.setGender(gender[i]);
			admin.setLocation(location[i]);
			admin.setMobile(mobile[i]);
			admin.setName(name[i]);
			admin.setPassword(pass[i]);
			admin.setUserId(id);
			
			List<String> list=cityMap.get(location[i]);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(branch[i]);
			
			cityMap.put(location[i], list);
			
			userMap.put(id, user);
			
		}
		
		//System.out.println(userMap);
		//System.out.println(cityMap);
	}
	
	public void addDefaultCars()
	{
		String[] location= {"trichy","madurai","coimbatore","chennai","trichy","madurai","coimbatore","chennai"};
		String[] branch= {"srirangam","mellur","gandhipuram","annanagar","goldenrock","avaniapuram",
				"peelamedu","kknagar"};
		String[] type= {"seltos","sonet"};
		String fuel="petrol";
		int[] seat= {5,6};
		int[] engine= {1453,1497};
		double[] mileage= {24.1,21};
		double[] cost= {10.19,7.15};
		
		//int k=0;
		for(int k=0;k<branch.length;k++)
		{
		for(int i=0;i<type.length;i++)
		{
			for(int j=0;j<5;j++)
			{
				int id=generateCarId();
				
				Car car=new Car();
				
				car.setCost(cost[i]);
				car.setEngine(engine[i]);
				car.setFuelType(fuel);
				car.setMileage(mileage[i]);
				car.setId(id);
				car.setName(type[i]);
				car.setNumOfSeat(seat[i]);
				car.setBranch(branch[k]);
				car.setLocation(location[k]);
				
				Map<String,List<Car>> tempMap=branchMap.get(branch[k]);
				
				if(tempMap==null)
				{
					tempMap=new HashMap<>();
				}
				
				List<Car> list=tempMap.get(type[i]);
				
				if(list==null)
				{
					list=new ArrayList<>();
				}
				
				list.add(car);
				
				tempMap.put(type[i], list);
				
				branchMap.put(branch[k], tempMap);
				
				carMap.put(id, car);
			}
			
		}
		}
		
		//System.out.println(branchMap);
		//System.out.println(carMap);
		
	}
	
	public boolean login(int id,String pass)
	{
		
		
		Admin admin=getAdminDetails(id);
		
		String getPass=admin.getPassword();
		
		if(getPass.equals(pass))
		{
			return true;
		}
		
		return false;
	}
	
	public Admin getAdminDetails(int id)
	{
       User user= userMap.get(id);
		
		Admin admin=(Admin)user;
		
		return admin;

	}
	
	public String getBranch(int id)
	{
		Admin admin=getAdminDetails(id);
		
		String branch=admin.getBranch();
		
		return branch;
	}
	
	public String getLocation(int id)
	{
		Admin admin=getAdminDetails(id);
		
		String location=admin.getLocation();
		
		return location;
	}
	
	public Map<String,List<Car>> getCarByBranch(String branch)
	{
		Map<String,List<Car>> temp=branchMap.get(branch);
		
		return temp;
	}
	
	public List<Car> getCarByName(String name,String branch)
	{
		Map<String,List<Car>> temp=getCarByBranch(branch);
		
		List<Car> list=temp.get(name);
		
		return list;
	}
	
	public Car getCarById(int id)
	{
		Car car=carMap.get(id);
		
		return car;
	}
	
	public void removeCar(int id,String branch)
	{
		Car car=getCarById(id);
		
		String name=car.getName();
		
		List<Car> list=getCarByName(name,branch);
		
		list.remove(car);
	}
	
	public int addCustomer(User user)
	{
		int id=generateCustomerId();
		
		userMap.put(id, user);
		
		return id;
	}
	
	public String getDate() 
	{
		
		long millis=System.currentTimeMillis();
		
		DateFormat date=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		
		Date result=new Date(millis);
		
		String time=date.format(result);
		
		return time;
	}
	
	
	
	public BookingInfo placeOrder(int customer_id,Car car)
	{
		
		int id=generateOrderId();
		String date=getDate();
		double amount=car.getCost();
		int car_id=car.getId();
		String location=car.getLocation();
		String branch=car.getBranch();
		
		BookingInfo order=new BookingInfo();
		
		order.setAmount(amount);
		order.setBookId(id);
		order.setCarId(car_id);
		order.setCustomerId(customer_id);
		order.setBranch(branch);
		order.setCity(location);
		order.setOrderDate(date);
		
		orderList.add(order);
		
		return order;
	}
	
	public String firstCarSoldCity()
	{
		BookingInfo book=orderList.get(0);
		
		String location=book.getBranch();
		
		return location;
	}
	
	public String recentCarSoldCity()
	{
		int size=orderList.size();
		
		BookingInfo book=orderList.get(size-1);
		
		String location=book.getBranch();
		
		return location;
	}
	
	public int getTotalOrder()
	{
		int length=orderList.size();
		
		return length;
	}
	
	public int getUpdatedData()
	{
		int length=salesList.size();
		
		if(length==0)
		{
			return 0;
		}
		
		int result=salesList.get(length-1);
		
		return result;
	}
	
	public List<Integer> setSalesInWeek()
	{
		int total=getTotalOrder();
		
		int update=getUpdatedData();
		
		int result=total-update;
		
		salesList.add(result);
		
		return salesList;
	}
	
	public List<String> profitInWeek()
	{
		int index=-1;
		//int index1=-1;
		int index2=-1;
		
		String temp="";
		List<String> list=new ArrayList<>();
		
		if(salesList.size()<=1)
		{
			return list;
		}
		
		for(int i=0;i<salesList.size();i++)
		{
			if(salesList.get(i)<salesList.get(i+1))
			{
				if(index==-1)
				{
					index=i;
				}
				
				//index1=i;
				index2=i+1;
			}
			else
			{
				temp="("+index+" "+index2+")";
				list.add(temp);
				
				index=i;
				index2=-1;
				temp="";
			}
		}
		
		return list;
	}
	
	public Map<String,Map<String,List<Car>>> getStockDetails()
	{
		return branchMap;
	}
	
	public List<String> orderCities()
	{
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<orderList.size();i++)
		{
			BookingInfo order=orderList.get(i);
			
			String branch=order.getBranch();
			
			list.add(branch);
		}
		
		return list;
	}
	
	public List<String> sortCities()
	{
		List<String> cityList=orderCities();
		
		Map<String,Integer> tempMap=new HashMap<>();
		List<String> list=new ArrayList<>();
		
		for(String city : cityList)
		{
			int count=tempMap.getOrDefault(city, 0);
			tempMap.put(city, count+1);
			list.add(city);
		}
		
		SortCities city=new SortCities(tempMap);
		
		Collections.sort(list, city);
		
		return list;
	}

}
