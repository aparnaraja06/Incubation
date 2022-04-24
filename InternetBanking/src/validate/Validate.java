package validate;

import java.util.List;
import java.util.Map;

import account.Account;
import customexception.CustomException;
import loan.LoanInfo;
import transaction.TransactionInfo;
import user.User;

public class Validate {
     
	public void validate(String... names)throws CustomException
	{
		for(String name:names)
		{
		if(name==null || name.isEmpty())
		{
			throw new CustomException("Input should not be empty or null");
		}
		}
	}
	
	public void validate(int num)throws CustomException
	{
		if(num<0)
		{
			throw new CustomException("Input should not be negative");
		}
	}
	
	public void validate(long num)throws CustomException
	{
		if(num<0)
		{
			throw new CustomException("Input should not be negative");
		}
	}
	
	public void validate(double amount)throws CustomException
	{
		if(amount<0)
		{
			throw new CustomException("Amount should not be negative");
		}
	}
	
	public void validate(List<Object> list)throws CustomException
	{
		if(list==null)
		{
			throw new CustomException("List should not be null");
		}
	}
	
	public void checkCustomerExists(long customer_id,Map<Long,User> customerDetails) throws CustomException 
	{
		if (customerDetails.get(customer_id) == null) 
		{
			throw new CustomException("Customer id not available");
		}
	}
	
	public void checkAccountExists(long acc_num,Map<Long,Account> accountDetails)throws CustomException
	{
		if(!accountDetails.containsKey(acc_num))
		{
			throw new CustomException("Account number not available");
		}
	}
	
	public void checkPojo(Object input)throws CustomException
	{
		if(input==null)
		{
			throw new CustomException("Input object should not be null");
		}
	}
	
	public void checkValidCustomer(long cust_id,Map<Long,List<Long>> customerIdMap)throws CustomException
	{
		if(customerIdMap.get(cust_id)==null)
		{
			throw new CustomException("Customer id does not have accounts");
		}
	}
	
	public void checkAccountLoan(long acc_num,Map<Long,Map<String,LoanInfo>> loanMap)throws CustomException
	{
		if(!loanMap.containsKey(acc_num))
		{
			throw new CustomException("Account number not exists");
		}
		if(loanMap.get(acc_num)==null)
		{
			throw new CustomException("Loan details not available");
		}
	}
	
	public void checkAccountTransfer(long acc_num,Map<Long,List<TransactionInfo>> transferMap)throws CustomException
	{
		if(!transferMap.containsKey(acc_num))
		{
			throw new CustomException("Account number not exists");
		}
		
		if(transferMap.get(acc_num)==null)
		{
			throw new CustomException("No transaction details found");
		}
	}
}
