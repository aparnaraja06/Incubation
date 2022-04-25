package rough;

import java.util.Scanner;

public class Rough {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	
	String str1="16:43:14.984";
	String str2="17:43:14.984";
	
	for(String each:str1.split(":"))
	{
		System.out.println(each);
	}
	
}
}
