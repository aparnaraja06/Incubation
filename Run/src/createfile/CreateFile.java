package createfile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import customexception.CustomException;

public class CreateFile {
public boolean createDirectory(String path) 
{
	return new File(path).mkdir();
}
public boolean createFile(String fileName)throws CustomException{
	try
	{
	File file=new File(fileName);
	if(file.exists())
	{
		return true;
	}else
	{
	return file.createNewFile();
	}
	}
	catch(IOException e)
	{
		//e.printStackTrace();
		throw new CustomException(e);
	}
}
public boolean newPath(String directory,String fileName)throws CustomException
{
	try {
		File file=new File(directory,fileName);
		
		return file.createNewFile();
	}
	catch(IOException e)
	{
		//e.printStackTrace();
		throw new CustomException(e);
	}
}

public void writeFile(String fileName,String[] lines)throws CustomException {
	try(FileWriter fileWriter=new FileWriter(fileName,true);
	BufferedWriter writer=new BufferedWriter(fileWriter)
	    )
	{
	for(String temp:lines)
	{
	writer.write(temp);
	writer.newLine();
	}
	}
	catch(IOException e)
	{
		//e.printStackTrace();
		throw new CustomException(e);
	}
}
}
