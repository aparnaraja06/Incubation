package reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {

	static int[] x= {-1,-1,-1,0,0,1,1,1};
	static int[] y= {-1, 0, 1, -1, 1, -1, 0, 1};
	int count=0;
	int count1=0;
	
	public int palindrome(int num) {
		String store=num+"";
		char first=store.charAt(0);
		String result=store+first;
		int resultt=Integer.parseInt(result);
		return resultt;
	}

	public String shortestTime(String[] arr) {
		List<Integer> hourList = new ArrayList<>();
		List<Integer> minList = new ArrayList<>();
		List<Integer> secList = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				String time1 = arr[i];
				String time2 = arr[j];

				String[] time1_arr = time1.split(":");
				String[] time2_arr = time2.split(":");

				int hour = Math.abs(Integer.parseInt(time1_arr[0]) - Integer.parseInt(time2_arr[0]));
				int min = Math.abs(Integer.parseInt(time1_arr[1]) - Integer.parseInt(time2_arr[1]));
				int sec = Math.abs(Integer.parseInt(time1_arr[2]) - Integer.parseInt(time2_arr[2]));

				
					hourList.add(hour);
					minList.add(min);
					secList.add(sec);
				
			}
		}
		int[] hour_arr = new int[hourList.size()];
		for (int i = 0; i < hour_arr.length; i++) {
			hour_arr[i] = hourList.get(i);
		}
		Arrays.sort(hour_arr);
		//System.out.println(hourList);
		int hourr = hour_arr[0];
		int index = 0;
		for (int i = 0; i < hourList.size(); i++) {

			if (hourList.get(i) == hourr) {
				index = i;
			}
		}

		int minn = minList.get(index);
		int secc = secList.get(index);

		String temp = "";

		temp = hourr + ":" + minn + ":" + secc;
		return temp;

	}
	
	public String hexaDecimal(long num)
	{
		String hexa=Long.toHexString(num);
		return hexa;
	}
	
	public String divisible(int num)
	{
		if(num%8==0)
		{
			return "Yes";
		}
		String store=num+"";
		int ans=0;
		String result="";
		String answer="";
		for(int i=0;i<store.length();i++)
		{
			store=store.replace(String.valueOf(store.charAt(i)), "");
			int temp=0;
			try
			{
			temp=Integer.parseInt(store);
			}
			catch(NumberFormatException e)
			{
				return "No";
			}
			if(temp%8==0)
			{
				answer="Yes";
				ans=temp;
			}
			else
			{
				store=num+"";
			}
			
		}
		if(answer=="")
		{
			return "No";
		}
		result=answer+"\n"+ans;
		return result;
	}
	
	public int largestNumber(int num,int digit)
	{
		String number=num+"";
		String balance="";
		int max=0;
		for(int i=0;i<number.length();i++)
		{
			if((number.charAt(i)-'0')==digit) {
				
				balance=number.substring(i+1, number.length());
			    int j=0;
				while(j<balance.length())
				{
					if(((balance.charAt(j)-'0')>digit) && (max<balance.charAt(j)))
					{
						max=Math.max(max, balance.charAt(j)-'0');
                       // j++;
					}
					j++;
				}
			}
		}
		return max;
	}
	
	public String hexaToBinary(String num)
	{
		Map<Character,String> map=new HashMap<>();
		
		map.put('A', "1010");
		map.put('B', "1011");
		map.put('C', "1100");
		map.put('D', "1101");
		map.put('E', "1110");
		map.put('F', "1111");
		String result="";
		for(int i=0;i<num.length();i++)
		{
			if(!map.containsKey(num.charAt(i)))
			{
				int number=Integer.parseInt(String.valueOf(num.charAt(i)));
				String temp=Long.toBinaryString(number);
				while(temp.length()%4 !=0)
				{
					temp="0"+temp;
				}
				result+=temp;
			}
			else
			{
				result+=map.get(num.charAt(i));
			}
		}
		return result;
	}
	
	public int divide(int num1,int num2)
	{
		while(num1%num2==0)
		{
			num1=num1/num2;
		}
		return num1;
	}
	
	public int checkUgly(int num)
	{
		num=divide(num,2);
		num=divide(num,3);
		num=divide(num,5);
		
		if(num==1)
		{
			return 1;
		}
		
		return 0;
	}
	
	public int getNum(int num)
	{
		int i=1;
		int count=1;
		
		while(num>count)
		{
			i++;
			if(checkUgly(i)==1)
			{
				count++;
			}
		}
		return i;
	}
	
	public int queenPath(int N,int x1,int y1,int[] kx1,int[] ky1)
	{
		int count=0;
		int[][] path=new int[N][N];
		
		for(int i=0;i<kx1.length;i++)
		{
			path[kx1[i]][ky1[i]]=1;
		}
		path[x1][y1]=2;
		
		for(int i=0;i<path.length;i++)
		{
			for(int j=0;j<path[0].length;j++)
			{
				moves(path,i,j,2);
			}
		}
		return count1;
	}
	
	public boolean moves(int[][] path,int row,int col,int move)
	{
		if(path[row][col] !=move)
		{
			return false;
		}
			for(int dir=0;dir<8;dir++)	
		{
			int k,rd=row+x[dir],cd=col+y[dir];
			
			for(k=0;k<path.length;k++)
			{
				if(rd>=path.length || rd<0 || cd>=path[0].length || cd<0)
				{
					break;
				}
				
				if(path[rd][cd]!=0)
				{
					break;
				}
				
				rd+=x[dir];
				cd+=y[dir];
				count++;
			}
			
			count1+=count;
			count=0;
		}
		
		return false;
			
	}
}
