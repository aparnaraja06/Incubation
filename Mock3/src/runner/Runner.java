package runner;

import java.util.Scanner;

import node.Node;
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
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.generatePalindrome(num);
		System.out.println(result);
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
		
		int[] result=reader.mergeSort(arr);
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i] +" ");
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
		System.out.println("Enter the sum");
		int sum=scanner.nextInt();
		scanner.nextLine();
		
		String result=reader.contiguousArray(arr, num, sum);
		System.out.println(result);
        break;
	}
	
	case 4:
	{
		System.out.println("Enter the row of array");
		int num1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the rcol of array");
		int num2=scanner.nextInt();
		scanner.nextLine();


		char[][] arr=new char[num1][num2];
		
		for(int i=0;i<num1;i++)
		{
			for(int j=0;j<num2;j++)
			{
			arr[i][j]=scanner.next().charAt(0);
			}
			
		}
		scanner.nextLine();
		System.out.println("Enter the word");
		String word=scanner.nextLine();
		
		int[][] result=reader.searchWord(arr, word);
		for(int i=0;i<result.length;i++)
		{
			for(int j=0;j<result[0].length;j++)
			{
				System.out.print(result[i][j]+" ");
			}
			//System.out.println();
		}

	}
	
	case 5:
	{
		System.out.println("Enter the size");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[] arr=new int[num];
		
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextInt();
		}
		
		Node root=null;
		System.out.println("Enter the min index");
		int min=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the max index");
		int max=scanner.nextInt();
		scanner.nextLine();
		Node result=reader.trimTree(root, arr, min,max);
		System.out.println(result);
	}
	}
}
}
