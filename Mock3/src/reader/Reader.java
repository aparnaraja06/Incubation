package reader;

import java.util.ArrayList;

import node.Node;
import tree.Bst;

public class Reader {
        
	static int[] x= {-1,-1,-1,0,0,1,1,1};
	static int[] y= {-1,0,1,-1,1,-1,0,1};
		
	
	public int generatePalindrome(int num)
	{
		String number=num+"";
		int first=number.charAt(0)-'0';
		String result=num+""+first;
		int ans=Integer.parseInt(result);
		return ans;
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
		
		if(arr.length%2==0)
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
		
		int leftpoint=0,rightpoint=0,resultpoint=0;
		
		while(leftpoint<left.length || rightpoint<right.length)
		{
			if(leftpoint<left.length && rightpoint<right.length)
			{
				if(left[leftpoint] < right[rightpoint])
				{
					result[resultpoint++]=left[leftpoint++];
				}
				else
				{
					result[resultpoint++]=right[rightpoint++];
				}
			}
			else if(leftpoint<left.length)
			{
				result[resultpoint++]=left[leftpoint++];
			}
			else if(rightpoint<right.length)
			{
				result[resultpoint++]=right[rightpoint++];
			}
		}
		return result;
	}
	
	public String contiguousArray(int[] arr,int num,int val)
	{
		
		int sum=0;
		int index1=0;
		int index2=0;
		String result="";
		
		for(int i=0;i<num;i++)
		{
			sum=arr[i];
			for(int j=i+1;j<num;j++)
			{
				sum+=arr[j];
				if(sum==val)
				{
					index1=i;
					index2=j;
					result=(index1+1)+"\n"+(index2+1);
					return result;
				}
				
				//break;
			}
			
		}
				return result;
	}
	
	public int[][] searchWord(char[][] arr,String word)
	{
		
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(getWord(arr,i,j,word))
				{
					ArrayList<Integer> temp=new ArrayList<>();
					temp.add(i);
					temp.add(j);
					list.add(temp);
				}
			}
		}
		
		int[][] result=new int[list.size()][2];
		
		for(int i=0;i<result.length;i++)
		{
			result[i][0]=list.get(i).get(0);
			result[i][1]=list.get(i).get(1);
		}
		
		return result;
	}
	
	public boolean getWord(char[][] arr,int row,int col,String word)
	{
		if(arr[row][col] != word.charAt(0))
		{
			return false;
		}
		
		for(int i=0;i<8;i++)
		{
			int j,rd=row+x[i],cd=col+y[i];
			
			int length=word.length();
			
			for(j=1;j<length;j++)
			{
			   if(rd>=arr.length || rd<0|| cd>=arr[0].length|| cd<0)
			   {
				   break;
			   }
			   
			   if(arr[rd][cd]!=word.charAt(j))
               {
                   break;
               }
               rd +=x[i];
               cd +=y[i];
           }
			
			if(j==length)
			{
				return true;
	                
			}
		}
		
		return false;
	}
	
	public Node trimTree(Node node,int[] arr,int low,int high)
	{
		Bst temp=new Bst();
	    Node store=null;
	    int i=0;
		while(i<arr.length)
		{
			if(store==null)
			{
			store=temp.insert(node, arr[i]);
			}
			else
			{
				store=temp.insert(store, arr[i]);
			}
			i++;
		}
		System.out.println("created tree : "+store);
		Node result=temp.trimLeaf(store, low, high);
		return result;
	}
}
