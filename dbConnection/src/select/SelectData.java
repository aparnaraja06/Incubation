package select;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connect.ConnectDB;

public class SelectData {
public List<String> selectData(String databaseName,int studentId)throws Exception
{
	ConnectDB connectt= new ConnectDB();
	Connection connect=connectt.getConnection(databaseName);
	PreparedStatement statement=null;
	ResultSet result=null;
	try
	{
		
		statement=connect.prepareStatement("SELECT * FROM student WHERE id="+studentId);
		
		 result=statement.executeQuery();
		 
		List<String> list= new ArrayList<String>();
		while(result.next())
		{
			System.out.print(result.getInt("id"));
			System.out.print(" ");
			System.out.print(result.getString("first"));
			System.out.print(" ");
			System.out.println(result.getString("last"));
			
			list.add(result.getString("last"));
		}
		System.out.println("All records have been selected");
		return list;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return null;
}
}
