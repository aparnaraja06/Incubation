package logic;

import java.util.List;
import java.util.Map;

import directory.Directory;
import file.File;
import operation.Operation;

public class SystemDemo 
{
	Operation reader=new Operation();
	
	public SystemDemo()
	{
		reader.addDefaultDirectory();
	}

	public List<String> getDirectories(String folder)
	{
		return reader.getDirectories(folder);
	}
	
	public boolean addFile(File file,String folder)
	{
		return reader.addFile(file, folder);
	}
	
	public boolean addHiddenFile(File file,String folder)
	{
		return reader.addHiddenFile(file, folder);
	}
	
	public String getTime()
	{
		return reader.getTime();
	}
	
	public boolean addDirectory(String path,String name)
	{
		return reader.addDirectory(path, name);
	}
	
	public List<String> getFilesInPath(String folder)
	{
		return reader.getFilesInPath(folder);
	}
	
	public boolean setContent(String file,String content)
	{
		return reader.setContent(file, content);
	}
	
	public File getContent(String name)
	{
		return reader.getContent(name);
	}
	
	public boolean setReadOnly(boolean change,String name)
	{
		return reader.setReadOnly(change, name);
	}
	
	public Map<String,File> listAllFiles()
	{
		return reader.listAllFiles();
	}
	
	public List<String> getDirectoryName(String path)
	{
		return reader.getDirectoryName(path);
	}
	
	public Directory getDirectoryDetails(String name)
	{
		return reader.getDirectoryDetails(name);
	}
	
	public boolean removeDirectory(String name)
	{
		return reader.removeDirectory(name);
	}
	
	public boolean removeFile(String name)
	{
		return reader.removeFile(name);
	}

}
