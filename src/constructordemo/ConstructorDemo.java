package constructordemo;

public class ConstructorDemo {
	String sample;
public ConstructorDemo(String sample)
{
	this.sample=sample;
}
@Override
public String toString()
{
	return this.sample;
}
}
