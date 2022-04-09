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
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.rightTriangle(num);
	}
	case 2:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
        reader.leftTriangle(num);
	}
	case 3:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.pyramid(num);
	}
	
	case 4:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.sandGlass(num);
	}
	
	case 5:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.simpleNumber(num);
	}
	
	case 6:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.rightPascal(num);
	}
	
	case 7:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.ZPattern(num);
	}
	
	case 8:
	{
		System.out.println("Enter the number of rows");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.rectangle(num);
	}
	
	case 9:
	{
		System.out.println("Enter the size of array");
		int num=scanner.nextInt();
		scanner.nextLine();
		char[] arr=new char[num];
		for(int i=0;i<num;i++)
		{
			arr[i]=scanner.next().charAt(0);
		}
		reader.charArray(arr);
	}
	
	case 10:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		String result=reader.countAndSay(num);
		System.out.println(result);
	}
	
	case 11:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.diamond(num);
	}
	
	case 12:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.triangle(num);
	}
	
	case 13:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.hollowDiamond(num);
	}
	
	case 14:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.circularSpiral(num);
	}
	
	case 15:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.pascal(num);
	}
	case 16:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		reader.diamondNumber(num);
	}
	}
}
}
