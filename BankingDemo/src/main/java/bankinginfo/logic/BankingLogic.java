package bankinginfo.logic;

import java.util.List;
import java.util.Map;
import java.util.Set;

import account.AccountInfo;
import bankingInfo.db.BankingDb;
import bankinginfo.property.LoadChoices;
import bankinginfo.storage.Storage;
import customer.BankingUtility;
import customer.CustomerInfo;
import customexception.CustomException;

// logical Layer

public class BankingLogic {

	Storage inter = null;
	LoadChoices choice = new LoadChoices();
	BankingUtility cache = new BankingUtility();

	public BankingLogic() {
		getInstance();
		readDetails();
	}

	public void getInstance() {
		try {
//			String name = choice.selectChoice();
//			Class<?> className = Class.forName(name);
//			Constructor<?> construct = className.getConstructor();
//			Object tempObj = construct.newInstance();
			inter = (Storage) new BankingDb();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readDetails() {
		try {
			Map<Integer, CustomerInfo> customerMap = inter.callReadCustomer();
			Map<Integer, Map<Integer, AccountInfo>> accountMap = inter.callReadAccount();
			//System.out.println("Accountmap in logic"+accountMap);
			cache.getMap(customerMap, accountMap);
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public Map<String,Integer> loginDetails(String user,String pass)throws CustomException
	{
		return inter.loginDetails(user, pass);
	}

	public void addNewCustomer(CustomerInfo customer) throws CustomException {
		int id = inter.addNewCustomer(customer);
		cache.addCustomer(customer, id);
	}

	public void addAccount(AccountInfo account) throws CustomException {
		int acc_num = inter.addAccount(account);
		//System.out.println("Logical layer "+account);
		cache.addAccount(account, acc_num);
	}

	public CustomerInfo getCustomerById(int customer_id) throws CustomException {
		return cache.getCustomerById(customer_id);
	}
	
	public void updateCustomer(CustomerInfo customer)throws CustomException
	{
		 CustomerInfo customerr=inter.updateCustomer(customer);
		 int cust_id=customerr.getCustomerID();
		 cache.addCustomer(customerr, cust_id);
	}
	
	public boolean changeCustomerStatus(int customerId,boolean active)throws CustomException
	{
		inter.changeCustomerStatus(customerId, active);
		return cache.changeCustomerStatus(customerId,active);
	}
	
	public Map<Integer,CustomerInfo> getActiveCustomers()throws CustomException
	{
		return inter.getActiveCustomers();
	}
	
	public Map<Integer,CustomerInfo> getInactiveCustomers()throws CustomException
	{
		return inter.getInactiveCustomers();
	}
	
	public List<String> getAllBranches()throws CustomException
	{
		return inter.getAllBranches();
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> getActiveAccounts()throws CustomException
	{
		return inter.getActiveAccounts();
	}
	public Map<Integer,Map<Integer,AccountInfo>> getInactiveAccounts()throws CustomException
	{
		return inter.getInactiveAccounts();
		//return cache.getInactiveAccounts();
	}
	
	public void updateAccount(AccountInfo account)throws CustomException
	{
		AccountInfo accountt=inter.updateAccount(account);
		int acc_num=accountt.getAccountNum();
		cache.addAccount(accountt, acc_num);	
	}

	public Map<Integer, AccountInfo> getAccountById(int customer_id) throws CustomException {

		return cache.getCustomerAccountsById(customer_id);
	}

	public Map<Integer, CustomerInfo> showAllCustomers() throws CustomException {
		return cache.showAllCustomers();
	}

	public AccountInfo getAccountByAccountNum(int customer_id, int account_num) throws CustomException {
		return cache.getAccountByAccountNum(customer_id, account_num);
	}

	public Map<Integer, Map<Integer, AccountInfo>> showAllAccounts() throws CustomException {
		return cache.getAllCustomersAccount();
	}

	public double getBalance(int customer_id, int account_num) throws CustomException {
		double balance=inter.getBalance(customer_id, account_num);
		AccountInfo account=new AccountInfo();
		account.setBalance(balance);
		return cache.addAccount(account, account_num);
	}

	public boolean withdraw(int customer_id, int acc_num, double amount) throws CustomException {
		inter.withdraw(customer_id, acc_num, amount);
		return cache.withdraw(customer_id, acc_num, amount);

	}

	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException {
		inter.deposit(customer_id, acc_num, amount);
		return cache.deposit(customer_id, acc_num, amount);
	}

	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException {
	
		inter.changeStatus(customer_id, acc_num, active);
		
		return cache.changeStatus(customer_id, acc_num, active);
	}
	

}
