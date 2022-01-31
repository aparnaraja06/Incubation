package update;

import java.sql.Connection;
import java.sql.PreparedStatement;


import connect.ConnectDB;

public class UpdateData {
public void updateData(String databaseName, int id,String first, String last,int newId)throws Exception
{
	ConnectDB connectt= new ConnectDB();
	Connection connect=connectt.getConnection(databaseName);
	PreparedStatement statement=null;
	try
	{
		statement=connect.prepareStatement("UPDATE student SET id=?,first=?,last=? WHERE id=?");
		statement.setInt(1, newId);
		statement.setString(2, first);
		statement.setString(3, last);
		statement.setInt(4, id);
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
