package runner;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	/*case 6:
	{
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		int result=reader.doors(num);
		System.out.println(result);
	}*/
	
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
		
		boolean result=reader.lucky(num);
		System.out.println(result);
	}
	
	case 12:
	{
		System.out.println("Enter the number 1");
		long num1=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number 2");
		long num2=scanner.nextInt();
		scanner.nextLine();

		long result=reader.maxVolume(num1,num2);
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
	
	case 13:
	{
		System.out.println("Enter the size of array");
		int num1 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the values");
		int[] int_arr1 = new int[num1];
		for (int i = 0; i < num1; i++) {
			int_arr1[i] = scanner.nextInt();
		}
		System.out.println("Enter the size of array");
		int num2 = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the values");
		int[] int_arr2 = new int[num2];
		for (int i = 0; i < num2; i++) {
			int_arr2[i] = scanner.nextInt();
		}
		
		int result=reader.petrol(int_arr1,int_arr2);
		System.out.println(result);
	}
	}
}
}
