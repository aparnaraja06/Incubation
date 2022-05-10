package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {
	
	int[] x= {-1,-1,-1,1,1,1,0,0};
	int[] y= {-1,0,1,-1,0,1,-1,1};
	
	public int sumOfElements(int[][] arr,int row,int col)
	{
		int sum=0;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				sum+=arr[i][j];
			}
		}
		
		return sum;
	}
	
	public int[][] rotate(int[][] arr,int num)
	{
		transpose(arr);
		
		for(int i=0;i<num;i++)
		{
		    rotation(arr,i);
		}
		return arr;
	}
	
	public void transpose(int[][] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				int temp=arr[i][j];
				arr[i][j]=arr[j][i];
				arr[j][i]=temp;
			}
		}
	}
	
	public void rotation(int[][] arr,int change)
	{
		int start=0;
		int end=arr.length-1;
		
		while(start<end)
		{
			int temp=arr[start][change];
			arr[start][change]=arr[end][change];
			arr[end][change]=temp;
			
			start++;
			end--;
		}
		
	}
	
	public List<List<Integer>> uniqueRows(int[][] arr,int row,int col)
	{
		
		List<List<Integer>> list=new ArrayList<>();
		
		for(int i=0;i<row;i++)
		{
			List<Integer> temp=new ArrayList<>();
			
			for(int j=0;j<col;j++)
			{
				temp.add(arr[i][j]);
			}
			
			if(!list.contains(temp))
			{
				list.add(temp);
			}
		}
		
		return list;
	}
	
	public int[][] replaceZero(int[][] arr,int row,int col)
	{
		int count=0;
		int max=Integer.MIN_VALUE;
		int index=0;
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(arr[i][j]==1)
				{
					count++;
				}
				
				if(max<count)
				{
					max=count;
					index=i;
				}
			}
		}
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==index)
				{
					arr[i][j]=0;
				}
			}
		}
		
		return arr;
	}
	
	public int[][] setZero(int[][] arr,int row,int col)
	{
		int[] row_arr=new int[row];
		int[] col_arr=new int[col];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(arr[i][j]==0)
				{
					row_arr[i]=1;
					col_arr[j]=1;
				}
			}
		}
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(row_arr[i]==1 || col_arr[j]==1)
				{
					arr[i][j]=0;
				}
			}
		}
		
		return arr;
	}
	
	public int[][] sortDiagonal(int[][] arr,int row,int col)
	{
		int[] temp=new int[col];
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				if(i==j)
				{
					temp[i]=arr[i][j];
				}
			}
		}
		
         Arrays.sort(temp);
         
         for(int i=0;i<row;i++)
         {
        	 for(int j=0;j<col;j++)
        	 {
        		 if(i==j)
        		 {
        			 arr[i][j]=temp[i];
        		 }
        	 }
         }
         
         return arr;
	}
	
	public int play(int[][] arr,int row,int col,int num)
	{
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++)
			{
				if(arr[i][j+num %col] != arr[i][j])
				{
					return 0;
				}
			}
		}
		return 1;
	}
	
	public int[][] grid(char[][] arr,String word)
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
		
		for(int i=0;i<list.size();i++)
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
				if(rd>=arr.length || rd<0 || cd>=arr[0].length || cd<0)
				{
					break;
				}
				
				if(arr[rd][cd] != word.charAt(j))
				{
					break;
				}
				
				rd+=x[i];
				cd+=y[i];
			}
			
			if(j==length)
			{
				return true;
			}
		}
		
		return false;
	}

}
