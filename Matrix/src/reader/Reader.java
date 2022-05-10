package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reader {
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

public int[][] transpose(int[][] arr,int num)
{
	for(int i=0;i<num-1;i++)
	{
		for(int j=i+1;j<num;j++)
		{
			int temp=arr[i][j];
			arr[i][j]=arr[j][i];
			arr[j][i]=temp;
		}
	}
	return arr;
}

public int[][] rotate(int[][] arr,int num)
{
	transpose(arr,num);
	
	for(int i=0;i<num;i++)
	{
		reverse(arr,i);
	}
	return arr;
}

public void reverse(int[][] arr,int change)
{
	int low=0,high=arr.length-1;
	
	while(low<high)
	{
		int temp=arr[low][change];
		arr[low][change]=arr[high][change];
		arr[high][change]=temp;
		
		low++;
		high--;
	}
}

public List<List<Integer>> uniqueRows(int[][] arr,int row,int col)
{
	List<List<Integer>> list=new ArrayList<>();
	
	Set<List<Integer>> set=new HashSet<>();
	
	for(int i=0;i<row;i++)
	{
		List<Integer> temp=new ArrayList<>();
		
		for(int j=0;j<col;j++)
		{
			temp.add(arr[i][j]);
			
			
		}
		if(!set.contains(temp))
		{
			set.add(temp);
			list.add(temp);
		}
	}
	
	return list;
	
}

public int[][] setZero(int[][] arr,int left,int right)
{
	int[] row=new int[left];
	int[] col=new int[right];
	
	for(int i=0;i<left;i++)
	{
		for(int j=0;j<right;j++)
		{
			if(arr[i][j]==0)
			{
				row[i]=1;
				col[j]=1;
			}
		}
	}
	
	for(int i=0;i<left;i++)
	{
		for(int j=0;j<right;j++)
		{
			if(row[i]==1 || col[j]==1)
			{
				arr[i][j]=0;
			}
		}
	}
	
	return arr;	
}

public int[][] replaceZero(int[][] arr,int row,int col)
{
	int[] temp=new int[row];
	
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			if(j==0 && arr[i][j]==1)
			{
				temp[i]=2;
			}
		}
	}
	
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			if(temp[i]==2)
			{
				arr[i][j]=0;
			}
		}
	}
	
	return arr;
}

public int[][] sortDiagonal(int[][] arr,int row,int col)
{
	
	int[] temp=new int[row];
	
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
				arr[i][j]=temp[j];
			}
		}
	}
	
	return arr;
}

public int play(int[][] arr,int row,int col,int num)
{
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
		{
			if(arr[i][(j+num)%col] != arr[i][j])
			{
				return 0;
			}
		}
	}
	
	return 1;
}
}
