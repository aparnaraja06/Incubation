import createfile.CreateFile;
import java.io.File;
package filerunner;

public class FileRunner {
public static void main(String[] args)
{
CreateFile newFile=new CreateFile();	
System.out.println("Enter the number between 1-5");
int option=scanner.nextInt();
scanner.nextLine();
switch(option)
{
case 1:
	try
	{
	System.out.println("Enter the name for the file");
	String name=scanner.nextLine();
	System.out.println("Enter the type of the file");
	String type=scanner.nextLine();
	File file=newFile.createFile(name,type);
	System.out.println("Enter the number of lines to add ");
	int lines=scanner.nextInt();
	String[] str_arr=new String[lines];
	for(int i=0;i<lines;i++)
	{
		str_arr[i]=scanner.nextLine;
	}
	newFile.writeFile();
	System.out.println("Successfully wrote the file");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
}
}
