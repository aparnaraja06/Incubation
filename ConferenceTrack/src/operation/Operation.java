package operation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import event.Event;

public class Operation 
{

	private String morning="09:00";
	private String afternoon="01:00";
	private int day=0;
	
	
	Map<String,Event> allocatedMap=new HashMap<>();
	
	
	public List<String> getFreeSession(Event event,String session)throws ParseException
	{
		//String session=event.getPreferredSession();
		
		List<String> list=new ArrayList<>();
		
		if(session.equals("morning"))
		{
			list=freeMorningSession(event);
		}
		
		else
		{
			list=freeAfternoon(event);
		}
		
		return list;
	}
	
	public List<String> freeMorningSession(Event event)throws ParseException
	{
		List<String> list=new ArrayList<>();
		
		int minute=event.getMinute();
		
		String end="12:00";
		
		
		
		helperMorning(morning,end,list,minute);
		
		/*int size=list.size();
		
		list.remove(size-1);*/
		
		
		return list;
		
	}
	
	public void helperMorning(String start,String end,List<String> list,int minute)throws ParseException
	{
		
		//System.out.println("Start : "+start);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		 Date d = df.parse(start); 
		 Date temp=df.parse(end);

		 
		 if(start.equals(end) || d.after(temp))
			{
				return;
			}
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(d);
		 cal.add(Calendar.MINUTE, minute);
		 String newTime = df.format(cal.getTime());
		 Date newDate=df.parse(newTime);
		 if(newDate.after(temp))
		 {
			 return;
		 }
		 if(list.isEmpty())
		 {
			 list.add(start);
		 }
		 list.add(newTime);
		 
		 helperMorning(newTime,end,list,minute);
	}
	
	public List<String> freeAfternoon(Event event)throws ParseException
	{
         List<String> list=new ArrayList<>();
		
		int minute=event.getMinute();
		
		String end="05:00";
		
		//list.add(afternoon);
		
		helperMorning(afternoon,end,list,minute);
		
       /* int size=list.size();
		
		list.remove(size-1);*/

		
		return list;
	}
	
	public boolean isFree(String time)
	{
		Event event=allocatedMap.get(time);
		
		if(event==null)
		{
			return true;
		}
		
		return false;
	}
	
	public void changeGlobalTime(String time,String session)
	{
		if(session.equals("morning"))
		{
			morning=time;
			System.out.println("Global morning : "+morning);
		}
		else
		{
			afternoon=time;
		}
	}
	
	public void allocateEvent(String time,Event event)
	{
		event.setTime(time);
		
		String date=getDate();
		
		event.setDate(date);		
		
		allocatedMap.put(time, event);
		
	}
	
	public void checkTime()
	{
		String time="12:00";
		String end="05:00";
		
		if(morning.equals(time))
		{
			addLunch(time);
		}
		else if(afternoon.equals(end))
		{
			addNetwork(end);
		}
	}
	
	public void addLunch(String time)
	{
		Event event=new Event();
		
		event.setName("Lunch");
		event.setMinute(60);
		event.setTime(time);
		
		allocatedMap.put(time, event);
	}
	
	public void addNetwork(String time)
	{
       Event event=new Event();
		
		event.setName("Network");
		event.setMinute(60);
		event.setTime(time);
		
		allocatedMap.put(time, event);

	}
	
	public String getDate() 
	{
		
		long millis=System.currentTimeMillis();
		
		DateFormat date=new SimpleDateFormat("dd MMM yyyy");
		
		Date result=new Date(millis);
		
		Calendar c = Calendar.getInstance(); 
		c.setTime(result); 
		c.add(Calendar.DATE, day);
		result = c.getTime();

		String time=date.format(result);
		
		return time;
	}
	
	public Map<String,Event> getAllDetails()
	{
		return allocatedMap;
	}
	
	public void nextDay()
	{
		++day;
		
		morning="09:00";
		
		afternoon="01:00";
	}
}
