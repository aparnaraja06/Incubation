package extend.thread;

import java.util.InputMismatchException;
import java.util.Scanner;

import runnable.thread.DumpRunnable;
import runnable.thread.RunnableSleep;
import runnable.thread.RunnableThread;

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
			thread1.setName("Extended Thread");

			RunnableThread instance2 = new RunnableThread();
			Thread thread2 = new Thread(instance2);
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
		
		case 4:
		{	
			System.out.println("Enter the number of threads to create : ");
			int number=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter seconds for making thread to sleep:");
			long seconds=scanner.nextLong();
			seconds*=1000;
			for(int i=1;i<=number;i++)
			{
			ExtendSleep thread1 = new ExtendSleep(seconds);
			thread1.setName("Extended Thread " +i);
			thread1.start();
			}
			
			System.out.println("Enter seconds for making thread to sleep:");
			seconds=scanner.nextLong();
			seconds*=1000;
			for(int i=1;i<=number;i++)
			{
			RunnableSleep instance1 = new RunnableSleep(seconds);
			Thread runThread1 = new Thread(instance1);
			runThread1.setName("Runnable Thread "+i);
			runThread1.start();
			}
			
			break;
			
		}
		
		case 5:
		{	
			System.out.println("Enter the number of threads to create : ");
			int number=scanner.nextInt();
			scanner.nextLine();
			for(int i=1;i<=number;i++)
			{
			System.out.println("Enter seconds for making thread to sleep:");
			long seconds=scanner.nextLong();
			seconds*=1000;
			ExtendSleep thread1 = new ExtendSleep(seconds);
			thread1.setName("Extended Thread " +i);
			thread1.start();
			}
			
			for(int i=1;i<=number;i++)
			{
			System.out.println("Enter seconds for making Runnable to sleep:");
			long seconds=scanner.nextLong();
			seconds*=1000;
			RunnableSleep instance1 = new RunnableSleep(seconds);
			Thread runThread1 = new Thread(instance1);
			runThread1.setName("Runnable Thread "+i);
			runThread1.start();
			}
			
			break;
			
		}
		case 6:
		{
			
			System.out.println("Enter the number of threads to create : ");
			int number=scanner.nextInt();
			scanner.nextLine();
			
			DumpExtend[] thread1 = new DumpExtend[number];
			DumpRunnable[] instance1 = new DumpRunnable[number];
			Thread[] runThread1 = new Thread[number];
			
			System.out.println("Enter seconds for making thread to sleep:");
			long seconds=scanner.nextLong();
			seconds*=1000;
			
			for(int i=0;i<number;i++)
			{
			
			
			thread1[i] = new DumpExtend(seconds);
			thread1[i].setName("Extended Thread " +i);
			thread1[i].start();
						
			instance1[i] = new DumpRunnable(seconds);
			runThread1[i] = new Thread(instance1[i]);
			runThread1[i].setName("Runnable Thread "+i);
			runThread1[i].start();
			}
			
			System.out.println("------ Main() going to sleep!");
			try
			{
				Thread.sleep(120000);
			}
			catch(InterruptedException ex) {}
			
			System.out.println("------ Main() after sleep!");
			
			System.out.println("Enter time sleep between stopping threads:");
			long sleepSec=scanner.nextLong();
			sleepSec*=1000;
			
			for(int i=0;i<number;i++)
			{
				System.out.println("Is extended thread "+i+" alive : "+thread1[i].isAlive());
				thread1[i].setValue(false);
				System.out.println("---------xxxxxxxxxxxxxxxxxxxxxxx---------------\nStopped:Extended Thread " +i);
				System.out.println("----------------xxxxxxxxxxxxxxx-----------------");
				System.out.println("Is extended thread "+i+" alive : "+thread1[i].isAlive());
			}
				
				try
				{
					Thread.sleep(sleepSec);
					
				}
				catch(InterruptedException ex) {
					
				}
				for(int i=0;i<number;i++)
				{
				System.out.println("Is runnable thread "+i+" alive : "+runThread1[i].isAlive());
				instance1[i].setValue(false);
				
				System.out.println("---------xxxxxxxxxxxxxxxxxxxxxxx---------------\nStopped:Runnable Thread "+i);
				System.out.println("----------------xxxxxxxxxxxxxxx-----------------");
				System.out.println("Is runnable thread "+i+" alive : "+runThread1[i].isAlive());
				}		
				}
			
			
		}
		scanner.close();
		}
		
		
	}

