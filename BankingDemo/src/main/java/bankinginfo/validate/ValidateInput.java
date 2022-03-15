package bankinginfo.validate;

import java.util.Map;
import account.AccountInfo;
import customer.CustomerInfo;
import customexception.CustomException;

public class ValidateInput {
	public void checkCustomerExists(int customer_id,Map<Integer,CustomerInfo> customerDetails) throws CustomException 
	{
		if (customerDetails.get(customer_id) == null) 
		{
			throw new CustomException("Customer id not available");
		}
	}

	public void checkCustomerValid(int customer_id,Map<Integer,Map<Integer,AccountInfo>> accountDetails) throws CustomException 
	{
		if (accountDetails.get(customer_id) == null) 
		{
			throw new CustomException("Customer id is not valid");
		}
	}

	public void checkAccountExists(int customer_id, int account_num,Map<Integer,Map<Integer,AccountInfo>> accountDetails) throws CustomException 
	{
		checkCustomerValid(customer_id,accountDetails);
		
		Map<Integer, AccountInfo> tempMap = accountDetails.get(customer_id);
		
		if (tempMap.get(account_num) == null) 
		{
			throw new CustomException("Customer id does not have this account number");
		}
	}

	
	public void validate(Object input) throws CustomException
	{
		if(input==null)
		{
			throw new CustomException("Input should not be null");
		}
	}
	
	public void validateAmount(double amount)throws CustomException
	{
		if(amount<0.0)
		{
			throw new CustomException("Amount should not be in negative");
		}
	}
	
	public void validateName(String name)throws CustomException
	{
		if(name==null || name.isEmpty())
		{
			throw new CustomException("Name should not be empty");
		}
	}
	
	public void checkAlpha(String name)throws CustomException
	{
		int length=name.length();
		
		for(int i=0;i<length;i++)
		{
			char character = name.charAt(i);
            if (!(character >= 'A' && character <= 'Z') && !(character >= 'a' && character<= 'z')) {
            	throw new CustomException("Name should contain only alphabets");
            }
		}
	}
}
