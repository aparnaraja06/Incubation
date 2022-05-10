package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import customexception.CustomException;

public class Practice {
	
	public int chocolate(int[] arr,int mid)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		Arrays.sort(arr);
		int diff=Integer.MAX_VALUE;
		
		 return helper(arr,mid,0,diff);
		
		//return diff;
	}
	
	public int helper(int[] arr,int mid,int start,int diff)
	{
		
		
		
		for(int i=start;i<mid-1;i++)
		{
			if(arr[mid-1]-arr[start] < diff)
			{
				diff=arr[mid-1]-arr[start];
			}
		}
		
		if(mid==arr.length-1)
		{
			return diff;
		}
		
		return helper(arr,mid+1,start+1,diff);
	}
	
	public int nCents(int[] arr,int size,int count)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int[] int_arr=new int[size+1];
		
		int_arr[0]=1;
		
		for(int i=0;i<count;i++)
		{
			for(int j=arr[i];j<=size;j++)
			{
				int_arr[j]+=int_arr[j-arr[i]];
			}
		}
		
		return int_arr[size];
	}
	
	public int[] closestSum(int[] arr,int sum,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int left=0,right=0;
		
		int[] int_arr=new int[2];
		int start=0;
		int end=arr.length-1;
		int add=Integer.MAX_VALUE;
		
		while(start<end)
		{
			if((Math.abs(arr[end]+arr[start])-sum) < add)
			{
				add=Math.abs(arr[end]+arr[start]-sum);
				left=start;
				right=end;
			}
			
			if(arr[end]+arr[start] > sum)
			{
				end--;
				
			}
			else
			{
				start++;
			
			}
		}
		
		int_arr[0]=arr[left];
		int_arr[1]=arr[right];
		
		return int_arr;
	}
	
	public List<Integer> rotate(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		List<Integer> list=new ArrayList<>();
		
		int length=arr.length-1;

		int last=arr[length];
		list.add(last);
		
		for(int i=0;i<length;i++)
		{
			list.add(arr[i]);
		}
		return list;
	}
	
	public List<String> mismatchElement(char[] arr1,char[] arr2)throws CustomException
	{
		if(arr1==null || arr2==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		List<String> list=new ArrayList<>();
		
		String temp="";
		
		for(int i=0;i<arr1.length;i++)
		{
			
				if(arr1[i] != arr2[i] && i<arr1.length-1 && arr1[i+1] != arr2[i+1])
				{
					temp+=arr1[i]+""+arr2[i];
					list.add(temp);
					temp="";
					
					temp+=arr1[i+1]+""+arr2[i+1];
					list.add(temp);
					temp="";
					i++;
				}
				
				else
				{
					if(arr1[i] != arr2[i])
					{
						temp+=arr1[i]+"";
						list.add(temp);
						temp="";
						
						temp+=arr2[i]+"";
						list.add(temp);
						temp="";
					}
			}
		}
		
		return list;
	}
	
	public ArrayList<Integer> sumPair(int[] arr,int sum)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int num1=0;
		int num2=0;
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]+arr[j]==sum)
				{
					num1=arr[i];
					num2=arr[j];
					
					list.add(num1);
					list.add(num2);
				}
			}
		}
		
		return list;
	}
	
	public int[] rotateLength(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int length=arr.length;
		
		for(int i=0;i<length;i++)
		{
		int last=arr[length-1];
		
		for(int j=length-1;j>0;j--)
		{
			arr[j]=arr[j-1];
		}
		
		arr[0]=last;
		}
		
		return arr;
	}
	
	public HashSet<Integer> union(ArrayList<Integer> list1,ArrayList<Integer> list2)throws CustomException
	
	{
		if(list1==null || list2==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		HashSet<Integer> set=new HashSet<>();
		
		for(int i=0;i<list1.size();i++)
		{
			set.add(list1.get(i));
		}
		
		for(int i=0;i<list2.size();i++)
		{
			set.add(list2.get(i));
		}
		
		return set;
	}
	
	public ArrayList<Integer> intersect(ArrayList<Integer> list1,ArrayList<Integer> list2)throws CustomException
	{
		if(list1==null || list2==null)
		{
			throw new CustomException("Input should not be null");
		}

		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++)
		{
			if(list2.contains(list1.get(i)))
			{
				list.add(list1.get(i));
			}
		}
		
		return list;
	}
	
	public ArrayList<Integer> except(ArrayList<Integer> list1,ArrayList<Integer> list2)throws CustomException
	{
		if(list1==null || list2==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		ArrayList<Integer> list=new ArrayList<>();
		
		for(int i=0;i<list1.size();i++)
		{
			if(list1.get(i)%2 ==0)
			{
				list.add(list1.get(i));
			}
		}
		
		for(int i=0;i<list2.size();i++)
		{
			
			if(list2.get(i)%2 !=0 )
			{
				list.add(list2.get(i));
			}
		}
		
		return list;


	}
	
	public void numOfTimes(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		List<String> list=new ArrayList<>();
		
		String temp="";
		String countt="";
		String result="";
		
		int count=0;
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++)
		{
			count=1;
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
		
		System.out.println(result);
		
		
	}
	
	public int grandSons(Map<String,List<String>> map,String name,int level)throws CustomException
	{
		if(map==null)
		{
			throw new CustomException("Input should not be null");

		}
		
		List<String> son=new ArrayList<>();
		List<String> grandson=new ArrayList<>();
		
		if(map.containsKey(name))
		{
			son.addAll(map.get(name));
		}
		
		if(level==1)
		{
			return son.size();
		}
		
		else if(level==2)
		{
		for(int i=0;i<son.size();i++)
		{
			grandson.addAll(map.get(son.get(i)));
		}
		}
		
		return grandson.size();
	}
	
	public boolean nonDecreasingArray(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int count=0;

		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]<arr[i+1])
			{
				count++;
			}
		}
		if(count>1) {
			return false;
		}
		
		return true;
	}
	
	public int maximumProduct(List<Integer> arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int max=Integer.MIN_VALUE;
		int product=1;
		
		for(int i=0;i<arr.size()-1;i++)
		{
			product*=arr.get(i);
			
			max=Math.max(max, product);
		}
		
		return max;
	}
	
	public int perfectNumber(int number)throws CustomException
	{
		String result="";
		int temp=0;
		int diff=0;
		temp=sumOfDigits(number);
		diff=Math.abs(10-temp);
		result=number+""+diff;
		return Integer.parseInt(result);
	}

	public int sumOfDigits(int number)
	{
		int sum=0;
		
		while(number!=0)
		{
			sum+=number%10;
			number=number/10;
		}
		return sum;
	}
	
	public int[] leftRotate(int[] arr,int count)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		for(int i=0;i<count;i++)
		{
			rotation(arr);
		}
		
		return arr;

	}
	
	public void rotation(int[] arr)
	{
		int length=arr.length;
		int last=arr[0];
		
		for(int i=0;i<length-1;i++)
		{
			arr[i]=arr[i+1];
		}
		arr[length-1]=last;
	}
	
	public int[] ascendingSum(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int first=0;
		int next=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
			first=sumOfDigits(arr[i]);
			next=sumOfDigits(arr[j]);
			
			if(first>next || first==next && arr[i] < arr[j])
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
			}
		}
		return arr;
	}
	
	public int[] minimumDifference(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int num1=0,num2=0;
		
		int[] int_arr=new int[2];
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(Math.abs(arr[i]-arr[j])<min)
				{
					min=Math.abs(arr[i]-arr[j]);
					num1=arr[i];
					num2=arr[j];
				}
			}
		}
		
		int_arr[0]=num1;
		int_arr[1]=num2;
		
		return int_arr;
	}

}
