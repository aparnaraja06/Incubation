package runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import customexception.CustomException;
import middle.pattern.MiddlePattern;

public class StringRunner {
public static void main(String[] args)
{
	Scanner scanner = new Scanner(System.in);
	MiddlePattern middle = new MiddlePattern();
	System.out.println("Enter the number to test");
	int option = scanner.nextInt();
	scanner.nextLine();
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter a string with odd length");
		String word=scanner.nextLine();
		try {
			String result = middle.middlePattern(word);
			System.out.println(result);
			
		} 
		catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		break;
	}
	case 2:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		System.out.println("Enter a character");
		char character= scanner.nextLine().charAt(0);
		System.out.println("Enter the count");
		int count=scanner.nextInt();
		scanner.nextLine();
		try
		{
			String result=middle.remainingStr(word, character, count);
			System.out.println(result);
			
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 3:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		try
		{
			String result=middle.reverseEach(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}

        break;
	}
	
	case 4:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		try
		{
			String result=middle.reverseSpace(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 5:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		System.out.println("Enter operations");
		int operation=scanner.nextInt();
		scanner.nextLine();
		try
		{
			boolean result=middle.kPangram(word, operation);
			if(!result)
			{
				System.out.println("0");
			}
			else
			{
				System.out.println("1");

			}
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
		break;
	}
	
	case 6:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		try
		{
			int result=middle.maximumChar(word);
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
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		int length=word.length();
		System.out.println("Enter indices to set");
		int[] int_arr=new int[length];
		for(int i=0;i<length;i++)
		{
			 int_arr[i] = scanner.nextInt();
		}
		scanner.nextLine();
		try
		{
           String result=middle.shuffleString(word, int_arr);
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
		System.out.println("Enter number of words in array");
		int number1=scanner.nextInt();
		scanner.nextLine();
		String[] array1= new String[number1];
		for(int i=0;i<number1;i++)
		{
			array1[i] = scanner.nextLine();
		}
		System.out.println("Enter number of words in second array");
		int number2=scanner.nextInt();
		scanner.nextLine();
		String[] array2= new String[number2];
		for(int i=0;i<number2;i++)
		{
			array2[i] = scanner.nextLine();
		}
		try
		{
			boolean result=middle.twoStrArray(array1, array2);
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
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		try
		{
			String result=middle.crossChar(word);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 10:
	{
		System.out.println("Enter a string ");
		String word=scanner.nextLine();
		try
		{
			List<String> list=middle.findPermutation(word);
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
		System.out.println("Enter the number of strings");
		int number=scanner.nextInt();
		scanner.nextLine();
		String[] str_arr=new String[number];
		for(int i=0;i<number;i++)
		{
			str_arr[i]=scanner.nextLine();
		}
		try
		{
			List<List<String>> list=middle.anagram(str_arr);
			System.out.println(list);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
		
	}
	
	case 12:
	{
		
		  System.out.println("Enter the number of strings"); 
		  int number=scanner.nextInt(); 
		  scanner.nextLine();
		 
		System.out.println("Enter the words");
		List<String> list=new ArrayList<>();
		for(int i=0;i<number;i++)
		{
			String word=scanner.nextLine();
			list.add(word);
		}
		System.out.println("Enter a word to check");
		String check=scanner.nextLine();
		try
		{
			int result=middle.wordBreak(check, list);
			System.out.println(result);
		}
		catch(CustomException e)
		{
			System.out.println(e.getMessage());
		}
        break;
	}
	
	case 13:
	{
		System.out.println("Enter a string");
		String word=scanner.nextLine();
		try
		{
			int result=middle.totalDecoding(word);
			System.out.println(result);
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

