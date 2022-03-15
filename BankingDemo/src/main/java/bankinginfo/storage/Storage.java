package bankinginfo.storage;

import java.util.List;
import java.util.Map;


import account.AccountInfo;
import customer.CustomerInfo;
import customexception.CustomException;

public interface Storage 
{
	public Map<String,Integer> loginDetails(String user,String pass)throws CustomException;
	
	public Map<Integer,CustomerInfo> callReadCustomer()throws CustomException;
	
	public Map<Integer,Map<Integer,AccountInfo>> callReadAccount()throws CustomException;
	
	public int addNewCustomer(CustomerInfo customer)throws CustomException;
	
	public int addAccount(AccountInfo account)throws CustomException;
	
	public CustomerInfo getCustomerById(int customer_id)throws CustomException;
	
	public CustomerInfo updateCustomer(CustomerInfo customer)throws CustomException;
	
	public AccountInfo updateAccount(AccountInfo account)throws CustomException;
	
	public Map<Integer, AccountInfo> getAccountById(int customer_id)throws CustomException;
	
	public Map<Integer, CustomerInfo> showAllCustomers()throws CustomException;
	
	public Map<Integer,CustomerInfo> getActiveCustomers()throws CustomException;
	
	public Map<Integer,CustomerInfo> getInactiveCustomers()throws CustomException;
	
	public List<String> getAllBranches()throws CustomException;
	
	public Map<Integer, Map<Integer, AccountInfo>> showAllAccounts()throws CustomException;
	
	public Map<Integer,Map<Integer,AccountInfo>> getInactiveAccounts()throws CustomException;
	
	public Map<Integer,Map<Integer,AccountInfo>> getActiveAccounts()throws CustomException;
	
	public AccountInfo getAccountByAccountNum(int customer_id, int account_num)throws CustomException;
	
	public double getBalance(int customer_id, int account_num)throws CustomException;
	
	public boolean changeCustomerStatus(int customer_id,boolean active)throws CustomException;
	
	public boolean withdraw(int customer_id, int accNum, double amount)throws CustomException;
	
	public boolean deposit(int customer_id, int acc_num, double amount)throws CustomException;
	
	public boolean changeStatus(int customer_id, int acc_num, boolean active)throws CustomException;
	
}
