package bankinginfo.property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

import customexception.CustomException;

public class LoadChoices 
{

public String selectChoice()throws CustomException
{
	
	try(FileReader fReader= new FileReader("select.properties");
			BufferedReader bReader= new BufferedReader(fReader))
	{
		Properties file= new Properties();
		file.load(bReader);
		String value=file.getProperty("1");
		System.out.println(value);
		return value;
	}
	catch(Exception e)
    {
   	 throw new CustomException("Information couldn't load");
     }
}
}

