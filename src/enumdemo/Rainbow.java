package enumdemo;

public enum Rainbow {
VIOLET(1),INDIGO(2),BLUE(3),GREEN(4),YELLOW(5),ORANGE(6),RED(7);
	private final int colourCode;
	private final String colour;
Rainbow(int colourCode)	
{
	this.colourCode=colourCode;
}
Rainbow(String colour)
{
    this.colour=colour;	
}
public getCode(String colour)
{
	return Rainbow.valueOf(colour);
}
public String toString()
{
	String result="The value of "+this.colour+"is "+getCode();
	return result;
}
}
