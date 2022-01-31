package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
public Connection getConnection(String databaseName)throws Exception{
	try
	{
		String driver="com.mysql.cj.jdbc.Driver";
		//String databaseName="";
		String url="jdbc:mysql://localhost:3306/"+databaseName;
		String userName="root";
		String passWord="Root@123";
		Class.forName(driver);
		
		Connection connectt=DriverManager.getConnection(url,userName,passWord);
		System.out.println("Connected successfully");
		return connectt;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	return null;
	
}
}
