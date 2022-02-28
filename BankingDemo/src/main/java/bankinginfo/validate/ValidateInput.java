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
}
