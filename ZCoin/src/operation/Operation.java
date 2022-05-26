package operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import account.Account;
import customexception.CustomException;
import transaction.Transaction;
import user.User;

public class Operation 
{
	
	private double zCoin=0.5;
	private int accountNum=1000;

	Map<String,User> userMap=new HashMap<>();
	Map<String,Integer> userAccount=new HashMap<>();
	Map<Integer,Account> accountMap=new HashMap<>();
	Map<String,List<Transaction>> transferMap=new HashMap<>();
	List<User> waitingList=new ArrayList<>();
	
	private int generateAccountNum()
	{
		return ++accountNum;
	}
	
	public void addDefaultCustomer()
	{
		String[] name= {"ram","raj","sam","uma","uva"};
		String[] mail= {"ram@gmail.com","raj@gmail.com","sam@gmail.com","uma@gmail.com","uva@gmail.com"};
		String[] password= {"pass","pass","pass","pass","pass"};
		long[] mobile= {9234782964L,9287348849L,9278343892L,9127423846L,9123478673L};
		long[] aadhar= {129784312872L,812436287412L,281346187412L,816437824612L,186327834781L};
		double[] deposit= {1000,2000,3000,5000,6000};
		
		for(int i=0;i<name.length;i++)
		{
			User user=new User();
			
			user.setAadhar(aadhar[i]);
			user.setInitialDeposit(deposit[i]);
			user.setMailId(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			user.setPass(password[i]);
			user.setType("customer");
			
			userMap.put(mail[i], user);
		}
	}
	
	public void addDefaultAdmin()
	{
		String[] name= {"admin1","admin2","admin3"};
		String[] mail= {"admin1@gmail.com","admin2@gmail.com","admin3@gmail.com"};
		String[] password= {"pass","pass","pass"};
		long[] mobile= {8234782964L,8287348849L,8278343892L};
		long[] aadhar= {729784312872L,312436287412L,781346187412L};
		
		for(int i=0;i<name.length;i++)
		{
			User user=new User();
			
			user.setAadhar(aadhar[i]);
			user.setMailId(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			user.setPass(password[i]);
			user.setType("admin");
			
			userMap.put(mail[i], user);
		}
	}
	
	public void addDefaultAccount()
	{
		String[] mail= {"ram@gmail.com","raj@gmail.com","sam@gmail.com","uma@gmail.com","uva@gmail.com"};
		double[] deposit= {1000,2000,3000,5000,6000};
		
		for(int i=0;i<mail.length;i++)
		{
			int id=generateAccountNum();
			
			Account account=new Account();
			
			account.setAccountNum(id);
			account.setMailId(mail[i]);
			account.setInitialAmount(deposit[i]);
			
		
			userAccount.put(mail[i], id);
			
			accountMap.put(id, account);
		}
		
		//System.out.println(accountMap);
	}
	
	public int addCustomer(User user)
	{
		String mail=user.getMailId();
		
		userMap.put(mail, user);
		
		int num=addAccount(user);
		
		return num;
	}
	
	public int addAccount(User user)
	{
		int id=generateAccountNum();
		
		String mail=user.getMailId();
		
		double initial=user.getInitialDeposit();
		
		
		Account account=new Account();
		
		account.setAccountNum(id);
		account.setMailId(mail);
		account.setInitialAmount(initial);
		
		userAccount.put(mail, id);
		
		accountMap.put(id, account);
		
		return id;
	
	}
	
	public void putInWaiting(User user)
	{
		waitingList.add(user);
	}
	
	public User getUser(String mail)
	{
		User user=userMap.get(mail);
		
		return user;
	}
	
	public void updateUser(User user)
	{
		String mail=user.getMailId();
		
		userMap.put(mail, user);
	}
	
	public String login(String mail,String pass)
	{
		User user=getUser(mail);
		
		String password=user.getPass();
		
		String type=user.getType();
		
		if(password.equals(pass))
		{
			return type;
		}
		
		return null;
		
	}
	
	public void setZCoinRate(double amount)
	{
		zCoin=amount;
	}
	
	public double getZCoinRate()
	{
		return zCoin;
	}
	
	public boolean passwordValidation(String pass,String name,String mail,long mobile)
	{
		if(pass.length()<8)
		{
			return false;
		}
		
		String number=Long.toString(mobile);
		
		if(name.contains(pass) || mail.contains(pass) || number.contains(pass))
		{
			return false;
		}
		
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(pass);
        
        boolean result=matcher.find();
        
        return result;
	}
	
	public boolean checkPassword(String pass1,String pass2)
	{
		if(pass1.equals(pass2))
		{
			return true;
		}
		
		return false;
	}
	
	public List<User> getWaitingUser()
	{
		return waitingList;
	}
	
	public Map<String,List<Transaction>> getHistory()
	{
		return transferMap;
	}
	
	public List<Transaction> showTransaction(String mail)
	{
		Map<String,List<Transaction>> tempMap=getHistory();
		
		List<Transaction> list=tempMap.get(mail);
		
		return list;
	}
	
	/*public Map<Integer,Account> getAccountDetails(String mail)
	{
		int account_num=userAccount.get(mail);
		
		Account account =accountMap.get(account_num);
		
		return tempMap;
	}*/
	
	public Account userWallets(int account_num)
	{
		
		Account account=accountMap.get(account_num);
		
		return account;
	}
	
	public Map<Integer,Account> allAccounts()
	{
		return accountMap;
	}
	
	public double withdrawRC(int account_num,double rCCoin)throws CustomException
	{
		
		Account account=accountMap.get(account_num);
		
		double amount=account.getInitialAmount();
		
		if(amount< rCCoin)
		{
			throw new CustomException("Your balance is less than the amount you entered");
		}
		
		double total=amount-rCCoin;
		
		account.setInitialAmount(total);
		
		
		accountMap.put(account_num, account);
		
		return total;
	}
	
	public double depositRC(int account_num,double rCCoin)
	{

		
		Account account=accountMap.get(account_num);
		
		double amount=account.getInitialAmount();
		
        double total=amount+rCCoin;
		
		account.setInitialAmount(total);
		
		
		accountMap.put(account_num, account);
		
		return total;
	}
	
	public double withdrawZC(int account_num,double zCoin)throws CustomException
	{
 
		
		Account account=accountMap.get(account_num);
		
		double amount=account.getzCoin();
		
		if(amount< zCoin)
		{
			throw new CustomException("Your balance is less than the amount you entered");
		}
		
		double total=amount-zCoin;
		
		account.setzCoin(total);
		
		accountMap.put(account_num, account);
		
		return total;
	}
	
	public double depositZC(int account_num,double zCoin)
	{
		
		Account account=accountMap.get(account_num);
		
		double amount=account.getzCoin();
		
        double total=amount+zCoin;
		
		account.setzCoin(total);
		
		accountMap.put(account_num, account);
		
		return total;
	}
	
	public double transfer(String mail,int fromAccount,int toAccount,double amount)throws CustomException
	{
		double total= withdrawZC(fromAccount,amount);
		
		depositZC(toAccount,amount);
		
		String time=getDate();
		
		Transaction transfer=new Transaction();
		
		transfer.setAmount(amount);
		transfer.setFromAccount(fromAccount);
		transfer.setToAccount(toAccount);
		transfer.setType("Z Coin");
	    transfer.setDate(time);
	    
	   List<Transaction> list= transferMap.get(mail);
	   
	   if(list==null)
	   {
		   list=new ArrayList<>();
	   }
		
	   list.add(transfer);
	   
	   transferMap.put(mail, list);
	   
		return total;
	}
	
	
	
	public boolean buyZCoin(int account_num,double zCoin)throws CustomException
	{
		
		Account account=accountMap.get(account_num);
		
		double amount=account.getInitialAmount();
		
		if(amount< zCoin)
		{
			throw new CustomException("Your balance is less than the amount you entered");
		}
		
		withdrawRC(account_num,zCoin);
		
		depositZC(account_num,zCoin);
		
		return true;

	} 
	
	public double conversion()
	{
		double rCoin=1;
		double zCoin=this.zCoin;
		
		double value=zCoin-rCoin;
		
		return value;
	}
	
	public double withdrawZcToRc(int account_num,double amount)throws CustomException
	{

		
		Account account=accountMap.get(account_num);
		
		double temp=account.getzCoin();
		
		if(temp< amount)
		{
			throw new CustomException("Your balance is less than the amount you entered");
		}
		

		double store=conversion();
	
		double total=temp*Math.abs(store);
		
		double deposit=depositRC(account_num,total);
		
		return deposit;
	}
	
	public int getAccountNum(String mail)
	{
		return userAccount.get(mail);
	}
	
	public String getDate()
	{
		String result="";
		
		long millis=System.currentTimeMillis();
		
		SimpleDateFormat format=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		
		Date date= new Date(millis);
		
		result=format.format(date);
		
		return result;
	}
	
	
}
