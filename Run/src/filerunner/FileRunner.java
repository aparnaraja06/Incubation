package filerunner;
import createfile.CreateFile;
import java.util.Scanner;
import java.util.Properties;
import propertiesdemo.PropertiesDemo;
import customexception.CustomException;
import java.util.InputMismatchException;
public class FileRunner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
    CreateFile newFile=new CreateFile();
    PropertiesDemo objectProperties=new PropertiesDemo();
    int option=0;
try
{
System.out.println("Enter the number between 1-5");
option=scanner.nextInt();
scanner.nextLine();
}
catch(InputMismatchException e)
{
System.out.println("You have entered string in place of number");	
}
switch(option)
{
case 1:
{
	try
	{
	System.out.println("Enter the name for the file");
	String name=scanner.nextLine();
	Boolean created=newFile.createFile(name);
	if(created)
	{
	System.out.println("File is created ");
	System.out.println("Enter the number of lines to add");
	int number=scanner.nextInt();
	scanner.nextLine();
	System.out.println("Enter the lines to add ");
	String[] str_arr=new String[number];
	for(int i=0;i<number;i++)
	{
		str_arr[i]=scanner.nextLine();
	}
	newFile.writeFile(name,str_arr);
	System.out.println("Successfully wrote the file");
	}
	else
	{
		System.out.println("File is created already");
	}
	}
	catch(CustomException ex)
	{
		System.out.println(ex.getMessage());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	break;
}
case 2:
{
	try
	{
		Properties newProperty=objectProperties.createProperties();
		System.out.println("Enter the number of values to add ");
		int number=scanner.nextInt();
		scanner.nextLine();
		for(int i=0;i<number;i++)
		{
		System.out.println("Enter the key ");
		String key=scanner.nextLine();
		System.out.println("Enter the value ");
		String value=scanner.nextLine();
		objectProperties.setValues(newProperty,key,value);
		}
		System.out.println("Enter the name of the file to store");
		String name=scanner.nextLine();
		objectProperties.storeAll(newProperty, name);
		System.out.println("stored successfully");
	}
	catch(CustomException ex)
	{
		System.out.println(ex.getMessage());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	break;
}
case 3:
{
	try
	{
		Properties newProperty=objectProperties.createProperties();
		System.out.println("Enter the file name to load keys and values ");
		String name=scanner.nextLine();
	    Properties loadProperty=objectProperties.loadAll(newProperty, name);
		System.out.println("Properties are "+loadProperty);
	}
	catch(CustomException ex)
	{
		System.out.println(ex.getMessage());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	break;
}
case 4:
{
	try
	{
		System.out.println("Enter the name of the directory ");
		String directory=scanner.nextLine();
		Boolean created=newFile.createDirectory(directory);
		if(created)
		{
			System.out.println("Directory is successfully created");
			System.out.println("Enter the number of files to add ");
			int number=scanner.nextInt();
			scanner.nextLine();
			for(int i=0;i<number;i++)
			{
			System.out.println("Enter the name of the file ");
			String name=scanner.nextLine();
			System.out.println("If the file is stored : "+newFile.newPath(directory, name));
			}
			
		}
		else
		{
			System.out.println("directory is not created");
		}
	}
	catch(CustomException ex)
	{
		System.out.println(ex.getMessage());
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	break;
}
default:
	System.out.println("You have entered more than 4! please enter between 1-4");
}
scanner.close();
}
}
