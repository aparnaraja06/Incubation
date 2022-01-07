package runnable.thread;

public class RunnableSleep implements Runnable{
	private long seconds;
	
	public RunnableSleep()
	{
		
	}
	public RunnableSleep(long time)
	{
		seconds=time;
	}
	public void run()
	{
		try
		{
		System.out.println("Going to sleep : "+Thread.currentThread().getName());
		Thread.sleep(seconds);
		
		System.out.println("After sleep : "+Thread.currentThread().getName());
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
