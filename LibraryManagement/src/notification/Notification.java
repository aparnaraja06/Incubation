package notification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import operation.Operation;
import order.Order;

public class Notification extends TimerTask
{
	Operation operation=new Operation();
	
	public Collection<Order> getOrders()
	{
		Map<Integer,Order> orderMap=operation.getOrderDetails();
		
		Collection<Order> list=orderMap.values();
		System.out.println(list);
		
		return list;
	}
	
	public void getCardNumbers() 
	{
		String last=operation.getDate();
		
		Collection<Order> list=getOrders();
		
		//List<Integer> temp=new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			Order order=new Order();
			String returnDate=order.getReturnDate();
			
			int cardNum=order.getCustomerId();
			
			if(returnDate.equals(last))
			{
				System.out.println(cardNum);
			}
			
		}
	}
	
	/*private  Calendar getTiming()
	{

		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 11);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);


		return today.getTime();

      }

	
	public  void startTask()
	{
		Timer timer = new Timer();
	    TimerTask task = new Notification();
        timer.schedule(task,getTiming.(),1000*60*60*24); 
    }*/

	

	@Override
	public void run() {
		
		getCardNumbers();
	}

}
