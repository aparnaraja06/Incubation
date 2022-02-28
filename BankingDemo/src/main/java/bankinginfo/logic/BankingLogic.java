package bankinginfo.logic;

import java.util.Map;

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
			cache.getMap(customerMap, accountMap);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void addNewCustomer(CustomerInfo customer) throws CustomException {
		int id = inter.addNewCustomer(customer);
		cache.addCustomer(customer, id);
	}

	public void addAccount(AccountInfo account) throws CustomException {
		int acc_num = inter.addAccount(account);
		cache.addAccount(account, acc_num);
	}

	public CustomerInfo getCustomerById(int customer_id) throws CustomException {
		return cache.getCustomerById(customer_id);
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
		return inter.getBalance(customer_id, account_num);
	}

	public boolean withdraw(int customer_id, int acc_num, double amount) throws CustomException {
		return inter.withdraw(customer_id, acc_num, amount);

	}

	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException {
		return inter.deposit(customer_id, acc_num, amount);
	}

	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException {
		return inter.changeStatus(customer_id, acc_num, active);
	}

}
