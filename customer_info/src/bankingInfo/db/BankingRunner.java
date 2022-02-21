package bankingInfo.db;

import java.util.Map;
import java.util.Scanner;

import account.AccountInfo;
import customer.CustomerInfo;
import customexception.CustomException;

public class BankingRunner {
public static void main(String[] args) {
	Scanner scanner= new Scanner(System.in);
	CustomerDb customerObj=new CustomerDb();
	AccountDb accountObj=new AccountDb();
	
	int option=0;
	try
	{
	System.out.println("Enter the number between 1-10");
	option=scanner.nextInt();
	scanner.nextLine();
	switch(option)
	{
	case 1:
	{
		try
		{
			customerObj.createTable();
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	case 2:
	{
		try
		{
			System.out.println("How many customers do you want to add");
			int number=scanner.nextInt();
			scanner.nextLine();
			for(int i=0;i<number;i++)
			{
				CustomerInfo customer=new CustomerInfo();
				System.out.println("Enter the customer name");
				String name=scanner.nextLine();
				System.out.println("Enter gender");
				String gender=scanner.nextLine();
				System.out.println("Enter mobile number");
				long mobile=scanner.nextLong();
				scanner.nextLine();
				customer.setCustomerName(name);
				customer.setGender(gender);
				customer.setMobileNum(mobile);
				customerObj.addCustomer(customer);
			}
			
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	 case 3:
    {
	 try
	 {
		 System.out.println("Enter the customer id");
		 int id=scanner.nextInt();
		 scanner.nextLine();
		 CustomerInfo customer=customerObj.getCustomerById(id);
		 System.out.println(customer);
		 break;
	 }
	 catch(Exception e)
		{
			System.out.println(e);
		}

     }
	 case 4:
	 {
		 try
		 {
			 accountObj.createTable();
		 }
	 catch(Exception e)
		{
			System.out.println(e);
		}
		 break;
	 }
	 case 5:
	 {
		 try
		 {
			 AccountInfo account=new AccountInfo();
			 
			 System.out.println("Enter customer id");
			 int id=scanner.nextInt();
			 scanner.nextLine();
			 String branch="Madurai";
			 double balance=20000.50;
			 account.setCustomerId(id);
			 account.setBalance(balance);
			 account.setBranch(branch);
			 int number=accountObj.addAccount(account);
			 System.out.println(number);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;

	 }
	 case 6:
	 {
		 try
		 {
			 int id=2;
			Map<Integer,AccountInfo> temp=accountObj.getAccountById(id);
			System.out.println(temp);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
	 case 7:
	 {
		 try
		 {
			 int id=2;
			 int acc_num=1000;
			 AccountInfo account=accountObj.getAccountByAccountNum(id, acc_num);
			 System.out.println(account);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
	 case 8:
	 {
		 try
		 {
			 int id=2;
			 int acc_num=1000;
			 double balance=accountObj.getBalance(id, acc_num);
			 System.out.println(balance);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
	 case 9:
	 {
		 try
		 {
			 int id=2;
			 int acc_num=1000;
			 int amount=1000;
			 boolean check=accountObj.withdraw(id, acc_num, amount);
			 System.out.println(check);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
	 case 10:
	 {
		 try
		 {
			 int id=2;
			 int acc_num=1000;
			 int amount=1000;
			 boolean check=accountObj.deposit(id, acc_num, amount);
			 System.out.println(check);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
	 case 11:
	 {
		 try
		 {
			 int id=2;
			 int acc_num=1000;
			 boolean active=false;
			 
			 boolean check=accountObj.changeStatus(id, acc_num, active);
			 System.out.println(check);
		 }
		 catch(Exception e)
			{
				System.out.println(e);
			}
			 break;
	 }
}
}
 catch(Exception e)
	{
		System.out.println(e);
	}
}
}
