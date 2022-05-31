package validate;

import java.util.List;
import java.util.Map;

import customer.CustomerInfo;
import customexception.CustomException;
import space.ParkingSpace;
import ticket.Ticket;

public class Validate {

	public void validate(long num)throws CustomException
	{
		if(num<0)
		{
			throw new CustomException("Input should be a positive number");
		}
	}
	
	public void validate(int num)throws CustomException
	{
		if(num<0)
		{
			throw new CustomException("Input should be a positive number");
		}
	}
	
	public void validate(int num,List<String> list)throws CustomException
	{
		if(num>list.size())
		{
			throw new CustomException("Invalid Option");
		}
	}
	
	public void validate(String type)throws CustomException
	{
		if(type==null || type.isEmpty())
		{
			throw new CustomException("Input should not be null or empty");
		}
	}
	
	public void validate(Object object)throws CustomException
	{
		if(object==null)
		{
			throw new CustomException("Input should not be null");
		}
	}
	
	public void validate(List<ParkingSpace> list,int num)throws CustomException
	{
		if(num>list.size())
		{
			throw new CustomException("Invalid Option");
		}
	}
	
	public void validate(long num,Map<Long,CustomerInfo> customerMap)throws CustomException
	{
		CustomerInfo customer=customerMap.get(num);
		
		if(customer==null)
		{
			throw new CustomException("This vehicle number does not have account");
		}
	}
	
	public void validate(int cust_id,long num,Map<Long,CustomerInfo> customerMap)throws CustomException
	{
		CustomerInfo customer=customerMap.get(num);
		
		validate(num,customerMap);
		
		int id=customer.getCustomerId();
		
		if(id==0)
		{
			throw new CustomException("Invalid customer Id");
		}
	}
	
	public void validate(int ticket_num,Map<Integer,Ticket> ticketMap)throws CustomException
	{
		Ticket ticket = ticketMap.get(ticket_num);
		
		if(ticket==null)
		{
			throw new CustomException("Invalid ticket number");
		}
	}
	
	public void checkSpace(int floor_num,Map<Integer,Map<String,List<ParkingSpace>>> emptySpaces)
			throws CustomException
	{
		Map<String,List<ParkingSpace>> temp=emptySpaces.get(floor_num);
		
		if(temp==null)
		{
			throw new CustomException("No spaces available");
		}
	}
	
	public void checkValidMobile(long mobile,Map<Long,CustomerInfo> customerMap)throws CustomException
	{
		CustomerInfo customer=customerMap.get(mobile);
		
		if(customer==null)
		{
			throw new CustomException("Mobile number not exists");
		}
	}
	
}
