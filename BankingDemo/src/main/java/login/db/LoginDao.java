package login.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import bankingInfo.db.ConnectDb;
import customexception.CustomException;

public class LoginDao {

	
	public Map<String,Integer> loginDetails(String user,String pass)throws CustomException
	{
		Map<String,Integer> validate=new HashMap<>();
		
		String role="role_Id";
		String cust_id="customer_id";
		
		String query="SELECT * from login WHERE UserName=? AND PassWord=?";
		
		try(PreparedStatement statement=ConnectDb.CONNECTION.getConnection().prepareStatement(query);)
		{
			statement.setString(1,user);
			statement.setString(2, pass);
			try(ResultSet result=statement.executeQuery();)
			{
				while(result.next())
				{
				int roleId=result.getInt("RoleId");
				int customerId=result.getInt("CustomerId");
				validate.put(role, roleId);
				validate.put(cust_id, customerId);
				}
				return validate;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new CustomException(e);
			
		}
	}
}
