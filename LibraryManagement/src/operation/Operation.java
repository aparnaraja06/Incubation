package operation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import book.Book;
import card.Card;
import notification.Notification;
import order.Order;

public class Operation
{

	private int cardId=100;
	private int bookId=0;
	private int orderId=1000;
	
	Map<String,List<Book>> showMap=new HashMap<>();
	Map<Integer,Card> customerMap=new HashMap<>();
	Map<Integer,Book> bookMap=new HashMap<>();
	Map<String,List<Integer>> availableMap=new HashMap<>();
	Map<Integer,Order> orderMap=new HashMap<>();
	Map<Integer,List<Integer>> waitingMap=new HashMap<>();
	
	//Notification notify=new Notification();
	
	private int generateCardId() 
	{
		return ++cardId;
	}
	
	private int generateBookId()
	{
		return ++bookId;
	}
	
	private int generateOrderId()
	{
		return ++orderId;
	}
	
	public void addDefaultBooks()
	{
		String[] title= {"THE GUIDE","CACTUS COUNTRY","THE GOD OF SMALL THINGS","A SUITABLE BOY","SHOW BUSINESS",
				"I TOO HAD A LOVE STORY","THE STORY OF MY EXPERMIMENTS WITH THE TRUTH"};
		String[] author= {"R K NARAYANAN","MANOHAR MALGONKAR","ARUNDHATI ROY","VIKRAM SETH","SHASHI THAROOR",
				"RAVINDER SINGH","MAHATMA GANDHI"};
		String[] subject= {"FICTION","THRILLER","NOVEL","NOVEL","NOVEL","HISTORICAL","ROMANCE","AUTO BIOGRAPHY"};
		String[] language= {"ENGLISH","ENGLISH","ENGLISH","ENGLISH","ENGLISH","ENGLISH","ENGLISH"};
		int[] edition= {1,1,1,1,1,1,1};
		String[] published= {"1960","1985","1998","1993","2001","2007","1935"};
		
		for(int i=0;i<title.length;i++)
		{
			
			int id=generateBookId();
			Book book=new Book();
			
			book.setTitle(title[i]);
			book.setAuthor(author[i]);
			book.setCategory(subject[i]);
			book.setLanguage(language[i]);
			book.setEdition(edition[i]);
			book.setPublishedDate(published[i]);
			book.setId(id);
			book.setRackNum(i);
			
			List<Integer> list= availableMap.get("available");
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(id);
			
			List<Book> titleList=showMap.get(title[i]);
			
			if(titleList==null)
			{
				titleList=new  ArrayList<>();
			}
			
			titleList.add(book);
			showMap.put(title[i], titleList);
			
			List<Book> authorList=showMap.get(author[i]);
			
			if(authorList==null)
			{
				authorList=new  ArrayList<>();
			}
			
			authorList.add(book);
			showMap.put(author[i], authorList);

			List<Book> subjectList=showMap.get(subject[i]);
			
			if(subjectList==null)
			{
				subjectList=new  ArrayList<>();
			}
			
			subjectList.add(book);
			showMap.put(subject[i], subjectList);
			
			List<Book> dateList=showMap.get(published[i]);
			
			if(dateList==null)
			{
				dateList=new  ArrayList<>();
			}
			
			dateList.add(book);
			showMap.put(published[i], dateList);

            bookMap.put(id, book);
            availableMap.put("available", list);
		}
	}
	
	public void addDefaultCustomers()
	{
		String[] name= {"Karthik","Priya","Sam","Apoorva","Hrithik"};
		int[] age= {20,30,40,33,23};
		String[] gender= {"male","female","male","female","male"};
		long[] mobile= {9284752342L,9264823762L,8136481272L,8264827342L,8237483634L};
		int[] maximum= {5,5,5,5,5};
		String[] location= {"gandhi street","nehru street","rose street","lovely street","thilakar street"};
		
		for(int i=0;i<name.length;i++)
		{
			int id=generateCardId();
			
			Card card=new Card();
			
			card.setCustomerId(id);
			card.setName(name[i]);
			card.setAge(age[i]);
			card.setGender(gender[i]);
			card.setMobile(mobile[i]);
			card.setLocation(location[i]);
			card.setMaxLimit(maximum[i]);
			
			customerMap.put(id, card);
		}
	}
	
	public int addCustomers(Card card)
	{
		int id=generateCardId();
		
		int maximum=5;
		
		card.setCustomerId(id);
		card.setMaxLimit(maximum);
		
		customerMap.put(id, card);
		
		return id;
	}
		
		public List<Book> getBookBySearch(String search)
		{
			search=search.toUpperCase();
			List<Book> list=showMap.get(search);
			
			if(list==null)
			{
				return null;
			}//not available
			
			return list;
		}
		
		public int rackNumber(int id)
		{
			Book book=bookMap.get(id);
			
			int rack=book.getRackNum();
			
			return rack;
		}
		
		public int addCustomer(Card customer)
		{
			int id=generateCardId();
			
			customerMap.put(id, customer);
			
			return id;
		}
		
		public Card showDetails(int number)
		{
			Card card=customerMap.get(number);
			
			return card;
		}
		
		public int  isMaximum(int cardNumber)
		{
			Card card=customerMap.get(cardNumber);
			
			int maximum=card.getMaxLimit();
			
			return maximum;
		}
		
		public Book  isAvailable(int bookNum)
		{
			List<Integer> list=availableMap.get("available");
			
			int index=list.indexOf(bookNum);
			
			if(index == -1)
			{
				return null;
			}
			
			list.remove(index);
			
			availableMap.put("available", list);
			
			List<Integer> temp=availableMap.get("booked");
			
			if(temp==null)
			{
				temp=new ArrayList<>();
			}
			
			temp.add(bookNum);
			
			availableMap.put("booked", temp);
			
			Book book=bookMap.get(bookNum);
			
			return book;
		}
		
		public String getDate() 
		{
			
			long millis=System.currentTimeMillis();
			
			DateFormat date=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
			
			Date result=new Date(millis);
			
			String time=date.format(result);
			
			return time;
		}
		
		public String lastDate()
		{
			 Date currentDate = new Date();
			 DateFormat date=new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		 
		        Calendar cal = Calendar.getInstance();
		        cal.setTime(currentDate);
		 
		        // add 10 days to current day
		        cal.add(Calendar.DAY_OF_MONTH, 10);
		 
		        Date datePlus10 = cal.getTime();
		        
		        String result=date.format(datePlus10);
		        
		        return result;
		}
				
		public int placeOrder(Book book,int cardNum)
		{
          
			
			int maximum=isMaximum(cardNum);
			
			if(maximum==0)
			{
				return 0;
			}
			
			int id=generateOrderId();
			int bookId=book.getId();
			String date=getDate();
			String last=lastDate();
			
			Order order=new Order();
			
			order.setBookId(bookId);
			order.setCustomerId(cardNum);
			order.setId(id);
			order.setOrderDate(date);
			order.setReturnDate(last);
			
						
			orderMap.put(bookId, order);
			
			Card card=customerMap.get(cardNum);
			
			--maximum;
			
			card.setMaxLimit(maximum);
			
			customerMap.put(cardNum, card);
			
			return id;
			
		}
		
		public int returnBook(int bookNum)
		{
			Integer temp=bookNum;
			
			List<Integer> list=availableMap.get("booked");
			
			list.remove(temp);
			
			availableMap.put("booked", list);
			
			updateInAvailable(bookNum);
			
			return bookNum;
		}
		
		public List<Integer> checkReserved(int bookNum)
		{
			List<Integer> list=waitingMap.get(bookNum);
			
			if(list==null)
			{
				return null;
			}
			
			return list;
		}
		
		public boolean setReserved(int bookNum)
		{
           List<Integer> list=availableMap.get("reserved");
           
           if(list==null)
           {
        	   list=new ArrayList<>();
           }
			
			list.add(bookNum);
			
			availableMap.put("reserved", list);
			
			return true;

		}
		
		public void updateInAvailable(int bookNum)
		{
           List<Integer> list=availableMap.get("available");
			
			list.add(bookNum);
			
			availableMap.put("available", list);
		}
		
		public Order getOrderDetails(int bookNum)
		{
			Order order=orderMap.get(bookNum);
			
			int cardNum=order.getCustomerId();
			
			Card card=customerMap.get(cardNum);
			
			int maximum=card.getMaxLimit();
			
			++maximum;
			
			card.setMaxLimit(maximum);
			
			customerMap.put(cardNum, card);
			
			return order;
		}
		
		public int checkLastDate(Order order)throws ParseException
		{
			String last=order.getReturnDate();
			String now=getDate();
			
			 SimpleDateFormat myFormat = new SimpleDateFormat("dd MMM yyyy");
			 
			 Date date1 = myFormat.parse(last);
			 long millis1 = date1.getTime();
			 Date date2 = myFormat.parse(now);
			 long millis2 = date2.getTime();
			 
			 long millis=millis2-millis1;
			 
			 int days = (int) (millis / (1000*60*60*24));
			 
			 return days;
		}
		
		public double getAmount(int days)
		{
			double fine=10;
			
			double amount=days*fine;
			
			return amount;
			
		}
		
		public void removeOrder(int bookNum)
		{
			orderMap.remove(bookNum);			
			
		}
		
		public boolean putInWaiting(int cardNum,int bookNum)
		{
			List<Integer> list=waitingMap.get(bookNum);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}
			
			list.add(cardNum);
			
			waitingMap.put(bookNum, list);
			
			return true;
		}
		
		public Map<Integer,Order> getOrderDetails()
		{
			return orderMap;
		}
		
		public void getNotification()
		{
			Timer timer = new Timer();
		    TimerTask task = new Notification();
		    timer.scheduleAtFixedRate(task,new Date(),87012000);
		}
		
		/*public void getNotification()
		{
			Notification notify=new Notification();
			
			notify.run();
		}*/
		
				
}
