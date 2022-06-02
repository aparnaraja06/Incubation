package runner;

import java.util.List;
import java.util.Scanner;

import account.Account;
import operation.Operation;
import user.User;

public class Runner {
	
	static Scanner scanner=new Scanner(System.in);
	static Operation reader=new Operation();
	
	public void addNewUser()
	{
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		
		System.out.println("Enter mail id");
		String mail=scanner.nextLine();
		
		System.out.println("Enter aadhar number");
		long aadhar=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter mobile");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		
		User user=new User();
		
		user.setAadhar(aadhar);
		user.setMail(mail);
		user.setMobile(mobile);
		user.setName(name);
		user.setType("customer");
		
		getPassword(user);
	}
	
	public void getPassword(User user)
	{
		String name=user.getName();
		long mobile=user.getMobile();
		String mail=user.getMail();
		
		System.out.println("Enter password");
		String pass1=scanner.nextLine();
		
		System.out.println("Re enter password");
		String pass2=scanner.nextLine();
		
		boolean check=reader.checkPassword(pass1, pass2);
		
		boolean validate=reader.passwordValidation(mail,name,mobile, pass2);
		
		if(check && validate)
		{
			System.out.println("Enter initial amount ");
			double amount=scanner.nextDouble();
			
			user.setPassword(pass2);
			user.setInitialAmount(amount);
			
			boolean result=reader.addWaiting(user);
			
			if(result)
			{
				System.out.println("Added Successfully..Please Wait for sometime");
			}
		}
		else
		{
			System.out.println("Incorrect password");
			System.out.println("Length of the password should be above 8 and should contains special"
					+ "characters");
			getPassword(user);
		}
	}
	
	public void login()
	{
		System.out.println("Enter mail id");
		String mail=scanner.nextLine();
		
		System.out.println("Enter password");
		String pass=scanner.nextLine();
		
		boolean result=reader.login(mail, pass);
		
		if(result)
		{
		User user=reader.getUser(mail);
		
		String type=user.getType();
		
		if(type.equals("customer"))
		{
			customer(mail);
		}
		
		else if(type.equals("admin"))
		{
			admin(mail);
		}
		}
		else
		{
			System.out.println("Invalid credentials");
			login();
		}


	}
	
	public void customer(String mail)
	{
		boolean flag=true;
		
		User user=reader.getUser(mail);
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Account Details 2.Change Password 3.Withdraw 4.Deposit"
				+ "5.buy Z coin 6.Z coin rate 7.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			Account account=reader.getAccount(mail);
			
			System.out.println(account);
			
			break;
		}
		
		case 2:
		{
			changePassword(mail,user);
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the amount to withdraw");
			double amount=scanner.nextDouble();
			
			double total;
			try {
				total = reader.withdrawRC(mail, amount);
				System.out.println("Total balance: "+total);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
					
		}
		
		case 4:
		{
			System.out.println("Enter the amount to deposit");
			double amount=scanner.nextDouble();
			
			double total=reader.depositRc(mail, amount);
			
			System.out.println("Total balanace: "+total);
			
			break;

		}
		
		case 5:
		{
			System.out.println("Enter the amount to buy z coin");
			double amount=scanner.nextDouble();
			
			boolean result;
			try {
				result = reader.buyZCoin(mail, amount);
				if(result)
				{
					System.out.println("Successfully bought");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
						
			break;
		}
		
		case 6:
		{
			double rate=reader.getZCoinRate();
			
			System.out.println("Today's rate : "+rate);
			
			break;
		}
		
		case 7:
		{
			flag=false;
		}
		}
		}
	}
	
	public void admin(String mail)
	{
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add user 2.Set Z coin amount ");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			List<User> list=reader.getWaiting();
			
			for(int i=0;i<list.size();i++)
			{
				
				User user=list.get(i);
			
				System.out.println(user);
				
				System.out.println("1.Approve 2.Reject");
				int num=scanner.nextInt();
				scanner.nextLine();
				
				switch(num)
				{
				case 1:
				{
					reader.addUser(user);
					int account=reader.addAccount(user);
					
					System.out.println("Account id : "+account);
					
					break;
				}
				case 2:
				{
					break;
				}
				}
			}
			break;
		}
				
				case 2:
				{
					System.out.println("Enter the amount to set");
					double amount=scanner.nextDouble();
					
					reader.setZCoinAmount(amount);
					
					System.out.println("Successfully set");
					
					break;
				}
				
				case 3:
				{
					flag=false;
				}
				}
			}
	}
	
	public void changePassword(String mail,User user)
	{
		String name=user.getName();
		long mobile=user.getMobile();
		
		System.out.println("Enter password");
		String pass1=scanner.nextLine();
		
		System.out.println("Re enter password");
		String pass2=scanner.nextLine();
		
		boolean check=reader.checkPassword(pass1, pass2);
		
		boolean validate=reader.passwordValidation(mail,name,mobile, pass2);
		
		if(check && validate)
		{
			boolean result=reader.changePassword(mail, pass2);
			
			if(result)
			{
				System.out.println("Password updated Successfully");
			}
		}
		
		else
		{
			System.out.println("Incorrect password");
			System.out.println("Length of the password should be above 8 and should contains special"
					+ "characters");
			changePassword(mail,user);

		}
	}
	
	public static void main(String[] args)
	{
		Runner runner=new Runner();
		
		reader.addDefaultUser();
		reader.addDefaultAdmin();
		reader.addDefaultAccount();
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add new User 2.Login 3.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			runner.addNewUser();
			break;
		}
		
		case 2:
		{
			runner.login();
			break;
		}
		
		case 3:
		{
			flag=false;
		}
		}
		}
	}

}
