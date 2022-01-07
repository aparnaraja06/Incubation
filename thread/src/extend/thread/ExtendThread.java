package extend.thread;

public class ExtendThread extends Thread{
	public void run(){
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
		System.out.println(Thread.currentThread().getState());
		}

}
