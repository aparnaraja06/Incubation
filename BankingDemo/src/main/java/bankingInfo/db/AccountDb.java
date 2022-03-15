package bankingInfo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import account.AccountInfo;
import customexception.CustomException;

public class AccountDb {

	public void createTable() throws CustomException {
		String query = "CREATE TABLE IF NOT EXISTS account(AccountNum int NOT NULL AUTO_INCREMENT,CustomerId int, Branch VARCHAR(255),Balance DOUBLE,Status BOOLEAN default TRUE,PRIMARY KEY(AccountNum),FOREIGN KEY(CustomerId) REFERENCES customer(CustomerId))ENGINE=InnoDB AUTO_INCREMENT=1000;";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.executeUpdate();
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public int addAccount(AccountInfo account) throws CustomException {
		int acc_num = 0;
		String query = "INSERT INTO account(CustomerId,Branch,Balance) VALUES (?,?,?)";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			
			int customer_id = account.getCustomerId();
			String branch = account.getBranch();
			double balance = account.getBalance();

			statement.setInt(1, customer_id);
			statement.setString(2, branch);
			statement.setDouble(3, balance);
			statement.executeUpdate();
			try (ResultSet result = statement.getGeneratedKeys()) {

				while (result.next()) {
					acc_num = result.getInt(1);

				}
				return acc_num;
			}
		} catch (Exception e) {
			throw new CustomException(e);
		}

	}

	public Map<Integer, AccountInfo> getAccountById(int customer_id) throws CustomException {
		AccountInfo account = new AccountInfo();

		Map<Integer, AccountInfo> tempMap = new HashMap<>();

		String query = "SELECT * FROM account WHERE CustomerId=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setInt(1, customer_id);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					// account.setAccountNum(result.getInt("acc))
					int account_num = result.getInt("AccountNum");
					account.setBranch(result.getString("Branch"));
					account.setBalance(result.getDouble("Balance"));
					account.setActive(result.getBoolean("Status"));

					tempMap.put(account_num, account);
				}
				return tempMap;
			}
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public Map<Integer, Map<Integer, AccountInfo>> showAllAccounts() throws CustomException {

		String query = "SELECT * FROM account";

		Map<Integer, AccountInfo> tempMap = new HashMap<>();

		Map<Integer, Map<Integer, AccountInfo>> accountMap = new HashMap<>();

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					AccountInfo account = new AccountInfo();

					int id = result.getInt("CustomerId");

					int acc_num = result.getInt("AccountNum");
					account.setBranch(result.getString("Branch"));
					account.setBalance(result.getDouble("Balance"));
					account.setActive(result.getBoolean("Status"));

					tempMap = accountMap.get(id);
					if (tempMap == null) {
						tempMap = new HashMap<>();
						accountMap.put(id, tempMap);
					}
					tempMap.put(acc_num, account);

				}
				return accountMap;
			}

		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public AccountInfo getAccountByAccountNum(int customer_id, int account_num) throws CustomException {
		String query = "SELECT * FROM account WHERE CustomerId=? AND AccountNum=?";

		AccountInfo account = new AccountInfo();

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setInt(1, customer_id);
			statement.setInt(2, account_num);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					// account.setAccountNum(result.getInt("accountNum"));
					account.setBranch(result.getString("branch"));
					account.setBalance(result.getDouble("balance"));

				}
				return account;
			}

		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public double getBalance(int customer_id, int account_num) throws CustomException {

		double balance = 0.0;

		String query = "SELECT Balance FROM account WHERE CustomerId=? AND AccountNum=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setInt(1, customer_id);
			statement.setInt(2, account_num);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {

					balance = result.getDouble("balance");

				}
				return balance;
			}
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}
	
	public AccountInfo updateAccount(AccountInfo account)throws CustomException
	{
		String query="UPDATE account SET CustomerId=?,Branch=?,Balance=? WHERE AccountNum=?";
		
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			int customer_id = account.getCustomerId();
			
			String branch = account.getBranch();
			
			double balance = account.getBalance();
			
			int account_num=account.getAccountNum();
			
			
			statement.setInt(1, customer_id);
			statement.setString(2, branch);
			statement.setDouble(3, balance);
			statement.setInt(4,account_num);
			statement.executeUpdate();
		
			return account;
		}
		catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public boolean withdraw(int customer_id, int accNum, double amount) throws CustomException {

		double balance = getBalance(customer_id, accNum);

		if (balance < amount) {
			throw new CustomException("Please enter the amount less than your balance " + balance);
		}

		double total = balance - amount;

		String query = "UPDATE account SET Balance=? WHERE CustomerId=? AND AccountNum=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setDouble(1, total);
			statement.setInt(2, customer_id);
			statement.setInt(3, accNum);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			throw new CustomException(e);
		}

	}

	public boolean deposit(int customer_id, int acc_num, double amount) throws CustomException {

		double balance = getBalance(customer_id, acc_num);

		double total = balance + amount;

		String query = "UPDATE account SET Balance=? WHERE CustomerId=? AND AccountNum=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setDouble(1, total);
			statement.setInt(2, customer_id);
			statement.setInt(3, acc_num);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public boolean changeStatus(int customer_id, int acc_num, boolean active) throws CustomException {

		String query = "UPDATE account SET Status=? WHERE CustomerId=? AND AccountNum=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setBoolean(1, active);
			statement.setInt(2, customer_id);
			statement.setInt(3, acc_num);
			statement.executeUpdate();
			return true;
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> getActiveAccounts()throws CustomException
	{
		String query="SELECT * FROM account WHERE Status=TRUE";
		AccountInfo account=null;
		int id=0;
		Map<Integer,Map<Integer,AccountInfo>> accountMap=new HashMap<>();
		Map<Integer,AccountInfo> tempMap=new HashMap<>();
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					
					account = new AccountInfo();
					id = result.getInt("CustomerId");

					int acc_num = result.getInt("AccountNum");
					//account.setAccountNum(acc_num);
					//account.setCustomerId(id);
					account.setBranch(result.getString("Branch"));
					account.setBalance(result.getDouble("Balance"));
					account.setActive(result.getBoolean("Status"));
					
					tempMap = accountMap.get(id);
					if (tempMap == null) {
						tempMap = new HashMap<>();
						accountMap.put(id, tempMap);
					}
					tempMap.put(acc_num, account);

				}
				return accountMap;
			}
		}
		catch(Exception e)
		{
			throw new CustomException(e);
		}
	}
	
	public Map<Integer,Map<Integer,AccountInfo>> getInactiveAccounts()throws CustomException
	{
		String query="SELECT * FROM account WHERE Status=FALSE";
	
		AccountInfo account=null;
		int id=0;
		Map<Integer,Map<Integer,AccountInfo>> accountMap=new HashMap<>();
		Map<Integer,AccountInfo> tempMap=new HashMap<>();
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					
					account = new AccountInfo();
					id = result.getInt("CustomerId");

					int acc_num = result.getInt("AccountNum");
					//account.setAccountNum(acc_num);
					//account.setCustomerId(id);
					account.setBranch(result.getString("Branch"));
					account.setBalance(result.getDouble("Balance"));
					account.setActive(result.getBoolean("Status"));
					
					tempMap = accountMap.get(id);
					if (tempMap == null) {
						tempMap = new HashMap<>();
						accountMap.put(id, tempMap);
					}
					tempMap.put(acc_num, account);

				}
				//System.out.println("Account object "+account);
				//System.out.println("Account map:"+accountMap);
				return accountMap;
				
			
		}
		}

		catch (Exception e) {
			throw new CustomException(e);
		}
		
	}
	public List<String> getAllBranches()throws CustomException
	{
		String query="SELECT DISTINCT Branch FROM account";
		
		List<String> list=new ArrayList<>();
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					String branch=result.getString("Branch");
					list.add(branch);
				}
			}
			
			return list;
		}
		
		catch (Exception e) {
			throw new CustomException(e);
		}
	}
				
}
