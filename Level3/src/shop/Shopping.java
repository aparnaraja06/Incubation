package shop;

import java.util.List;

import custom.CustomException;
import customer.Customer;
import operations.Operations;
import product.Product;

public class Shopping {
	
	Operations reader=new Operations();
	
	public void addCustomer()throws CustomException{
		
		reader.addDefaultCustomers();
		
	}
	
	public void addProduct()throws CustomException
	{
		reader.addDefaultProduct();
	}
	
	public void newAccount(Customer customer)throws CustomException
	{
		reader.newAccount(customer);
	}
	
	public boolean checkUserName(String mail)throws CustomException
	{
		return reader.checkUserName(mail);
	}
	
	public boolean checkPassword(String pass1,String pass2)
	{
		return reader.checkPassword(pass1, pass2);
	}
	
	public boolean login(String user, String pass)throws CustomException {
		return reader.login(user, pass);
	}
	
	public List<Product> placeOrder(String category,String brand)throws CustomException
	{
		return reader.placeOrder(category, brand);
	}
	
	public int bookProduct(String user,Product product)throws CustomException
	{
		return reader.bookProduct(user, product);
	}
	
	

}
