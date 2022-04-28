package operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.BookingInfo;
import hotel.HotelInfo;
import user.User;

/*public class HotelOperationss {

	private int userId=0;

	Map<String,List<Hotel>> hotelMap=new HashMap<>();
	List<User> userList=new ArrayList<>();
	List<BookingInfo> bookList=new ArrayList<>();
	
	
	public HotelOperations() {
		addDefaultHotels();
		addDefaultUsers();
	}
	
	private int generateId() {
		return ++userId;
	}
	
	public void addDefaultHotels() {
		String[] name= {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5"};
		int[] rooms= {4,6,8,2,5};
		String[] location= {"Bangalore","Mumbai","Agra","Bangalore","Goa"};
		float[] rating= {3F,4F,5F,3.5F,4F};
		double[] price= {200,300,600,400,300};
		
		for(int i=0;i<name.length;i++)
		{
			Hotel hotel=new Hotel();
			
			List<Hotel> list=hotelMap.get(location[i]);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			hotel.setName(name[i]);
			hotel.setRooms(rooms[i]);
			hotel.setLocation(location[i]);
			hotel.setRating(rating[i]);
			hotel.setPrice(price[i]);
			
			list.add(hotel);
			
			hotelMap.put(location[i], list);
			
		}
	}
	
	public void addDefaultUsers() {
	
		String[] name= {"User1","User2","User3"};
		String[] location= {"ooty","bangalore","chennai","kodaikanal","goa"};
		long[] mobile= {9857932473L,8493278945L,9327589320L,8496478374L,9845738257L};
		
		for(int i=0;i<name.length;i++)
		{
			int cust_id=generateId();
			User user=new User();
			
			user.setUserId(cust_id);
			user.setUserName(name[i]);
			user.setLocation(location[i]);
			user.setMobileNumber(mobile[i]);
			
			userList.add(user);
		}
		
		
	}
	
	public Collection<List<Hotel>> getHotelData(){
		
		return hotelMap.values();
	}
	
	public boolean addHotel(Hotel hotel)
	{
	     String location=hotel.getLocation();
	     
	     List<Hotel> list=hotelMap.get(location);
	     
	     if(list==null)
	     {
	    	 list=new ArrayList<>();
	     }
	     
	     list.add(hotel);
	     hotelMap.put(location, list);
	     
	     return true;
	}
	
	public boolean addUser(User user)
	{
		int cust_id=generateId();
		
		user.setUserId(cust_id);
		
		userList.add(user);
		
		return true;
	}
	
	public Collection<List<Hotel>> sortByName(){
		
		Collection<List<Hotel>> list=getHotelData();
		
		for(List<Hotel> hotelList:list)
		{
		Collections.sort(hotelList,new Comparator<Hotel>(){

			@Override
			public int compare(Hotel name1, Hotel name2) {
				return name2.getName().compareTo(name1.getName());
			}
			
		});
		
		list.add(hotelList);
		}
	   
		return list;
		}
		
			
	
	
	/*public List<Hotel> sortByRating()
	{
		Collections.sort(hotelList,new Comparator<Hotel>(){
           
			@Override
			public int compare(Hotel name1, Hotel name2) {
				if (name1.getRating() < name2.getRating()) {
					  return 1;
					} else if (name1.getRating() > name2.getRating()) {
					  return -1;
					} else {
					  return 0;
					}

			}
			
		});
	   
		return hotelList;
		
	}
	
	public List<Hotel> sortByRooms()
	{
		Collections.sort(hotelList,new Comparator<Hotel>(){

			@Override
			public int compare(Hotel name1, Hotel name2) {
				return name1.getRooms()-name2.getRooms();
			}
			
		});
	   
		return hotelList;
	}
	
	public List<Hotel> getLocaation(String location)
	{
		List<Hotel> list=new ArrayList<>();
		
		for(int i=0;i<hotelList.size();i++)
		{
			Hotel hotel=hotelList.get(i);
			String current=hotel.getLocation();
		    if(current.equals(location))
		    {
		    	list.add(hotel);
		    }
		}
		
		return list;
	}
	
	public List<User> getUsers(){
		return list;
	}
}*/
