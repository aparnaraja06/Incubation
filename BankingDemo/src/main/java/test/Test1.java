/*package test;

import java.io.BufferedReader;
//import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
//import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import java.util.Scanner;

import account.AccountInfo;
import customer.BankingUtility;
import customer.CustomerInfo;

public class Test1 {
	static Scanner scanner= new Scanner(System.in);
	BankingUtility customer1= new BankingUtility();
	
	

	public void addCustomers() {

		try(FileWriter fWriter= new FileWriter("customer.properties");
				BufferedWriter bWriter= new BufferedWriter(fWriter))
		{
			
			String[] name_arr= {"pratik","sathya","dev","aasha","akira"};
			String[] gender_arr= {"Male","Male","Male","Female","Female"};
			long[] mob_arr= {984659841L,8130257081L,72359126L,9475819512L,921047598L};
			CustomerInfo customer= new CustomerInfo();
			for(int i=0;i<name_arr.length;i++)
			{
			int id=customer1.generateCustomerId();
			customer.setCustomerName(name_arr[i]);
			customer.setGender(gender_arr[i]);
			customer.setMobileNum(mob_arr[i]);
			Properties customerDetails= new Properties();
			
			
			customerDetails.setProperty(String.valueOf(id),customer.toString());
			customerDetails.store(bWriter," ");
			//System.out.println(customerDetails);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void addAccounts() {
		try(FileWriter fWriter= new FileWriter("account.properties");
				BufferedWriter bWriter= new BufferedWriter(fWriter))
		{
			
			
			int[] id_arr= {1,2,3,4,5};
			String[] branch_arr= {"Karaikudi","Madurai","Trichy","Salem","Coimbatore"};
			double[] balance_arr= {30000.90,25000,15000.25,50000.40,16000};
			AccountInfo account= new AccountInfo();
			for(int i=0;i<branch_arr.length;i++)
			{
				int acc_num=customer1.getAccountNum();
				account.setBranch(branch_arr[i]);
				account.setBalance(balance_arr[i]);
				Properties tempProperty=new Properties();
				tempProperty.setProperty(String.valueOf(acc_num), account.toString());
				
				Properties accountDetails = new Properties();
				accountDetails.setProperty(String.valueOf(id_arr[i]), tempProperty.toString());
				accountDetails.store(bWriter, " ");
				//System.out.println(accountDetails);
			}
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	public void addCustomer(CustomerInfo customer) {
		try(FileWriter fWriter= new FileWriter("customer.properties",true);
				BufferedWriter bWriter= new BufferedWriter(fWriter))
		{
			Properties customerDetails= new Properties();
		//	CustomerUtility custom= new CustomerUtility();
			int id=customer1.generateCustomerId();
			
			customerDetails.setProperty(String.valueOf(id), customer.toString());
			customerDetails.store(bWriter, " ");
			
			//customerDetails.containsKey(id);
			
			//System.out.println(customerDetails);	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public String getCustomerInfoById(int customer_id) {
		try(FileReader fWriter= new FileReader("customer.properties");
				BufferedReader bWriter= new BufferedReader(fWriter))
		{
			Properties customerDetails= new Properties();
			customerDetails.load(bWriter);
			String values=customerDetails.getProperty(String.valueOf(customer_id));
			return values;
			//System.out.println(values);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public String getAccountInfoById(int customer_id) {
		try(FileReader fWriter= new FileReader("account.properties");
				BufferedReader bWriter= new BufferedReader(fWriter))
		{
			Properties accountDetails= new Properties();
			accountDetails.load(bWriter);
			String values=accountDetails.getProperty(String.valueOf(customer_id));
			return values;
			//System.out.println(values);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public String getBalance(int customer_id,int account_num) {
		try(FileReader fWriter= new FileReader("account.properties");
				BufferedReader bWriter= new BufferedReader(fWriter))
		{
			Properties accountDetails= new Properties();
			accountDetails.load(bWriter);
			String values=accountDetails.getProperty(String.valueOf(customer_id));
			String value=values.replace("="," ");
			String[] words=value.split(" ");
			String balance="";
			for(int i=0;i<words.length;i++)
			{
				balance=words[1];
			}
			return balance;
			//System.out.println(balance);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
	public void withdraw(int customer_id,int account_num,double amount) {
		try(FileReader fWriter= new FileReader("account.properties");
				BufferedReader bWriter= new BufferedReader(fWriter))
		{
			Properties accountDetails= new Properties();
			accountDetails.load(bWriter);
			double total=0.0;
			String balance=getBalance(customer_id,account_num);
			double result=Double.parseDouble(balance);
			if(result<amount)
			{
				System.out.println("please enter the amount less than your balance: "+result);
			}
			total=result-amount;
			System.out.println(total);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void deposit(int customer_id,int account_num,double amount)
	{
		try(FileReader fWriter= new FileReader("account.properties");
				BufferedReader bWriter= new BufferedReader(fWriter))
		{
			Properties accountDetails= new Properties();
			accountDetails.load(bWriter);
			double total=0.0;
			String balance=getBalance(customer_id,account_num);
			double result=Double.parseDouble(balance);
			total=result+amount;
			System.out.println(total);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
			
	}

public static void main(String[] args)
{
	Test1 test= new Test1();
	System.out.println("Enter number between 1-10");
	int choice=scanner.nextInt();
	scanner.nextLine();
	switch(choice)
	{
	case 1:
	{
	test.addCustomers();
	}
	case 2:
	{
	test.addAccounts();
	}
	case 3:
	{
		CustomerInfo customer= new CustomerInfo();
		customer.setCustomerName("meera");
		customer.setGender("Female");
		customer.setMobileNum(892658912L);
	test.addCustomer(customer);
	}
	case 4:
	{
		int number=3;
		
	String result=test.getCustomerInfoById(number);
	System.out.println(result);
	}
	case 5:
	{
		int number=3;
	String result=test.getAccountInfoById(number);
	System.out.println(result);
	}
	case 6:
	{
		int customer_id=3;
		int acc_num=1003;
	String values=test.getBalance(customer_id,acc_num);
	System.out.println(values);
	}
	case 7:
	{
		int customer_id=3;
		int acc_num=1003;
		int amount=1000;
		test.withdraw(customer_id, acc_num, amount);
		//System.out.println(valu)
	}
	case 8:
	{
		int customer_id=3;
		int acc_num=1003;
		int amount=1000;
		test.deposit(customer_id, acc_num, amount);
	}
	}
}
}*/
	

