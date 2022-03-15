package bankingInfo.db;

import java.util.List;
import java.util.Map;


import account.AccountInfo;
import bankinginfo.storage.Storage;
import bankinginfo.validate.ValidateInput;
import customer.CustomerInfo;
import customexception.CustomException;
import login.db.LoginDao;

public class BankingDb implements Storage
{
	ValidateInput validator=new ValidateInput();
	CustomerDb customerDb=new CustomerDb();
	AccountDb accountDb=new AccountDb();
	LoginDao login=new LoginDao();

	@Override
	public int addNewCustomer(CustomerInfo customer) throws CustomException 
	{
		validator.validate(customer);
		int id=customerDb.addCustomer(customer);
		return id;
	}

	@Override
	public int addAccount(AccountInfo account) throws CustomException 
	{
		int id=accountDb.addAccount(account);
		return id;
	}

	@Override
	public CustomerInfo getCustomerById(int customer_id) throws CustomException 
	{
		CustomerInfo customer=customerDb.getCustomerById(customer_id);
		return customer;
	}

	@Override
	public Map<Integer, AccountInfo> getAccountById(int customer_id) throws CustomException 
	{
		Map<Integer,AccountInfo> account=accountDb.getAccountById(customer_id);
		return account;
	}

	@Override
	public Map<Integer, CustomerInfo> showAllCustomers() throws CustomException 
	{
		Map<Integer,CustomerInfo> customerMap=customerDb.showAllCustomers();
		return customerMap;
	}

	@Override
	public Map<Integer, Map<Integer, AccountInfo>> showAllAccounts() throws CustomException 
	{
		Map<Integer, Map<Integer, AccountInfo>> accountMap=accountDb.showAllAccounts();
		return accountMap;
	}

	@Override
	public AccountInfo getAccountByAccountNum(int customer_id, int account_num) throws CustomException
	{
		AccountInfo account=accountDb.getAccountByAccountNum(customer_id, account_num);
		return account;
	}

	@Override
	public double getBalance(int customer_id, int account_num) throws CustomException 
	{
		double balance=accountDb.getBalance(customer_id, account_num);
		return balance;
	}

	@Override
	public boolean withdraw(int customer_id, int accNum, double amount) throws CustomException 
	{
		boolean check=accountDb.withdraw(customer_id, accNum, amount);
		return check;
	}

	@Override
	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException 
	{
		boolean check=accountDb.deposit(customer_id, acc_num, amount);
		return check;
	}

	@Override
	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException 
	{
		boolean check=accountDb.changeStatus(customer_id, acc_num, active);
		return check;
	}

	@Override
	public Map<Integer, CustomerInfo> callReadCustomer() throws CustomException 
	{
		customerDb.createTable();
		Map<Integer,CustomerInfo> customerDetails=showAllCustomers();
		return customerDetails;
	}

	@Override
	public Map<Integer, Map<Integer, AccountInfo>> callReadAccount() throws CustomException 
	{
		accountDb.createTable();
		Map<Integer,Map<Integer,AccountInfo>> accountDetails=showAllAccounts();
		
		return accountDetails;
	}
	

	@Override
	public CustomerInfo updateCustomer(CustomerInfo customer) throws CustomException {
		return customerDb.updateCustomer(customer);
	}

	@Override
	public AccountInfo updateAccount(AccountInfo account) throws CustomException {
		return accountDb.updateAccount(account);
	}

	@Override
	public boolean changeCustomerStatus(int customer_id, boolean active) throws CustomException {
		return customerDb.changeCustomerStatus(customer_id, active);
	}

	@Override
	public Map<Integer,Map<Integer,AccountInfo>> getInactiveAccounts() throws CustomException {
		return accountDb.getInactiveAccounts();
	}

	@Override
	public Map<Integer, Map<Integer, AccountInfo>> getActiveAccounts() throws CustomException {
		return accountDb.getActiveAccounts();
	}

	@Override
	public Map<Integer, CustomerInfo> getActiveCustomers() throws CustomException {
		return customerDb.getActiveCustomers();
	}

	@Override
	public Map<Integer, CustomerInfo> getInactiveCustomers() throws CustomException {
		return customerDb.getInactiveCustomers();
	}

	@Override
	public Map<String, Integer> loginDetails(String user,String pass) throws CustomException {
		return login.loginDetails(user,pass);
	}

	@Override
	public List<String> getAllBranches() throws CustomException {
		return accountDb.getAllBranches();
	}


}
