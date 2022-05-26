package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import order.Order;
import product.Product;
import user.User;

public class FileDemo 
{
	String customerFile="zusers.txt";
	String cartFile="zkart.txt";
	String bookFile="zbook.txt";
	String passwordFile="zpass.txt";
	
	public boolean checkFileExists(File file)
	{
		return file.exists();
	}
	
	public Map<String,User> readCustomers()throws CustomException
	{
		Map<String,User> customerMap=new HashMap<>();
		
		if(!checkFileExists(new File(customerFile)))
		{
			return customerMap;
		}
		try(FileInputStream fIn=new FileInputStream(customerFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			customerMap=(Map<String,User>) objIn.readObject();
			
			return customerMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}
	}
	
	public void writeCustomers(Map<String,User> customerMap)throws CustomException
	{
		
		try(FileOutputStream fOut=new FileOutputStream(customerFile,false);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(customerMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
		

	}
	
	public Map<String,List<Product>> readProduct()throws CustomException
	{
		Map<String,List<Product>> productMap=new HashMap<>();
		
		if(!checkFileExists(new File(cartFile)))
		{
			return productMap;
		}
		
		try(FileInputStream fIn=new FileInputStream(cartFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			productMap=(Map<String,List<Product>>) objIn.readObject();
			return productMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}

		
		
	}
	
	public Map<String,List<String>> readPassword()throws CustomException
	{
		Map<String,List<String>> passwordMap=new HashMap<>();
		
		if(!checkFileExists(new File(passwordFile)))
		{
			return passwordMap;
		}
		
		try(FileInputStream fIn=new FileInputStream(passwordFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			passwordMap=(Map<String,List<String>>) objIn.readObject();
			return passwordMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}

		
		
	}
	
	public Map<String,List<Order>> readBooking()throws CustomException
	{
		Map<String,List<Order>> bookMap=new HashMap<>();
		
		if(!checkFileExists(new File(bookFile)))
		{
			return bookMap;
		}
		
		try(FileInputStream fIn=new FileInputStream(bookFile);
				ObjectInputStream objIn=new ObjectInputStream(fIn))
		{
			bookMap=(Map<String,List<Order>>) objIn.readObject();
			return bookMap;
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't load");
		}

		
		
	}
	
	public void writeProducts(Map<String,List<Product>> productMap)throws CustomException
	{
					
		try(FileOutputStream fOut=new FileOutputStream(cartFile,false);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(productMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
		
	}

	public void writeBooking(Map<String,List<Order>> bookMap)throws CustomException
	{
		try(FileOutputStream fOut=new FileOutputStream(bookFile,false);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(bookMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
	}
	
	public void writePassword(Map<String,List<String>> passMap)throws CustomException
	{
		try(FileOutputStream fOut=new FileOutputStream(passwordFile,false);
				ObjectOutputStream objOut=new ObjectOutputStream(fOut))
		{
			objOut.writeObject(passMap);
		}
		catch(Exception e)
		{
			throw new CustomException("Information couldn't store");
		}
	}
	

}
