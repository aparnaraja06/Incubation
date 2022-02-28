package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;


public class Test {
public static void main(String[] args)
{
	Properties propObj=new Properties();
	
	
	try(FileWriter fileOut= new FileWriter("/home/inc8/Desktop/test.properties");
		BufferedWriter objOut=new BufferedWriter(fileOut))
	{
		BookData book=new BookData();
		book.setId(25);
		book.setName("Aparna AutoBiography");
	
		propObj.setProperty(String.valueOf(book.getId()),book.toString());
//		objOut.writeObject(customer1);
		propObj.store(objOut, "");
		System.out.println("Written Successfully!");
		
		try(FileReader read= new FileReader("/home/inc8/Desktop/test.properties");
				BufferedReader reader=new BufferedReader(read);)
		{
			Properties properties=new Properties();
			properties.load(reader);
			System.out.println(properties);
		}
	}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		
}
}
