package transaction;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import account.Account;
import customexception.CustomException;
import netbanking.BankingOperations;
import validate.Validate;

public class Transaction {
	
	      Validate validator=new Validate();
	
	
	public double getBalance(Long account_num,Map<Long,Account> accountMap)
	{
		Account account=accountMap.get(account_num);
		
		double balance=account.getBalance();
		
		return balance;
	}
	
	
	public double withdraw(Long acc_num,double amount,Map<Long,Account> accountMap
			                                                              )throws CustomException
	{
      
		double balance=getBalance(acc_num,accountMap);
		
		if(balance < amount)
		{
			throw new CustomException("Balance is less than given amount");
		}
		double total=balance-amount;
		
		if(accountMap.get(acc_num)!=null)
		{
			Account account=accountMap.get(acc_num);
			account.setBalance(total);
			accountMap.put(acc_num, account);
		}
		
		return total;
	}
	
	public boolean deposit(Long acc_num,double amount,Map<Long,Account> accountMap
			)throws CustomException
	{
		//System.out.println("FRom Account : "+fromAccount);
		

       double balance=getBalance(acc_num,accountMap);
		
		double total=balance+amount;
		
		if(accountMap.get(acc_num)!=null)
		{
			Account account=accountMap.get(acc_num);
			account.setBalance(total);
			accountMap.put(acc_num, account);
		}
		
		return true;
	}
	
	public Map<Long, List<TransactionInfo>> transfer(Long fromAcc,Long toAcc,double amount,Map<Long,Account> accountMap,
			 Map<Long,List<TransactionInfo>> transferMap)throws CustomException
	{
		double beforeBalance=getBalance(fromAcc,accountMap);
		double afterBalance=0.0;
       
		boolean result=false;
		
		afterBalance=withdraw(fromAcc,amount,accountMap);
		result=deposit(toAcc,amount,accountMap);
		System.out.println("Deposited :"+result);
		if(result)
		{
		TransactionInfo transfer=new TransactionInfo();
		transfer.setToAccount(toAcc);
		transfer.setAmount(amount);
		transfer.setType("debited");
		transfer.setBeginningBalance(beforeBalance);
		transfer.setEndingBalance(afterBalance);
		
		List<TransactionInfo> list=new ArrayList<>();
		list.add(transfer);
		
		transferMap.put(fromAcc, list);
		}
		return transferMap;
		
		}
	
	public List<TransactionInfo> getHistory(long acc_num,Map<Long,List<TransactionInfo>>transferMap)
			                                                                           throws CustomException
	{
		validator.checkAccountTransfer(acc_num, transferMap);
		List<TransactionInfo> transfer=transferMap.get(acc_num);
		return transfer;
	}

}
