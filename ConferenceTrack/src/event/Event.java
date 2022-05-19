package event;

public class Event 
{
	
	private String name;
	private int minute;
	private String time;
	private String preferredSession;
	private String allocatedSession;
	private String date;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPreferredSession() {
		return preferredSession;
	}
	public void setPreferredSession(String preferredSession) {
		this.preferredSession = preferredSession;
	}
	public String getAllocatedSession() {
		return allocatedSession;
	}
	public void setAllocatedSession(String allocatedSession) {
		this.allocatedSession = allocatedSession;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() 
	{
		return "name : " + name + "\n minute : " + minute + "\n time : " + time + "\n preferredSession : "
				+ preferredSession + "\n allocatedSession : " + allocatedSession + "\n date : " + date;
	}
	
	

}
