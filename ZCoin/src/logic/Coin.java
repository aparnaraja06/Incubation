package logic;

import java.util.List;
import java.util.Map;

import account.Account;
import customexception.CustomException;
import operation.Operation;
import transaction.Transaction;
import user.User;

public class Coin {
	
	Operation reader=new Operation();
	
	public Coin()
	{
		reader.addDefaultCustomer();
		reader.addDefaultAdmin();
		reader.addDefaultAccount();
	}
	
	public int addCustomer(User user)
	{
		return reader.addCustomer(user);
	}
	
	public int addAccount(User user)
	{
		return reader.addAccount(user);
	}
	
	public void putInWaiting(User user)
	{
		reader.putInWaiting(user);
	}
	
	public User getUser(String mail)
	{
		return reader.getUser(mail);
	}
	
	public void updateUser(User user)
	{
		reader.updateUser(user);
	}
	
	public String login(String mail,String pass)
	{
		return reader.login(mail, pass);
	}
	
	public void setZCoinRate(double amount)
	{
		reader.setZCoinRate(amount);
	}
	
	public double getZCoinRate()
	{
		return reader.getZCoinRate();
	}
	
	public boolean passwordValidation(String pass,String name,String mail,long mobile)
	{
		return reader.passwordValidation(pass, name, mail, mobile);
	}
	
	public boolean checkPassword(String pass1,String pass2)
	{
		return reader.checkPassword(pass1, pass2);
	}
	
	public List<User> getWaitingUser()
	{
		return reader.getWaitingUser();
	}
	
	public Map<String,List<Transaction>> getHistory()
	{
		return reader.getHistory();
	}
	
	public List<Transaction> showTransaction(String mail)
	{
		return reader.showTransaction(mail);
	}
	
	public Account userWallets(int account_num)
	{
		return reader.userWallets(account_num);
	}
	
	public Map<Integer,Account> allAccounts()
	{
		return reader.allAccounts();
	}
	
	public double withdrawRC(int account_num,double rCCoin)throws CustomException
	{
		return reader.withdrawRC(account_num, rCCoin);
	}
	public double depositRC(int account_num,double rCCoin)
	{
		return reader.depositRC(account_num, rCCoin);
	}
	
	public double transfer(String mail,int fromAccount,int toAccount,double amount)throws CustomException
	{
		return reader.transfer(mail, fromAccount, toAccount, amount);
	}
	
	public boolean buyZCoin(int account_num,double zCoin)throws CustomException
	{
		return reader.buyZCoin(account_num, zCoin);
	}
	public double withdrawZcToRc(int account_num,double amount)throws CustomException
	{
		return reader.withdrawZcToRc(account_num, amount);
	}
	
	public int getAccountNum(String mail)
	{
		return reader.getAccountNum(mail);
	}



}
