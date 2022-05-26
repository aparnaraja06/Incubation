package runner;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import directory.Directory;
import file.File;
import logic.SystemDemo;
import operation.Operation;

public class Runner {
	
	static String path="";
	
	static Scanner scanner=new Scanner(System.in);
	static SystemDemo reader=new SystemDemo();
	
	public String changeDirectory(String base)
	{
		path+="/"+base;
		
		List<String> list=reader.getDirectories(base);
		//System.out.println(list);
		
		if(list.isEmpty() || list==null)
		{
			return base;
		}
		
		
		System.out.println("1.Choose Directory 2.Return");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			System.out.println(list);
			System.out.println("Choose the directory");
			int num=scanner.nextInt();
			scanner.nextLine();
			
			base=list.get(num-1);
			
			break;
		}
		case 2:
		{
			return base;
		}
		}
		
		return base;
		
	}
	
	public String traverseDirectory(String base)
	{
		List<String> list=reader.getDirectories(base);
		System.out.println(list);
		
		/*if(list.isEmpty())
		{
			return base;
		}*/
		
	        String result="";
	        
			System.out.println("1.SubDirectory 2.Previous");
			int option=scanner.nextInt();
			scanner.nextLine();
			
			switch(option)
			{
			case 1:
			{
				result=list.get(0);
				break;
			}
			case 2:
			{
				result=getPrevious(base);
				break;
			}
			}
			return result;

		}
	
	public String getPrevious(String base) {
		
		Directory direct=reader.getDirectoryDetails(base);
		
		return direct.getPath();
	}
	
	public File addFile(String choose)
	{
		System.out.println("Enter the file name ");
		String name=scanner.nextLine();
		
		System.out.println("Enter the size of file");
		double size=scanner.nextDouble();
		scanner.nextLine();
		
		System.out.println("Enter type of file ");
		String type=scanner.nextLine();
		
		String date=reader.getTime();
		
		File file=new File();
		
		file.setName(name);
		file.setSize(size);
		file.setType(type);
		file.setFolder(choose);
		file.setDate(date);
		
		return file;
		
	}
	
	
	
	public static void main(String[] args)
	{
		
		String base="zoho";
		
		Runner runner=new Runner();
		
		
		String choose=runner.changeDirectory(base);
		
		
		//System.out.println("Base : "+base);
		
		System.out.println("Currently in directory : "+choose);
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Add File 2.Add Hidden File 3.Add Directory 4.Set content in file \n"
				+ "5.Get content in file 6.Change permission 7.Traverse Directory 8.List files \n"
				+ "9.List all files 10.File Details 11.Directory Details 12.Delete File \n"
				+ "13.Delete Directory 14.Change Directory 15.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			File file=runner.addFile(choose);
			
			boolean result=reader.addFile(file, choose);
			if(result)
			{
			System.out.println("File Successfully added");
			}
			
			break;
		}
		
		case 2:
		{
						
			File file=runner.addFile(choose);
			
			boolean result=reader.addHiddenFile(file, choose);
			
			if(result)
			{
			System.out.println("File Successfully added");
			}
			
			break;
			
		}
		
		case 3:
		{
			System.out.println("Enter the name of the directory");
			String name=scanner.nextLine();
			
			boolean result=reader.addDirectory(choose, name);
			
			if(result)
			{
			System.out.println("File Successfully added");
			}
			
			break;
		}
		
		case 4:
		{
			List<String> list=reader.getFilesInPath(choose);
			 System.out.println(list);
			
			System.out.println("Choose the file");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			String name=list.get(number-1);
			
			System.out.println("Enter the content you want to set");
			String content=scanner.nextLine();
			
			boolean result=reader.setContent(name, content);
			
			if(result)
			{
			System.out.println("Content Successfully added");
			}
			else
			{
				System.out.println("Oops! Something went wrong,Can't change the content");
			}
			
			break;
		}
		
		case 5:
		{
           List<String> list=reader.getFilesInPath(choose);
           System.out.println(list);
           
			System.out.println("Choose the file");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			String name=list.get(number-1);
			
			File file=reader.getContent(name);
			
			System.out.println("Content ");
			System.out.println(file.getContent());
			
			break;	
		}
		
		case 6:
		{
           List<String> list=reader.getFilesInPath(choose);
           System.out.println(list);
			
			System.out.println("Choose the file");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			String name=list.get(number-1);
			
			System.out.println("1.Read and write 2. Read only");
			int num=scanner.nextInt();
			scanner.nextLine();
			
			boolean result=false;
			
			switch(num)
			{
			case 1:
			{
				result=reader.setReadOnly(true, name);
				break;
			}
			
			case 2:
			{
				result=reader.setReadOnly(false, name);
				break;
			}
			}
			
			if(result)
			{
			System.out.println("Successfully updated changes");
			}
			
			break;
		}
		
		case 7:
		{
			choose=runner.traverseDirectory(choose);
			break;
		}
		
		case 8:
		{
			List<String> list=reader.getFilesInPath(choose);
			
			for(String each : list)
			{
				System.out.println("File name : "+each);
			}
			
			break;
		}
		
		case 9:
		{
			Map<String,File> tempMap=reader.listAllFiles();
			
			for(String each:tempMap.keySet())
			{
				
				System.out.println("File name : "+each);
			}
			
			break;
		}
		
		case 10:
		{
            Map<String,File> tempMap=reader.listAllFiles();
			
			for(String each:tempMap.keySet())
			{
				File file=tempMap.get(each);
				
				boolean check=file.isDeleted();
				
				if(!check)
				{
				System.out.println("File name : "+each);
				System.out.println("Details : "+file);
				}
			}
			
			break;
		}
		
		case 11:
		{
			Directory direct=reader.getDirectoryDetails(choose);
			
			System.out.println(direct);
			
			break;
		}
		
		case 12:
		{
			 List<String> list=reader.getFilesInPath(choose);
			 System.out.println(list);
				
				System.out.println("Choose the file");
				int number=scanner.nextInt();
				scanner.nextLine();
				
				String name=list.get(number-1);
				
				boolean result=reader.removeFile(name);
				
				if(result)
				{
					System.out.println(name+" moved to trash");
				}
				
				break;
		}
		
		case 13:
		{
			boolean result=reader.removeDirectory(choose);
			
			Directory direct=reader.getDirectoryDetails(choose);
			
			String previous=direct.getPath();
			
			if(result)
			{
				System.out.println(choose+" moved to trash");
			}
			
			base=previous;
			
			break;
		}
		
		case 14:
		{
			choose=runner.changeDirectory(base);
			break;
		}
		
		case 15:
		{
			flag=false;
		}
		}
		}
	}

}
