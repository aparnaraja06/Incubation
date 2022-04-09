package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;

public class Reader {

	public boolean pangram(String sentence) throws CustomException {
		int length = sentence.length();
		boolean[] alphabet = new boolean[length];
		int count = 0;
		int index = 0;

		if (length < 26) {
			return false;
		}

		for (int i = 0; i < length; i++) {
			if (sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
				index = sentence.charAt(i) - 'a';
			}
			alphabet[index] = true;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[index] == false) {
				count++;
			}
		}

		if (count != 0) {
			return false;
		} else {
			return true;
		}
	}

	public String removeChar(String word1, String word2) throws CustomException {
		for (int i = 0; i < word2.length(); i++) {
			for (int j = 0; j < word1.length(); j++) {
				if (word2.charAt(i) == word1.charAt(j)) {
					char character = word1.charAt(j);
					word1 = word1.replace(String.valueOf(character), "");
				}
			}
		}
		return word1;

	}

	public boolean validParantheses(String bracket) throws CustomException {
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;

		for (int i = 0; i < bracket.length(); i++) {
			if (bracket.charAt(i) == '(' || bracket.charAt(i) == ')') {
				count1++;
			}

			if (bracket.charAt(i) == '[' || bracket.charAt(i) == ']') {
				count2++;
			}
			if (bracket.charAt(i) == '{' || bracket.charAt(i) == '}') {
				count3++;
			}

		}

		if (count1 % 2 != 0 || count2 % 2 != 0 || count3 % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}

	public String reverseVowel(String word) throws CustomException {
		int start = 0;
		int end = word.length()-1;
		char[] char_arr=word.toCharArray();

		while (start < end) {
			if (!check(char_arr[start])) {
				start++;
				continue;
			}
			if (!check(char_arr[end])) {
				end--;
				continue;
			}
			else
			{
				char temp=char_arr[start];
				char_arr[start]=char_arr[end];
				char_arr[end]=temp;
			}
			start++;
			end--;
		}
		String result=new String(char_arr);
		return result;
	}
	
	public boolean check(char character)
	{
		if(character=='a' || character=='e'|| character=='i'|| character=='o' || character=='u')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public String firstLetter(String word)throws CustomException
	{
		String[] words=word.split(" ");
		String result="";
		
		for(String temp : words)
		{
			result+=temp.charAt(0);
		}
		return result;
	}
	
	public boolean rotate(String word1, String word2)throws CustomException
	{
		int length=word1.length();
		String store=word1+word1;
		
		if(store.indexOf(word2)==2 || store.indexOf(word2)==length-2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isomorphic(String word1,String word2)throws CustomException
	{
		Map<Character,Character> store=new HashMap<>();
		int length1=word1.length();
		int length2=word2.length();
		
		if(length1 != length2)
		{
			return false;
		}
		
		for(int i=0;i<length1;i++)
		{
			char character1=word1.charAt(i);
			char character2=word2.charAt(i);
			
			if(store.containsKey(character1))
			{
				if(store.get(character1) != character2)
				{
					return false;
				}
			}
			else
			{
		    if(store.containsValue(character2))
		    {
		    	return false;
		    }
		    store.put(character1,character2);
			}
		}
		
		return true;
	}
	
	public boolean validateIp(String word)throws CustomException
	{
		int dot=0;
		for(int i=0;i<word.length();i++)
		{
			if(word.charAt(i)=='.')
			{
				dot++;
			}
		}
		
		if(dot != 3)
		{
			return false;
		}
		String[] words=word.split("\\.");
		
		if(words.length != 4)
		{
			return false;
		}
		
		for(String each:words)
		{
			int length=each.length();
			
			if(length != 1 && each.startsWith("0"))
			{
				return false;
			}
			if(length > 3)
			{
				return false;
			}
			int number=0;
			try
			{
			number=Integer.parseInt(each);
			}
			catch(NumberFormatException e)
			{
				return false;
			}
			
			if(number<0 || number>255)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean findPermutation(String word1, String word2)throws CustomException
	{
		List<String> list=new ArrayList<>();
		char[] char_arr=word1.toCharArray();
		Arrays.sort(char_arr);
		String result=new String(char_arr);
	
		permutation("",result,list);
		boolean isValid=false;
		for(String word:list)
		{
			if(word2.contains(word))
			{
				isValid=true;
			}
		}
		return isValid;
		
	}
	
	public void permutation(String addStr,String sortStr,List<String> list)
	{
		if(sortStr.length()==0)
		{
			list.add(addStr);
		}
		
		for(int i=0;i<sortStr.length();i++)
		{
			permutation(addStr+sortStr.charAt(i),sortStr.substring(0, i)+sortStr.substring(i+1),list);
		}
	}
	
	public int roman(String word)throws CustomException
	{
		Map<Character,Integer> map=new HashMap<>();
		int result=0;
		
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L',50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		for(char character:word.toCharArray())
		{
			int value=map.get(character);
			result+=value;
		}
		return result;
	}
	
	public String countSay(int number)throws CustomException
	{
		//System.out.println("MEthod called");
		String current="1";
		
		for(int i=0;i<number-1;i++)
		{
			String next=" ";
			int j=0;
			while(j<current.length())
			{
				int count=1;
				
				while(j< current.length()-1 && current.charAt(j)==current.charAt(j+1))
				{
					count++;
					j++;
				}
				next+=Integer.toString(count)+ current.charAt(j);
				j++;
			}
			current=next;
			
		}
		return current;
	}
	
	public int palindrome(String word)throws CustomException
	{
		int length=word.length();
		String revStr="";
		
		for(int i=length-1;i>=0;i--)
		{
			revStr+=word.charAt(i);
		}
		
		int[][] arr=new int[length+1][length+1];
		
		for(int i=1;i<arr.length;i++)
		{
			for(int j=1;j<arr.length;j++)
			{
				if(word.charAt(i-1)==revStr.charAt(j-1))
				{
				arr[i][j]=1+arr[i-1][j-1];
				}
				else
				{
					arr[i][j]=Math.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		System.out.println("Arr len "+arr[length][length]);
		return length-arr[length][length];
	}
}
