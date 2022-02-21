package bankingInfo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public enum ConnectDb {
CONNECTION;
	private String url="jdbc:mysql://localhost:3306/bankInfo";
	private String username="inc8";
	private String password="Root@123";
	
	Connection connectt=null;
	
	public Connection getConnection() {
		if(connectt==null)
		{
			try
			{
				connectt=DriverManager.getConnection(url,username,password);
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
	
	public void closeConnection()throws Exception
	{
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
