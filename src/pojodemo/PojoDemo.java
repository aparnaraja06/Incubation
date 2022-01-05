package pojodemo;

public class PojoDemo {
	private String string;
	private int integer;
public pojoDemo(String string,int integer)	
{
	this.string=string;
	this.integer=integer;
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
	String result=getString()+"\n";
	result+=getIntger()+"\n";
	return result;
}
}