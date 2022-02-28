package bankinginfo.runner;


import java.util.Map;
import java.util.Scanner;

import account.AccountInfo;
import bankinginfo.logic.BankingLogic;
import customer.CustomerInfo;


public class BankingRunner {
	static Scanner scanner= new Scanner(System.in);
	public static void main(String[] args) {
		BankingLogic demo = new BankingLogic();

		System.out.println("Enter the number between 1-10");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		switch (choice) {
		case 1: {
			try {
				
				System.out.println("Enter the number of customer to add");
				int number=scanner.nextInt();
				scanner.nextLine();
				for(int i=0;i<number;i++)
				{
				CustomerInfo customer = new CustomerInfo();
				System.out.println("Enter name of the customer");
				String name=scanner.nextLine();
				System.out.println("Enter gender");
				String gender=scanner.nextLine();
				System.out.println("Enter mobile num");
				long mob=scanner.nextLong();
				scanner.nextLine();
				customer.setCustomerName(name);
				customer.setGender(gender);
				customer.setMobileNum(mob);
				demo.addNewCustomer(customer);
				}
				

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 2: 
		{
			try {
				AccountInfo account = new AccountInfo();
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter branch");
				String branch=scanner.nextLine();
				System.out.println("Enter balance");
				double balance=scanner.nextDouble();
				account.setCustomerId(customerId);
				account.setBranch(branch);
				account.setBalance(balance);
				demo.addAccount(account);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 3: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				CustomerInfo customer=demo.getCustomerById(customerId);
				System.out.println(customer);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 4: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				Map<Integer,AccountInfo> account=demo.getAccountById(customerId);
				System.out.println(account);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 5: {
			try {
				Map<Integer,CustomerInfo> customer=demo.showAllCustomers();
				System.out.println(customer);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 6: {
			try {
				Map<Integer,Map<Integer,AccountInfo>> account=demo.showAllAccounts();
				System.out.println(account);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 7: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the account Number");
				int accountNum = scanner.nextInt();
				scanner.nextLine();
				double result = demo.getBalance(customerId, accountNum);
				System.out.println(result);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 8: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the account Number");
				int accountNum = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the amount to withdraw");
				int amount = scanner.nextInt();
				scanner.nextLine();
				boolean result=demo.withdraw(customerId, accountNum, amount);
				if(result)
				{
				System.out.println("Successfully withdrawn ");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 9: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the account Number");
				int accountNum = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the amount to withdraw");
				int amount = scanner.nextInt();
				scanner.nextLine();
				boolean result=demo.deposit(customerId, accountNum, amount);
				if(result)
				{
				System.out.println("Successfuly deposited ");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 10: {
			try {
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the account Number");
				int accountNum = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Set to inactive");
				boolean active=false;
					
				boolean result=demo.changeStatus(customerId, accountNum, active);
				if(result)
				{
				System.out.println("Successfuly set to inactive ");
				}
					
                 }

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		
		case 11:
		{
			try
			{
				System.out.println("Enter the customer id");
				int customerId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the account Number");
				int accountNum = scanner.nextInt();
				scanner.nextLine();
				AccountInfo account=demo.getAccountByAccountNum(customerId, accountNum);
				System.out.println(account);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		
		}
	}
}
	
		
		
