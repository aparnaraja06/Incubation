package operation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import directory.Directory;
import file.File;

public class Operation 
{

	Map<String,List<String>> directoryMap=new HashMap<>();
	Map<String,Directory> folderName=new HashMap<>();
	Map<String,List<String>> fileName=new HashMap<>();
	Map<String,File> fileMap=new HashMap<>();
	
	
	public void addDefaultDirectory()
	{
		Directory zoho=new Directory();
		
		String name="zoho";
		String date=getTime();
		
		zoho.setDate(date);
		zoho.setFreeSpace(355);
		zoho.setName(name);
		zoho.setType("Folder");
		
		List<String> list=directoryMap.get(name);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		folderName.put(name, zoho);
		
		directoryMap.put(name, list);
	}
	
	public List<String> getDirectories(String folder)
	{
		List<String> list=directoryMap.get(folder);
		
		return list;

	}
	
	
	public boolean addFile(File file,String folder)
	{
		//System.out.println("Folder : "+folder);
		String name=file.getName();
		
		double size=file.getSize();
		
		List<String> list=fileName.get(folder);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(name);
		
		fileName.put(folder, list);
		
		fileMap.put(name, file);
		
		Directory direct=folderName.get(folder);
		
		int number=direct.getTotalItems();
		
		double space=direct.getOccupiedSpace();
		
		direct.setOccupiedSpace(space+size);
		
		direct.setTotalItems(number+1);
		
		folderName.put(folder, direct);
		
		return true;
	}
	
	public boolean addHiddenFile(File file,String folder)
	{
		
		double size=file.getSize();
		
		String name=file.getName();
		
		fileMap.put(name, file);
		
       Directory direct=folderName.get(folder);
		
		double space=direct.getOccupiedSpace();
		
		direct.setOccupiedSpace(space+size);
		
		folderName.put(folder, direct);
		
		return true;
	}
	
	public String getTime()
	{
		String result="";
		
		long millis=System.currentTimeMillis();
		
		SimpleDateFormat format=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		
		Date date=new Date(millis);
		
		result=format.format(date);
		
		return result;
		
	}
	
	public boolean addDirectory(String path,String name)
	{
		Directory direct=new Directory();
		
		String date=getTime();
		
		direct.setName(name);
		direct.setDate(date);
		direct.setFreeSpace(355);
		direct.setType("Folder");
		direct.setPath(path);
		
		
		folderName.put(name, direct);
		
	   List<String> temp=directoryMap.get(path);
	   
	   if(temp==null)
	   {
		   temp=new ArrayList<>();
	   }
	   
	   temp.add(name);
	   
	   directoryMap.put(path, temp);
		
		return true;
	}
	
	public List<String> getFilesInPath(String folder)
	{
		List<String> list=fileName.get(folder);
		
		return list;
	}
	
	public boolean setContent(String file,String content)
	{
	
		File temp=fileMap.get(file);
		
		boolean check=temp.isReadAndWrite();
		
		boolean delete=temp.isDeleted();
		
		if(!check || delete)
		{
			return false;
		}
		
		String date =getTime();
		
		temp.setModifiedDate(date);
		temp.setContent(content);
		
		fileMap.put(content, temp);
		
		return true;
		
	}
	
	public File getContent(String name)
	{
		File temp=fileMap.get(name);
		
		return temp;
	}
	
	public boolean setReadOnly(boolean change,String name)
	{
		
		File file=getContent(name);
		
		file.setReadAndWrite(change);
		
		fileMap.put(name, file);
		
		return true;
	}
	
	public Map<String,File> listAllFiles()
	{
		return fileMap;
	}
	
	public List<String> getDirectoryName(String path)
	{
		List<String> list=directoryMap.get(path);
		
		return list;
	}
	
	public Directory getDirectoryDetails(String name)
	{
		Directory directory=folderName.get(name);
		
		return directory;
	}
	
	public boolean removeDirectory(String name)
	{
		List<String> list=directoryMap.get(name);
		
		list.remove(name);
		
		Directory folder=folderName.get(name);
		
	    folder.setDeleted(true);
		
	    folderName.put(name, folder);
		
		directoryMap.put(name, list);
		
		return true;
	}
	
	/*public void removeAllFiles(String folder)
	{
		List<String> list=fileName.get(folder);
		
		for(String name: list)
		{
			fileMap.remove(name);
		}
		
		fileName.remove(folder);
	}*/
	
	public boolean removeFile(String name)
	{
		File file=fileMap.get(name);
		
		String path=file.getFolder();
		
		file.setDeleted(true);
		
		fileMap.put(name, file);
		
		List<String> list=fileName.get(path);
		
		list.remove(name);
		
		fileName.put(path, list);
		
		return true;
	}
	
	
}
