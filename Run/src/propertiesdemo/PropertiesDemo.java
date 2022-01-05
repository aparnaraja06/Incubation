package propertiesdemo;
import java.util.Properties;
import customexception.CustomException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class PropertiesDemo {
public Properties createProperties() 
{
	Properties properties=new Properties();
	return properties;
}
public Object setValues(Properties properties, String key,String value)
{
	return properties.setProperty(key,value);
}
public Properties loadAll(Properties properties,String fileName)throws CustomException
{
	try(FileReader fileReader=new FileReader(fileName);
	BufferedReader reader=new BufferedReader(fileReader)
	   )
	{
	
	properties.load(reader);
	return properties;
	}
	catch(Exception e)
	{
		throw new CustomException("File couldn't load");
	}
}
public void storeAll(Properties properties,String fileName)throws CustomException
{
	try(FileWriter fileWriter=new FileWriter(fileName);
	BufferedWriter writer=new BufferedWriter(fileWriter)
		)
	{
	properties.store(writer,"Writing properties to file");
	}
	catch(Exception e) {
		throw new CustomException("File couldn't store");
	}
}


}
