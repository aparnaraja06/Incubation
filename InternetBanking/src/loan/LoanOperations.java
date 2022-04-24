package loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import validate.Validate;

public class LoanOperations {

	Validate validator=new Validate();
	
	public Map<Long,Map<String,LoanInfo>>  applyLoan(LoanInfo loan,Map<Long,Map<String,LoanInfo>> loanMap)
	{
		long acc_num=loan.getAccountNum();
		loan.setStatus("Processing");
		String type=loan.getType();
		Map<String,LoanInfo> temp=loanMap.get(acc_num);
		if(temp==null)
		{
			temp=new HashMap<>();
			temp.put(type, loan);
		}
		loanMap.put(acc_num,temp);
		return loanMap;
	}
	
	public String checkStatus(long acc_num,String type,
			                        Map<Long,Map<String,LoanInfo>> loanMap)throws CustomException
	{
		validator.checkAccountLoan(acc_num, loanMap);;
		Map<String,LoanInfo> tempMap=loanMap.get(acc_num);
		LoanInfo loan=tempMap.get(type);
		String status=loan.getStatus();
		return status;
	}
	
	public boolean updateStatus(long acc_num,Map<Long,Map<String,LoanInfo>> loanMap,
			                                     String type,String status)throws CustomException
	{
		validator.checkAccountLoan(acc_num, loanMap);
		
		Map<String,LoanInfo> tempMap=loanMap.get(acc_num);
		LoanInfo loan=tempMap.get(type);
		
		loan.setStatus(status);
		return true;
		
	}
}
