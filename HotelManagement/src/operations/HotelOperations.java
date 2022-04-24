package operations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hotel.Hotel;
import user.User;

public class HotelOperations {

	Map<String,Map<Object,Hotel>> hotelMap=new HashMap<>();
	List<User> list=new ArrayList<>();
	
	
	public HotelOperations() {
		addDefaultNameHotels();
		addDefaultRatingHotel();
		addDefaultLocationHotel();
		addDefaultRoomsHotel();
		addDefaultUsers();
	}
	
	/*public void addDefaultHotels() {
		String[] name= {"Hotel1","Hotel2","Hotel3","Hotel4","Hotel5"};
		int[] rooms= {4,6,8,2,5};
		String[] location= {"Bangalore","Mumbai","Agra","Bangalore","Goa"};
		float[] rating= {3F,4F,5F,3.5F,4F};
		double[] price= {200,300,600,400,300};
		
		for(int i=0;i<name.length;i++)
		{
			Hotel hotel=new Hotel();
			
			hotel.setName(name[i]);
			hotel.setRooms(rooms[i]);
			hotel.setLocation(location[i]);
			hotel.setRating(rating[i]);
			hotel.setPrice(price[i]);
			
			String namee=hotel.getName();
			
			namesList.add(namee);
			hotelMap.put(namee, hotel);
			
		}
	}*/
	
	public void addDefaultUsers() {
		int[] id= {1,2,3};
		String[] name= {"User1","User2","User3"};
		String[] hotel= {"Hotel1","Hotel2","Hotel3"};
		double[] cost= {1000,1200,1100};
		
		for(int i=0;i<id.length;i++)
		{
			User user=new User();
			
			user.setUserId(id[i]);
			user.setUserName(name[i]);
			user.setHotelName(hotel[i]);
			user.setTotalCost(cost[i]);
			
			list.add(user);
		}
		
		
	}
	
	public void addDefaultNameHotels() {
	
		String[] name= {"Hotel1","Hotel2","Hotel3"};
		int[] rooms= {4,2,5};
		String[] location= {"Bangalore","Goa","Bangalore"};
		float[] rating= {3F,4.5F,4F};
		double[] price= {200,300,600};
		
		for(int i=0;i<name.length;i++)
		{
			Hotel hotel=new Hotel();
			
			Map<Object,Hotel> temp=new HashMap<>();
			
			hotel.setName(name[i]);
			hotel.setRooms(rooms[i]);
			hotel.setLocation(location[i]);
			hotel.setRating(rating[i]);
			hotel.setPrice(price[i]);
			
			
			if(hotelMap.containsKey("Name"))
			{
				Map<Object,Hotel> tempp=hotelMap.get("Name");
				tempp.put(name[i], hotel);
				hotelMap.put("Name", tempp);
				
			}
			else
			{
			temp.put(name[i], hotel);
			hotelMap.put("Name", temp);
			}
			//list.add(temp);
		}
		
		
		
	}
		
		public void addDefaultRatingHotel() {
			
			String[] name= {"Hotel1","Hotel2","Hotel3"};
			int[] rooms= {4,2,5};
			String[] location= {"Bangalore","Goa","Bangalore"};
			float[] rating= {3F,4.5F,4F};
			double[] price= {200,300,600};
			
	
			for(int i=0;i<name.length;i++)
			{
				Hotel hotel=new Hotel();
				
				Map<Object,Hotel> temp=new HashMap<>();
				
				hotel.setName(name[i]);
				hotel.setRooms(rooms[i]);
				hotel.setLocation(location[i]);
				hotel.setRating(rating[i]);
				hotel.setPrice(price[i]);
				
				
				if(hotelMap.containsKey("Rating"))
				{
					Map<Object,Hotel> tempp=hotelMap.get("Rating");
					tempp.put(rating[i], hotel);
					hotelMap.put("Rating", tempp);
					
				}
				else
				{
				temp.put(rating[i], hotel);
				hotelMap.put("Rating", temp);
				}
				//list.add(temp);


			}
			
		}
		
		public void addDefaultLocationHotel() 
		{
			String[] name= {"Hotel1","Hotel2","Hotel3"};
			int[] rooms= {4,2,5};
			String[] location= {"Bangalore","Goa","Bangalore"};
			float[] rating= {3F,4.5F,4F};
			double[] price= {200,300,600};
			
	
			for(int i=0;i<name.length;i++)
			{
				Hotel hotel=new Hotel();
				
				Map<Object,Hotel> temp=new HashMap<>();
			
				
				hotel.setName(name[i]);
				hotel.setRooms(rooms[i]);
				hotel.setLocation(location[i]);
				hotel.setRating(rating[i]);
				hotel.setPrice(price[i]);
				
				
				if(hotelMap.containsKey("Location"))
				{
					Map<Object,Hotel> tempp=hotelMap.get("Location");
					tempp.put(location[i], hotel);
					hotelMap.put("Location", tempp);
					
				}
				else
				{
				temp.put(location[i], hotel);
				hotelMap.put("Location", temp);
				}
                //list.add(temp);
			}
			
		
	      }
		
		public void addDefaultRoomsHotel() {
			String[] name= {"Hotel1","Hotel2","Hotel3"};
			int[] rooms= {4,2,5};
			String[] location= {"Bangalore","Goa","Bangalore"};
			float[] rating= {3F,4.5F,4F};
			double[] price= {200,300,600};
			
	
			for(int i=0;i<name.length;i++)
			{
				Hotel hotel=new Hotel();
				
				Map<Object,Hotel> temp=new HashMap<>();
				
				
				hotel.setName(name[i]);
				hotel.setRooms(rooms[i]);
				hotel.setLocation(location[i]);
				hotel.setRating(rating[i]);
				hotel.setPrice(price[i]);
				
				
				if(hotelMap.containsKey("Rooms"))
				{
					Map<Object,Hotel> tempp=hotelMap.get("Rooms");
					tempp.put(rooms[i], hotel);
					hotelMap.put("Rooms", tempp);
					
				}
				else
				{
				temp.put(rooms[i], hotel);
				hotelMap.put("Rooms", temp);
				}
				//list.add(temp);

			}

		}
	
	public Map<Object,Hotel> getHotelData(){
		Map<Object,Hotel> temp=hotelMap.get("Name");
		return temp;
	}
	
	public Map<Object,Hotel> sortByName(){
		
		Map<Object,Hotel> name=hotelMap.get("Name");
		
		TreeMap<Object,Hotel> sortMap=new TreeMap<Object,Hotel>(name);
		
		return sortMap;
			
	}
	
	public Map<Object,Hotel> sortByRating()
	{
		
		Map<Object,Hotel> rate=hotelMap.get("Rating");
		
		TreeMap<Object,Hotel> sortMap=new TreeMap<Object,Hotel>(rate);
		
		return sortMap;
	}
	
	public Map<Object,Hotel> sortByRooms()
	{
		Map<Object,Hotel> room=hotelMap.get("Rooms");
		
		TreeMap<Object,Hotel> sortMap=new TreeMap<Object,Hotel>(room);
		
		return sortMap;
	}
	
	public Hotel getLocaation(String location)
	{
		Map<Object,Hotel> room=hotelMap.get("Location");
		
		Hotel hotel=room.get(location);
		
		return hotel;
	}
	
	public List<User> getUsers(){
		return list;
	}
}
