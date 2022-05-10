package reader;

public class Reader {

	public int numOfPaths(int num1,int num2)
	{
		//int sum=0;
		if(num1==1 || num2==1)
		{
			//sum++;
			//System.out.println("Sum : "+sum+"Num1 "+num1+" Num2 "+num2);
			return 1;
		}
		
		return numOfPaths(num1-1,num2)+numOfPaths(num1,num2-1);
	}
	
	public int squareRoot(int num)
	{
		return (int)Math.sqrt(num);
	}
	
	public boolean balanced(String num)
	{
		int mid=num.length()/2;
		
		int sum1=0;
		int sum2=0;
		
		for(int i=0;i<mid;i++)
		{
			sum1+=num.charAt(i)-'0';
		}
		
		for(int i=num.length()-1;i>mid;i--)
		{
			sum2+=num.charAt(i)-'0';
		}
		
		if(sum1==sum2)
		{
			return true;
		}
		return false;
	}
	
	public long palindrome(long num)
	{
		String number=Long.toBinaryString(num);
		
		String rev=reverse(number);
		
		if(number.equals(rev))
		{
			return (long)1;
		}
		return (long)0;
	}
	
	public String reverse(String number)
	{
		String rev="";
		
		for(int i=number.length()-1;i>=0;i--)
		{
			rev+=number.charAt(i);
		}
		
		return rev;
	}
	
	public long oddFactor(int num)
	{
		return (long)Math.sqrt(num);
	}
	
	public int doors(int num)
	{
		return (int)Math.sqrt(num);
	}
	
	public int perfectNumber(long num)
	{
		long sum=0;
		
		for(long i=1;i<num;i++)
		{
			if(num%i==0)
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
			return "No";
		}
		
		if(Math.abs(x1-x2)==Math.abs(x3-x4) && Math.abs(y3-y4)==Math.abs(y2-y1))
		{
			return "Yes";
		}
		return "No";
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
	
	public boolean luckyNum(int num)
	{
		return helper(num,2);
	}
	
	public boolean helper(int num,int count)
	{
		if(num<count)
		{
			return true;
		}
		
		if(num%count==0)
		{
			return false;
		}
		
		return helper(num-(num/count),count+1);
	}
	
	public int twistedPrime(int num)
	{
		int rev=0;
		int sum=num;
		
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
			if(num%i==0)
			{
				return false;
			}
		}
		
		return true;
	}
}
