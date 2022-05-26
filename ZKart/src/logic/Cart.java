package logic;

import java.util.List;
import java.util.Map;

import customexception.CustomException;
import operation.Operation;
import order.Order;
import product.Product;
import user.User;

public class Cart 
{
	Operation reader=new Operation();
	
	public void addDefaults()throws CustomException
	{
		reader.addDefaultAdmin();
		reader.addDefaultUsers();
		reader.addDefaultProduct();
	}
	
	
	public void addStock(Product product)throws CustomException
	{
		reader.addStock(product);
	}
	
	public double applyDiscount(String mail,double amount)throws CustomException
	{
		return reader.applyDiscount(mail, amount);
	}
	
	public boolean checkOldPasswords(String mail,String pass)throws CustomException
	{
		return reader.checkOldPasswords(mail, pass);
	}
	
	public boolean checkPasswordComplexity(String pass)throws CustomException
	{
		return reader.checkPasswordComplexity(pass);
	}
	
	public int checkStock(Product product)throws CustomException
	{
		return reader.checkStock(product);
	}
	
	public List<Order> getOrderedProducts(String mail)throws CustomException
	{
		return reader.getOrderedProducts(mail);
	}
	
	public String getType(String mail)throws CustomException
	{
		return reader.getType(mail);
	}
	
	public double generateOrder(List<Product> list,String mail)throws CustomException
	{
		return reader.generateOrder(list, mail);
	}
	
	public void placeOrder(Product product,String type,String mail)throws CustomException
	{
		reader.placeOrder(product, type, mail);
	}
	
	public boolean login(String mail,String pass)throws CustomException
	{
		return reader.login(mail, pass);
	}
	
	public void addCustomer(User user,String mail)throws CustomException
	{
		reader.addCustomer(user, mail);
	}
	
	public boolean checkPassword(String pass1,String pass2)throws CustomException
	{
		return reader.checkPassword(pass1, pass2);
	}
	
	public boolean checkValidUser(String mail)throws CustomException
	{
		return reader.checkValidUser(mail);
	}
	
	public boolean changePassword(String mail,String pass)throws CustomException
	{
		return reader.changePassword(mail, pass);
	}

	public boolean validatePassword(String mail,String pass)throws CustomException
	{
		return reader.validatePassword(mail, pass);
	}
	
	public List<String> getPasswords(String mail)throws CustomException
	{
		return reader.getPasswords(mail);
	}
	
	public User getUser(String mail)throws CustomException
	{
		return reader.getUser(mail);
	}
	
	public List<Product> getProductsByCategory(String type)throws CustomException
	{
		return reader.getProductsByCategory(type);
	}
	
	public Map<String,List<Product>> showProduct()throws CustomException
	{
		return reader.showProduct();
	}
	
	public Map<String,User> showCustomers() throws CustomException
	{
		return reader.showCustomers();
	}

}
