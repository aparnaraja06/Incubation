package constructorrunner;
import constructordemo.ConstructorDemo;
import pojodemo.PojoDemo;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ConstructorRunner {
public static void main(String[] args)
{
	Scanner scanner=new Scanner(System.in);
	int option=0;
	try
	{
	System.out.println("Enter the number between 1-3");
	 option=scanner.nextInt();
	scanner.nextLine();
	}
	catch(InputMismatchException e)
	{
		System.out.println("You have entered string in place of integer");
	}
	switch(option)
	{
	case 1:
	{
		System.out.println("Enter the String to add ");
		String name=scanner.nextLine();
		ConstructorDemo construct=new ConstructorDemo(name);
		System.out.println("The object is "+construct);	
		break;
	}
	case 2:
	{
		System.out.println("Enter the string to add ");
		String name=scanner.nextLine();
		System.out.println("Enter the integer to add ");
		int number=scanner.nextInt();
		PojoDemo demo=new PojoDemo(name,number);
		System.out.println(demo);
		break;
	}
	case 3:
	{
		PojoDemo construct=new PojoDemo();
		System.out.println("Enter the String to add ");
		String name=scanner.nextLine();
		System.out.println("Enter the integer to add ");
		int number=scanner.nextInt();
		scanner.nextLine();
		construct.setString(name);
		construct.setInteger(number);
	    System.out.println(construct.getString());
		System.out.println(construct.getInteger());
		break;
	}
	default:
		System.out.println("You have entered more than 3! please enter between 1-3");
}
	scanner.close();
}
}
