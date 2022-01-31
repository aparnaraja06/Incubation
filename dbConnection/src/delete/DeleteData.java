package delete;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connect.ConnectDB;

public class DeleteData {
public void deleteData(String databaseName, int id,String firstName,String lastName)throws Exception
{
	ConnectDB connectt= new ConnectDB();
	Connection connect=connectt.getConnection(databaseName);
	PreparedStatement statement=null;
	try
	{
		statement=connect.prepareStatement("DELETE FROM student WHERE id="+id);

		System.out.println(statement);
		 statement.executeUpdate();
		 
	
		System.out.println("All records have been updated");
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
