package pojodemo;

public class PojoDemo {
	private String string;
	private int integer;
	public PojoDemo()
	{
	System.out.println("I'm POJO default!!!!");
	}
public PojoDemo(String string,int integer)	
{
	setString(string);
	setInteger(integer);
}
public String getString()	
{	
	return string;
}	
public void setString(String string)
{
	this.string=string;
}
public int getInteger()
{
	return integer;
}
public void setInteger(int integer)
{
	this.integer=integer;
}
public String toString() {
	
	return "String:"+string+"\nint:"+integer;
	
}
}