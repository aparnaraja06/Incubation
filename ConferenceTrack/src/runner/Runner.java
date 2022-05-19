package runner;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import event.Event;
import logic.Conference;

public class Runner 
{
	static Scanner scanner=new Scanner(System.in);
	static Conference reader=new Conference();
	
	public Event enterDetails()
	{
		System.out.println("Enter the event name");
		String name=scanner.nextLine();
		
		System.out.println("Enter the number of minutes");
		int minute=scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Choose the Session you prefer");
		System.out.println("1. Morning 2.Afternoon");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		String session="";
		if(num==1)
		{
			session="morning";
		}
		else if(num==2)
		{
			session="afternoon";
		}
		
		Event event=new Event();
		event.setName(name);
		event.setMinute(minute);
		event.setPreferredSession(session);
		event.setAllocatedSession(session);
		
		return event;
	}
	
	public void helper()
	{
		
		Event event=enterDetails();
		
		addEvent(event);
	}
	
	public void addEvent(Event event)
	{

		String session=event.getAllocatedSession();
		
		List<String> list=null;
		try {
			list=reader.getFreeSession(event, session);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		
		 String time="";
		if(!list.isEmpty())
		{
		 time=getFreeSpace(list);
		}
		  
		  if(time.equals("return") || list.isEmpty())
		  {
			  System.out.println("Do you want to choose afternoon slot / exit");
			  System.out.println("1.Choose Afternoon session 2.Exit");
			  int option=scanner.nextInt();
			  scanner.nextLine();
			  
			  switch(option)
			  {
			  
			  case 1:
			  {
			  String sessionn="afternoon";
			  
			  event.setAllocatedSession(sessionn);
			  
			 List<String> temp=null;
			  
			  try {
				temp=reader.getFreeSession(event, sessionn);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			  
			 if(!temp.isEmpty())
			 {
			time=getFreeSpace(temp);
			 }
			
			 else if(temp.isEmpty())
			{
				System.out.println("Oops! All slots are filled !");
				System.out.println("1.Choose Next Day 2.Exit");
				int choose=scanner.nextInt();
				scanner.nextLine();
				
				switch(choose)
				{
				case 1:
				{
					nextDay(event);
				}
				case 2:
				{
					return;
				}
				}
			}
			
			int index=temp.indexOf(time);
			  String next="";
			  if(temp.size()>1)
			  {
			  next=temp.get(index+1);
			  }
			  else
			  {
			  next=temp.get(index);
			  }
			  
			
			reader.allocateEvent(time, event);
			reader.changeGlobalTime(next,sessionn);
			reader.checkTime();
			
			  }
			  case 2:
			  {
				  return ;
			  }
			  }
		  }
		  else
		  {
		  int index=list.indexOf(time);
		  String next="";
		  if(list.size()>1)
		  {
		  next=list.get(index+1);
		  }
		  else
		  {
		  next=list.get(index);
		  }
		  
		reader.allocateEvent(time, event);
		reader.changeGlobalTime(next,session);
		reader.checkTime();
		  }
		
	}
	
	public void nextDay(Event event)
	{
		reader.nextDay();
		
		addEvent(event);
	}
	
	public String getFreeSpace(List<String> list)
	{
		/*System.out.println("Choose the time slot");
		for(int i=1;i<=list.size();i++)
		{
			String time=list.get(i-1);
			System.out.println(i+"  "+time);
		}
		
		int number=scanner.nextInt();
		scanner.nextLine();*/
		
		String time=list.get(0);
		
		boolean check=reader.isFree(time);
		
		if(check)
		{
			System.out.println("Time slot is free! You have been booked at : "+time);
			return time;
		}
		
		else
		{
			System.out.println("Oops! Time slot is allocated for another event");
			System.out.println("1.Choose another slot 2. Exit");
			int option=scanner.nextInt();
			scanner.nextLine();
			
			switch(option)
			{
			case 1:
			{
				return getFreeSpace(list);
			}
			case 2:
			{
				return "return";
			}
			}
			
		}
		
		return "return";
		
	}
	
	public void display()
	{
		Map<String,Event> result=reader.getAllDetails();
		
		for(String time : result.keySet())
		{
			Event event=result.get(time);
			
			System.out.println("Time : "+time);
			System.out.println("Event : "+event);
			System.out.println("----------------------------------------------");
		}
	}

	public static void main(String[] args)
	{
		Runner runner=new Runner();
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("1.Add Event 2.Display all events 3.exit");
		int num=scanner.nextInt();
		scanner.nextLine();
		
		switch(num)
		{
		case 1:
		{
			runner.helper();
			break;
		}
		
		case 2:
		{
			runner.display();
			break;
		}
		
		case 3:
		{
			flag=false;
		}
		}
		}
	}
}
