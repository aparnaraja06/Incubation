package connection.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DbUtility {
	
	Connection connectt=ConnectionEnum.CONNECTION.getConnection();
	
	
	public void createDbTable()throws Exception
	{
		String query="CREATE TABLE IF NOT EXISTS student(id int NOT NULL AUTO_INCREMENT, firstName varchar(255),lastName varchar(255),age int,gender varchar(255), PRIMARY KEY(id))";
		
		try(PreparedStatement create =connectt.prepareStatement(query))
		{
			create.executeUpdate();
			
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		}
	public void insertDbTable(String firstName, String lastName,int age,String gender)throws Exception
	{
          String query="INSERT INTO student(firstName, lastName, age, gender) VALUES (?, ?, ?, ?)";
		
		try(PreparedStatement statement=connectt.prepareStatement(query))
		{
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setInt(3, age);
			statement.setString(4, gender);
			
			statement.executeUpdate();
			
		}
		catch(Exception e)
		{
		   throw new Exception(e);
		}	
	}
	
	public Map<Integer,StudentInfo> selectDbTable()throws Exception
	{
		Map<Integer,StudentInfo> map= new HashMap<>();
		
		String query="SELECT * FROM student";

		try(PreparedStatement statement=connectt.prepareStatement(query))
		{
			
			 try(ResultSet result=statement.executeQuery())
			 {
			 
			while(result.next())
			{
				StudentInfo student= new StudentInfo();
				int student_id=result.getInt("id");
				student.setFirstName(result.getString("firstName"));
				student.setLastName(result.getString("lastName"));
				student.setGender(result.getString("gender"));
				student.setAge(result.getInt("age"));
				
				map.put(student_id,student);
			}
			
			
			return map;
		}
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
		
	} 
	public void updateDbData(int id,String first,String last,int newId)throws Exception
	{
		String query="UPDATE student SET id=?,firstName=?,lastName=? WHERE id=?;";
		 
		try(PreparedStatement statement=connectt.prepareStatement(query))
		{
		
			
	    	statement.setInt(1, newId);
			statement.setString(2, first);
			statement.setString(3, last);
			statement.setInt(4, id);
			
			
			//PreparedStatement statement=connect.prepareStatement("UPDATE student SET id=\''"+newId+"\'',first=\\''"+first+"\\'',last=\\''"+last+"\\''WHERE id=\\''"+id+"\\'';");
			
			
			 statement.executeUpdate();
			
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}
	public void deleteDbData(int id)throws Exception
	{
         String query="DELETE FROM student WHERE id=?";
		
		try(PreparedStatement statement=connectt.prepareStatement(query))
		{
			
            statement.setInt(1, id);
			 statement.executeUpdate();
			
		}
		catch(Exception e)
		{
			throw new Exception(e);
		}
	}
	public void dropDbData()throws Exception
	{
       String query="DROP TABLE student";
		
		try(PreparedStatement statement=connectt.prepareStatement(query))
		{
			 statement.executeUpdate();	
			
	     }
		catch(Exception e)
		{
			throw new Exception(e);
		}
	} 
	public void closeDbConnection()throws Exception
	{
		ConnectionEnum.CONNECTION.closeConnection();
	}
		
	}

