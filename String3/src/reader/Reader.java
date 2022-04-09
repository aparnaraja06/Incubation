package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import customexception.CustomException;

public class Reader {

	
	public boolean rotation(String word1,String word2)throws CustomException
	{
		String newStr=word1+word1;
		
		if(newStr.contains(word2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public char nonRepeatedChar(String word)throws CustomException
	{
		char[] char_arr=word.toCharArray();
		int length=word.length();
		String newStr="";
		for(int i=0;i< length;i++)
		{
			if(word.lastIndexOf(char_arr[i])== word.indexOf(char_arr[i]))
			{
				newStr+=char_arr[i];
			}
		}
		
		if(newStr.isEmpty())
		{
			return '0';
		}
		else
		{
			//System.out.println("abcbac :"+newStr.charAt(0));
			return newStr.charAt(0);
		
		}
		
	}
	
	public List<String> compareTwoStr(String word1,String word2)throws CustomException
	{
		List<String> list=new ArrayList<>();
		
		int length1=word1.length();
		int length2=word2.length();
		String newStr1="";
		String newStr2="";
		//int index=0;
		int[] int_arr=new int[length1];
		//char[] char_arr=word2.toCharArray();
		if(length1 != length2)
		{
			throw new CustomException("Length of the strings should be equal");
		}
		
		int i=0;
		while(i<length1)
		{
			if(word1.charAt(i)!=word2.charAt(i))
			{
				int_arr[i]=i;
				i++;
			}
			else
			{   
				i++;
				continue;
			}
			i++;
		}
		System.out.println("Array : "+int_arr);
		for(int j=0;j<int_arr.length;j++)
		{
			newStr1=word1.substring(int_arr[j],int_arr[j+1]);
			newStr2=word2.substring(int_arr[j], int_arr[j+1]);
			list.add(newStr1);
			list.add(newStr2);
			newStr1="";
			newStr2="";
		}
		
		return list;
	}
	
	public List<String> find_permutation(char[] char_arr)throws CustomException
	{
		List<String> list=new ArrayList<>();
		Arrays.sort(char_arr);
		String sortStr=new String(char_arr);
		permutation("",sortStr,list);
		return list;
	}
	
	public void permutation(String addStr, String sortStr,List<String> list)
	{
		if(addStr!="" || sortStr.length()==0)
		{
			list.add(addStr);
		}
		
		for(int i=0;i<sortStr.length();i++)
		{
			permutation(addStr+sortStr.charAt(i),sortStr.substring(0, i)+sortStr.substring(i+1),list);
		}
	}
	
	public String palindrome(String word)throws CustomException
	{
		int length=word.length();
		char[] char_arr=new char[length];
		
		for(int i=0;i<length;i++)
		{
			char_arr[i]=word.charAt(i);
		}
		
		String temp="";
		String revStr="";
		String result="";
		for(int i=0;i<char_arr.length;i++)
		{
			if(char_arr[i]!=' ')
			{
				temp=char_arr[i]+temp;
				
			}
			
			else
			{
				//System.out.println("temp : "+temp);
				 revStr=reverse(temp);
				 if(!temp.equals(revStr))
				 {
					 result+=temp+" ";
				 }
				 revStr="";
				 temp="";
			}
		}	
	
		return result;
    }
	
	
	public String reverse(String word)
	{
		int length=word.length();
		String revStr="";
		for(int i=length-1;i>=0;i--) {
			revStr+=word.charAt(i);
		}
		return revStr;
		
	}
	
	public String commonFragment(String word1,String word2,String word3)throws CustomException
	{
		String result="";
		List<String> list=new ArrayList<>();
		String store="";
		for(int i=0;i<word1.length();i++)
		{
			if(word1.charAt(i)!=' ')
			{
				result+=word1.charAt(i);
			}
			else
			{
				if(word2.contains(result) && word3.contains(result))
				{
					list.add(result);
					result="";
				}
				else
				{
					result="";
				}
			}
		}
		
		for(String word:list)
		{
			store+=word+" ";
		}
		return store;
		
	}
	
	public int longestSubStr(String word)throws CustomException
	{
		List<Character> list=new ArrayList<>();
		
		int i=0,length=0;
		
		while(i<word.length())
		{
			if(list.contains(word.charAt(i)))
			{
				list.remove(0);
			}
			else
			{
				list.add(word.charAt(i));
				length=Math.max(length, list.size());
				i++;
			}
		}
		return length;
	}
	
	public int longestPrefix(String word)throws CustomException
	{
		int length=word.length();
		int[] int_arr=new int[length];
		int i=0,j=1;
		
		while(j<length)
		{
			if(word.charAt(i)==word.charAt(j))
			{
				int_arr[j]=i+1;
				i++;
				j++;
			}
			else
			{
				if(i==0)
				{
					int_arr[j]=0;
					j++;
				}
				else
				{
					i=int_arr[i-1];
				}
			}
		}
		return int_arr[length-1];
	}
	
	public String lexicograph(String word1,String word2)throws CustomException
	{
		int length1=word1.length();
		int length2=word2.length();
		String result="";
		
		if(length1 != length2)
		{
			throw new CustomException("Both the word should be of same length");
		}
		
		for(int i=0;i<length1;i++)
		{
			if(word1.charAt(i)!=word2.charAt(i))
			{
				char character=getCharacter(word1.charAt(i),word2.charAt(i));
				if(character=='0')
				{
					return "0";
				}
				result+=character;
			}
			else
			{
				result+=word1.charAt(i);
			}
		}
		return result;
	}
	
	public char getCharacter(char letter1, char letter2)
	{
		String alphabets="abcdefghijklmnopqrstuvwxyz";
		
		int from=alphabets.indexOf(letter1);
		int to=alphabets.indexOf(letter2);
		
		if(to==from+1)
		{
			return '0';
		}
		String characters=alphabets.substring(from+1, to);
		
		char character=characters.charAt(0);
		return character;
	}
	
	public List<String> mappingDigits(String number)throws CustomException
	{
		List<String> list=new ArrayList<>();
		validNumber(number,list,"");
		return list;
	}
	
	public void validNumber(String number,List<String> list,String store)
	{
		String[] letters= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		if(number.isEmpty())
		{
			list.add(store);
			return;
		}
		
		int digit=(int)number.charAt(0)-'0';
		int length=letters[digit].length();
		for(int i=0;i<length;i++)
		{
			char character=(char)(letters[digit].charAt(i));
			validNumber(number.substring(1),list,store+character);
		}
	}
	
	public String convertNumber(int number)throws CustomException
	{
		int length=String.valueOf(number).length();
		int numberr=number%1000;
		String word="";
	    int first=number/1000;
		if(length==4)
		{
			String temp=threeDigits(first);
			word=temp+" thousand ";
		}
		
			String store=threeDigits(numberr);
			word+=store;

		
		return word;
	}
	
	public String threeDigits(int number)
	{
		String[] numbers= {"","one","two","three","four","five","six","seven","eight","nine"};
		String[] twoDigit= {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
				"seventeen","eighteen","nineteen"};
		String[] tenValues= {"","","twenty","thirty","forty","fifty","sixty","seventy",
				"eighty","ninety"};
		
		String store="";
		int num=number%100;
		
		if(num<10)
		{
			store+=numbers[num];
		}
		else if(num<20)
		{
			store +=twoDigit[num%10];
		}
		else
		{
			store =tenValues[num/10]+numbers[num%10];
		}
		
		if(number/100 >0) {
			store=numbers[number/100]+" hundred and "+store;
		}
		return store;
	}
}
