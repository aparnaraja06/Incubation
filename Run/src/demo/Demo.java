package demo;

public class Demo {
	static Demo obj;
	private Demo() {
		System.out.println("Object is created");

	}
	public synchronized static  Demo getValue() {
		if(obj==null)
		{
		obj=new Demo();
		}
		return obj;
	}
	
}


