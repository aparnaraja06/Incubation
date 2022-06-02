package operations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import book.Booking;
import custom.CustomException;
import customer.Customer;
import file.FileDemo;
import product.Product;

public class Operations {
	
	private int orderNum=0;

	//Map<String, Customer> customerMap = new HashMap<>();
	//Map<String, Map<String, List<Product>>> productMap = new HashMap<>();
	
	FileDemo demo=new FileDemo();
	
	public Map<String,Customer> readCustomer()throws CustomException
	{
		Map<String, Customer> customerMap=demo.readCustomers();
		
		return customerMap;
	}
	
	public Map<String,Map<String,List<Product>>> readProduct()throws CustomException
	{
		Map<String, Map<String, List<Product>>> productMap=demo.readProduct();
		
		return productMap;
	}
	
	public int generateOrderNum() {
		return ++orderNum;
	}

	public void addDefaultCustomers()throws CustomException {
		Map<String,Customer> customerMap=new HashMap<>();
		
		String[] username = { "abc@zoho.com", "123@zoho.com", "user@zoho.com","admin@zoho.com" };
		String[] password = { "pass", "pass", "pass","admin"};
		String[] name = { "Rahul", "Ram", "Anitha","admin" };
		long[] mobile = { 9837489243L, 9831497489L, 9238174897L,9812374274L};

		for (int i = 0; i < name.length; i++) {
			
			String pass=encryptPass(password[i]);
					
			Customer customer = new Customer();

			customer.setUsername(username[i]);
			customer.setPassword(pass);
			customer.setMobile(mobile[i]);
			customer.setName(name[i]);

			customerMap.put(username[i], customer);
			
			demo.writeCustomers(customerMap);
		}

	}

	public void addDefaultProduct()throws CustomException {
		
		Map<String, Map<String, List<Product>>> productMap=new HashMap<>();

		String[] category = { "mobile", "mobile", "laptop", "tablet" };
		String[] brand = { "apple", "motrola", "hp", "google" };
		String[] model = { "6s", "G", "elite", "chromebook" };
		double[] price = { 60000, 12000, 56000, 8000 };
		int[] stock = { 10, 5, 20, 12 };

		for (int i = 0; i < brand.length; i++) {
			
			Product product = new Product();

			product.setCategory(category[i]);
			product.setBrand(brand[i]);
			product.setModel(model[i]);
			product.setPrice(price[i]);
			product.setStock(stock[i]);


			Map<String, List<Product>> tempMap = productMap.get(category[i]);

			if (tempMap == null) {
				tempMap = new HashMap<>();
			}
			
			List<Product> list = tempMap.get(brand[i]);
			
			if(list==null)
			{
				list=new ArrayList<>();
			}

			list.add(product);
			tempMap.put(brand[i], list);
			
			productMap.put(category[i], tempMap);
			
			demo.writeProducts(productMap);
		}
	}

	public boolean login(String user, String pass)throws CustomException {
		
		Map<String, Customer> customerMap=readCustomer();

		Customer customer = customerMap.get(user);

		if (customer == null) {
			return false;
		}

		String password = customer.getPassword();
		String temp=decryptPass(password);
		
		//System.out.println("Decrypt : "+temp);

		if (temp.equals(pass)) {
			return true;
		}

		return false;
	}
	
	public String decryptPass(String pass)
	{
		String result="";
		//int number=0;
		
		for(int i=0;i<pass.length();i++)
		{
				result+=getbefore(pass.charAt(i));
		}
		
		return result;
	}
	
	public char getbefore(char character)
	{
		String alphabets="1234567890abcdefghijklmnopqrstuvwxyz";
		
		int index=alphabets.indexOf(character);
		
		char temp=alphabets.charAt(index-1);
		
		return temp;
	}
	
	
	public void newAccount(Customer customer)throws CustomException
	{
		
		Map<String, Customer> customerMap=readCustomer();
		
		String user=customer.getUsername();
		String pass=customer.getPassword();
		
		String temp=encryptPass(pass);
		
		customer.setPassword(temp);
		
		customerMap.put(user, customer);
		
		demo.writeCustomers(customerMap);
	}
	
	public boolean checkUserName(String mail)throws CustomException
	{
		Map<String, Customer> customerMap=readCustomer();
		
		//System.out.println("Customer : "+customerMap);
		Customer customer=customerMap.get(mail);
		
		if(customer!=null)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean checkPassword(String pass1,String pass2)
	{
		if(pass1.equals(pass2))
		{
			return true;
		}
		
		return false;
	}
	
	public String encryptPass(String pass)
	{
		String result="";
		//int number=0;
		
		for(int i=0;i<pass.length();i++)
		{
				result+=getNextChar(pass.charAt(i));
		}
		

		return result;
	}
	
	public char getNextChar(char character)
	{
		String alphabets="1234567890abcdefghijklmnopqrstuvwxyz";
		
		int index=alphabets.indexOf(character);
		//String result=alphabets.substring(index, index+2);
		
		char temp=alphabets.charAt(index+1);
		
		return temp;
	}
	
	public List<Product> placeOrder(String category,String brand)throws CustomException
	{
		Map<String, Map<String, List<Product>>> productMap=readProduct();
		
		//System.out.println("product : "+productMap);
		
		Map<String,List<Product>> tempMap=productMap.get(category);
		List<Product> list=tempMap.get(brand);
		
		return list;
	}
	
	public int bookProduct(String user,Product product)throws CustomException
	{
		Map<Integer,Booking> bookMap=new HashMap<>();
		
		Booking book=new Booking();
		
		int order_num=generateOrderNum();
		int id=product.getId();
		book.setUsername(user);
		book.setId(id);
		book.setOrderNum(order_num);
		
		bookMap.put(order_num, book);
		
		demo.writeBooking(bookMap);
		
		String category=product.getCategory();
		String brand=product.getBrand();
		int stock=product.getStock();
		product.setStock(stock-1);
	
		Map<String,Map<String,List<Product>>> productMap=readProduct();
		
		Map<String,List<Product>> tempMap=productMap.get(category);
		List<Product> list=tempMap.get(brand);
		list.add(product);
		tempMap.put(brand, list);
		productMap.put(category, tempMap);
		
		demo.writeProducts(productMap);
		
		return order_num;
	
	}

}
