package operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.Book;
import card.Card;
import order.Order;

public class Operation 
{

	private int cardId=100;
	private int bookId=0;
	private int orderId=1000;
	
	Map<String,List<Book>> availableMap=new HashMap<>();
	Map<Integer,Card> customerMap=new HashMap<>();
	Map<Integer,Book> bookMap=new HashMap<>();
	Map<Integer,List<Order>> orderMap=new HashMap<>();
	Map<String,List<Integer>> waitingMap=new HashMap<>();
	
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
			int id=generateCardId();
			
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
		
		public List<Book> getBookBySearch(String search)
		{
			List<Book> list=availableMap.get(search);
			
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
		
		public int  isMaximum(int number)
		{
			List<Order> list=orderMap.get(number);
			
			if(list==null || list.isEmpty())
			{
				return 0;
			}//0-->no order/5 maximum
			
			return list.size();
		}
		
		public Book getBook(int id)
		{
			Book book=bookMap.get(id);
			
			return book;
		}
		
		public int orderBook(Book book)
		{
			int id=generateOrderId();
			
			String type=book.ge
			
		}
		
		
		
}
