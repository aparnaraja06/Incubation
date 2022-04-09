package reader;

public class Reader {
public void rightTriangle(int num)
{
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<=i;j++)
		{
			
				System.out.print("*");
		}

		System.out.println("");
	}
}

public void leftTriangle(int num)
{
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<num;j++)
		{
			if(i+j==num-1 || i+j>=num)
			{
		
			System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
			
		}
		System.out.println("");
	}
}

public void pyramid(int num)
{
	for(int i=0;i<num;i++)
	{
		for(int j=num-i;j>1;j--)
		{
			System.out.print(" ");
		}
		
		for(int j=0;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
	
}

public void diamond(int num)
{
	for(int i=1;i<num;i++)
	{
		for(int j=i;j<=num;j++)
		{
			System.out.print(" ");
		}
		
		for(int j=1;j<i;j++)
		{
			System.out.print("* ");
		}
		
		for(int j=1;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<i;j++)
		{
			System.out.print(" ");
		}
		
		for(int j=i;j<num;j++)
		{
			System.out.print("* ");
		}
		
		for(int j=i;j<=num;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
	}
	
	

public void sandGlass(int num)
{
	
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<=i;j++)
		{
			System.out.print(" ");
		}
		for(int j=num-i;j>0;j--)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
	for(int i=0;i<num;i++)
	{
		for(int j=num-i;j>1;j--)
		{
			System.out.print(" ");
		}
		for(int j=0;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}	
	
}

public void simpleNumber(int num)
{
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(j+" ");
		}
		System.out.println(" ");
	}
}

public void rightPascal(int num)
{
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<=i;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
	for(int i=num-1;i>=0;i--)
	{
		for(int j=0;j<=i-1;j++)
		{
			System.out.print("* ");
		}
		System.out.println("");
	}
}

public void ZPattern(int num)
{
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<num;j++)
		{
			if(i==0 || i==num-1 || i+j==num-1)
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
}

public void rectangle(int num)
{
	int mid=num/2;
	for(int i=0;i<num;i++)
	{
		for(int j=0;j<num;j++)
		{
			if((i==0||i==num-1) || (j==0 || j==num-1) ||(i==mid && j==mid))
			{
				System.out.print("X");
			}
			else
			{
				System.out.print("0");
			}
		}
		System.out.println("");
	}
}

public void charArray(char[] arr)
{
	//int mid=arr.length/2;
	int j=0;
	int count=0;
	for(int i=arr.length-1;i>=0;i--)
	{
		if(arr[i]==arr[j])
		{
			count++;
			System.out.print(arr[i]);
			System.out.println("");
			j++;
		}
		else
		{
			if(count==1)
			{
				System.out.print(arr[i]);
				System.out.print(arr[j]);
				System.out.println("");
				j++;
			}
			else
			{
			System.out.print(arr[j]);
			System.out.print(arr[i]);
			System.out.println("");
			j++;
			}
		}
	}
	System.out.println("");
}

public String countAndSay(int num)
{
	if(num==1)
	{
		return "1";
	}
	
	String result="1";
	
	//System.out.println(result.charAt(0));
	for(int i=1;i<num;i++)
	{
		char prev=result.charAt(0);
		String temp="";
		int count=1;
		
		for(int j=0;j<result.length();j++)
		{
			if(result.charAt(j) != prev)
			{
				temp+=Integer.toString(count)+prev;
				prev=result.charAt(j);
				count=1;
			}
			else
			{
				count++;
			}
		}
		result=temp;
	}
	return result;
}

public void triangle(int num)
{
	
	for(int i=1;i<=num;i++)
	{
		for(int j=i;j<=num;j++)
		{
			System.out.print(" ");
		}
		
		for(int j=1;j<i;j++)
		{
			if(i==num ||j==1)
			{
				System.out.print("*");
			}
			else
			{
			System.out.print(" ");
			}
		
		}
		for(int j=1;j<=i;j++)
		{
			if(i==num || j==i)
			{
				System.out.print("*");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println("");
	}

}

public void hollowDiamond(int num)
{
	for(int i=1;i<num;i++)
	{
		for(int j=i;j<=num;j++)
		{
			System.out.print(" ");
		}
		
		for(int j=1;j<i;j++)
		{
			if(j==1)
			{
			System.out.print("* ");
			}
			else
			{
				System.out.print(" ");
			}
		}
		
		for(int j=1;j<=i;j++)
		{
			if(j==i)
			{
			System.out.print("* ");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
	for(int i=1;i<=num;i++)
	{
		for(int j=1;j<=i;j++)
		{
			System.out.print(" ");
		}
		
		for(int j=i;j<num;j++)
		{
			if(j==i)
			{
			System.out.print("* ");
			}
			else
			{
				System.out.print(" ");
			}
		}
		
		for(int j=i;j<=num;j++)
		{
			if(j==num)
			{
			System.out.print("* ");
			}
			else
			{
				System.out.print(" ");
			}
		}
		System.out.println("");
	}
}

public void circularSpiral(int num)
{
	for(int i=1-num;i<num;i++)
	{
		for(int j=1-num;j<num;j++)
		{
			if(Math.abs(i) > Math.abs(j))
			{
				System.out.print(Math.abs(i)+1+" ");
			}
			else
			{
				System.out.print(Math.abs(j)+1+" ");
			}
		}
		System.out.println("");
	}
}

public void pascal(int num)
{
	for(int i=0;i<num;i++)
	{
		int number=1;
		System.out.printf("%"+(num-i)*2+"s","");
		for(int j=0;j<=i;j++)
		{
			System.out.print("    "+number);
			number=number*(i-j)/(j+1);
		}
		System.out.println("");
	}
}

public void diamondNumber(int num)
{
	int rows=(num*2)-1;
	
	for(int i=1;i<=rows;i++)
	{
		for(int j=1;j<=rows;j++)
		{
			if(j==num)
			{
				System.out.println(1);
			}
			else
			{
				System.out.print(" ");
			}
		}
	}
}
}
