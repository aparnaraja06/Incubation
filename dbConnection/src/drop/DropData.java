package drop;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.ConnectDB;

public class DropData {
public void dropData(String databaseName)throws Exception
{
	ConnectDB connectt= new ConnectDB();
	Connection connect=connectt.getConnection(databaseName);
	PreparedStatement statement=null;
	try
	{
		statement=connect.prepareStatement("DROP TABLE student");
		
		System.out.println(statement);
		 statement.executeUpdate();
		 
	
		System.out.println("Table has dropped");
}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
