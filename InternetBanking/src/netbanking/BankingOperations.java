package netbanking;

import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import account.Account;
import customexception.CustomException;
import loan.LoanInfo;
import loan.LoanOperations;
import login.Login;
import transaction.Transaction;
import transaction.TransactionInfo;
import user.User;
import validate.Validate;

public class BankingOperations {
    
	private long customerId=220100;
	private long accountNum=63000100;
			
	Map<Long,User>  userMap=new HashMap<>();
	Map<Long,List<Long>> customerIdMap=new HashMap<>();
	Map<Long,Account> accountMap=new HashMap<>();
	List<Long> storeAccounts=new ArrayList<>();
	Map<Long,List<TransactionInfo>> transferMap=new HashMap<>();
	Map<Long,Map<String,LoanInfo>> loanMap=new HashMap<>();
	
	//Map<Long,LoginInfo> loginMap=new HashMap<>();
    Validate validator=new Validate();
    
	public long generateCustomerId() {
		return ++customerId;
	}
    
	public long generateAccountNum() {
		return ++accountNum;
	}	
	
	public String generatePass() {
		return "Premium";
	}
    
	public void addDefaultCustomers()
	{
		String[] names= {"Kartik","Sam","Preethi","Keerthi","Anwar"};
		String[] gender= {"Male","Male","Female","Female","Male"};
		String[] location= {"Trichy","Mumbai","Agra","Palakad","Cochin"};
		long[] mobileNum= {9847592784L,9172834922L,9281789264L,7231458355L,8912748164L};
		String[] password= {"pass1","pass2","pass3","pass4","pass5"};
		
		for(int i=0;i<names.length;i++)
		{
			User user=new User();
			long cust_id=generateCustomerId();
			//user.setCustomerId(cust_id);
			user.setName(names[i]);
			user.setGender(gender[i]);
			user.setLocation(location[i]);
			user.setMobileNum(mobileNum[i]);
			user.setPassword(password[i]);
			
			userMap.put(cust_id, user);
			
		}
		
	}
	
	public void addDefaultAccounts() {
		
		long[] cust_id= {220101L,220102L,220103L,220104L,220105L};
		String[] branch= {"Trichy","Mumbai","Agra","Palakad","Cochin"};
		double[] balance= {20000,15000.50,45000,60500,47852.30};
		
		for(int i=0;i<cust_id.length;i++)
		{
			Account account=new Account();
						
			long accountNum=generateAccountNum();
			account.setCustomerId(cust_id[i]);
			account.setBranch(branch[i]);
			account.setBalance(balance[i]);
            long customer_id=account.getCustomerId();
			
            List<Long> list=new ArrayList<>();
            list.add(accountNum);
            storeAccounts.add(accountNum);
			customerIdMap.put(customer_id, list);
			accountMap.put(accountNum, account);
		}
	}
	public void addDefaultAdmin() {
		long admin_id=000001;
		String[] pass= {"Admin1","Admin2","Admin3","Admin4","Admin5"};
		
		for(int i=0;i<pass.length;i++)
		{
			User customer =new User();
			
			customer.setCustomerId(admin_id);
			customer.setPassword(pass[i]);
			long id=customer.getCustomerId();
			
			userMap.put(id, customer);
		}
		
	}
	
	public String login(User customer)throws CustomException
	{
		validator.checkPojo(customer);
		
		Login loginobj=new Login();
		String result=loginobj.login(customer, userMap);
		//System.out.println(userMap);
		return result;
		
	}
	
	public List<Long> getAllAccounts()throws CustomException
	{
		return storeAccounts;
	}
	 public List<Long> getAccountsById(long cust_id)throws CustomException
	 {
		 validator.checkCustomerExists(cust_id, userMap);
		 validator.checkValidCustomer(cust_id, customerIdMap);
		 List<Long> list=customerIdMap.get(cust_id);
		 return list;
	 }
	
	public long addAccount(Account account)throws CustomException
	{
		validator.checkPojo(account);
		long acc_num=generateAccountNum();
         long cust_id=account.getCustomerId();
		   accountMap.put(acc_num, account);
			
			if(customerIdMap.get(cust_id)!=null)
			{
				List<Long> listt=customerIdMap.get(cust_id);
				listt.add(acc_num);
				customerIdMap.put(cust_id, listt);
			}
		else
		{
			List<Long> list=new ArrayList<>();
			list.add(acc_num);
			customerIdMap.put(cust_id, list);
			
		}
			
		storeAccounts.add(acc_num);
		return acc_num;
		
		
	}
	
	
	public double getBalance(Long account_num)throws CustomException
	{
		//validateCustomer(customer_id);
		validator.checkAccountExists(account_num, accountMap);
		Transaction transfer=new Transaction();
		
		double balancee=transfer.getBalance(account_num, accountMap);
		return balancee;
		
	}
	
	public double withdraw(Long acc_num,double amount)throws CustomException
	{
		validator.checkAccountExists(accountNum, accountMap);
		validator.validate(amount);
		Transaction transfer=new Transaction();
		return transfer.withdraw(acc_num, amount, accountMap);
		
	}
	
	public boolean deposit(Long acc_num,double amount)throws CustomException
	{
		validator.checkAccountExists(accountNum, accountMap);
		validator.validate(amount);
		Transaction transfer=new Transaction();
        return transfer.deposit(acc_num, amount, accountMap);
		
	}
	
	public boolean transfer(long fromAccount,long toAccount,double amount)throws CustomException
	{
		//System.out.println(accountMap);
		validator.checkAccountExists(fromAccount, accountMap);
		validator.checkAccountExists(toAccount, accountMap);
		validator.validate(amount);
		Transaction transferr=new Transaction();
	
		transferMap=transferr.transfer(fromAccount, toAccount, amount, accountMap,transferMap
				                                                                   );
		 return true;
	}
	
	public long addCustomer(User customer)throws CustomException
	{
		validator.checkPojo(customer);
		long cust_id=generateCustomerId();
		
		userMap.put(cust_id, customer);
		return cust_id;
		
	}
	
	public String newUserLogin(long cust_id)throws CustomException
	{
		validator.checkCustomerExists(cust_id, userMap);
		String pass=generatePass();
		
        User customer=new User();
		
		customer.setCustomerId(cust_id);
		customer.setPassword(pass);
		
		Login login=new Login();
		return login.createLogin(customer, userMap);
	}
	
	public String updateUserIdPass(User customer)throws CustomException
	{
		validator.checkPojo(customer);
		Login login=new Login();
		return login.createLogin(customer, userMap);
	}
		
	public List<TransactionInfo> getHistory(long acc_num)throws CustomException
	{
		validator.checkAccountExists(acc_num, accountMap);
		Transaction transfer=new Transaction();
		
		List<TransactionInfo> list=transfer.getHistory(acc_num,transferMap);
		return list;
	}
	
	public Account getAccountDetails(long acc_num)throws CustomException
	{
		validator.checkAccountExists(acc_num, accountMap);
		Account info=accountMap.get(acc_num);
		return info;
	}
	
	public boolean applyLoan(LoanInfo loan)throws CustomException
	{
		validator.checkPojo(loan);
		LoanOperations change=new LoanOperations();
		loanMap=change.applyLoan(loan, loanMap);
		return true;
	}
	
	public String checkStatus(long acc_num,String type)throws CustomException
	{
		validator.checkAccountExists(acc_num, accountMap);
		LoanOperations change=new LoanOperations();
        return change.checkStatus(acc_num, type,loanMap);
	}
	
	public boolean updateStatus(long acc_num,String type,String status)throws CustomException
	{
		validator.checkAccountExists(acc_num, accountMap);
		LoanOperations change=new LoanOperations();
		return change.updateStatus(acc_num, loanMap, type, status);
	}
}
