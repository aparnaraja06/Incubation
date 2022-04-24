package runner;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import customexception.CustomException;
import reader.Reader;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	Reader reader=new Reader();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the word 1");
		String str1=scanner.nextLine();
		System.out.println("Enter the word 2");
		String str2=scanner.nextLine();
		try
		{
			boolean result=reader.rotation(str1, str2);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 2:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++) {
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the sum");
		int sum=scanner.nextInt();
		scanner.nextLine();
		try
		{
			List<String> list=reader.pairOfNumbers(arr, sum);
			System.out.println(list);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 3:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++) {
			arr[i]=scanner.nextInt();
		}
		try
		{
			int result=reader.maximumSum(arr, num);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	case 4:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		try
		{
			reader.countAndSay(num);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	}
}
}
