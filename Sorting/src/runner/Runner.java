package runner;

import java.util.ArrayList;
import java.util.Scanner;

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
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int[] result=reader.mergeSort(arr);
		for(int i=0;i<num;i++)
		{
			System.out.print(result[i]);
		}
	}
	
	case 2:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int[] result=reader.bubbleSort(arr);
		for(int i=0;i<num;i++)
		{
			System.out.print(result[i]);
		}
	}
	
	case 3:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int[] result=reader.selectionSort(arr);
		for(int i=0;i<num;i++)
		{
			System.out.print(result[i]);
		}
	}
	
	case 4:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int[]result=reader.insertionSort(arr);
		for(int i=0;i<num;i++)
		{
		System.out.print(result[i]);
		}
	}
	
	case 5:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int[] result=reader.quickSort(arr, 0, num-1);
		for(int i=0;i<num;i++)
		{
		System.out.print(result[i]);
		}
	}
	
	case 6:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the value to select");
		int value=scanner.nextInt();
		scanner.nextLine();
		int result=reader.KSmallest(arr, value);
		System.out.println(result);
	}
	
	case 7:
	{
		System.out.println("Enter string 1");
		String str1=scanner.nextLine();
		System.out.println("Enter string 2");
		String str2=scanner.nextLine();
		boolean result=reader.anagram(str1, str2);
		System.out.println(result);
	}
	
	case 8:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		
		int[] arr2=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr2[i]=scanner.nextInt();
		}
        boolean result=reader.equalArray(arr, arr2);
        System.out.println(result);

	}
	
	case 9:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
        boolean result=reader.checkSorted(arr);
        System.out.println(result);
	}
	
	case 10:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
        int result=reader.nearestZero(arr, num);
        System.out.println(result);
	}
	
	case 11:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
        System.out.println("Enter money");
        int value=scanner.nextInt();
        scanner.nextLine();
        int result=reader.toys(arr, value, num);
        System.out.println(result);
	}
	
	case 12:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		System.out.println("Enter the part");
		int part=scanner.nextInt();
		scanner.nextLine();
		ArrayList<Integer> list=reader.candy(arr, num, part);
		System.out.println(list);
	}
	case 13:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		int count=reader.minSwaps(arr);
		System.out.println(count);
	}
	}
	
}
}
