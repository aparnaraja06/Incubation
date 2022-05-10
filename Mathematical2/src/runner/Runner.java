package runner;

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
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.palindrome(num);
		System.out.println(result);
	}
	
	case 2:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		String[] arr=new String[num];
		
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.nextLine();
		}
		
		String result=reader.shortestTime(arr);
		System.out.println(result);
	}
	
	case 3:
	{
		System.out.println("Enter the number");
		long num=scanner.nextLong();
		scanner.nextLine();

		String result=reader.hexaDecimal(num);
		System.out.println(result);
	}
	
	case 4:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();

		String result=reader.divisible(num);
		System.out.println(result);
	}
	
	case 5:
		
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
  
		System.out.println("Enter the digit");
		int digit=scanner.nextInt();
		scanner.nextLine();

		int result=reader.largestNumber(num, digit);
		System.out.println(result);
	}
	
	case 6:
	{
		System.out.println("Enter a hexa value");
		String hexa=scanner.nextLine();
		
		String result=reader.hexaToBinary(hexa);
		System.out.println(result);
	}
	
	case 7:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
  
		int result=reader.getNum(num);
		System.out.println(result);
		
	}
	
	case 8:
	{
		System.out.println("Enter the  size");
		int num=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the x axis of queen");
		int x=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the y axis of queen");
		int y=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of  obstacle");
		int k=scanner.nextInt();
		scanner.nextLine();
		int[] kx1=new int[k];
		System.out.println("Enter the x axis");
		for(int i=0;i<k;i++)
		{
			kx1[i]=scanner.nextInt();
		}
		int[] ky1=new int[k];
		System.out.println("Enter the y axis");
		for(int i=0;i<k;i++)
		{
			ky1[i]=scanner.nextInt();
		}
		
		int result=reader.queenPath(num, x, y, kx1, ky1);
		System.out.println(result);

	}
	}
}
}
