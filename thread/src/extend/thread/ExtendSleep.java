package extend.thread;

public class ExtendSleep extends Thread {
	private long seconds;
	public ExtendSleep() {
	
	}
	public ExtendSleep(long time)
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
