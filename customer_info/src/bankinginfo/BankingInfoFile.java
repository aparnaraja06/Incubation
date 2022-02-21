package bankinginfo;

import java.util.HashMap;
import java.util.Map;

import account.AccountInfo;
import bankinginfo.file.FileDemo;
import bankinginfo.storage.Storage;
import bankinginfo.validate.ValidateInput;
import customer.CustomerInfo;

import customexception.CustomException;

//utility Layer

public class BankingInfoFile implements Storage 
{
	FileDemo demo = new FileDemo();
	ValidateInput validator=new ValidateInput();

	private int customer_id = 0;
	private int acc_num = 1000;



	public Map<Integer,CustomerInfo> callReadCustomer() throws CustomException 
	{
		Map<Integer, CustomerInfo> customerDetails = demo.readCustomer();
		return customerDetails;
	}

	public Map<Integer,Map<Integer,AccountInfo>> callReadAccount() throws CustomException
	{
		Map<Integer,Map<Integer,AccountInfo>> accountDetails = demo.readAccount();
		return accountDetails;
	}

	/*public void addCustomers() throws CustomException 
	{
		Map<Integer,CustomerInfo> customerDetails=callReadCustomer();

		String[] names = { "pratik", "sathya", "dev", "aasha", "akira" };
		String[] gender = { "Male", "Male", "Male", "Female", "Female" };
		long[] mobile = { 984659841L, 8130257081L, 72359126L, 9475819512L, 921047598L };

		for (int i = 0; i < names.length; i++) 
		{
			CustomerInfo customer = new CustomerInfo();
			
			customer_id = demo.generateCustomerId();
			customer.setCustomerName(names[i]);
			customer.setGender(gender[i]);
			customer.setMobileNum(mobile[i]);
			
			customerDetails.put(customer_id, customer);
		}
		demo.writeCustomer(customerDetails, customer_id);

		// System.out.println(customerDetails);
	}

	public void addAccounts() throws CustomException 
	{
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		int[] id = { 1, 2, 3, 4, 5 };
		String[] branch = { "Karaikudi", "Madurai", "Trichy", "Salem", "Coimbatore" };
		double[] balance = { 30000.90, 25000, 15000.25, 50000.40, 16000 };

		for (int i = 0; i < id.length; i++) 
		{
			Map<Integer, AccountInfo> tempMap = new HashMap<>();
			
			AccountInfo account = new AccountInfo();
			
			acc_num = demo.generateAccountNum();
			account.setCustomerId(id[i]);
			account.setBranch(branch[i]);
			account.setBalance(balance[i]);
			
			tempMap.put(acc_num, account);
			
			accountDetails.put(id[i], tempMap);

		}

		demo.writeAccount(accountDetails, acc_num);

		// System.out.println(accountDetails);
	}*/

	public int addNewCustomer(CustomerInfo customer) throws CustomException 
	{
		validator.validate(customer);
		
		Map<Integer,CustomerInfo> customerDetails=callReadCustomer();

		customer_id = demo.generateCustomerId();
		
		customerDetails.put(customer_id, customer);
		
		demo.writeCustomer(customerDetails, customer_id);
		
		return customer_id;
		// System.out.println(customerDetails);
	}

	public int addAccount( AccountInfo account)
			throws CustomException
	{
		validator.validate(account);
		
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		int customer_id=account.getCustomerId();

		Map<Integer, AccountInfo> tempMap = accountDetails.get(customer_id);
		
		acc_num = demo.generateAccountNum();
		
		if (tempMap == null) 
		{
			tempMap = new HashMap<>();
			accountDetails.put(customer_id, tempMap);
		}
		tempMap.put(acc_num, account);

		demo.writeAccount(accountDetails, acc_num);
		
		return acc_num;

		// System.out.println(accountDetails);
	}

	public CustomerInfo getCustomerById(int customer_id) throws CustomException 
	{
		
		Map<Integer,CustomerInfo> customerDetails=callReadCustomer();
		
		validator.checkCustomerExists(customer_id,customerDetails);

		CustomerInfo values = customerDetails.get(customer_id);
		
		return values;
		// System.out.println(values);

	}

	public Map<Integer, AccountInfo> getAccountById(int customer_id) throws CustomException 
	{
		
		
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		validator.checkCustomerValid(customer_id,accountDetails);
		
		Map<Integer, AccountInfo> account_details = accountDetails.get(customer_id);
		
		return account_details;
		// System.out.println(account_details);

	}

	public Map<Integer, CustomerInfo> showAllCustomers() throws CustomException {

		Map<Integer,CustomerInfo> customerDetails=callReadCustomer();
		
		return customerDetails;
		// System.out.println(customerDetails);
	}

	public Map<Integer, Map<Integer, AccountInfo>> showAllAccounts() throws CustomException {

		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		return accountDetails;
		// System.out.println(accountDetails);

	}
	public AccountInfo getAccountByAccountNum(int customer_id, int account_num) throws CustomException
	{
		
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		validator.checkCustomerValid(customer_id,accountDetails);
		validator.checkAccountExists(customer_id, account_num,accountDetails);
		
		Map<Integer, AccountInfo> tempMap = accountDetails.get(customer_id);

		AccountInfo account = tempMap.get(account_num);

		return account;

	}

	public double getBalance(int customer_id, int account_num) throws CustomException 
	{
	
		AccountInfo account = getAccountByAccountNum(customer_id, account_num);
		
		double balance = account.getBalance();
		return balance;
	}

	public boolean withdraw(int customer_id, int accNum, double amount) throws CustomException 
	{
		

		AccountInfo account = getAccountByAccountNum(customer_id, accNum);
		
		double balance = getBalance(customer_id, accNum);
		if (balance < amount)
		{
			throw new CustomException("please enter the amount less than your balance: " + balance);
		}
		double total = balance - amount;

		account.setBalance(total);
		return true;
		}
		
		
		
		
		
		// return total;
		// System.out.println(total);




	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException 
	{

		AccountInfo account = getAccountByAccountNum(customer_id, acc_num);
		
		double balance = getBalance(customer_id, acc_num);
		double total = balance + amount;
		
		account.setBalance(total);
		return true;
		// System.out.println(total);

	}

	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException 
	{
		
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=callReadAccount();
		
		validator.checkCustomerValid(customer_id,accountDetails);
		validator.checkAccountExists(customer_id, acc_num,accountDetails);

		Map<Integer, AccountInfo> tempMap = accountDetails.get(customer_id);
		
		boolean result = false;
		
		AccountInfo account = tempMap.get(acc_num);
		account.setActive(active);

		boolean activity = account.isActive();
		
		if (!activity) 
		{
			result = true;
		}
		return result;
		// System.out.println(result);
	}

}