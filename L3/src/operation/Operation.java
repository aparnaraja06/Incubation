package operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import account.Account;
import transaction.Transaction;
import user.User;

public class Operation {
	
	private int id=1000;
	private double zCoin=50;
	
	Map<String,User> userMap=new HashMap<>();
	Map<String,Account> accountMap=new HashMap<>();
	Map<String,List<Transaction>> transactionMap=new HashMap<>();
	List<User> waitingList=new ArrayList<>();
	
	
	public int generateAccountNum()
	{
		return ++id;
	}
	
	public void addDefaultUser()
	{
		String[] name= {"ram","sam","uma"};
		String[] mail= {"ram@gmail.com","sam@gmail.com","uma@gmail.com"};
		long[] mobile= {9273857432L,9823645783L,8265743884L};
		long[] aadhar= {362354623212L,17234623452L,287356873432L};
		String[] pass= {"pass","pass","pass"};
		double[] amount= {1000,3000,4000};
		
		for(int i=0;i<name.length;i++)
		{
			User user=new User();
			
			user.setAadhar(aadhar[i]);
			user.setInitialAmount(amount[i]);
			user.setMail(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			user.setPassword(pass[i]);
			user.setType("customer");
			
			userMap.put(mail[i], user);
		}
	}
	
	public void addDefaultAdmin()
	{
		String[] name= {"admin1","admin2","admin3"};
		String[] mail= {"admin1@gmail.com","admin2@gmail.com","admin3@gmail.com"};
		String[] pass= {"pass","pass","pass"};
		long[] mobile= {9123841654L,9823645839L,8265873459L};
		long[] aadhar= {928375457894L,82136471235L,87213563274L};
		
		for(int i=0;i<name.length;i++)
		{
			User user=new User();
			
			user.setAadhar(aadhar[i]);
			user.setMail(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			user.setPassword(pass[i]);
			user.setType("admin");
			
			userMap.put(mail[i], user);
		}
		
	}
	
	public void addDefaultAccount()
	{
		String[] mail= {"ram@gmail.com","sam@gmail.com","uma@gmail.com"};
		double[] amount= {1000,3000,4000};
		
		for(int i=0;i<mail.length;i++)
		{
			Account account=new Account();
			
			int id=generateAccountNum();
			
			account.setId(id);
			account.setMail(mail[i]);
			account.setRcCoin(amount[i]);
			
			accountMap.put(mail[i], account);
		}
	}
	
	public boolean addUser(User user)
	{
		String mail=user.getMail();
		
		userMap.put(mail, user);
		
		return true;
	}
	
	public boolean addWaiting(User user)
	{
		waitingList.add(user);
		
		return true;
	}
	
	public void setZCoinAmount(double amount)
	{
		zCoin=amount;
	}
	
	public boolean login(String mail,String pass)
	{
		User user=userMap.get(mail);
		
		if(user==null)
		{
			return false;
		}
		
		String password=user.getPassword();
		
		boolean result=password.equals(pass);
		
		return result;
	}
	
	public boolean checkPassword(String pass1,String pass2)
	{
        boolean result=pass1.equals(pass2);
		
		return result;
	}
	
	public User getUser(String mail)
	{
		User user=userMap.get(mail);
		
		return user;
	}
	
	public boolean passwordValidation(String mail,String name,long mobile,String pass)
	{
		if(pass.length()<8)
		{
			return false;
		}
		
		
		String mob_number=Long.toString(mobile);
		
		if(name.contains(pass) || mob_number.contains(pass) || mail.contains(pass))
		{
			return false;
		}
		
		Pattern pattern=Pattern.compile("[^a-zA-Z0-9]");
		
		Matcher match=pattern.matcher(pass);
		
		boolean result=match.find();
		
		return result;
		
	}
	
	/*public boolean emailValidation(String mail)
	{
       Pattern pattern=Pattern.compile("[^a-zA-Z0-9+_.-]+@(.+)$");
		
		Matcher match=pattern.matcher(mail);
		
		boolean result=match.find();
		
		return result;

	}*/
	
	public List<User> getWaiting()
	{
		return waitingList;
	}
	
	public int addAccount(User user)
	{
		waitingList.remove(user);
		
		String mail=user.getMail();
		
		int id=generateAccountNum();
		
		double amount=user.getInitialAmount();
		
		Account account=new Account();
		
		account.setId(id);
		account.setMail(mail);
		account.setRcCoin(amount);
		
		accountMap.put(mail, account);
		
		return id;
	}
	
	public Account getAccount(String mail)
	{
		Account account=accountMap.get(mail);
		
		return account;
	}
	
	public boolean changePassword(String mail,String pass)
	{
		User user=getUser(mail);
		
		user.setPassword(pass);
		
		userMap.put(mail, user);
		
		return true;
	}
	
	public double withdrawRC(String mail,double amount)throws Exception
	{
		Account account=accountMap.get(mail);
		
		double rcCoin=account.getRcCoin();
		
		if(rcCoin<amount)
		{
			throw new Exception("Balance is less than amount");
		}
		
		double total=rcCoin-amount;
		
		account.setRcCoin(total);
		
		accountMap.put(mail, account);
		
		return total;
	}
	
	public double depositRc(String mail,double amount)
	{
       Account account=accountMap.get(mail);
		
		double rcCoin=account.getRcCoin();
		
       double total=rcCoin+amount;
		
		account.setRcCoin(total);
		
		accountMap.put(mail, account);
		
		return total;

	}
	
	public double depositZc(String mail,double amount)
	{
      Account account=accountMap.get(mail);
		
		double rcCoin=account.getzAmount();
		
       double total=rcCoin+amount;
		
		account.setzAmount(total);
		
		accountMap.put(mail, account);
		
		return total;
	}
	
	public boolean buyZCoin(String mail,double amount)throws Exception
	{
       Account account=accountMap.get(mail);
		
		double rcCoin=account.getRcCoin();
		
		if(rcCoin<amount)
		{
			throw new Exception("Balance is less than amount");
		}
		
		withdrawRC(mail,amount);
		depositZc(mail,amount);
		
		return true;

	}
	
	public double getZCoinRate()
	{
		return zCoin;
	}

}
