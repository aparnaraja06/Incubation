package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.Booking;
import custom.CustomException;
import customer.Customer;
import product.Product;

public class FileDemo {
	
	String customerFile="zusers.txt";
	String cartFile="zkart.txt";
	String bookFile="zbook.txt";
	
	public boolean checkFileExists(File file)
	{
		return file.exists();
	}
	
	public Map<String,Customer> readCustomers()throws CustomException
	{
		Map<String,Customer> customerMap=new HashMap<>();
		
		if(!checkFileExists(new File(customerFile)))
		{
			return customerMap;
		}
		
		try(FileInputStream fIn=new FileInputStream(customerFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			customerMap=(Map<String,Customer>) objIn.readObject();
			
			return customerMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}
	}
	
	public void writeCustomers(Map<String,Customer> customerMap)throws CustomException
	{
		try(FileOutputStream fOut=new FileOutputStream(customerFile);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(customerMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}

	}
	
	public Map<String,Map<String,List<Product>>> readProduct()throws CustomException
	{
		Map<String,Map<String,List<Product>>> productMap=new HashMap<>();
		
		if(!checkFileExists(new File(cartFile)))
		{
			return productMap;
		}
		
		try(FileInputStream fIn=new FileInputStream(cartFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			productMap=(Map<String,Map<String,List<Product>>>) objIn.readObject();
			return productMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}

		
		
	}
	
	public void writeProducts(Map<String,Map<String,List<Product>>> productMap)throws CustomException
	{
		try(FileOutputStream fOut=new FileOutputStream(cartFile);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(productMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
	}

	public void writeBooking(Map<Integer,Booking> bookMap)throws CustomException
	{
		try(FileOutputStream fOut=new FileOutputStream(bookFile);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(bookMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
	}
	

}
