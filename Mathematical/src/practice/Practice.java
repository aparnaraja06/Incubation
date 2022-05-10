package practice;

public class Practice {
	
	public int numOfPaths(int num1,int num2)
	{
		if(num1==1 || num2==1)
		{
			return 1;
		}
		
		return numOfPaths(num1-1,num2)+numOfPaths(num1,num2-1);
	}
	
	public int squareRoot(int num)
	{
		return(int) Math.floor(Math.sqrt(num));
	}
	
	public boolean balanced(String num)
	{
		int length=num.length();
		
		int mid=length/2;
		
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<mid;i++)
		{
			sum1+=num.charAt(i)-'0';
		}
		
		for(int i=length-1;i>mid;i--)
		{
			sum2+=num.charAt(i)-'0';
		}
		
		if(sum1==sum2)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean lucky(int num)
	{
		return helper(num,2);
	}
	
	public boolean helper(int num,int count)
	{
		if(count>num)
		{
			return true;
		}
		
		if(count==num)
		{
			return false;
		}
		
		return helper(num-(num/count),count+1);
	}
	
	public long palindrome(long num)
	{
		
		String number=Long.toBinaryString(num);
		String rev=reverse(number);
		
		if(rev.equals(number))
		{
			return (long)1;
		}
		
		return (long)0;
	}
	
	public String reverse(String num)
	{
		String rev="";
		
		for(int i=num.length()-1;i>=0;i--)
		{
			rev+=num.charAt(i);
		}
		return rev;
	}
	
	public long oddFactor(int num)
	{
		return (long)Math.sqrt(num);
	}
	
	public int perfectNumber(long num)
	{
		int sum=0;
		
		for(int i=1;i<=num;i++)
		{
			if(i%num==0)
			{
				sum+=i;
			}
		}
		
		if(sum==num)
		{
			return 1;
		}
		return 0;
	}
	
	public String isSquare(int x1,int x2,int x3,int x4,int y1,int y2,int y3,int y4)
	{
		if(x1==x2 && x3==x4 && y1==y2 && y3==y4)
		{
			return "false";
		}
		
		if(Math.abs(x1-x2)==Math.abs(x3-x4) && Math.abs(y1-y2)==Math.abs(y3-y4))
		{
			return "true";
		}
		
		return "false";
	}
	
	public long maxVolume(long num1,long num2)
	{
		
		float temp=(float)((num1-Math.sqrt(num1*num1-24*num2))/12);
		long result=(long)(temp*(num2/2.0 - temp*(num1/4.0-temp)));
		
		return result;
	}
	
	public long isPower(long num1,long num2)
	{
		for(int i=1;i<=num2;i++)
		{
			if(Math.pow(num1, i)==num2)
			{
				return (long)1;
			}
		}
		
		return (long)0;
	}
	
	public int twistedPrime(int num)
	{
		int sum=num;
		int rev=0;
		
		while(num>0)
		{
			int rem=num%10;
			rev=rev*10+rem;
			num=num/10;
		}
		
		if(check(sum) && check(rev))
		{
			return 1;
		}
		
		return 0;
	}
	
	public boolean check(int num)
	{
		if(num<=1)
		{
			return false;
		}
		
		for(int i=2;i<=Math.sqrt(num);i++)
		{
			if(num%2==0)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public int petrol(int[] arr1,int[] arr2)
	{
		int temp=0;
		int store=0;
		int sum=0;
		
		for(int i=0;i<arr1.length;i++)
		{
			temp+=arr1[i]-arr2[i];
			
			if(temp<0)
			{
				sum=i+1;
				store=temp;
				temp=0;
			}
		}
		
		if(temp+store>=0)
		{
			return sum;
		}
		
		return -1;
	}

}
