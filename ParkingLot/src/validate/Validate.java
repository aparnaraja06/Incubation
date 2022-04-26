package validate;

import java.util.List;

import customexception.CustomException;
import space.ParkingSpace;

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
	
	
}
