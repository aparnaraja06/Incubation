package runner;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import book.Book;
import card.Card;
import operation.Operation;
import order.Order;

public class Runner 
{
	static Scanner scanner=new Scanner(System.in);
	static Operation reader=new Operation();

	public void existingMember()
	{
		System.out.println("Enter the card Number");
		int cardNum=scanner.nextInt();
		scanner.nextLine();
		
		Card card=reader.showDetails(cardNum);
		System.out.println(card);
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Get book by title 2. Get book 3.Return book 4. Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		
		case 1:
		{
			
		System.out.println("Enter the book name to serach");
		String title=scanner.nextLine();
		
		List<Book> list=reader.getBookBySearch(title);
		
		System.out.println(list);
		break;
		}
		
		case 2:
		{
			System.out.println("Enter book number");
			int bookNum=scanner.nextInt();
			scanner.nextLine();
			
			Book book=reader.isAvailable(bookNum);
			if(book==null)
			{
				boolean stop=true;
				
				while(stop)
				{
				System.out.println("1.Put in waiting list 2.leave");
				int num=scanner.nextInt();
				scanner.nextLine();
				
				switch(num)
				{
				
				case 1:
				{
				boolean result=reader.putInWaiting(cardNum, bookNum);
				if(result)
				{
					System.out.println("Currently in waiting list...");
					System.out.println("Let you know after the arrival of book");
				}
				}
				case 2:
				{
					stop=false;
					break;
				}
				}
				}
			}
			else
			{
			System.out.println(book);
			
			int orderNum=reader.placeOrder(book, cardNum);
			if(orderNum==0)
			{
				System.out.println("Sorry You have reached Maximum limit");
			}
			else
			{
			System.out.println("Your Order Id : "+orderNum);
			}
			}
			break;
		}
		
		case 3:
		{
			System.out.println("Enter book number");
			int bookNum=scanner.nextInt();
			scanner.nextLine();
			
			reader.returnBook(bookNum);
			
			Order order=reader.getOrderDetails(bookNum);
			int days=0;
			try {
				days=reader.checkLastDate(order);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(days>0)
			{
				double amount=reader.getAmount(days);
				System.out.println("Fine amount : "+amount);
			}
			reader.removeOrder(bookNum);
			System.out.println("Thank you All Details are updated");
			
			List<Integer> list=reader.checkReserved(bookNum);
			
			System.out.println("Notification send to card numbers reserved this book");
			System.out.print(list+" ");
			
					
			
			break;
		}
				
		case 4:
		{
			flag=false;
		}
		}
		}
	}
	
	public void newCustomer()
	{
		System.out.println("Enter your name");
		String name=scanner.nextLine();
		
		System.out.println("Enter age");
		int age=scanner.nextInt();
		
		System.out.println("Enter Gender");
		String gender=scanner.nextLine();
		
		System.out.println("Enter mobile");
		long mobile=scanner.nextLong();
		scanner.nextLine();
		
		System.out.println("Enter location");
		String location=scanner.nextLine();
		
		Card card=new Card();
		
		card.setAge(age);
		card.setName(name);
		card.setGender(gender);
		card.setLocation(location);
		card.setMobile(mobile);
		card.setLocation(location);
		
		int cardNum=reader.addCustomer(card);
		
		System.out.println("Generated Card Number is : "+cardNum);
	}
	public static void main(String[] args)
	{
		Runner runner=new Runner();
				
		reader.addDefaultCustomers();
		reader.addDefaultBooks();
		
		reader.getNotification();
		
		boolean flag=true;
		
		while(flag)
		{
		System.out.println("Enter the option");
		System.out.println("1.Existing member 2.New member 3.Exit");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		switch(option)
		{
		case 1:
		{
			runner.existingMember();
			break;
		}
		
		case 2:
		{
			runner.newCustomer();
			break;
		}
		
		case 3:
		{
			flag=false;
		}
		}
		}
	}

}
