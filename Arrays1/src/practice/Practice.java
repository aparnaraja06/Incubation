package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import customexception.CustomException;

public class Practice {
	
	public int[] smallNum(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int[] int_arr=new int[arr.length];
		int count=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					count++;
				}
			}
			
			int_arr[i]=count;
			count=0;
		}
		
		return int_arr;
	}
	
	public int kadane(int num,int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int max=Integer.MIN_VALUE;
		int sum=0;
		
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			max=Math.max(max, sum);
			if(sum<0)
			{
				sum=0;
			}
		}
		
		return sum;
	}
	
	public int[] waveArray(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(i%2!=0)
			{
				int temp=arr[i];
				arr[i]=arr[i-1];
				arr[i-1]=temp;
			}
			else
			{
				continue;
			}
		}
		return arr;
	}
	
	public ArrayList<Long> alternateStr(long[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		Arrays.sort(arr);
		
		int start=0;
		int end=arr.length-1;
		ArrayList<Long> list=new ArrayList<>();
		
		int i=0;
		
		while(start<=end)
		{
			if(i%2==0)
			{
				list.add(arr[end]);
				i++;
				end--;
			}
			else
			{
				list.add(arr[start]);
				i++;
				start++;
			}
		}
		return list;
	}
	
	public int majorityElement(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}

		int majority=num/2;
		int first=arr[0];
		int count=1;
		
		for(int i=1;i<num;i++)
		{
			if(first==arr[i])
			{
				count++;
			}
			else
			{
				count--;
			}
			if(count==0)
			{
				first=arr[i];
				count=0;
			}
		}
		
		count=0;
		
		for(int i=0;i<num;i++)
		{
			if(first==arr[i])
			{
				count++;
			}
		}
		
		if(count<=majority) {
			return -1;
		}
		
		return first;
		
	}
	
	public int searchElement(int[] arr,int num,int key)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int index=-1;
		
		for(int i=0;i<num;i++)
		{
			if(arr[i]==key)
			{
				index=i;
			}
		}
		
        return index;
	}
	
	public int balancedArray(int num,int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int sum1=0;
		int sum2=0;
		int mid=arr.length/2;
		
		for(int i=0;i<arr.length;i++)
		{
			if(i<mid)
			{
				sum1+=arr[i];
			}
			else
			{
				sum2+=arr[i];
			}
		}
		
		return Math.abs(sum1-sum2);

	}
	
	public int[] shuffleArray(int[] arr,int mid)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int start=0;
		int end=mid;
		int[] int_arr=new int[arr.length];
		
		for(int i=0;i<arr.length;i++)
		{
			if(i%2 !=0 )
			{
				int_arr[i]=arr[end];
				end++;
			}
			else
			{
				int_arr[i]=arr[start];
				start++;
			}
		}
		
		return int_arr;

	}
	
	public int goodPairs(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j] && i<j)
				{
					count++;
				}
			}
		}
		
		return count;

	}
	
	public int minimumDifference(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		Arrays.sort(arr);

		int min=Integer.MAX_VALUE;
		
		for(int i=1;i<arr.length;i++)
		{
			int difference=Math.abs(arr[i]-arr[i-1]);
			
			min=Math.min(min, difference);
		}
		
		return min;
	}
	
	public ArrayList<Integer> leader(int[] arr,int num)
	{
				
		ArrayList<Integer> list=new ArrayList<>();
		
		int last=arr[arr.length-1];
		list.add(last);
		
		for(int i=num-2;i>=0;i--)
		{
			if(arr[i]>=last)
			{
				last=arr[i];
				list.add(last);
				
			}
		}
		Collections.reverse(list);
		return list;

	}
	
	public int minDistance(int[] arr,int  num,int from,int to)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		int index1=-1;
		int index2=-1;
		
		int min=Integer.MAX_VALUE;
		
		for(int i=0;i<num;i++)
		{
			if(arr[i]==from)
			{
				index1=i;
			}
			if(arr[i]==to)
			{
				index2=i;
			}
			if(index1 != -1 && index2 != -1)
			{
				int diff=Math.abs(index1-index2);
				min=Math.min(min, diff);
				return min;
			}
		}
		
		
		
		return -1;
	}
	
	public int[] alternateNumber(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		List<Integer> positive=new ArrayList<>();
		List<Integer> negative=new ArrayList<>();
		
		for(int i=0;i<num;i++)
		{
			if(arr[i]>=0)
			{
				positive.add(arr[i]);
			}
			else
			{
				negative.add(arr[i]);
			}
		}
		
		int i=0,j=0,k=0;
		
		while(i<positive.size() || j<negative.size())
		{
			if(i<positive.size())
			{
				arr[k]=positive.get(i);
				i++;
				k++;
			}
			if(j<negative.size())
			{
				arr[k]=negative.get(j);
				j++;
				k++;
			}
		}
		
		return arr;
		
	}
	
	public boolean zeroSum(int num,int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		
		int sum=0;
		
		Set<Integer> set=new HashSet<>();
		set.add(0);
		
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
			
			if(set.contains(sum))
			{
				return true;
			}
			else
			{
				set.add(sum);
			}
		}
		
		return false;
	}
	
	public int nonRepeating(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		Map<Integer,Integer> map=new HashMap<>();
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				map.put(arr[i], map.getOrDefault(arr[i], 1)+1);
			}
			else
			{
				map.put(arr[i], 1);
			}
		}
		
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i])==1)
			{
				count=arr[i];
			}
		}
		
		return count;
	}
	
	public int minimumElement(int[] arr)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		Arrays.sort(arr);
		return arr[0];
	}
	
	public int kSmallest(int[] arr,int num)throws CustomException
	{
		if(arr==null)
		{
			throw new CustomException("Input should not be null");
		}
		
		Arrays.sort(arr);
		int number=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(i==num)
			{
				number=arr[i-1];
			}
			
			else if(num==arr.length-1)
			{
				number=arr[arr.length-1];
			}
		}
		
		return number;
	}

}
