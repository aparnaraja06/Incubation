import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import propertiesdemo.PropertiesDemo;
package createfile;

public class CreateFile {
public File createDirectory(String path) 
{
	File file=new File(path).mkdir();
}
public File createFile(String fileName,String type) {
	try
	{
	fileName=fileName+ type;
	File file=new File(fileName);
	return file;
	}
	catch(Exception e)
	{
		System.out.println("File cannot be created due to some reason");
	}
}
public void writeFile(File fileName,String[] str_arr) {
	try
	{
	FileWriter fileWriter=new FileWriter(fileName);
	BufferedWriter writer=new BufferedWriter(fileWriter);
	writer.write(str_arr);
	writer.close();
	}
	catch(Exception e)
	{
		System.out.println("Error occured while writing");
	}
}
public Reader readFile(Properties properties)
{
	BufferedReader reader= new BufferedReader(properties);
}

}
