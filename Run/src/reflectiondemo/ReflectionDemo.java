package reflectiondemo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;
public class ReflectionDemo {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	try
	{
		Class<?> className=Class.forName("pojodemo.PojoDemo");
		System.out.println("Calling Default Constructor");
		Constructor<?> sample=className.getConstructor();
		Object defaultObj=sample.newInstance();
		System.out.println(defaultObj);
		
		System.out.println("Calling Parameterized constructor");
		Class<?> [] type= {String.class,int.class};
		Constructor<?> construct=className.getConstructor(type);
		
		System.out.println("Enter the string to get ");
		String string1=scanner.nextLine();
		System.out.println("Enter the integer to get ");
		int integer1=scanner.nextInt();
		scanner.nextLine();
		
		//Object[] parameter= {string1,integer1};
		Object instance=construct.newInstance(string1,integer1);
		System.out.println(instance);
		
		Method nameSet=className.getMethod("setString",String.class);
		System.out.println("enter the string to change ");
		String str=scanner.nextLine();
		nameSet.invoke(instance, str);
		
		Method nameGet=className.getMethod("getString");
		String result= nameGet.invoke(instance).toString();
		System.out.println(result);
		
		System.out.println("parameter object from getter:");
		System.out.println(instance);
		
		/*System.out.println("Instance obj:");
		System.out.println(instance);*/	
		
	}
	catch(Exception e)
	{
		e.getMessage();
	}
	scanner.close();
}
}
