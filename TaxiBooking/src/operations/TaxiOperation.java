package operations;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import booking.BookingInfo;
import taxi.TaxiInfo;

public class TaxiOperation {
	
	private int taxiNum=0;
	private int customerId=0;
	
	Map<String,List<TaxiInfo>> freeTaxi=new HashMap<>();
	Map<Integer,TaxiInfo> busyTaxi=new HashMap<>();
	//List<CustomerInfo> customerList=new ArrayList<>();
	List<String> points=new ArrayList<>();
	Map<Integer,List<BookingInfo>> bookingMap=new HashMap<>();
	
	public TaxiOperation() {
		addPoints();
	}
	
	public int generateTaxiNum() {
		return ++taxiNum;
	}
	
	public int generateCustomerId() {
		return ++customerId;
	}
	
	public void addDefaultTaxi(int number) {
		
		double[] price= {100.00,300.00,150.00,200,350};
		//String[] location= {"A","B","C","D","E","F"};
		String location="A";
		int j=0;
		for(int i=0;i<number;i++)
		{
			if(i%number==0)
			{
				j=0;
			}
			TaxiInfo taxi=new TaxiInfo();
			
			int taxi_num=generateTaxiNum();
			taxi.setTaxiNum(taxi_num);
			taxi.setFromLocation(location);
			taxi.setPrice(price[j]);
			
			List<TaxiInfo> list=freeTaxi.get(location);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(taxi);
			freeTaxi.put(location, list);
			j++;
			
			
		}
		
		//System.out.println(freeTaxi);
		
	}
	
	public void addPoints() {
		
		points.add("A");
		points.add("B");
		points.add("C");
		points.add("D");
		points.add("E");
		points.add("F");
	}
	
	/*public void addDefaultCustomers() {
		
		String[] names= {"Ram","Raju","Raj","Poonam","Leena"};
		String[] location= {"A","B","C","D","E"};
		String[] gender= {"Male","Male","Male","Female","Female"};
		long[] mobile= {9328473249L,8347826478L,8934782338L,9384626343L,8327647829L};
		
		for(int i=0;i<names.length;i++)
		{
			int id=generateCustomerId();
			CustomerInfo customer=new CustomerInfo();
			
			customer.setName(names[i]);
			customer.setId(id);
			customer.setGender(gender[i]);
			customer.setLocation(location[i]);
			customer.setMobile(mobile[i]);
			
			customerList.add(customer);
		}
	}*/
	
	public List<TaxiInfo> getTaxi(String location)
	{
		
		List<TaxiInfo> list=freeTaxi.get(location);
		
		if(list==null)
		{
			return null;
		}
		
		return list;
	}
	
	public int getTaxiNumber(TaxiInfo taxi)
	{
		int number=taxi.getTaxiNum();
		
		return number;
	}
	
	public List<String> getPoints(){
		return points;
	}
	
	public TaxiInfo getTaxiByNum(int number)
	{
		TaxiInfo taxi=busyTaxi.get(number);
		return taxi;
	}
	
	public void bookTaxi(BookingInfo book,TaxiInfo taxi)
	{
		int cust_id=generateCustomerId();
		//String location=book.getFromLocation();
		String from=taxi.getFromLocation();
		
		book.setCustomerId(cust_id);
		List<TaxiInfo> list=freeTaxi.get(from);
		list.remove(taxi);
		
		int number=taxi.getTaxiNum();
		busyTaxi.put(number, taxi);
	
	}
	
	public String getTime(long millis)
	{
		String pattern = "HH:mm:ss";

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		Date date = new Date(millis);

		String time = formatter.format(date);

		return time;
	}
	
	public TaxiInfo getAdjacent(int num1,int num2)
	{
		String from1=points.get(num1);
		String from2=points.get(num2);
		
		List<TaxiInfo> taxi1=freeTaxi.get(from1);
		List<TaxiInfo> taxi2=freeTaxi.get(from2);
		
		if(taxi1==null && taxi2==null && num1<0 && num2>points.size())
		{
			return null;
		}
		
		if(taxi1 !=null && taxi2 !=null)
		{
			TaxiInfo taxi=checkPrice(taxi1,taxi2);
			
			return taxi;
		}
		
		else if(taxi1 != null)
		{
			return taxi1.get(0);
		}
		
		else if(taxi2 != null)
		{
		return taxi2.get(0);
		}
		
		return getAdjacent(num1-1,num2+1);
		
	}
	
	public TaxiInfo checkPrice(List<TaxiInfo> taxi1,List<TaxiInfo> taxi2)
	{
		double min1=Integer.MAX_VALUE;
		
		TaxiInfo taxiObj1=null;
		//TaxiInfo taxiObj2=null;
		
		for(int i=0;i<taxi1.size();i++)
		{
			TaxiInfo taxiObj=new TaxiInfo();
			
			double amount=taxiObj.getPrice();
			
			min1=Math.min(min1, amount);
			
			if(amount<min1)
			{
				taxiObj1=taxiObj;
			}
		}
		
		for(int i=0;i<taxi2.size();i++)
		{
             TaxiInfo taxiObj=new TaxiInfo();
			
			double amount=taxiObj.getPrice();
			
			min1=Math.min(min1, amount);
			
			if(amount<min1)
			{
				taxiObj1=taxiObj;
			}

		}
		
		return taxiObj1;
	}
	
	public void bookDetails(BookingInfo book)
	{
		
	int number=book.getTaxiNum();
	
	List<BookingInfo> listt=bookingMap.get(number);
	
	if(listt==null)
	{
		listt=new ArrayList<>();
	}
	if(listt.contains(book))
	{
		listt.remove(book);
	}
	listt.add(book);
	bookingMap.put(number,listt);
	}
	
	public TaxiInfo changeStatus(String status,int number,String fromLocation)
	{
		
		//System.out.println("Busy taxi : "+busyTaxi);
		TaxiInfo taxi=busyTaxi.get(number);
		
		
		String location=taxi.getFromLocation();
		
		taxi.setStatus(status);
		
		List<TaxiInfo> list=freeTaxi.get(location);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		list.add(taxi);
		freeTaxi.put(fromLocation, list);
		
		return taxi;
		
	}
	
	public int calculateDistance(String from,String to)
	{
		int point1=points.indexOf(from);
		int point2=points.indexOf(to);
		
		int total=Math.abs(point1-point2);
		
		return total*15;
		
	}
	
	public double calculateCost(int distance)
	{
		int balance=distance-5;
		double temp=100;
		
		double amount=(balance*10)+temp;
		
		return amount;
	}
	
	public Map<Integer,List<BookingInfo>> getTaxiDetails(){
		
		return bookingMap;
	}
	
	public List<BookingInfo> getBookingInfo(int number)
	{
		return bookingMap.get(number);
	}
}
