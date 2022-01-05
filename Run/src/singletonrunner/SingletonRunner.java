package singletonrunner;
import singletonenum.SingletonEnum;
public class SingletonRunner {
public static void main(String[] args)
{
	SingletonEnum demo=SingletonEnum.INSTANCE;
	System.out.println(demo.getValue());
	demo.setValue(10);
	System.out.println(demo.getValue());
}
}
