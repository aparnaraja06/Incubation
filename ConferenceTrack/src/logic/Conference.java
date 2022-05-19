package logic;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import event.Event;
import operation.Operation;

public class Conference {
	
	Operation reader=new Operation();

	
	public List<String> getFreeSession(Event event,String session)throws ParseException
	{
		return reader.getFreeSession(event, session);
	}
	
	public boolean isFree(String time)
	{
		return reader.isFree(time);
	}
	
	public void changeGlobalTime(String time,String session)
	{
		reader.changeGlobalTime(time, session);
	}
	
	public void allocateEvent(String time,Event event)
	{
		reader.allocateEvent(time, event);
	}
	
	public void checkTime()
	{
		reader.checkTime();
	}
	
	public Map<String,Event> getAllDetails()
	{
		return reader.getAllDetails();
	}
	
	public void nextDay()
	{
		reader.nextDay();
	}

}
