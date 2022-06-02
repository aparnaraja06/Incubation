package runner;

import java.util.List;
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
			System.out.println("Enter the word1");
			String word1=scanner.nextLine();
			
			System.out.println("Enter the word2 ");
			String word2=scanner.nextLine();
			
			boolean result=reader.rotation(word1, word2);
			System.out.println(result);
			break;
		}
		case 2:
		{
			System.out.println("Enter the size of array 1");
			int num1=scanner.nextInt();
			scanner.nextLine();
			
			int[] arr1=new int[num1];
			System.out.println("Enter the values");
			for(int i=0;i<num1;i++)
			{
				arr1[i]=scanner.nextInt();
			}
			System.out.println("Enter the size of array 2");
			int num2=scanner.nextInt();
			scanner.nextLine();
			
			int[] arr2=new int[num2];
			System.out.println("Enter the values");
			for(int i=0;i<num2;i++)
			{
				arr2[i]=scanner.nextInt();
			}
			
			System.out.println("Enter the size of array 3");
			int num3=scanner.nextInt();
			scanner.nextLine();
			
			int[] arr3=new int[num3];
			System.out.println("Enter the values");
			for(int i=0;i<num3;i++)
			{
				arr3[i]=scanner.nextInt();
			}
			
			//List<Integer> result=reader.commonElement(arr1, arr2, arr3);
			List<Integer> result=reader.common(arr1, arr2, arr3);
			
			if(result.isEmpty())
			{
				System.out.println("No common elements available");
			}
			else
			{
			System.out.println(result);
			}
			
			break;

		}
		
		case 3:
		{
			System.out.println("Enter the size of array 1");
			int num1=scanner.nextInt();
			scanner.nextLine();
			
			int[] arr1=new int[num1];
			System.out.println("Enter the values");
			for(int i=0;i<num1;i++)
			{
				arr1[i]=scanner.nextInt();
			}
			System.out.println("Enter the size of array 2");
			int num2=scanner.nextInt();
			scanner.nextLine();
			
			int[] arr2=new int[num2];
			System.out.println("Enter the values");
			for(int i=0;i<num2;i++)
			{
				arr2[i]=scanner.nextInt();
			}
			
			int[] result=reader.mergeArrays(arr1, arr2);
			
			for(int i=0;i<result.length;i++)
			{
				System.out.print(result[i]+" ");
			}
			break;
		}
		}
	}

}
