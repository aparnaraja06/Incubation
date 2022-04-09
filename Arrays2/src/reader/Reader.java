package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import customexception.CustomException;

public class Reader {

	public List<Integer> rotateArray(int[] arr) throws CustomException {
		int last = arr[arr.length - 1];
		List<Integer> list = new ArrayList<>();
		list.add(last);
		for (int i = 0; i < arr.length - 1; i++) {
			list.add(arr[i]);
		}
		return list;
	}

	public int[] closestSum(int[] arr, int x, int num) throws CustomException {
		int left = 0;
		int right = 0;

		int start = 0;
		int end = num - 1;
		int min = Integer.MAX_VALUE;
		int[] int_arr = new int[2];
		while (start < end) {
			if ((Math.abs(arr[start] + arr[end] - x)) < min) {
				left = start;
				right = end;
				min = Math.abs(arr[start] + arr[end] - x);
			}
			if (arr[start] + arr[end] > x) {
				end--;
			} else {
				start++;
			}
		}
		int_arr[0] = arr[left];
		int_arr[1] = arr[right];
		return int_arr;

	}

	public int[] rotateLength(int[] arr) throws CustomException {
		int length = arr.length;

		for (int i = 0; i < length; i++) {
			int last = arr[length - 1];
			for (int j = length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = last;
		}

		return arr;
	}

	public HashSet<Integer> union(ArrayList<Integer> arr1, ArrayList<Integer> arr2) throws CustomException {
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < arr1.size(); i++) {
			set.add(arr1.get(i));
		}
		for (int i = 0; i < arr2.size(); i++) {
			set.add(arr2.get(i));
		}
		return set;

	}

	public ArrayList<Integer> intersect(ArrayList<Integer> arr1, ArrayList<Integer> arr2) throws CustomException {
        ArrayList<Integer> list=new ArrayList<>();
		for (int i = 0; i < arr1.size(); i++) {
			if (arr2.contains(arr1.get(i))) {
				list.add(arr1.get(i));
			} else {
				continue;
			}
		}
		return list;

	}

	public ArrayList<Integer> except(ArrayList<Integer> arr1, ArrayList<Integer> arr2) throws CustomException {
		ArrayList<Integer> store = new ArrayList<>();
		//System.out.println("array:" + arr1);
		for (int i = 0; i < arr1.size(); i++) {

			if (arr1.get(i) % 2 == 0) {
				store.add(arr1.get(i));
			}
		}
		for (int i = 0; i < arr2.size(); i++) {
			if (arr2.get(i) % 2 != 0) {
				store.add(arr2.get(i));
			}
		}
		return store;
	}
	
	public void numOfTimes(int[] arr)throws CustomException
	{
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
			System.out.println(arr[i]+"-"+count);
			count=0;
		}
	}
	
	public int largestProduct(ArrayList<Integer> list)throws CustomException
	{
		int max=Integer.MIN_VALUE;
		
		int product=1;
		for(int i=0;i<list.size()-1;i++)
		{
			product*=(list.get(i));
			max=Math.max(product, max);
		}
		return max;
	}
	
	public int perfectNumber(int num)throws CustomException
	{
		String result="";
		int ans=0;
		int temp=0;
		temp=sumOfDigits(num);
		int difference=Math.abs(10-temp);
		result=Integer.toString(num)+Integer.toString(difference);
		ans=Integer.parseInt(result);
		return ans;
		
	}
	
	public int sumOfDigits(int num)
	{
		int sum=0;
		while(num!=0)
		{
			sum+=num%10;
			num=num/10;
		}
		return sum;
	}
	
	public int[] minimumDifference(int[] arr,int size)throws CustomException
	{
		int min=Integer.MAX_VALUE;
		int num1=0;
		int num2=0;
		int[] int_arr=new int[2];
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				int diff=Math.abs(arr[i]-arr[j]);
			if(diff<min)
			{
			min=Math.min(diff, min);
			num1=arr[i];
			num2=arr[j];
			}
			}
		}
		int_arr[0]=num1;
		int_arr[1]=num2;
		return int_arr;
	}
	
	public ArrayList<Integer> sumPair(int[] arr,int sum)throws CustomException
	{
		int add=0;
		ArrayList<Integer> list=new ArrayList<>();
		//ArrayList<ArrayList<Integer>> result=new ArrayList<>();
		//Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				add=arr[i]+arr[j];
				if(add==sum)
				{
					list.add(arr[i]);
					list.add(arr[j]);
					
					//map.put(arr[i], arr[j]);
				}
				
			}
		}
		
		return list;
	}
	
	public int[] leftRotate(int[] arr, int rotate)throws CustomException
	{
		for(int i=0;i<rotate;i++)
		{
			leftRotateOne(arr);
		}
		return arr;
	}
	
	public void leftRotateOne(int[] arr)
	{
		int first=arr[0];
		for(int i=0;i<arr.length-1;i++)
		{
		    arr[i]=arr[i+1];
		}
		
		arr[arr.length-1]=first;
	}
	
	public ArrayList<String> misMatchElement(char[] arr1, char[] arr2)throws CustomException
	{
		ArrayList<String> list=new ArrayList<>();
		String temp="";
		
		for(int i=0;i<arr1.length;i++)
		{
			if(arr1[i]!=arr2[i] && i<arr1.length-1 && arr1[i+1]!=arr2[i+1] )
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
	
	public boolean nonDecreasingArray(int[] arr)throws CustomException
	{
		int count=0;
		//int first=arr[0];
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]<arr[i+1])
			{
				continue;
			}
			else
			{
				count++;
			}
			
		}
		
		if(count != 1)
		{
			return false;
		}
		return true;
	}
	
	public void pattern(int[] arr)throws CustomException
	{		
		int temp=0;
		for(int i=0;i<5;i++)
		{
			temp=i;
			for(int j=0;j<i+1;j++)
			{
				System.out.print(arr[temp]+" ");
				//System.out.println("i : "+i+"j : "+j);
				temp=i+4+j;
			}
			System.out.println("");
		}
	}
	
	public int longestSubSequence(int[] arr,int size)throws CustomException
	{
		int[] int_arr=new int[size];
		int max=0;
		for(int i=0;i<size;i++)
		{
			int_arr[i]=1;
		}
		
		for(int i=1;i<size;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j] && int_arr[i]<int_arr[j]+1)
				{
					int_arr[i]=int_arr[j]+1;
				}
			}
		}
		
		for(int i=0;i<size;i++)
		{
			if(max<int_arr[i])
			{
				max=int_arr[i];
			}
		}
		return max;
	}
	
	public int chocolate(int[] arr,int mid)throws CustomException
	{
		Arrays.sort(arr);
		int diff=Integer.MAX_VALUE;
		return helper(arr, mid, 0, diff);
	}
	
	public int helper(int[] arr,int mid,int start,int diff)
	{
		for(int i=start;i<mid-1;i++)
		{
			if(arr[mid-1]-arr[start]<diff)
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
	
	public int grandsons(Map<String,List<String>> map,String name,int level)throws CustomException
	{
		List<String> sons=new ArrayList<>();
		List<String> grandson=new ArrayList<>();
		int size=0;
		if(map.containsKey(name))
		{
			sons=(map.get(name));
			//System.out.println("Sons "+sons);
			if(level==1)
			{
				 size=sons.size();
			}
			else if(level==2)
			{
				for(int i=0;i<sons.size();i++)
				{
				     grandson.addAll(map.get(sons.get(i)));
				}
				//System.out.println("Grandson "+grandson);
				size=grandson.size();
			}
		}
		return size;
	}
	
	public int[] ascendingSum(int[] arr,int size)throws CustomException
	{
		int first=0;
		int next=0;
		for(int i=0;i<size;i++)
		{
			for(int j=i+1;j<size;j++)
			{
				first=sumOfDigits(arr[i]);
				next=sumOfDigits(arr[j]);
				
				if(first>next || (first==next && arr[i]<arr[j])) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	public int NCents(int[] arr,int size,int count)throws CustomException
	{
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
}
