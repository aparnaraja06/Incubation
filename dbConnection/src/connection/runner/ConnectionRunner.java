package connection.runner;


import java.util.Map;
import java.util.Scanner;
import connection.logic.ConnectionReader;
import connection.logic.StudentInfo;

public class ConnectionRunner {
	static Scanner scanner= new Scanner(System.in);
	ConnectionReader reader=new ConnectionReader();
	StudentInfo student= new StudentInfo();
	public void case1() //table
	{ 
		try
		{
			reader.createTable();
			System.out.println("Table created successfully");
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void case2() //insert
	{
		try
		{
	
			System.out.println("Enter the number of students to add");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			for(int i=0;i<number;i++)
			{
				System.out.println("Enter the first name");
				String first=scanner.nextLine();
				System.out.println("Enter the last name");
				String last=scanner.nextLine();
				System.out.println("Enter the age");
				int age=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter the gender");
				String gender=scanner.nextLine();
				reader.insertData(first, last,age,gender);
				System.out.println("Inserted successfully");
			}
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void case3()//select
	{
		try
		{
			
			Map<Integer,StudentInfo> map=reader.selectData();
//			list=reader.selectData(dbName,studentID);
			System.out.println(map);
			System.out.println("All records have been selected");
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
	}
	public void case4() { //update
		try
		{
			
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
			reader.updateData(studentID, firstNname, lastName, newID);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void case5()//delete
	{
		try
		{
			
			System.out.println("Enter the  student id to delete");
			int studentID=scanner.nextInt();
			scanner.nextLine();
		     reader.deleteData(studentID);
		     System.out.println("All records have been deleted");
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void case6()//drop
	{
		try
		{
			reader.dropData();
			System.out.println("Table has dropped");
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	public void case7() {
		try
		{
			reader.closeConnection();
			System.out.println("Connection closed successfully");
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}
	
	public static void main(String[] args)
	{
		//ConnectionRunner conRun=new ConnectionRunner();
		
		ConnectionRunner runner= new ConnectionRunner();
		
		try
		{
		
		System.out.println("Enter your choice between 1 to 7");
		int choice=scanner.nextInt();
		scanner.nextLine();
		switch(choice)
		{
		case 1://table
		{
		runner.case1();
		break;
		}
		case 2://insert
		{
		runner.case2();
		break;
		}
		case 3://select
		{
			runner.case3();
			break;
		}
		case 4://update
		{
			runner.case4();
			break;
		}
		case 5://delete
		{
			runner.case5();
			break;
		}
		case 6://drop
		{
			runner.case6();
			break;
		}
		case 7:
		{
			runner.case7();
			break;
		}
		
		/*case 8:
		{
			try
			{
				System.out.println("Enter the database name");
				String dbName=scanner.nextLine();
				System.out.println("Enter the student id to get data:");
				int num=scanner.nextInt();
				System.out.println("Data:"+reader.selectDataByID(dbName, num));
			}
			catch(Exception e)
			{
				e.getMessage();
			}

		}*/
		
		}//switch
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			scanner.close();
		}
	}//method

	}//class

