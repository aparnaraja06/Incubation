package runner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import account.Account;
import customexception.CustomException;
import loan.LoanInfo;
import logic.LogicalLayer;
import transaction.TransactionInfo;
import user.User;
import validate.Validate;

public class Runner {
	static long customer_id=0;
	static String passsword="";
	static long account_num=0;

	static Scanner scanner=new Scanner(System.in);
	static Validate validator=new Validate();
	 static LogicalLayer reader=new LogicalLayer();
	
	public User addCustomer()throws CustomException
	{
		System.out.println("Enter the name");
		String name=scanner.nextLine();
		System.out.println("Enter the gender");
		String gender=scanner.nextLine();
		System.out.println("Enter your location");
		String location=scanner.next();
		
		validator.validate(name,gender,location);
		System.out.println("Enter your mobile number");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		validator.validate(mobile);
		
		User customer=new User();
		customer.setName(name);
		customer.setGender(gender);
		customer.setMobileNum(mobile);
		customer.setLocation(location);
		
		return customer;
	}
	
	public Account addAccount(long cust_id)throws CustomException
	{
		Account account=new Account();
		System.out.println("Enter the branch");
		String branch=scanner.nextLine();
		validator.validate(branch);
		System.out.println("Enter the amount");
		double amount=scanner.nextDouble();
		validator.validate(amount);
		
		account.setCustomerId(cust_id);
		account.setBranch(branch);
		account.setBalance(amount);
		return account;
		
	}
	
	public User login() throws CustomException{
		System.out.println("Enter user id");
		long id=scanner.nextLong();
		scanner.nextLine();
		validator.validate(id);
		customer_id=id;
		System.out.println("Enter password");
		String getPass=scanner.nextLine();
		validator.validate(getPass);
		
		User customerr=new User();
		
		customerr.setCustomerId(id);
		customerr.setPassword(getPass);
		
		return customerr;
	}
	
	public double balance(long accountNum)throws CustomException
	{
		return reader.getBalance(account_num);
	}
	
	public boolean transfer(long fromAcc)throws CustomException
	{
		System.out.println("Transfer to account");
		long toAccount=scanner.nextLong();
		scanner.nextLine();
		validator.validate(toAccount);
		System.out.println("Enter the amount to transfer");
		double amount=scanner.nextDouble();
		validator.validate(amount);
		boolean result=reader.transfer(fromAcc, toAccount, amount);
		return result;
	}
	
public static void main(String[] args)
{
	Runner runner=new Runner();
	

try
	{
	System.out.println("For New Customer Press 1 for sign-up &  Press 2 for Log-in");
	int num=scanner.nextInt();
	scanner.nextLine();
	validator.validate(num);
	
	if(num==1)
	{
		User customer=runner.addCustomer();
		long cust_id=reader.addCustomer(customer);
		customer_id=cust_id;
		String pass=reader.newUserLogin(cust_id);
		passsword=pass;
		if(pass!="")
		{
			System.out.println("Login Created successfully");
			System.out.println("Do you want to change password Y/N");
			char character=scanner.next().charAt(0);
			scanner.nextLine();
			if(character !='Y' && character!='N')
			{
				System.out.println("Invalid option");
				passsword="Invalid userName";
			}
			if(character=='Y')
			{
				User user=new User();
				System.out.println("Enter the new password");
				String password=scanner.nextLine();
				validator.validate(password);
			    passsword=password;
				user.setCustomerId(cust_id);
				user.setPassword(password);
				
				reader.updateUserId(user);
			}
			if(passsword!="Invalid userName")
			{
			
			Account account=runner.addAccount(cust_id);
			reader.addAccount(account);
			}
		}
	}
	if(num==2)
	{
		
		User customerr=runner.login();
		String result=reader.login(customerr);
		passsword=result;
		System.out.println(result);
	}
	 if(num>2)
	{
		System.out.println("Invalid option");
	}
	if(customer_id==000001)
	{
		
		boolean flag = false;
		
		scanner.nextLine();

		System.out.println("Total Accounts ");
		List<Long> accounts=reader.getAllAccounts();
		System.out.println(accounts);
		while(!flag)
		{
			System.out.println("Enter the option");
			System.out.println("1-Add account 2-Balance 3-Transfer 4-Change loan status 5-withdraw");
		    int option=scanner.nextInt();
		switch(option)
		{
		case 0:
		{
			flag =true;
			break;
		}
		
		case 1:
		{
			System.out.println("Adding account for 1-new user 2-existing user");
			int optionn=scanner.nextInt();
			scanner.nextLine();
			long id=0;
			if(optionn==1)
			{
			User user=runner.addCustomer();
			id=reader.addCustomer(user);
			}
			else
			{
				System.out.println("Enter the customer id");
				id=scanner.nextLong();
				scanner.nextLine();
			}
			Account account=runner.addAccount(id);
			reader.addAccount(account);
			break;
		}
		
		case 2:
		{
			System.out.println("Enter the account to check");
			int account=scanner.nextInt();
			scanner.nextLine();
			long accountNum=accounts.get(account-1);
			double amount=runner.balance(accountNum);
			System.out.println(amount);
			break;
		}
		
		case 3:
		{
			System.out.println("Enter the account to check");
			int account=scanner.nextInt();
			scanner.nextLine();
			long accountNum=accounts.get(account-1);
			boolean result=runner.transfer(accountNum);
			if(result)
			{
				System.out.println("Transaction successful");
			}
			else
			{
				System.out.println("Something went wrong!");
			}
			break;
		}
		
		case 4:
		{
			System.out.println("Enter the account to check");
			int account=scanner.nextInt();
			scanner.nextLine();
			long accountNum=accounts.get(account-1);
			System.out.println("Enter the type of loan");
			String type=scanner.nextLine();
			System.out.println("Enter the status");
			String status=scanner.nextLine();
			boolean result=reader.updateStatus(num, type, status);
			if(result)
			{
				System.out.println("updated successfully");
			}
			else
			{
				System.out.println("Something went wrong!");
			}
			break;
		}
		
		case 5:
		{
			System.out.println("Enter the account to check");
			int account=scanner.nextInt();
			scanner.nextLine();
			long accountNum=accounts.get(account-1);
			System.out.println("Enter the amount");
			double amount=scanner.nextDouble();
			double balance=reader.withdraw(accountNum, amount);
		
		System.out.println("Successfully withdrawn now balance is "+balance);
		break;
		}
		
		}
		}
	}
	if(passsword!="Invalid password" && passsword!="Invalid username" && passsword!="" 
			                                                     && customer_id!=000001)
	{
		boolean flag1 = false;
		
		while(!flag1)
		{

	System.out.println("Accounts you have:");
	List<Long> list=reader.getAccountById(customer_id);
	System.out.println(list);
	
	System.out.println("Choose the account to use");
	int optionn=scanner.nextInt();
	scanner.nextLine();
	validator.validate(optionn);
	account_num=list.get(optionn-1);
	System.out.println("Account number : "+account_num);
	
		System.out.println("Enter option 1-balance enquiry, 2-Transfer,3-Bank statement,"
			+ "4-Add Account, 5-exit");
	int option=scanner.nextInt();
	scanner.nextLine();
	validator.validate(option);
	
	switch(option)
	{
	case 1:
	{
		double amount=runner.balance(account_num);
		System.out.println("Balance : "+amount);
		break;
	}
	
	case 2:
	{
		boolean result=runner.transfer(account_num);		
		if(result)
		{
			System.out.println("Transaction successful");
		}
		else
		{
			System.out.println("Something went wrong!");
		}
		break;
	}
	case 3:
	{
		Account accInfo=reader.getAccountDetails(account_num);
		List<TransactionInfo> transfer=reader.getHistory(account_num);
		System.out.println("ACCOUNT DETAILS:");
		System.out.println(accInfo);
		System.out.println("TRANSACTION HISTORY:");
		System.out.println(transfer);
		break;
	}
	case 4:
	{
		Account account=runner.addAccount(customer_id);
		long number=reader.addAccount(account);
		System.out.println(number);
		break;
	}
	case 5:
	{
		flag1=true;
	}
	}
	
	boolean flag = false;
	
	while(!flag)
	{
	System.out.println("Enter the your choice for loan details");
	System.out.println("1-Apply loan 2-check status 3-exit");
	int choice=scanner.nextInt();
	validator.validate(choice);
	scanner.nextLine();
	List<String> listt11=new ArrayList<>();
	listt11.add("Personal loan");
	listt11.add("House loan");
	listt11.add("Educational loan");
	listt11.add("Car loan");
	listt11.add("Small business loan");
	listt11.add("Gold loan");
	switch(choice)
	{
	case 1:
	{
		System.out.println("which type of loan do you want to apply");
		System.out.println(listt11);
		System.out.println("Enter the option");
		int choose=scanner.nextInt();
		scanner.nextLine();
		validator.validate(choose);
		String type=listt11.get(choose-1);
		System.out.println("Enter the amount of loan to apply");
		double amount=scanner.nextDouble();
		validator.validate(amount);
		LoanInfo loan=new LoanInfo();
		loan.setCustomerId(customer_id);
		loan.setAccountNum(account_num);
		loan.setType(type);
		loan.setAmount(amount);
		
		boolean result=reader.applyLoan(loan);
		if(result)
		{
			System.out.println("Applied successfully");
		}
		else
		{
			System.out.println("Something went wrong");
		}
		break;
	}
	
	case 2:
	{
		System.out.println(listt11);
		System.out.println("Enter the type of loan");
		int loan=scanner.nextInt();
		scanner.nextLine();
		String type=listt11.get(loan-1);
		String info=reader.checkStatus(account_num,type);
		System.out.println(info);
		break;
	}
	
	case 3:
	{
		flag=true;
	}
	}
	}
	}
	}
	else
	{
		System.out.println("Invalid Login credentials");
	}
	}
	catch(InputMismatchException e)
	{
		System.out.println("Input should be a number");
	}
	catch(CustomException e)
	{
		System.out.println(e.getMessage());
	}
}
}
