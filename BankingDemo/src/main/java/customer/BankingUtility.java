package customer;

import java.util.HashMap;
import java.util.Map;

import account.AccountInfo;
import bankinginfo.validate.ValidateInput;
import customexception.CustomException;

public class BankingUtility {

	Map<Integer, CustomerInfo> customerMap = new HashMap<>();

	Map<Integer, Map<Integer, AccountInfo>> accountMap = new HashMap<>();

	ValidateInput validator = new ValidateInput();

	public void getMap(Map<Integer, CustomerInfo> customerDetails,
			Map<Integer, Map<Integer, AccountInfo>> accountDetails) throws CustomException {
		
		customerMap = customerDetails;
		accountMap = accountDetails;
	}

	/*
	 * public void defaultCustomer() { String[] name_arr=
	 * {"pratik","sathya","dev","aasha","akira"}; String[] gender_arr=
	 * {"Male","Male","Male","Female","Female"}; long[] mobile_arr=
	 * {984659841L,8130257081L,72359126L,9475819512L,921047598L};
	 * 
	 * for(int i=0;i<name_arr.length;i++) { CustomerInfo customer=new
	 * CustomerInfo();
	 * 
	 * int custID=generateCustomerId(); customer.setCustomerID(custID);
	 * customer.setCustomerName(name_arr[i]); customer.setGender(gender_arr[i]);
	 * customer.setMobileNum(mobile_arr[i]); customerMap.put(custID, customer);
	 * //System.out.println(customerMap); } }
	 * 
	 * public void defaultAccount()throws CustomException {
	 * 
	 * int[] customer_id={1,2,3,4,5}; String[] branch_arr=
	 * {"Karaikudi","Madurai","Trichy","Salem","Coimbatore"}; double[] balance_arr=
	 * {30000.90,25000,15000.25,50000.40,16000};
	 * 
	 * for(int i=0;i<branch_arr.length;i++) { Map<Integer,AccountInfo> tempMap=new
	 * HashMap<>(); checkCustomerExists(customer_id[i]);
	 * 
	 * AccountInfo account= new AccountInfo(); int account_id=getAccountNum();
	 * account.setCustomerId(customer_id[i]); account.setBalance(balance_arr[i]);
	 * account.setBranch(branch_arr[i]); int customerId=account.getCustomerId();
	 * 
	 * tempMap.put(account_id,account);
	 * 
	 * accountMap.put(customerId,tempMap); } //System.out.println(accountMap);
	 * 
	 * }
	 */

	public int addCustomer(CustomerInfo customerInfo, int customer_id) throws CustomException {
		validator.validate(customerInfo);

		// int id=generateCustomerId();
		customerMap.put(customer_id, customerInfo);
		return customer_id;
		// addAccountDetails(id,account);

	}

	public int addAccount(AccountInfo account, int acc_num) throws CustomException {
		validator.validate(account);

		int customer_id = account.getCustomerId();

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		if (tempMap == null) {
			tempMap = new HashMap<>();
			accountMap.put(customer_id, tempMap);
		}
		tempMap.put(acc_num, account);
		return acc_num;

	}

	public Map<Integer, CustomerInfo> showAllCustomers() {
		return customerMap;

	}

	public CustomerInfo getCustomerById(int customer_id) throws CustomException {
		validator.checkCustomerExists(customer_id, customerMap);

		return customerMap.get(customer_id);

	}

	public AccountInfo getAccountByAccountNum(int customer_id, int account_num) throws CustomException {

		validator.checkCustomerValid(customer_id, accountMap);
		validator.checkAccountExists(customer_id, account_num, accountMap);

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		AccountInfo account = tempMap.get(account_num);

		return account;

	}

	public Map<Integer, AccountInfo> getCustomerAccountsById(int customer_id) throws CustomException {
		validator.checkCustomerExists(customer_id, customerMap);

		return accountMap.get(customer_id);
	}

	public Map<Integer, Map<Integer, AccountInfo>> getAllCustomersAccount() {
		return accountMap;
	}

	public double getBalance(int customer_id, int acc_num) throws CustomException {
		validator.checkCustomerValid(customer_id, accountMap);
		validator.checkAccountExists(customer_id, acc_num, accountMap);

		double balance = 0.0;

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		AccountInfo accountNum = tempMap.get(acc_num);
		balance = accountNum.getBalance();
		return balance;

	}

	public boolean withdraw(int customer_id, int acc_num, double amount) throws CustomException {
		validator.checkCustomerValid(customer_id, accountMap);
		validator.checkAccountExists(customer_id, acc_num, accountMap);

		double total = 0.0;

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		AccountInfo accountNum = tempMap.get(acc_num);
		double balance = accountNum.getBalance();

		if (balance < amount) {
			throw new CustomException("please enter the amount less than your balance: " + balance);
		}

		total = balance - amount;

		accountNum.setBalance(total);
		return true;

	}

	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException {
		validator.checkCustomerValid(customer_id, accountMap);
		validator.checkAccountExists(customer_id, acc_num, accountMap);

		double total = 0.0;

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		AccountInfo accountNum = tempMap.get(acc_num);
		double balance = accountNum.getBalance();
		total = balance + amount;

		accountNum.setBalance(total);
		return true;

	}

	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException {
		validator.checkCustomerValid(customer_id, accountMap);
		validator.checkAccountExists(customer_id, acc_num, accountMap);

		Map<Integer, AccountInfo> tempMap = accountMap.get(customer_id);

		boolean result = false;

		// System.out.println("Activity before setting
		// :"+tempMap.get(acc_num).isActive());
		AccountInfo accountNum = tempMap.get(acc_num);
		accountNum.setActive(active);

		boolean activity = accountNum.isActive();

		if (!activity) {
			result = true;
		}

		return result;

	}

}
