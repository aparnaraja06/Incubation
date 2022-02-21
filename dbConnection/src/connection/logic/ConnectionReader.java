package connection.logic;

import java.util.Map;


public class ConnectionReader {
	
	DbUtility utility= new DbUtility();
	
	public void validate(String... inputs)throws Exception
	{
		for(String input:inputs)
		{
		if(input==null || input.isEmpty())
		{
			throw new Exception("Input String should not be empty or null");
		}
	}
	}
	
	public void createTable()throws Exception {
		
		utility.createDbTable();
	}
	public void insertData(String firstName, String lastName,int age,String gender)throws Exception
	{
		validate(firstName,lastName,gender);
		utility.insertDbTable(firstName, lastName, age, gender);
		
	}
	public Map<Integer,StudentInfo> selectData()throws Exception
	{
	
		Map<Integer,StudentInfo> map=utility.selectDbTable();
		return map;
	}
	public void updateData(int id,String first, String last,int newId)throws Exception
	{
		validate(first,last);
		utility.updateDbData(id, first, last, newId);
	
	}
	public void deleteData( int id)throws Exception
	{
		utility.deleteDbData(id);
	}
	public void dropData()throws Exception
	{
		utility.dropDbData();
	}
	public void closeConnection() throws Exception
	{
		utility.closeDbConnection();
	}
}
