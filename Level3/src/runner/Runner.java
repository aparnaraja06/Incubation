package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import custom.CustomException;
import customer.Customer;
import product.Product;
import shop.Shopping;

public class Runner {
	
	static String user="";
	
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		Shopping reader=new Shopping();
		
		List<String> category=new ArrayList<>();
		category.add("mobile");
		category.add("laptop");
		category.add("tablet");
		
		List<String> brand=new ArrayList<>();
		brand.add("apple");
		brand.add("motrola");
		brand.add("hp");
		brand.add("google");
		
		boolean flag=false;
		//reader.addDetails();
		while(!flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add customers 2.Add products 3.Sign-in/Sign-up 4.shopping");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			try
			{
			reader.addCustomer();
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 2:
		{
			try
			{
				reader.addProduct();
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
				System.out.println("Enter the mail id ");
				String mail=scanner.nextLine();
				user=mail;
				
				boolean result=reader.checkUserName(mail);
				//System.out.println(result);
				if(!result)
				{
					System.out.println("Enter your name");
					String name=scanner.nextLine();
					
					System.out.println("enter the mobile number");
					long mobile=scanner.nextLong();
					scanner.nextLine();
					
					System.out.println("enter the password");
					String pass=scanner.nextLine();
					
					System.out.println("Re enter the password");
					String pass2=scanner.nextLine();
					
					boolean resultt=reader.checkPassword(pass, pass2);
					
					if(!resultt)
					{
						throw new CustomException("You have entered incorrectly");
					}
					
					Customer customer=new Customer();
					
					customer.setName(name);
					customer.setUsername(mail);
					customer.setPassword(pass);
					customer.setMobile(mobile);

					reader.newAccount(customer);
				}
				else if(result)
				{
					System.out.println("Enter the password");
					String pass=scanner.nextLine();
					
					boolean resultt=reader.login(mail, pass);
					
					if(!resultt)
					{
						throw new CustomException("Invalid login credentials");
					}
					
					System.out.println("Successfully logged in");
					
					if(mail.equals("admin@zoho.com"))
					{
						
					}
				}
				break;
				
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
		}
		
		case 4:
		{
			try
			{
			System.out.println("1.mobile 2.laptop 3. tablet");
			System.out.println("Choose the category");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("1.apple 2.motrola 3.hp 4.google");
			System.out.println("Choose the brand");
			int number2=scanner.nextInt();
			scanner.nextLine();
			
			String type1=category.get(number-1);
			String type2=brand.get(number2-1);
			
			//System.out.println("category ");
			List<Product> result=reader.placeOrder(type1, type2);
			
			System.out.println(result);
			
			System.out.println("choose a product");
			int product=scanner.nextInt();
			scanner.nextLine();
			
			Product temp=result.get(product-1);
			int order=reader.bookProduct(user, temp);
			System.out.println("Your order number is : "+order);
			System.out.println(temp);
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
		}
		
		case 5:
		{
			flag=true;
		}
		
		}
		}
		
	}

}
