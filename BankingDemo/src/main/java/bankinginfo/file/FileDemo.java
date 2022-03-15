package bankinginfo.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import account.AccountInfo;
import customer.CustomerInfo;
import customexception.CustomException;

// File IO Layer

public class FileDemo {
	private int customer_id = 0;
	private int acc_num = 1000;

	String accountFileName = "account.txt";
	String customerFileName="customer.txt";
	
	public int generateCustomerId() {
		return ++customer_id;
	}

	public int generateAccountNum() {
		return ++acc_num;
	}

	public boolean checkFileExists(File fileObj) {
		return fileObj.exists();
	}
	

	public Map<Integer, Map<Integer, AccountInfo>> readAccount() throws CustomException {

		Map<Integer,Map<Integer,AccountInfo>> accountDetails =new HashMap<>();
		if(!checkFileExists(new File(accountFileName)))
		{
		return accountDetails;	
		}
		try (FileInputStream fIn = new FileInputStream(accountFileName);
				ObjectInputStream objIn = new ObjectInputStream(fIn)) 
		{
			accountDetails= (Map<Integer, Map<Integer, AccountInfo>>) objIn.readObject();
		 acc_num=(int) objIn.readObject();
			//System.out.println("In file demo class :"+accountDetails);
		return accountDetails;
		} 
		catch (Exception e) 
		{
			throw new CustomException("Information couldn't load ");
		}
	}

	public Map<Integer, CustomerInfo> readCustomer() throws CustomException {
		
		Map<Integer, CustomerInfo> customerDetails=new HashMap<>();
		
		if(!checkFileExists(new File(customerFileName)))
		{
			return customerDetails;
		}
		try (FileInputStream fIn = new FileInputStream(customerFileName);
				ObjectInputStream objIn = new ObjectInputStream(fIn)) {
			 customerDetails = (Map<Integer, CustomerInfo>) objIn.readObject();
			customer_id = (int) objIn.readObject();
			// System.out.println(customer_id);
			// System.out.println("In file demo class :"+customerDetails);
			return customerDetails;
		} catch (Exception e) {
			throw new CustomException("Information couldn't load");
		}
	}

	public void writeAccount(Map<Integer, Map<Integer, AccountInfo>> accountDetails, int accId) throws CustomException {
		try (FileOutputStream fOut = new FileOutputStream(accountFileName);
				ObjectOutputStream objOut = new ObjectOutputStream(fOut)) {
			objOut.writeObject(accountDetails);
			objOut.writeObject(accId);
		} catch (Exception e) {
			throw new CustomException("Information couldn't write");
		}
	}

	public void writeCustomer(Map<Integer, CustomerInfo> customerDetails, int custId) throws CustomException {
		try (FileOutputStream fOut = new FileOutputStream(customerFileName);
				ObjectOutputStream objOut = new ObjectOutputStream(fOut)) {
			objOut.writeObject(customerDetails);
			objOut.writeObject(custId);
		} catch (Exception e) {
			throw new CustomException("Information couldn't write");
		}
	}
}
