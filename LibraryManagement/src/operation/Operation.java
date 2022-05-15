package operation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.Book;
import card.Card;
import order.Order;

public class Operation {
	
	private int cardNum=0;
	private int bookId=100;
	private int orderId=1000;
	
	Map<String,List<Book>> availableMap=new HashMap<>();
	Map<Integer,Card> customerMap=new HashMap<>();
	Map<Integer,Book> bookMap=new HashMap<>();
	Map<Integer,List<Book>> filledMap=new HashMap<>();
	Map<Integer,Map<String,Order>> orderMap=new HashMap<>();
	Map<String,List<Integer>> waitingMap=new HashMap<>();
	
	private int generateCardNum()
	{
		return ++cardNum;
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
			
			List<Book> titleList=availableMap.get(title[i]);
			
			if(titleList==null)
			{
				titleList=new  ArrayList<>();
			}
			
			titleList.add(book);
			availableMap.put(title[i], titleList);
			
			List<Book> authorList=availableMap.get(author[i]);
			
			if(authorList==null)
			{
				authorList=new  ArrayList<>();
			}
			
			authorList.add(book);
			availableMap.put(author[i], authorList);

			List<Book> subjectList=availableMap.get(subject[i]);
			
			if(subjectList==null)
			{
				subjectList=new  ArrayList<>();
			}
			
			subjectList.add(book);
			availableMap.put(subject[i], subjectList);
			
			List<Book> dateList=availableMap.get(published[i]);
			
			if(dateList==null)
			{
				dateList=new  ArrayList<>();
			}
			
			dateList.add(book);
			availableMap.put(published[i], dateList);

            bookMap.put(id, book);
		}
	}
	
	public void addDefaultCustomers()
	{
		String[] name= {"Karthik","Priya","Sam","Apoorva","Hrithik"};
		int[] age= {20,30,40,33,23};
		String[] gender= {"male","female","male","female","male"};
		long[] mobile= {9284752342L,9264823762L,8136481272L,8264827342L,8237483634L};
		String[] location= {"gandhi street","nehru street","rose street","lovely street","thilakar street"};
		
		for(int i=0;i<name.length;i++)
		{
			int id=generateCardNum();
			
			Card card=new Card();
			
			card.setCustomerId(id);
			card.setName(name[i]);
			card.setAge(age[i]);
			card.setGender(gender[i]);
			card.setMobile(mobile[i]);
			card.setLocation(location[i]);
			
			customerMap.put(id, card);
		}
	}
	
	public Card getDetails(int cardNumber)
	{
		Card card=customerMap.get(cardNumber);
		
		return card;
	}
	
	public List<Book> getBook(String title)
	{
		List<Book> list=availableMap.get(title);
		
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book=bookMap.get(id);
		
		if(book==null)
		{
			return null;
		}
		
		return book;
	}
	
	public void updateOrder(Book book,int cardNumber)
	{
		List<Book> temp=filledMap.get(cardNumber);
		
		int bookId=book.getId();
		
		if(temp==null)
		{
			temp=new ArrayList<>();
		}
		
		filledMap.put(bookId, temp);
	}
	
	public int checkMaximumLimit(int cardNumber)
	{
		List<Book> temp=orderMap.get(cardNumber);
		
		if(temp==null)
		{
			return 0;
		}
		
		/*if(temp.size()==5)
		{
			re
		}*/
		
		return temp.size();
	}
	
	public void removeInAvailable(Book book)
	{
		int id=book.getId();
		
		bookMap.remove(id);
	}
	
	public boolean storeInWaitingList(int cardNum,String title)
	{
		List<Integer> list=waitingMap.get(title);
		
		if(list==null)
		{
			list=new ArrayList<>();
		}
		
		list.add(cardNum);
		
		waitingMap.put(title, list);
		
		return true;
	}
	
	/*public boolean returnBook(Book book,int cardNum)
	{
		int id=book.getId();
		
		Map<Integer,Book> temp=orderMap.get(cardNum);
		temp.remove(id);
		
	}*/
	
	public String getDate() {
		
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
	 
	        // add 1 days to current day
	        cal.add(Calendar.DAY_OF_MONTH, 10);
	 
	        Date datePlus10 = cal.getTime();
	        
	        String result=date.format(datePlus10);
	        
	        return result;
	}
	
	public void placeOrder(Book book,int cardNum)
	{
		int id=generateOrderId();
		
		int book_id=book.getId();
		String date=getDate();
		String last=lastDate();
		
		
		Order order=new Order();
		
		order.setBookId(book_id);
		order.setCustomerId(cardNum);
		order.setId(id);
		order.setOrderDate(date);
		order.setReturnDate(last);
	}
}
