package runner;

import java.util.List;
import java.util.Scanner;

import customexception.CustomException;
import reader.Reader;

public class runner {
public static void main(String[] args)
{
	Scanner scanner= new Scanner(System.in);
	Reader reader=new Reader();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter first word");
		String word1=scanner.nextLine();
		System.out.println("Enter second word");
		String word2=scanner.nextLine();
		try
		{
			boolean result=reader.rotation(word1, word2);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 2:
	{
		System.out.println("Enter a word");
		String word=scanner.nextLine();
		try
		{
			char result=reader.nonRepeatedChar(word);
			if(result=='0')
			{
				System.out.println("No matches available");
			}
			else
			{
				System.out.println(result);
			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;

	}
	
	case 3:
	{
		System.out.println("Enter first word");
		String word1=scanner.nextLine();
		System.out.println("Enter second word");
		String word2=scanner.nextLine();
		try
		{
			List<String> list=reader.compareTwoStr(word1, word2);
			System.out.println(list);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
         break;
	}
	
	case 4:
	{
		System.out.println("Enter the number of characters");
		int number=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the characters");
		char[] char_arr=new char[number];
		for(int i=0;i<number;i++)
		{
			char_arr[i]=scanner.next().charAt(0);
		}
		try
		{
			List<String> list=reader.find_permutation(char_arr);
			System.out.println(list);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 5:
	{
		System.out.println("Enter a word");
		String word=scanner.nextLine();
		try
		{
           String result=reader.palindrome(word);
           System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 6:
	{
		System.out.println("Enter first word");
		String word1=scanner.nextLine();
		System.out.println("Enter second word");
		String word2=scanner.nextLine();
		System.out.println("Enter third word");
		String word3=scanner.nextLine();
		try
		{
			String result=reader.commonFragment(word1, word2, word3);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 7:
	{
		System.out.println("Enter a word");
		String word=scanner.nextLine();
		try
		{
			int result=reader.longestSubStr(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 8:
	{
		System.out.println("Enter a word");
		String word=scanner.nextLine();
		try
		{
			int result=reader.longestPrefix(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 9:
	{
		System.out.println("Enter first word");
		String word1=scanner.nextLine();
		System.out.println("Enter second word");
		String word2=scanner.nextLine();
        try
        {
        	String result=reader.lexicograph(word1, word2);
        	if(result=="0")
        	{
        		System.out.println("No such String");
        	}
        	else
        	{
        	System.out.println(result);
        	}
        }catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 10:
	{
		System.out.println("Enter a word");
		String word=scanner.nextLine();
		try
		{
			List<String> list=reader.mappingDigits(word);
			System.out.println(list);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 11:
	{
		System.out.println("Enter a word");
		int number=scanner.nextInt();
		scanner.nextLine();
		try
		{
			String word=reader.convertNumber(number);
			System.out.println(word);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	}
}
}
