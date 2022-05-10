package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import customexception.CustomException;

public class Reader {

public int[] smallerNum(int[] int_arr)throws CustomException
{
	int count=0;
	
	int[] arr= new int[int_arr.length];
	
	for(int i=0;i<int_arr.length;i++)
	{
		for(int j=0;j<int_arr.length;j++)
		{
			if(int_arr[i] > int_arr[j] && j!=i)
			{
				count++;
			}
			
		}
		arr[i]=count;
		count=0;
	}
	return arr;
}

public int kadane(int num,int[] arr)throws CustomException
{
	int sum=0;
	int max=Integer.MIN_VALUE;
	
	for(int i=0;i<num;i++)
	{
		sum+=arr[i];
		max=Math.max(sum, max);
		
		if(sum<0)
		{
			sum=0;
		}
	}
	return max;
}

public int[] waveArray(int[] arr,int num)throws CustomException
{
	int temp=0;
	
	for(int i=0;i<num;i++)
	{
		if(i%2!=0)
		{
			temp=arr[i];
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
	Arrays.sort(arr);
	
	int start=0;
	int end=num-1;
	
	ArrayList<Long> list=new ArrayList<>();
	while(start<end)
	{
		list.add(arr[end]);
		list.add(arr[start]);
		
		start++;
		end--;
	}
	if(num%2 !=0)
	{
	list.add(arr[end]);
	}
	
	return list;
	
}

public int majorityElement(int num,int[] arr)throws CustomException
{
	int majority=num/2;
	
	int count=1;
	int first=arr[0];
	for(int i=1;i<arr.length;i++)
	{
		if(arr[i]==first)
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
			count=1;
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
		
		if(count<=majority)
		{
			return -1;
		}
		return first;
	
	
}

public int searchElement(int size,int[] arr,int key)throws CustomException
{
	int index=-1;
	for(int i=0;i<size;i++)
	{
		if(arr[i]==key)
		{
			index=i;
		}
	}
	return index;
}

public int balancedArray(int size,int[] arr)throws CustomException
{
	int sum1=0;
	int sum2=0;
	int mid=size/2;
	
	for(int i=0;i<size;i++)
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

public int[] shuffleArray(int[] arr,int num)throws CustomException
{
	int a=0;
	int b=num;
	
	int[] int_arr=new int[arr.length];
	for(int i=0;i<arr.length;i++)
	{
		if(i%2!=0)
		{
			int_arr[i]=arr[b];
			b++;
		}
		else
		{
			int_arr[i]=arr[a];
			a++;
		}
	}
	return int_arr;
}

public int goodPairs(int[] arr)throws CustomException
{
	int count=0;
	for(int i=0;i<arr.length;i++)
	{
		for(int j=0;j<arr.length;j++)
		{
			if(arr[i]==arr[j] && i<j)
			{
				count++;
			}
		}
	}
	return count;
}

public int minDifference(int[] arr)throws CustomException
{
	int min=Integer.MAX_VALUE;
	Arrays.sort(arr);
	for(int i=0;i<arr.length-1;i++)
	{
		min=Math.min(arr[i+1]-arr[i], min);
	}
	return min;
}

public int minDistance(int[] arr,int size,int x,int y)throws CustomException
{
	int index1=-1;
	int index2=-1;
	int result=Integer.MAX_VALUE;
	for(int i=0;i<size;i++)
	{
		if(arr[i]==x)
		{
			index1=i;
		}
		else if(arr[i]==y)
		{
			index2=i;
		}
		
		if(index1 != -1 && index2 !=-1)
		{
			int min=Math.abs(index1-index2);
			result=Math.min(min, result);
		}
	}
	
	if(index1 == -1 || index2== -1)
	{
		return -1;
	}
	return result;
	
}

public int[] alternateNumber(int[] arr,int size)throws CustomException
{
	ArrayList<Integer> positive=new ArrayList<>();
	ArrayList<Integer> negative=new ArrayList<>();
	
	int[] int_arr=new int[size];
	for(int i=0;i<size;i++)
	{
		if(arr[i]<0)
		{
			negative.add(arr[i]);
		}
		else
		{
			positive.add(arr[i]);
		}
	}
	
	int i=0;
	int j=0;
	int k=0;
	while(i<negative.size() || j< positive.size())
	{
		if(i<negative.size())
		{
			int_arr[k]=negative.get(i);
			k++;
			i++;
		}
		
		if(j<positive.size())
		{
			int_arr[k]=positive.get(j);
			k++;
			j++;
		}
	}
	return int_arr;
}
public boolean zeroSum(int size,int[] arr)throws CustomException
{
	HashSet<Integer> set=new HashSet<>();
	set.add(0);
	int sum=0;
	for(int i=0;i<size;i++)
	{
		sum+=arr[i];
		if(set.contains(sum))
		{
			return true;
		}
		set.add(sum);
	}
	return false;
}

public int nonRepeatingNumber(int[] arr)throws CustomException
{
	Map<Integer,Integer> map=new HashMap<>();
	
	for(int i=0;i<arr.length;i++)
	{
		if(map.containsKey(arr[i]))
		{
			map.put(arr[i], map.get(arr[i])+1);
		}
		else
		{
		map.put(arr[i],1);
		}
	}
	int store=0;
	for(int i=0;i<arr.length;i++)
	{
		if(map.get(arr[i])==1)
		{
			store=arr[i];
		}
	}
	return store;
}

public int minimumElement(int[] int_arr)throws CustomException
{
	int min=Integer.MAX_VALUE;
	
	for(int i=0;i<int_arr.length;i++)
	{
		min=Math.min(int_arr[i], min);
	}
	return min;
}

public int KSmallest(int[] arr,int k)throws CustomException
{
	Arrays.sort(arr);
	int result=0;
	for(int i=arr.length-1;i>=0;i--)
	{
		if(i==k)
		{
			result=arr[i-1];
		}
		else if(k==arr.length-1)
		{
			result=arr.length-1;
		}
	}
	return result;
}
}
