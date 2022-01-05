package extend.thread;
import extend.thread.ExtendThread;
import runnable.thread.RunnableThread;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ThreadRunner {
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		int option=0;
		try
		{
		 System.out.println("Enter the number between 1-7");
		 option=scanner.nextInt();
		 scanner.nextLine();
		}
		catch(InputMismatchException e)
		{
			System.out.println("You have entered string in place of integer ");
		}
		switch(option)
		{
		case 1:
		{
		   ExtendThread thread1 = new ExtendThread();
		   System.out.println("Current thread name : "+thread1.getName());
		   System.out.println("Priority : "+thread1.getPriority());
		   System.out.println("state : "+thread1.getState());
		   thread1.start();
		   System.out.println("Current thread name : "+thread1.getName());
		   System.out.println("Priority : "+thread1.getPriority());
		   System.out.println("state : "+thread1.getState());
		   break;
	    }
		case 2:
		{
			RunnableThread instance2=new RunnableThread();
			Thread thread2 = new Thread(instance2);
			System.out.println("Current thread name : "+thread2.getName());
			System.out.println("Priority : "+thread2.getPriority());
			System.out.println("state : "+thread2.getState());
			thread2.start();
			System.out.println("Current thread name : "+thread2.getName());
			System.out.println("Priority : "+thread2.getPriority());
			System.out.println("state : "+thread2.getState());
			break;
		}
		case 3:
		{
			ExtendThread thread1 = new ExtendThread();
			RunnableThread instance2 = new RunnableThread();
			Thread thread2 = new Thread(instance2);
			thread1.setName("Extended Thread");
			thread2.setName("Runnable thread");
			System.out.println("Extended Thread name before start : "+thread1.getName());
			System.out.println("Priority before start : "+thread1.getPriority());
			System.out.println("state before start : "+thread1.getState());
			
			System.out.println("Runnable thread name before start : "+thread2.getName());
			System.out.println("Priority before start : "+thread2.getPriority());
			System.out.println("state before start : "+thread2.getState());
			
			thread1.start();
			thread2.start();
			
			System.out.println("Extended thread name after start : "+thread1.getName());
			System.out.println("Priority after start : "+thread1.getPriority());
			System.out.println("state after start : "+thread1.getState());
			
			System.out.println("Runnable thread name after start: "+thread2.getName());
			System.out.println("Priority after start: "+thread2.getPriority());
			System.out.println("state after start: "+thread2.getState());
			
			break;
		}
		}
		scanner.close();
	}

}
