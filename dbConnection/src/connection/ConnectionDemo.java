package connection;

import connect.ConnectDB;
import delete.DeleteData;
import drop.DropData;
import insert.InsertData;
import select.SelectData;
import table.CreateTable;
import update.UpdateData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.sql.*;

public class ConnectionDemo {
public static void main(String[] args)
{
	Scanner scanner= new Scanner(System.in);
	ConnectDB connectt= new ConnectDB();
	CreateTable tab= new CreateTable();
	InsertData insertt= new InsertData();
	SelectData selectt= new SelectData();
	UpdateData updatee= new UpdateData();
	DeleteData deletee= new DeleteData();
	DropData dropp= new DropData();
	
	try
	{
	System.out.println("Enter your choice between 1 to 7");
	int choice=scanner.nextInt();
	scanner.nextLine();
	switch(choice)
	{
	case 1:
	{
	try
	{
		System.out.println("Enter the database name to connect");
		String dbName=scanner.nextLine();
		connectt.getConnection(dbName);
		break;
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	}
	case 2:
	{
	try
	{
		System.out.println("Enter the database name to create table");
		String dbName=scanner.nextLine();
		tab.createTable(dbName);
		break;
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	}
	case 3://insert(create)
	{
		try
		{
			System.out.println("Enter the database name");
			String dbName=scanner.nextLine();
			System.out.println("Enter the number of students to add");
			int number=scanner.nextInt();
			scanner.nextLine();
			for(int i=0;i<number;i++)
			{
				String firstName=scanner.nextLine();
				String lastName=scanner.nextLine();
			insertt.insertData(dbName,firstName,lastName);
			}
			break;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	case 4://select(read)
	{
		try
		{
			System.out.println("Enter the database name");
			String dbName=scanner.nextLine();
			System.out.println("Enter the student id");
			int studentID=scanner.nextInt();
			scanner.nextLine();
			List<String> list = new ArrayList<String>();
			list=selectt.selectData(dbName,studentID);
			System.out.println(list);
			break;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	case 5://update
	{
		try
		{
			System.out.println("Enter the database name");
			String dbName=scanner.nextLine();
			System.out.println("Enter the old  student id");
			int studentID=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the student firstname");
	        String firstNname=scanner.nextLine();
			System.out.println("Enter the student lastname");
			String lastName=scanner.nextLine();
			System.out.println("Enter the new student id");
			int newID=scanner.nextInt();
			scanner.nextLine();
			updatee.updateData(dbName, studentID, firstNname, lastName, newID);
			break;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	case 6://delete
	{
		try
		{
			System.out.println("Enter the database name");
			String dbName=scanner.nextLine();
			System.out.println("Enter the  student id to delete");
			int studentID=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the student firstname");
	        String firstName=scanner.nextLine();
			System.out.println("Enter the student lastname");
			String lastName=scanner.nextLine();
			deletee.deleteData(dbName, studentID,firstName,lastName);
			break;
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	case 7://drop
	{
		try
		{
			System.out.println("Enter the database name");
			String dbName=scanner.nextLine();
			dropp.dropData(dbName);
			break;
		}
		catch(Exception e)
		{
			e.getMessage();
		}

		
	}
	}//switch
	}
	catch(Exception e)
	{
		System.out.println("You have entered more than 5");
	}
	finally
	{
		scanner.close();
	}
}//method

}//class
