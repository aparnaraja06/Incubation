package runner;


import java.util.Scanner;

import customexception.CustomException;
import reader.Reader;

public class runner {
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
		System.out.println("Enter a string");
		String word=scanner.nextLine();
		try
		{
			boolean result=reader.pangram(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 2:
	{
		System.out.println("Enter first string");
		String word1=scanner.nextLine();
		System.out.println("Enter second string");
		String word2=scanner.nextLine();
		try
		{
			String result=reader.removeChar(word1, word2);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 3:
	{
		System.out.println("Enter brackets");
		String bracket=scanner.nextLine();
		try
		{
			boolean result=reader.validParantheses(bracket);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 4:
	{
		System.out.println("Enter a string");
		String word=scanner.nextLine();
		try
		{
			String result=reader.reverseVowel(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 5:
	{
		System.out.println("Enter a string");
		String word=scanner.nextLine();
		try
		{
			String result=reader.firstLetter(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	case 6:
	{
		System.out.println("Enter first string");
		String word1=scanner.nextLine();
		System.out.println("Enter second string");
		String word2=scanner.nextLine();
		try
		{
			boolean result=reader.rotate(word1, word2);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 7:
	{
		System.out.println("Enter first string");
		String word1=scanner.nextLine();
		System.out.println("Enter second string");
		String word2=scanner.nextLine();
		try
		{
			boolean result=reader.isomorphic(word1, word2);
			if(result)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("0");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

	}
	
	case 8:
	{
		System.out.println("Enter an ip address");
		String ip=scanner.nextLine();
		try
		{
			boolean result=reader.validateIp(ip);
			if(result)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("0");
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 9:
	{
		System.out.println("Enter first string");
		String word1=scanner.nextLine();
		System.out.println("Enter second string");
		String word2=scanner.nextLine();
		try
		{
			boolean result=reader.findPermutation(word1, word2);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 10:
	{
		System.out.println("Enter a string");
		String roman=scanner.nextLine();
		try
		{
			int result=reader.roman(roman);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 11:
	{
		System.out.println("Enter a string");
		int word=scanner.nextInt();
		scanner.nextLine();
		try
		{
			String result=reader.countSay(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	case 12:
	{
		System.out.println("Enter a string");
		String word=scanner.nextLine();
		try
		{
			int result=reader.palindrome(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

	}
	}
}
}
