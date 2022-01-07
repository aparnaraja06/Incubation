package extend.thread;

public class DumpExtend extends Thread{
	private long seconds;
	private boolean execute;
	
	public DumpExtend() {
	
	}
	public DumpExtend(long time)
	{
		seconds=time;
		execute=true;
	}
	
	public void setValue(Boolean value)
	{
		execute=value;
	}
	
	public void run()
	{
		int count=0;
		while(execute)
		{
			try
			{

				System.out.println("Going to sleep : "+Thread.currentThread().getName()+" counter:"+count);
				Thread.sleep(seconds);

				System.out.println("After sleep : "+Thread.currentThread().getName()+" counter:"+count);
				count++;
			}
			catch(Exception e)
			{

			}
		}
		
	}

}
