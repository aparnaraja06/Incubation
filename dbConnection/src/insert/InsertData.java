package insert;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.ConnectDB;

public class InsertData {
public void insertData(String databaseName,String variable1, String variable2)throws Exception
{
	
	ConnectDB connectt= new ConnectDB();
	
	try
	{
		Connection connect=connectt.getConnection(databaseName);
		PreparedStatement posted=connect.prepareStatement("INSERT INTO student(first, last) VALUES ('"+variable1+"','"+variable2+"')");
		posted.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		System.out.println("Inserted successfully");
	}
}
}
