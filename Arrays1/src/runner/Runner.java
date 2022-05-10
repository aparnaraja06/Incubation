package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customexception.CustomException;
import practice.Practice;
import reader.Reader;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	//Reader reader=new Reader();
	Practice reader=new Practice();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
	    try
	    {
	    	int[] arr=reader.smallNum(int_arr);
	    	for(int i=0;i<num;i++)
	    	{
	    		System.out.print(arr[i]);
	    	}
	    	
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
		
	}
	
	case 2:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
	    try
	    {
	    	int result=reader.kadane(num, int_arr);
	    	System.out.println(result);
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 3:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
	    try
	    {
	    	int[] arr=reader.waveArray(int_arr, num);
	    	for(int i=0;i<num;i++)
	    	{
	    		System.out.print(arr[i]);
	    	}
	    	
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 4:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		long[] int_arr=new long[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
	    try
	    {
	    	ArrayList<Long> list=reader.alternateStr(int_arr, num);
	    	System.out.println(list);
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 5:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
	    try
	    {
	    	int result=reader.majorityElement( int_arr,num);
	    	System.out.println(result);
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 6:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Enter the key to find");
		int key=scanner.nextInt();
		scanner.nextLine();
	    try
	    {
	    	int result=reader.searchElement(int_arr,num, key);
	    	System.out.println(result);
	    }
	    catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }

	}
	
	case 7:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int result=reader.balancedArray(num, int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 8:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Enter mid value");
		int mid=scanner.nextInt();
		scanner.nextLine();
		try
	    {
			int[] arr=reader.shuffleArray(int_arr, mid);
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]);
			}
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 9:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int result=reader.goodPairs(int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }

	}
	
	case 10:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int result=reader.minimumDifference(int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 11:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Enter from value");
		int from=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter to value");
		int to=scanner.nextInt();
		scanner.nextLine();
		try
	    {
			int result=reader.minDistance(int_arr, num, from, to);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 12:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int[] arr=reader.alternateNumber(int_arr, num);
			for(int i=0;i<arr.length;i++)
			{
			System.out.print(arr[i]+" ");
			}
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 13:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			boolean result=reader.zeroSum(num, int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 14:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int result=reader.nonRepeating(int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	case 15:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		try
	    {
			int result=reader.minimumElement(int_arr);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }

	}
	
	case 16:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Enter the element to find smallest value");
		int element=scanner.nextInt();
		scanner.nextLine();
		try
	    {
			int result=reader.kSmallest(int_arr,element);
			System.out.println(result);
	    }
		catch(CustomException e)
	    {
	    	System.out.println(e.getMessage());
	    }

	}
	
	case 17:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] int_arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			int_arr[i]=scanner.nextInt();
			scanner.nextLine();
		}
		List<Integer> list=reader.leader(int_arr, num);
		System.out.println(list);
	}
	}
}
}
