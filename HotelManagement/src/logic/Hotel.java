package logic;

import java.util.List;

import book.BookingInfo;
import hotel.HotelInfo;
import operations.HotelOperations;

public class Hotel {
	
	HotelOperations hotel=new HotelOperations();
	
	public Hotel() {
		hotel.addDefaultHotels();
		hotel.addDefaultUsers();
		hotel.addDefaultBooking();
	}
	
	public List<HotelInfo> getHotelData(){
		
		return hotel.getHotelData();
	}
	
	public boolean addHotel(HotelInfo hotell)
	{
		return hotel.addHotel(hotell);
	}
	
	public List<HotelInfo> sortByName(){
		
		return hotel.sortByName();
	}
	
	public List<HotelInfo> sortByRating()
	{
		return hotel.sortByRating();
	}
	
	public List<HotelInfo> sortByRooms()
	{
		return hotel.sortByRooms();
	}
	
	public List<HotelInfo> getLocaation(String location)
	{
		return hotel.getLocaation(location);
	}
	
	public List<BookingInfo> getBookingDetails(){
		return hotel.getBookingDetails();
	}



}
