package runner;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import account.Account;
import customexception.CustomException;
import logic.Coin;
import operation.Operation;
import transaction.Transaction;
import user.User;

public class Runner 
{
	static Scanner scanner=new Scanner(System.in);
	static Coin reader=new Coin();
	
	public void newUser()
	{
		System.out.println("Enter your name");
		String name=scanner.nextLine();
		
		System.out.println("Enter mail id");
		String mail=scanner.nextLine();
		
		System.out.println("Enter mobile");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter your aadhar number");
		long aadhar=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter initial deposit");
		double amount=scanner.nextDouble();
		
		User user=new User();
		
		user.setAadhar(aadhar);
		user.setInitialDeposit(amount);
		user.setMailId(mail);
		user.setMobile(mobile);
		user.setName(name);
		user.setType("customer");
		
		getPassword(user);
		
	}
	
	public void getPassword(User user)
	{
		String name=user.getName();
		String mail=user.getMailId();
		long mobile=user.getMobile();
		scanner.nextLine();
		
		System.out.println("Enter password");
		System.out.println("Password should contain both upper case & lower case with special characters"
				+ ", minimum length of 8");
		String pass1=scanner.nextLine();
		
		System.out.println("Re enter password");
		String pass2=scanner.nextLine();
		
		boolean check=reader.checkPassword(pass1, pass2);
		
		if(check)
		{
			boolean validate=reader.passwordValidation(pass2, name, mail, mobile);
			
			user.setPass(pass2);
			
			if(validate)
			{
				reader.putInWaiting(user);
			}
			else
			{
				System.out.println("Password should contain both upper case & lower case with special characters"
						+ ", minimum length of 8");
				getPassword(user);
			}
		}
		
		else
		{
			System.out.println("Password doesn't match with previous password");
			getPassword(user);
		}
	}
	
	public void changePassword(User user)
	{
		String name=user.getName();
		String mail=user.getMailId();
		long mobile=user.getMobile();

		System.out.println("Enter password");
		System.out.println("Password should contain both upper case & lower case with special characters"
				+ ", minimum length of 8");
		String pass1=scanner.nextLine();
		
		System.out.println("Re enter password");
		String pass2=scanner.nextLine();
		
		boolean check=reader.checkPassword(pass1, pass2);
		
		if(check)
		{
			boolean validate=reader.passwordValidation(pass2, name, mail, mobile);
			
             user.setPass(pass2);
			
			if(validate)
			{
				reader.updateUser(user);
			}
			
			else
			{
				System.out.println("Password should contain both upper case & lower case with special characters"
						+ ", minimum length of 8");
				getPassword(user);
			}
		}
		
		else
		{
			System.out.println("Password doesn't match with previous password");
			getPassword(user);
		}

		
	}
	
	/*public String getMail(int account_num)
	{
		Map<String,Map<Integer,Account>> accountMap=reader.allAccounts();
		
		for(Entry<String,Map<Integer,Account>> entry: accountMap.entrySet()) {
			
			Map<Integer,Account> tempMap=accountMap.get(entry.getKey());

			for(Integer key : tempMap.keySet())
			{
				if(key==account_num)
				{
					return entry.getKey();
				}
			}
		}
			
			return null;
	}*/
	
	public void admin(String mail)
	{
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Check waiting list 2.History 3.User's History 4.Set Z Coin rate 5.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			List<User> list=reader.getWaitingUser();
			
			int i=0;
			
			while(i<list.size())
			{
				User user=list.get(i);
				System.out.println(user);
				
				System.out.println("1.Approve 2.reject");
				int number=scanner.nextInt();
				scanner.nextLine();
				
				switch(number)
				{
				case 1:
				{
					int id=reader.addCustomer(user);
					System.out.println("Account number : "+id);
					i++;
					break;
				}
				
				case 2:
				{
					i++;
					break;
				}
				}
			}
			
			break;
		}
		
		case 2:
		{
			Map<String,List<Transaction>> tempMap=reader.getHistory();
			
			for(String key : tempMap.keySet())
			{
				List<Transaction> list=tempMap.get(key);
				
				System.out.println("Mail id : "+key);
				System.out.println("Details : "+list);
				System.out.println("------------------------------------------------------------------");
			}
			
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the mail id of the user to check");
			String id=scanner.nextLine();
			
			List<Transaction> list=reader.showTransaction(id);
			
			System.out.println(list);
			break;
		}
		
		case 4:
		{
			System.out.println("Enter the amount to set Z Coin rate");
			double amount=scanner.nextDouble();
			
			reader.setZCoinRate(amount);
			
			break;
		}
		case 5:
		{
			flag=false;
		}
		}
		}
	}
	
	public void customer(String mail)
	{
		int account_num=reader.getAccountNum(mail);
		
       boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Account details 2.Wallet 3.change password 4.withdraw "
				+ "5.deposit 6.Today's rate of Z Coin 7. Buy Z coin 8.Transfer Z Coin 9.History "
				+ "10.ZC to RC 11.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		
		
		switch(option)
		{
		case 1:
		{
			Account account=reader.userWallets(account_num);
				
				System.out.println("Account id : "+account_num);
				System.out.println("Account Details : "+account);
				System.out.println("------------------------------------------------------------------");
			
			break;
		}
		
		case 2:
		{
			Account account=reader.userWallets(account_num);
			
			double rcCoins=account.getInitialAmount();
			
			double zCoins=account.getzCoin();
			
			System.out.println("RC Coins : "+rcCoins);
			System.out.println("Z Coins : "+zCoins);
			
			break;
		}
		
		case 3:
		{
			User user=reader.getUser(mail);
			changePassword(user);
			break;
		}
		
		case 4:
		{
			System.out.println("Enter the amount to withdraw ");
			double amount=scanner.nextDouble();
			
			try
			{
			double total=reader.withdrawRC(account_num, amount);
			System.out.println("Balance is :"+total);
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 5:
		{
			System.out.println("Enter the amount to deposit ");
			double amount=scanner.nextDouble();
			
			double total=reader.depositRC( account_num, amount);
			System.out.println("Balance is :"+total);
			break;
		}
		
		case 6:
		{
			double amount=reader.getZCoinRate();
			System.out.println("Today's rate of Z Coin is : "+amount);
			break;
		}
		
		case 7:
		{
			System.out.println("Enter the amount to buy Z coin");
			double amount=scanner.nextDouble();
			
			try
			{
			boolean result=reader.buyZCoin( account_num, amount);
			if(result)
			{
				System.out.println("Successfully you have bought z coin for Rs."+amount);
			}
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 8:
		{
			System.out.println("Enter the account number to transfer");
			int toAccount=scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Enter the amount to deposit ");
			double amount=scanner.nextDouble();
			
			//String toMail=getMail(toAccount);
			
			try
			{
			double total=reader.transfer(mail,account_num, toAccount, amount);
			
			System.out.println("Balance is : "+total);
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 9:
		{
			List<Transaction> list=reader.showTransaction(mail);
			
			for(int i=0;i<list.size();i++)
			{
				Transaction transfer=list.get(i);
				
				System.out.println(transfer);
			}
			
			break;
		}
		
		case 10:
		{
			System.out.println("Enter the amount to convert");
			double amount=scanner.nextDouble();
			
			try
			{
		
			double total=reader.withdrawZcToRc( account_num, amount);
			System.out.println("RC coins : "+total);
			}catch(CustomException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
		}
		
		case 11:
		{
			flag=false;
		}
		}
		}
	}
	
	public static void main(String[] args)
	{
		
		Runner runner=new Runner();
		
				
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.New User 2.Login 3.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			runner.newUser();
			break;
		}
		
		case 2:
		{
			System.out.println("Enter mail id");
			String mail=scanner.nextLine();
			
			System.out.println("Enter password");
			String pass=scanner.nextLine();
			
		
			String type=reader.login(mail, pass);
			
			if(type.equals("customer"))
			{
				runner.customer(mail);
			}
			else
			{
				runner.admin(mail);
			}
			
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
