package reader;

import java.util.ArrayList;
import java.util.List;

import bst.BST;
import node.Node;

public class Reader {

	BST call=new BST();
	
	public boolean validIp(String number)
	{
		int dot=0;
		
		for(int i=0;i<number.length();i++)
		{
			if(number.charAt(i)=='.')
			{
				dot++;
			}
		}
		
		if(dot !=3)
		{
			return false;
		}
		
		String[] words=number.split("\\.");
		if(words.length != 4)
		{
			return false;
		}
		
		for(String word: words)
		{
			if(word.length() > 3)
			{
				return false;
			}
		
		int temp=0;
		try
		{
			temp=Integer.parseInt(word);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		if(temp<0 || temp>255)
		{
			return false;
		}
		}
		return true;
	}
	
	public int[][] rotate(int[][] arr,int num)
	{
		transpose(arr,num);
		
		for(int i=0;i<arr.length;i++)
		{
			reverse(arr,i);
		}
		return arr;
	}
	
	public void transpose(int[][] arr,int num)
	{
		for(int i=0;i<num;i++)
		{
			for(int j=i+1;j<num;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
	}
	
	public void reverse(int[][] arr,int change)
	{
		int low=0;
		int high=arr.length-1;
		
		while(low<high)
		{
			int temp=arr[low][change];
			arr[low][change]=arr[high][change];
			arr[high][change]=temp;
			
			low++;
			high--;
		}
	}
	
	public void numberOfTimes(int[] arr)
	{
		String temp="";
		String countt="";
		String result="";
		//int j=1;
		List<String> list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
		{
			int count=1;
			for(int j=i+1;j<arr.length;j++)
			{
			if(arr[i]==arr[j])
			{
				count++;
			}
			}
			temp=Integer.toString(arr[i]);
			countt="-"+Integer.toString(count);
			if(!list.contains(temp))
			{
			list.add(temp);
			list.add(countt);
			result+=temp+countt+"\n";
			}	
			count=0;

			}
			
		//temp="";
		System.out.println(result);
	
	}
	
	public Node subTree(Node node,int val)
	{
		Node change=call.insert(node,val);
		Node result=call.getChild(change, val);
		return result;
	}
}
