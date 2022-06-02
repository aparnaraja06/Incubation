package reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Reader {
	
	public boolean rotation(String word1,String word2)
	{
		if(word1==null || word1.isEmpty() || word2==null || word2.isEmpty())
		{
			return false;
		}
		
		if(word1.length() != word2.length())
		{
			return false;
		}
		
		//String rotate=rotateLength(word1);
		char[] arr=new char[word1.length()];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=word1.charAt(i);
		}
		String temp=rotateSample(arr);
		//System.out.println(temp);
		
		for(int i=0;i<word2.length();i++)
		{
			if(temp.charAt(i)!=word2.charAt(i))
			{
				return false;
			}
		}
				
		return true;
	}
	
	
	public String rotateSample(char[] word)
	{
		int length=word.length;
		char[] rev=new char[length];
		//String result="";
		for(int i=0;i<length;i++)
		{
			char last=word[length-1];
			for(int j=length-1;j>0;j--)
			{
				rev[j]=word[j-1];
			}
			rev[0]=last;
		}
		

		String result=String.valueOf(rev);
		return result;
		
	}
	
	/*public List<Integer> commonElement(int[] arr1,int[] arr2,int[] arr3)
	{
		if(arr1==null || arr2==null || arr3==null)
		{
			return null;
		}
		
		List<Integer> list=new ArrayList<>();
		List<Integer> result=new ArrayList<>();
		
		for(int i=0;i<arr1.length;i++) 
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					list.add(arr1[i]);
					
				}
			}
		}
		
		//int count=0;
		
		for(int i=0;i<arr3.length;i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(arr3[i]==list.get(j))
				{
					result.add(arr3[i]);
					
				}
			}
			
		}
		
				
		return result;
	}*/
	
	public List<Integer> common(int[] arr1,int[] arr2,int[] arr3)
	{
		if(arr1==null || arr2==null || arr3==null)
		{
			return null;
		}
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr1.length;i++)
		{
			map.put(arr1[i], map.getOrDefault(arr1[i], 0)+2);
		}
		
		for(int i=0;i<arr2.length;i++)
		{
			if(map.getOrDefault(arr2[i], 0)>0)
			{
				map.put(arr2[i], map.getOrDefault(arr2[i], 0)-1);
			}
		}
		
		for(int i=0;i<arr3.length;i++)
		{
			if(map.getOrDefault(arr3[i], 0) > 0)
			{
				map.put(arr3[i], map.getOrDefault(arr3[i], 0)-1);
			}
		}
		
		List<Integer> list=new ArrayList<>();
		
		for(Entry<Integer,Integer> entry:map.entrySet())
		{
			if(entry.getValue()==0)
			{
				list.add(entry.getKey());
			}
		}
		return list;
	}
	
	public int[] mergeArrays(int[] arr1,int[] arr2)
	{
		
		if(arr1==null || arr2==null)
		{
			return null;
		}
		
		arr1=mergeSort(arr1);
		arr2=mergeSort(arr2);
		
		int[] arr=new int[arr1.length+arr2.length];
		
		
		for(int i=0;i<arr1.length;i++)
		{
			arr[i]=arr1[i];
		}
		
		int index=arr1.length;
		
		for(int i=0;i<arr2.length;i++)
		{
			arr[index++]=arr2[i];
		}
		
		int[] result=mergeSort(arr);
		
		/*for(int i=0;i<result.length;i++)
		{
		System.out.println("Result : "+result[i]);
		}*/
		
		int start=0;
		int end=result.length-1;
		int i=0;
		
		while(start<=end)
		{
			if(i%2==0)
			{
				arr[i]=result[start];
				start++;
				i++;
			}
			else
			{
				
				arr[i]=result[end];
				end--;
				i++;
			}
			
		

		}
		
		return arr;

	}
	
	public int[] mergeSort(int[] arr)
	{
		if(arr.length<=1)
		{
			return arr;
		}
		
		int mid=arr.length/2;
		
		int[] left=new int[mid];
		
		int[] right;
		
		if(arr.length % 2==0)
		{
			right=new int[mid];
		}
		else
		{
			right=new int[mid+1];
		}
		
		for(int i=0;i<mid;i++)
		{
			left[i]=arr[i];
		}
		
		for(int j=0;j<right.length;j++)
		{
			right[j]=arr[mid+j];
		}
		
		int[] result=new int[arr.length];
		
		left=mergeSort(left);
		right=mergeSort(right);
		
		result=merge(left,right);
		
		return result;
	}
	
	public int[] merge(int[] left,int[] right)
	{
		int[] result=new int[left.length+right.length];
		
		int leftPoint=0,rightPoint=0,resultPoint=0;
		
		while(leftPoint<left.length || rightPoint<right.length)
		{
			
			if(leftPoint<left.length && rightPoint<right.length)
			{
				if(left[leftPoint] < right[rightPoint])
				{
					result[resultPoint++]=left[leftPoint++];
				}
				else
				{
					result[resultPoint++]=right[rightPoint++];

				}
			}
			else if(leftPoint<left.length)
			{
				result[resultPoint++]=left[leftPoint++];
			}
			else if(rightPoint<right.length)
			{
				result[resultPoint++]=right[rightPoint++];
			}

		}
		return result;
	}
	
	/*public String rotateLength(String word)
	{
		int length=word.length();
		char last=word.charAt(length-1);
		String rev="";
		String result="";
		for(int i=0;i<length-1;i++)
		{
			rev+=word.charAt(i);
		}
		
		result+=last+rev;
		
		return result;
		
		
	}*/
	

}
