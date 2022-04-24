package runner;

import java.util.List;
import java.util.Scanner;

import reader.Reader;

public class Runner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	Reader reader=new Reader();
	
	System.out.println("Enter the option");
	int option=scanner.nextInt();
	scanner.nextLine();
	
	
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		
		int result=reader.sumOfElements(arr, row, col);
		System.out.println(result);
	}
	
	case 2:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][row];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		
		int[][] result=reader.transpose(arr, row);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{

				 System.out.print(result[i][j]);
			}
			
			System.out.println();
		}
	}
	
	case 3:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][row];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		
		int[][] result=reader.rotate(arr, row);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{

				 System.out.print(result[i][j]);
			}
			
			System.out.println();
		}

	}
	
	case 4:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
					
		List<List<Integer>> result=reader.uniqueRows(arr, row, col);
		System.out.println(result);
	}
	
	case 5:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		
		int[][] result=reader.setZero(arr, row, col);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{

				 System.out.print(result[i][j]);
			}
			
			System.out.println();
		}

	}
	
	case 6:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
         
		int[][] result=reader.replaceZero(arr, row, col);
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{

				 System.out.print(result[i][j]);
			}
			
			System.out.println();
		}
	}
	
	case 7:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
         
       int[][] result=reader.sortDiagonal(arr, row, col);
       for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{

				 System.out.print(result[i][j]);
			}
			
			System.out.println();
		}

	}
	
	case 8:
	{
		System.out.println("Enter the number of rows");
		int row=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter the number of column");
		int col=scanner.nextInt();
		scanner.nextLine();
		int[][] arr=new int[row][col];
		System.out.println("Enter the values");
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				arr[i][j]=scanner.nextInt();
			}
		}
		System.out.println("Enter the number");
		int num=scanner.nextInt();
		scanner.nextLine();
		int result=reader.play(arr, row, col, num);
		System.out.println(result);
	}
	}
}
}
