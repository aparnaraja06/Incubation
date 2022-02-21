package connection.logic;

import java.sql.Connection;
import java.sql.DriverManager;

public enum ConnectionEnum {
    CONNECTION;
	
	private String url="jdbc:mysql://localhost:3306/studentdatabase";
	private String userName="inc8";
	private String passWord="Root@123";

	Connection connectt=null;
	
	
	
	public Connection getConnection(){
		
		if(connectt==null)
		{
		try
		{
			connectt=DriverManager.getConnection(url,userName,passWord);
			return connectt;
		}
		catch(Exception e)
		{
			return null;
		}
		}
		else
		{
			return connectt;
		}
		
		
	}
	public void closeConnection()throws Exception{
		if(connectt!=null)
		{
			try
			{
			connectt.close();
		}
			catch(Exception e)
			{
				throw new Exception(e);
			}
		}
	}
	
}
