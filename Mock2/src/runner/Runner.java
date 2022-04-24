package runner;

import java.util.Scanner;

import node.Node;
import reader.Reader;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	Reader reader=new Reader();
	Node node=new Node();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the ip");
		String ip=scanner.nextLine();
		boolean result=reader.validIp(ip);
		if(!result)
		{
			System.out.println("0");
		}
		else
		{
			System.out.println("1");
		}
		break;
	}
	case 2:
	{
		System.out.println("Enter the size");
		int num=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[num][num];
		
		System.out.println("Enter the values");
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		
		int[][] result=reader.rotate(arr, num);
		for(int i=0;i<num;i++)
		{
			for(int j=0;j<num;j++)
			{
               System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		break;
		
	}
	
	case 3:
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
		
		reader.numberOfTimes(arr);
		break;
	}
	
	case 4:
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
		
		int mid=num/2;
		for(int i=0;i<arr.length;i++)
		{
			if(arr.length %2 ==0)
			{
			if(i==mid-1)
			{
				int temp=arr[0];
				arr[0]=arr[i];
				arr[i]=temp;
			}
		}
			else
			{
				if(i==mid)
				{
					int temp=arr[0];
					arr[0]=arr[i];
					arr[i]=temp;

				}
			}
	}
		node.data=arr[0];
		Node root=null;
		
	}
	}
}
}
