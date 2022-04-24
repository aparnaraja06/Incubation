package reader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import customexception.CustomException;

public class Reader {
	
	public void validate(String str)throws CustomException
	{
		if(str==null || str.isEmpty())
		{
			throw new CustomException("Input should not be empty or null");
		}
	}
	
	public void validate(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Array should not be empty");
		}
	}
	
	public void validate(int num)throws CustomException
	{
		if(num<0)
		{
			throw new CustomException("Number should contain positive value");
		}
	}
	public boolean rotation(String word1,String word2)throws  CustomException
	{
		validate(word1);
		validate(word2);
		String result=word1+word1;
		
		if(result.contains(word2))
		{
			return true;
		}
		return false;
	}
	
	public List<String> pairOfNumbers(int[] arr,int sum)throws CustomException
	{
		validate(arr);
		validate(sum);
		String num1="";
		String num2="";
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
			if(arr[i]+arr[j]==sum)
			{
				num1+="("+String.valueOf(arr[i]);
				num2+=String.valueOf(arr[j])+")";
				
				list.add(num1);
				list.add(num2);
			}
			num1="";
			num2="";
			}
		}
		return list;
	}
	
	public int maximumSum(int[] arr,int num)throws CustomException
	{
		validate(arr);
		validate(num);
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<num;i++)
		{
			sum+=arr[i];			
			max=Math.max(sum, max);
		}
		return max;
	}
	
	public void countAndSay(int num)throws CustomException
	{
		validate(num);
		String result="1";
	    System.out.println(result);
		for(int i=0;i<num-1;i++)
		{
			String next="";
			int j=0;
		
			while(j< result.length())
			{
				int count=1;
				
				while(j<result.length()-1 && result.charAt(j)==result.charAt(j+1))
				{
					count++;
					j++;
				}
				next+=Integer.toString(count)+result.charAt(j);
				j++;
			}
			result=next;
			System.out.println(result);
		}
	}
}
