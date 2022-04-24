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
		System.out.println("Enter the number 1");
		int num1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 2");
		int num2=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.numOfPaths(num1, num2);
		System.out.println(result);

	}
	
	case 2:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.squareRoot(num);
		System.out.println(result);
	}
	
	case 3:
	{
		System.out.println("Enter the number");
		String num=scanner.nextLine();
        
		boolean result=reader.balanced(num);
		System.out.println(result);
		
	}
	
	case 4:
	{
		System.out.println("Enter the number");
		long num=scanner.nextInt();
		scanner.nextLine();
		
		long result=reader.palindrome(num);
		System.out.println(result);
	}
	
	case 5:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
        
		long result=reader.oddFactor(num);
		System.out.println(result);
	}
	
	case 6:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.doors(num);
		System.out.println(result);
	}
	
	case 7:
	{
		System.out.println("Enter the number");
		long num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.perfectNumber(num);
		System.out.println(result);
	}
	
	case 8:
	{
		System.out.println("Enter the number 1");
		int num1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 2");
		int num2=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 3");
		int num3=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 4");
		int num4=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 5");
		int num5=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 6");
		int num6=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 7");
		int num7=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 8");
		int num8=scanner.nextInt();
		scanner.nextLine();
		
		String result=reader.isSquare(num1, num2, num3, num4, num5, num6, num7, num8);
		System.out.println(result);
	}
	
	case 9:
	{
		System.out.println("Enter the number 1");
		long num1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 2");
		long num2=scanner.nextInt();
		scanner.nextLine();
 
		long result=reader.isPower(num1, num2);
		System.out.println(result);
	}
	
	case 10:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		boolean result=reader.luckyNum(num);
		System.out.println(result);
	}
	
	case 11:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
       
		int result=reader.twistedPrime(num);
		System.out.println(result);
		
	}
	}
}
}
