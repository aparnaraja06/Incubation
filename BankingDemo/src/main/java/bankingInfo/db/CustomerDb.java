package bankingInfo.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import customer.CustomerInfo;
import customexception.CustomException;

public class CustomerDb {

	public void createTable() throws CustomException {
		String query = "CREATE TABLE IF NOT EXISTS customer(CustomerId int NOT NULL AUTO_INCREMENT, Name VARCHAR(255),Gender VARCHAR(255),Mobile LONG,Status BOOLEAN default TRUE,PRIMARY KEY(CustomerId))";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.executeUpdate();
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	public int addCustomer(CustomerInfo customer) throws CustomException {
		int id = 0;
		String query = "INSERT INTO customer(Name,Gender,Mobile) VALUES (?,?,?);";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query,
				PreparedStatement.RETURN_GENERATED_KEYS)) {
			String name = customer.getCustomerName();
			String gender = customer.getGender();
			long mobile = customer.getMobileNum();

			statement.setString(1, name);
			statement.setString(2, gender);
			statement.setLong(3, mobile);

			statement.executeUpdate();

			try (ResultSet result = statement.getGeneratedKeys()) {
				if (result.next()) {
					id = result.getInt(1);
				}

				return id;
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new CustomException(e);
		}

	}

	public CustomerInfo getCustomerById(int customer_id) throws CustomException {
		CustomerInfo customer = new CustomerInfo();

		String query = "SELECT * FROM customer WHERE CustomerId=?";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setInt(1, customer_id);

			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {

					customer.setCustomerName(result.getString("Name"));
					customer.setGender(result.getString("Gender"));
					customer.setMobileNum(result.getLong("Mobile"));
				}
				return customer;
			}
		} catch (Exception e) {
			throw new CustomException(e);
		}

	}

	public Map<Integer, CustomerInfo> showAllCustomers() throws CustomException {
		Map<Integer, CustomerInfo> customerMap = new HashMap<>();

		String query = "SELECT * FROM customer";

		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					CustomerInfo customer = new CustomerInfo();
					int id = result.getInt("CustomerId");
					customer.setCustomerID(id);
					customer.setCustomerName(result.getString("Name"));
					customer.setGender(result.getString("Gender"));
					customer.setMobileNum(result.getLong("Mobile"));
					customer.setActive(result.getBoolean("Status"));

					customerMap.put(id, customer);
				}
				return customerMap;
			}

		} catch (Exception e) {
			throw new CustomException(e);
		}
	}
	public CustomerInfo updateCustomer(CustomerInfo customer)throws CustomException
	{
		String query="UPDATE customer SET Name=?,Gender=?,Mobile=? WHERE CustomerId=?";
		
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			String name = customer.getCustomerName();
			String gender = customer.getGender();
			long mobile = customer.getMobileNum();
			int cust_id=customer.getCustomerID();
			
			statement.setString(1,name);
			statement.setString(2, gender);
			statement.setLong(3, mobile);
			statement.setInt(4, cust_id);
			
			statement.executeUpdate();
			return customer;
	
		}
		catch (Exception e) {
			throw new CustomException(e);
		}
	}
	
	public boolean changeCustomerStatus(int customerId,boolean active)throws CustomException
	{
		String query="UPDATE customer SET Status=? WHERE CustomerId=?";
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			statement.setBoolean(1, active);
			statement.setInt(2, customerId);
			statement.executeUpdate();
			return true;
		}
			catch (Exception e) {
				throw new CustomException(e);
			}
	}
	
	public Map<Integer,CustomerInfo> getActiveCustomers()throws CustomException
	{
		String query="SELECT * FROM customer WHERE Status=TRUE";
		
		Map<Integer,CustomerInfo> customerMap=new HashMap<>();
		
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					CustomerInfo customer=new CustomerInfo();
					
					int id=result.getInt("CustomerId");
					customer.setCustomerID(id);
					customer.setCustomerName(result.getString("Name"));
					customer.setGender(result.getString("Gender"));
					customer.setMobileNum(result.getLong("Mobile"));
					customer.setActive(result.getBoolean("Status"));
					
					customerMap.put(id,customer);
				}
				//System.out.println("Customer map:"+customerMap);
				return customerMap;
			}
		}
		catch (Exception e) {
			throw new CustomException(e);
		}

	}
	
	public Map<Integer,CustomerInfo> getInactiveCustomers()throws CustomException
	{
		String query="SELECT * FROM customer WHERE Status=FALSE";
		
		Map<Integer,CustomerInfo> customerMap=new HashMap<>();
		
		try (PreparedStatement statement = ConnectDb.CONNECTION.getConnection().prepareStatement(query)) {
			try (ResultSet result = statement.executeQuery()) {
				while (result.next()) {
					CustomerInfo customer=new CustomerInfo();
					
					int id=result.getInt("CustomerId");
					customer.setCustomerID(id);
					customer.setCustomerName(result.getString("Name"));
					customer.setGender(result.getString("Gender"));
					customer.setMobileNum(result.getLong("Mobile"));
					customer.setActive(result.getBoolean("Status"));
					
					customerMap.put(id,customer);
				}
				//System.out.println("Customer map:"+customerMap);
				return customerMap;
			}
		}
		catch (Exception e) {
			throw new CustomException(e);
		}

	}
	
}
