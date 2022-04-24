package logic;

import java.util.List;

import account.Account;
import customexception.CustomException;
import loan.LoanInfo;
import netbanking.BankingOperations;
import transaction.TransactionInfo;
import user.User;

public class LogicalLayer {

	BankingOperations logic=new BankingOperations();
	
	public LogicalLayer() {
		addDefault();
	}
	public void addDefault() {
		logic.addDefaultCustomers();
		logic.addDefaultAccounts();
		logic.addDefaultAdmin();
	}
	
	public long addCustomer(User customer) throws CustomException
	{
		return logic.addCustomer(customer);
	}
	
	public String newUserLogin(long cust_id) throws CustomException
	{
		return logic.newUserLogin(cust_id);
	}
	
	public String updateUserId(User customer) throws CustomException
	{
		return logic.updateUserIdPass(customer);
	}
	
	public long addAccount(Account account) throws CustomException
	{
		return logic.addAccount(account);
	}
	
	public String login(User customer) throws CustomException
	{
		return logic.login(customer);
	}
	
	public List<Long> getAccountById(long cust_id) throws CustomException
	{
		return logic.getAccountsById(cust_id);
	}
	
	public double getBalance(long acc_num) throws CustomException
	{
		return logic.getBalance(acc_num);
	}
	
	public boolean transfer(long fromAcc,long toAcc,double amount) throws CustomException
	{
		return logic.transfer(fromAcc, toAcc, amount);
	}
	
	public Account getAccountDetails(long acc_num) throws CustomException
	{
		return logic.getAccountDetails(acc_num);
	}
	
	public List<TransactionInfo> getHistory(long acc_num) throws CustomException
	{
		return logic.getHistory(acc_num);
	}
	
	public boolean applyLoan(LoanInfo loan) throws CustomException
	{
		return logic.applyLoan(loan);
	}
	
	public String checkStatus(long acc_num,String type) throws CustomException
	{
		return logic.checkStatus(acc_num,type);
	}
	
	public boolean updateStatus(long acc_num,String type,String status)throws CustomException
	{
		return logic.updateStatus(acc_num, type, status);
	}
	
	public List<Long> getAllAccounts()throws CustomException
	{
		return logic.getAllAccounts();
	}
	
	public double withdraw(long acc_num,double amount)throws CustomException
	{
		return logic.withdraw(acc_num,amount);
	}
	
}
