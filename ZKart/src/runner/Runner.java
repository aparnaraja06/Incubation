package runner;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import customexception.CustomException;
import logic.Cart;
import order.Order;
import product.Product;
import user.User;

public class Runner {
	
	static Scanner scanner=new Scanner(System.in);
	
	static Cart reader=new Cart();

	
	public void login(String mail)
	{
		System.out.println("Enter the password");
		String pass=scanner.nextLine();
		
		boolean check=false;
		try
		{
		check=reader.login(mail, pass);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

		
		if(check)
		{
			System.out.println("Successfully logged in");
			
			try
			{
			String type=reader.getType(mail);
			
			if(type.equals("customer"))
			{
				customerFunctions(mail);
			}
			
			else
			{
				admin(mail,pass);
			}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("Incorrect password");
			
			login(mail);
		}
		
		
		
	}
	
	public String password(String mail)
	{
		System.out.println("Enter new password");
		System.out.println("Password should contain 2 lowercase 2 upper case 2 numbers");
		String change=scanner.nextLine();
		
		System.out.println("Re enter new password");
		String pass2=scanner.nextLine();
		
		boolean temp=false;
		boolean old=false;
		try
		{
		temp=reader.checkPassword(change, pass2);
		
		old=reader.checkOldPasswords(mail, pass2);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		if(temp && old)
		{
			 boolean constraint=false;
		try
		{
		constraint=reader.checkPasswordComplexity(change);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
			
		 if(constraint)
		 {
			 return change;
		 }
		 else
		 {
			 System.out.println("Password should contain 2 lowercase 2 upper case 2 numbers");
			 return password(mail);
		 }
		}
		else
		{
		System.out.println(" Please Enter the password correctly!");
		return password(mail);
		}
	}
	
	public void admin(String mail,String pass)
	{
		boolean check=false;
		try
		{
		check=reader.validatePassword(mail,pass);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		if(check)
		{
			String change=password(mail);
	
			boolean temp=false;
			try
			{
			temp=reader.changePassword(mail, change);
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			if(temp)
			{
				System.out.println("Successfully changed password");
			}
		}
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add stock 2.Change password 3. exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			try
			{
			Map<String,List<Product>> temp=reader.showProduct();
			
			for(String each:temp.keySet())
			{
				List<Product> list=temp.get(each);
				
				for(int i=0;i<list.size();i++)
				{
					Product product=list.get(i);
					
					int stock=product.getStock();
					
					if(stock<5)
					{
						addStock(product);
					}
				}
			}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			
			break;
		}
		
		case 2:
		{
			password(mail);
			System.out.println("Password updated successfully");
			break;
		}
		
		case 3:
		{
			flag=false;
		}
		}
		}
		
	}
	
	public void addStock(Product product)
	{
		try
		{
		reader.addStock(product);
		System.out.println("Product successfully added");
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void customerFunctions(String mail)
	{
		boolean flag=true;
		List<Product> list=new ArrayList<>();
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add product 2.Place order 3.Order History 4.Change password 5.exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		
		
		switch(option)
		{
		case 1:
		{
			try
			{
			Product product=addProduct();
			
			int check=reader.checkStock(product);
			
			if(check!=0)
			{
			list.add(product);
			}
			else
			{
				System.out.println("OOPS! this product is currently unavailable");
			}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 2:
		{
			try
			{
			double amount=reader.generateOrder(list, mail);
			System.out.println("Total amount : "+amount);
			
			List<Order> temp=reader.getOrderedProducts(mail);
			System.out.println(temp);
			
			User user=reader.getUser(mail);
			
			
			String code=user.getCode();
			int count=user.getTransaction();
			
			if(code!=null && count!=0 && !code.isEmpty())
			{
				System.out.println("Do you want to apply discount");
				int num=scanner.nextInt();
				scanner.nextLine();
				switch(num)
				{
				
				case 1:
				{
				double total=reader.applyDiscount(mail, amount);
				
				System.out.println("After discount : "+String.format("%.2f",(amount-total)));
				
				
				}
				case 2:
				{
					break;
				}
			}
			}
			list.removeAll(list);
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 3:
		{
			try
			{
			List<Order> temp=reader.getOrderedProducts(mail);
		
           Iterator<Order> iter=temp.iterator();
			
			while(iter.hasNext())
			{
				System.out.println(iter.next());
			}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
 
		}
		
		case 4:
		{
			password(mail);
			System.out.println("Password updated successfully");
			break;
		}
		
		case 5:
		{
			flag=false;
		}
		}
		}
	}
	
	public Product addProduct()
	{
		Map<String,List<Product>> tempMap=null;
		try
		{
		tempMap=reader.showProduct();
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		for(String each:tempMap.keySet())
		{
			List<Product> list=tempMap.get(each);
			
			System.out.println("Category : "+each);
			Iterator<Product> iter=list.iterator();
			
			while(iter.hasNext())
			{
				System.out.println(iter.next());
			}
		}
		System.out.println("Enter the category");
		String type=scanner.nextLine();
		
		List<Product> temp=null;
		try
		{
		
		temp=reader.getProductsByCategory(type);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	
		
		for(int i=0;i<temp.size();i++)
		{
		  System.out.println((i+1)+"    "+temp.get(i));
		}
		
		System.out.println("choose which product do u want");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		Product product=temp.get(num-1);
		
		return product;
		

	}
	
	public void newCustomer(String mail)
	{
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter gender");
		String gender=scanner.nextLine();
		
		System.out.println("Enter mobile number");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		
       User user=new User();
		
		user.setAge(age);
		user.setGender(gender);
		user.setMailId(mail);
		user.setMobile(mobile);
		user.setType("customer");
		user.setName(name);
		
		validate(user);
		
	
	}
	
	public void validate(User user)
	{
		try
		{
		System.out.println("Enter the password");
		System.out.println("Password should contain 2 lowercase 2 upper case 2 numbers");
		String pass1=scanner.nextLine();
		
		
		System.out.println("Re enter the password");
		String pass2=scanner.nextLine();
		
		
		
		boolean check=reader.checkPassword(pass1, pass2);
		
	     if(check)
	     {
	    	 boolean constraint=reader.checkPasswordComplexity(pass2);
	    	 
	    	 if(constraint)
	    	 {
	    	 String mail=user.getMailId();
	    	 
	    	 user.setPassword(pass2);
	    	 
	    	 try
	    	 {
	    	 reader.addCustomer(user, mail);
	    	 }
	    	 catch(CustomException e)
	 		{
	 			System.out.println(e.getMessage());
	 		}
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Password should contain 2 lowercase 2 upper case 2 numbers");
	    		 validate(user);
	    	 }
	     }
	     else
	     {
	    	 validate(user);
	     }
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	     
	     
	}
		
	public static void main(String[] args)
	{
				
		Runner runner =new Runner();
		
		try
		{
			reader.addDefaults();
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.show customers 2.show products 3.login 4. exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			try
			{
			Map<String,User> userMap=reader.showCustomers();
			
			for(String each:userMap.keySet())
			{
				User user=userMap.get(each);
				
				String type=user.getType();
				
				if(type.equals("customer"))
				{
				System.out.println("Mail id : "+each);
				System.out.println("Details : "+user);
				System.out.println("-------------------------------------------------------");
				}
			}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			
			break;
		}
		
		case 2:
		{
			try
			{
			Map<String,List<Product>> tempMap=reader.showProduct();
			
			for(String each:tempMap.keySet())
			{
				List<Product> list=tempMap.get(each);
				
				System.out.println("Category : "+each);
				System.out.println("Details : "+list);
				System.out.println("-----------------------------------------------------------------");

			
		}
			}
			catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 3:
		{
			try
			{
			System.out.println("Enter mail id");
			String mail=scanner.nextLine();
			
			boolean check=reader.checkValidUser(mail);
			
			if(check)
			{
				runner.login(mail);
			}
			else
			{
				System.out.println("Do you want to create  new account");
				System.out.println("1.yes 2.no");
				int num=scanner.nextInt();
				scanner.nextLine();
				
				switch(num)
				{
				case 1:
				{
					runner.newCustomer(mail);
				}
				case 2:
				{
					break;
				}
				}
			}
			
		}
		
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
			break;
		}

		
		case 4:
		{
			flag=false;
		}
		
	}
		}

	}
}


