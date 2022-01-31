package table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import connect.ConnectDB;

public class CreateTable {
public void createTable(String databaseName)throws Exception {
	ConnectDB connectt= new ConnectDB();
	try
	{
		Connection connect= connectt.getConnection(databaseName);
		PreparedStatement create =connect.prepareStatement("CREATE TABLE IF NOT EXISTS student(id int NOT NULL AUTO_INCREMENT, first varchar(255),last varchar(255), PRIMARY KEY(id))");
		create.executeUpdate();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		System.out.println("Function completed");
	}
}
}
