package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Reader {
public int[] mergeSort(int[] arr)
{
	int num=arr.length;
	if(num<=1)
	{
		return arr;
	}
	
	int mid=num/2;
	int[] left=new int[mid];
	int[] right;
	if(num%2==0)
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
	
	int[] result=new int[num];
	
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
		if(leftPoint < left.length && rightPoint < right.length)
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

public int[] bubbleSort(int[] arr)
{
	int num=arr.length;
	
	for(int i=0;i<num;i++)
	{
		for(int j=i+1;j<num;j++)
		{
			if(arr[i]>arr[j])
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	return arr;
}

public int[] selectionSort(int[] arr)
{
	int num=arr.length;
	for(int i=0;i<num;i++)
	{
		int index=i;
		for(int j=i+1;j<num;j++)
		{
			if(arr[j]<arr[index])
			{
				index=j;
			}
		}
		int temp=arr[index];
		arr[index]=arr[i];
		arr[i]=temp;
	}
	return arr;
}

public int[] insertionSort(int[] arr)
{
	int num=arr.length;
	for(int i=1;i<num;i++)
	{
		int key=arr[i];
		int j=i-1;
		
		while(j>=0 && arr[j]>key)
		{
			arr[j+1]=arr[j];
			j--;
		}
		
		arr[j+1]=key;
	}
	return arr;
}

public int[] quickSort(int[] arr,int low,int high)
{
	if(low>high)
	{
		return arr;
	}
	
	int mid=low+(high-low)/2;
	
	int pivot=arr[mid];
	int i=low;
	int j=high;
	
	while(i<=j)
	{
		if(arr[i]<pivot)
		{
			i++;
		}
		if(arr[j]>pivot)
		{
			j--;
		}
		
		if(i<=j)
		{
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
	if(low<j)
	{
		quickSort(arr,low,j);
	}
	if(high>i)
	{
		quickSort(arr,i,high);
	}
	return arr;

}

public int KSmallest(int[] arr,int num)
{
	int result=0;
	for(int i=0;i<arr.length;i++)
	{
		for(int j=i+1;j<arr.length;j++)
		{
			if(arr[i]>arr[j])
			{
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
	for(int i=0;i<arr.length;i++)
	{
		if(i==num-1)
		{
			result=arr[i];
		}
	}
	return result;
}

public boolean anagram(String str1,String str2)
{
	Map<Character,Integer> map=new HashMap<>();
	
	for(int i=0;i<str1.length();i++)
	{
		map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
	}
	
	for(int i=0;i<str2.length();i++)
	{
		if(!map.containsKey(str2.charAt(i)))
		{
			return false;
		}
		else
		{
			map.put(str2.charAt(i), map.get(str2.charAt(i))-1);
			if(map.get(str2.charAt(i))==0)
			{
				map.remove(str2.charAt(i));
			}
		}
		
	}
	if(map.size()!=0)
	{
		return false;
	}
	return true;
	
}

public boolean equalArray(int[] arr1,int[] arr2)
{
	Map<Integer,Integer> map=new HashMap<>();
	
	if(arr1.length != arr2.length)
	{
		return false;
	}
	for(int i=0;i<arr1.length;i++)
	{
		map.put(arr1[i], map.getOrDefault(arr1[i], 0)+1);
	}
	
	for(int i=0;i<arr2.length;i++)
	{
		if(!map.containsKey(arr2[i]))
		{
			return false;
		}
		else
		{
			map.put(arr2[i],map.get(arr2[i])-1);
			if(map.get(arr2[i])==0)
			{
				map.remove(arr2[i]);
			}
		}
	}
	if(map.size()==0)
	{
		return true;
	}
	return false;
}

public boolean checkSorted(int[] arr)
{
	int last=arr[arr.length-1];
	for(int i=0;i<arr.length-1;i++)
	{
		if(arr[i]>arr[i+1] && arr[i]>last)
		{
			return false;
		}
	}
	return true;
}

public int nearestZero(int[] arr,int num)
{
	Arrays.sort(arr);
	int start=0;
	int end=num-1;
	
	int result=arr[start]+arr[end];
	
	while(start<end)
	{
		int sum=arr[start]+arr[end];
		
		if(sum==0)
		{
			return 0;
		}
		if(sum<0)
		{
			start++;
		}
		else
		{
			end--;
		}
		
		if(Math.abs(sum) < Math.abs(result))
		{
			result=sum;
		}
		if(Math.abs(sum)==Math.abs(result))
		{
			result=Math.max(sum, result);
		}
	}
	return result;
}

public int toys(int[] arr,int rupee,int num)
{
	Arrays.sort(arr);
	int count=0;
	for(int i=0;i<num;i++)
	{
		if(arr[i] <= rupee)
		{
			rupee-=arr[i];
			count++;
		}
		else
		{
			return count;
		}
	}
	return count;
}

public ArrayList<Integer> candy(int[] arr,int num,int part)
{
	Arrays.sort(arr);
	int min=0;
	int max=0;
	ArrayList<Integer> list=new ArrayList<>();
	for(int i=0;i<num;i++)
	{
		min+=arr[i];
		num-=part;
	}
	int mid=0;
	for(int i=arr.length-1;i>=mid;i--)
	{
		max+=arr[i];
		mid+=part;
	}
	list.add(min);
	list.add(max);
	return list;
}
public int minSwaps(int nums[])
{
    int start=0;
    int num=nums.length-1;
    int count=0;
   count=quickSortt(nums,start,num);
    return count;
}

public int quickSortt(int[] arr,int low,int high)
{
    int count=0;
    if(low>high)
    {
        return 0;
    }
    
    int mid=low+(high-low)/2;
    int pivot=arr[mid];
    int i=low;
    int j=high;
    
    while(i<=j)
    {
        if(arr[i]<pivot)
        {
            i++;
        }
        
        else if(arr[j]>pivot)
        {
            j--;
        }
        
       else if(i<=j)
        {
            count++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    System.out.println("Count :"+count);
    if(low<j)
    {
        int result1=lowquick(arr,low,j);
        System.out.println("Count in low "+result1);
    }
   else if(high>i)
    {
        int result2=highquick(arr,i,high);
        System.out.println("count in high"+result2);
    }
    return count;
}

public int lowquick(int[] arr,int low,int high)
{
	int count=0;
    if(low>high)
    {
        return 0;
    }
    
    int mid=low+(high-low)/2;
    int pivot=arr[mid];
    int i=low;
    int j=high;
    
    while(i<=j)
    {
        if(arr[i]<pivot)
        {
            i++;
        }
        
        else if(arr[j]>pivot)
        {
            j--;
        }
        
       else if(i<=j)
        {
            count++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    return count;

}
public int highquick(int[] arr,int low,int high)
{
	int count=0;
    if(low>high)
    {
        return 0;
    }
    
    int mid=low+(high-low)/2;
    int pivot=arr[mid];
    int i=low;
    int j=high;
    
    while(i<=j)
    {
        if(arr[i]<pivot)
        {
            i++;
        }
        
        else if(arr[j]>pivot)
        {
            j--;
        }
        
       else if(i<=j)
        {
            count++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    return count;

}
}
