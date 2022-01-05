package singleton;
import demo.Demo;
public class Singleton {
public static void main(String[] args)
{
	Thread t1=new Thread(new Runnable()
	{
		public void run() {
			Demo d1=Demo.getValue();
		}
     });
	Thread t2=new Thread(new Runnable()
			{
		public void run()
		{
			Demo d2=Demo.getValue();
		}
		
			});
	t1.start();
	t2.start();

}
}
