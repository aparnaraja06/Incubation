package operation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customexception.CustomException;
import file.FileDemo;
import order.Order;
import product.Product;
import user.User;

public class Operation {

	private int productId = 100;
	private int orderId = 1000;

	// Map<String,User> userMap=new HashMap<>();
	// Map<String,List<Product>> productMap=new HashMap<>();
	// Map<String,List<String>> passwordMap=new HashMap<>();
	// Map<String,List<Order>> orderMap=new HashMap<>();

	FileDemo demo = new FileDemo();

	public int generateOrderId() {

		return ++orderId;

	}

	public int generateProductId() {
		return ++productId;
	}

	public void addDefaultUsers() throws CustomException {
		Map<String, User> userMap = new HashMap<>();
		Map<String, List<String>> passwordMap = new HashMap<>();

		String[] name = { "karthi", "priya", "ram", "sam", "uma" };
		int[] age = { 30, 20, 40, 33, 25 };
		String[] mail = { "karthi@gmail.com", "priya@gmail.com", "ram@gmail.com", "sam@gmail.com", "uma@gmail.com" };
		String[] gender = { "male", "female", "male", "male", "female" };
		long[] mobile = { 9237854384L, 9283648737L, 8236587439L, 9832297585L, 8263428746L };
		String[] password = { "pass", "pass", "pass", "pass", "pass" };
		String[] type = { "customer", "customer", "customer", "customer", "customer" };

		for (int i = 0; i < name.length; i++) {
			User user = new User();

			user.setAge(age[i]);
			user.setGender(gender[i]);
			user.setMailId(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			String pass = encryptPassword(password[i]);

			user.setPassword(pass);

			user.setType(type[i]);

			userMap.put(mail[i], user);

			// System.out.println("user map : "+userMap);
			demo.writeCustomers(userMap);

			List<String> list = passwordMap.get(mail[i]);

			if (list == null) {
				list = new ArrayList<>();
			}

			list.add(password[i]);

			passwordMap.put(mail[i], list);

			demo.writePassword(passwordMap);
		}

		// System.out.println(userMap);
	}

	public void addDefaultAdmin() throws CustomException {
		Map<String, User> userMap = new HashMap<>();
		Map<String, List<String>> passwordMap = new HashMap<>();

		String[] name = { "admin1", "admin2", "admin3" };
		int[] age = { 34, 28, 38 };
		String[] mail = { "admin1@gmail.com", "admin2@gmail.com", "admin3@gmail.com" };
		String[] gender = { "male", "female", "male" };
		long[] mobile = { 8263583778L, 9126428734L, 9123648344L };
		String[] password = { "xyzxyz", "xyzxyz", "xyzxyz" };
		String[] type = { "admin", "admin", "admin" };

		for (int i = 0; i < name.length; i++) {
			User user = new User();

			user.setAge(age[i]);
			user.setGender(gender[i]);
			user.setMailId(mail[i]);
			user.setMobile(mobile[i]);
			user.setName(name[i]);
			String pass = encryptPassword(password[i]);

			user.setPassword(pass);
			// user.setPassword(password[i]);
			user.setType(type[i]);

			userMap.put(mail[i], user);

			// System.out.println("User map : "+userMap);
			demo.writeCustomers(userMap);

			List<String> list = passwordMap.get(mail[i]);

			if (list == null) {
				list = new ArrayList<>();
			}

			list.add(password[i]);

			passwordMap.put(mail[i], list);

			demo.writePassword(passwordMap);
		}

		// System.out.println(userMap);

	}

	public void addDefaultProduct() throws CustomException {
		Map<String, List<Product>> productMap = new HashMap<>();

		String[] name = { "mobile", "laptop", "tablet", "tv", "headphone" };
		String[] brand = { "apple", "motrola", "samsung", "google", "hp" };
		String[] model = { "6s", "8g", "g", "elite", "chromebook", "100s" };
		double[] amount = { 60000, 20000, 7000, 10000, 30000 };
		int[] stock = { 10, 10, 10, 10, 10 };

		int k = 0;

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < name.length; i++) {
				if (j == name.length) {
					k = 0;
				}
				int id = generateProductId();
				Product product = new Product();

				product.setType(name[k]);
				product.setAmount(amount[i]);
				product.setBrand(brand[i]);
				product.setModel(model[i]);
				product.setId(id);
				product.setStock(stock[i]);

				List<Product> list = productMap.get(name[k]);

				if (list == null) {
					list = new ArrayList<>();
				}

				list.add(product);

				productMap.put(name[k], list);

				demo.writeProducts(productMap);

			}
			k++;
		}

		// System.out.println(productMap);
	}

	public Map<String, User> showCustomers() throws CustomException {
		Map<String, User> userMap = demo.readCustomers();

		return userMap;
	}

	public Map<String, List<Product>> showProduct() throws CustomException {
		
		Map<String, List<Product>> productMap = demo.readProduct();

		return productMap;
	}

	public List<Product> getProductsByCategory(String type) throws CustomException 
	{
		Map<String, List<Product>> productMap =showProduct();

		List<Product> list = productMap.get(type);

		return list;
	}

	public User getUser(String mail) throws CustomException {
		Map<String, User> userMap = demo.readCustomers();

		User user = userMap.get(mail);

		return user;
	}

	public List<String> getPasswords(String mail) throws CustomException {
		Map<String, List<String>> passwordMap = demo.readPassword();

		List<String> list = passwordMap.get(mail);

		return list;
	}

	public boolean validatePassword(String mail, String pass) throws CustomException {
		List<String> list = getPasswords(mail);

		String password = list.get(0);

		if (password.equals(pass)) {
			return true;
		}

		return false;
	}

	public boolean changePassword(String mail, String pass) throws CustomException {
		Map<String, List<String>> passwordMap = demo.readPassword();

		User user = getUser(mail);

		user.setPassword(pass);

		List<String> list = passwordMap.get(mail);

		list.add(pass);

		passwordMap.put(mail, list);

		demo.writePassword(passwordMap);

		return true;
	}

	public boolean checkValidUser(String mail) throws CustomException {
		User user = getUser(mail);

		if (user == null) {
			return false;
		}

		return true;
	}

	public boolean checkPassword(String pass1, String pass2) {
		if (pass1.equals(pass2)) {
			return true;
		}

		return false;
	}

	public void addCustomer(User user, String mail) throws CustomException {
		Map<String, User> userMap = demo.readCustomers();

		Map<String, List<String>> passwordMap = demo.readPassword();

		String password = user.getPassword();

		String pass = encryptPassword(password);

		user.setPassword(pass);

		userMap.put(mail, user);

		demo.writeCustomers(userMap);

		List<String> list = passwordMap.get(mail);

		list.add(pass);

		passwordMap.put(mail, list);

		demo.writePassword(passwordMap);
	}

	public String encryptPassword(String pass) {
		// System.out.println("entered");
		String result = "";
		int length = pass.length();

		for (int i = 0; i < length; i++) {
			char character = pass.charAt(i);

			if (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z'
					|| character >= '0' && character <= '9') {
				int temp = (int) character;

				char next = (char) (temp + 1);

				result += next;
			}
		}

		return result;
	}

	public String decryptPassword(String pass) {
		String result = "";
		int length = pass.length();

		for (int i = 0; i < length; i++) {
			char character = pass.charAt(i);

			if (character >= 'a' && character <= 'z' || character >= 'A' && character <= 'Z'
					|| character >= '0' && character <= '9') {
				int temp = (int) character;

				char next = (char) (temp - 1);

				result += next;
			}
		}

		return result;
	}

	public boolean login(String mail, String pass) throws CustomException {
		String password = encryptPassword(pass);

		User user = getUser(mail);

		String getPass = user.getPassword();

		if (getPass.equals(password)) {
			return true;
		}

		return false;
	}
	
	public Product checkHashcode(List<Product> list,Product product)
	{
		for(int i=0;i<list.size();i++)
		{
			Product temp=list.get(i);
			
			int id=temp.getId();
			
			int id2=product.getId();
			
			if(id==id2)
			{
				return temp;
			}
		}
		return null;
	}

	public void placeOrder(Product product, String type, String mail) throws CustomException {

		Map<String, List<Product>> productMap=showProduct();

		List<Product> list = productMap.get(type);
		
		//System.out.println("product : "+productMap);
		
		Product temp=checkHashcode(list,product);
		
		System.out.println("Product :"+temp);

		boolean result=list.remove(temp);

		System.out.println("Removed : "+result);

		 productMap.put(type, list);

		// demo.writeProducts(productMap);

		int stock = product.getStock();

		stock = stock - 1;

		product.setStock(stock);

		list.add(product);
		
		System.out.println("List : "+list);

		productMap.put(type, list);
		

		demo.writeProducts(productMap);

	}

	public double generateOrder(List<Product> list, String mail) throws CustomException {
		Map<String, List<Order>> orderMap = demo.readBooking();

		int id = generateOrderId();

		double total = 0;

		for (int i = 0; i < list.size(); i++) {
			Product product = list.get(i);

			int stock = product.getStock();

			if (stock > 8) {
				product.setDiscount(10);
			}

			Order order = bookOrder(product, mail, id);

			int discount = product.getDiscount();

			double amount = order.getTotal();

			if (discount != 0) {
				double temp = getDiscount(amount, discount);

				amount = amount - temp;
			}

			total += amount;

			List<Order> temp = orderMap.get(mail);

			if (temp == null) {
				temp = new ArrayList<>();
			}

			temp.add(order);

			orderMap.put(mail, temp);

			demo.writeBooking(orderMap);
		}

		List<Order> temp = orderMap.get(mail);

		User user = getUser(mail);

		String available = user.getCode();

		if ((temp.size() > 3 || total > 20000) && available == null) {
			String code = getDiscountCode();

			user.setCode(code);
			user.setTransaction(3);

			Map<String, User> userMap = demo.readCustomers();

			userMap.put(mail, user);

			demo.writeCustomers(userMap);

		}

		return total;

	}

	public double getDiscount(double amount, int percentage) {
		double temp = (double) percentage;

		double total = (temp / 100) * amount;

		return total;
	}

	public String getType(String mail) throws CustomException {
		User user = getUser(mail);

		String type = user.getType();

		return type;
	}

	public List<Order> getOrderedProducts(String mail) throws CustomException {
		Map<String, List<Order>> orderMap = demo.readBooking();

		List<Order> list = orderMap.get(mail);

		return list;
	}

	public String getTime() {

		String time = "";

		long millis = System.currentTimeMillis();

		DateFormat date = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");

		Date result = new Date(millis);

		time = date.format(result);

		return time;
	}

	public int checkStock(Product product) {
		int stock = product.getStock();

		return stock;

	}

	public Order bookOrder(Product product, String mail, int id) throws CustomException {

		String name = product.getType();
		String model = product.getModel();
		String brand = product.getBrand();
		String date = getTime();
		double amount = product.getAmount();
		int product_id = product.getId();

		placeOrder(product, name, mail);

		Order order = new Order();

		order.setBrand(brand);
		order.setDate(date);
		order.setMailId(mail);
		order.setType(name);
		order.setModel(model);
		order.setOrderId(id);
		order.setTotal(amount);
		order.setProductId(product_id);

		return order;
	}

	public boolean checkPasswordComplexity(String pass) {
		int lower = 2;
		int upper = 2;
		int number = 2;

		if (pass.length() < 6) {
			return false;
		}

		for (int i = 0; i < pass.length(); i++) {
			char character = pass.charAt(i);

			if (character >= 'A' && character <= 'Z') {
				upper = upper - 1;
			}

			else if (character >= 'a' && character <= 'z') {
				lower = lower - 1;
			} else if (character >= '0' && character <= '9') {
				number = number - 1;
			}
		}

		if (lower <= 0 && upper <= 0 && number <= 0) {
			return true;
		}

		return false;
	}

	public boolean checkOldPasswords(String mail, String pass) throws CustomException {
		Map<String, List<String>> passwordMap = demo.readPassword();

		List<String> list = passwordMap.get(mail);

		if (list == null) {
			return false;
		}

		String store = encryptPassword(pass);

		for (int i = 0; i < list.size(); i++) {
			String temp = list.get(i);

			if (temp.equals(store)) {
				return false;
			}
		}

		return true;
	}

	public String getDiscountCode() {

		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		String result = "";

		for (int i = 0; i < 6; i++) {
			int number = (int) (alphabet.length() * Math.random());

			result += alphabet.charAt(number);
		}

		return result;
	}

	public double applyDiscount(String mail, double amount) throws CustomException {
		int max = 30;
		int min = 20;

		Map<String, User> userMap = demo.readCustomers();

		User user = userMap.get(mail);

		int count = user.getTransaction();

		if (count == 0) {
			user.setCode(null);

			userMap.put(mail, user);

			demo.writeCustomers(userMap);
		} else {
			count = count - 1;

			user.setTransaction(count);

			userMap.put(mail, user);

			demo.writeCustomers(userMap);
		}

		double random = (double) (Math.random() * (max - min)) + min;

		// System.out.println("Gen : "+random);

		double total = (random / 100) * amount;

		// System.out.println("Random : "+total);

		return total;
	}

	public void addStock(Product product) throws CustomException {
		Map<String, List<Product>> productMap = demo.readProduct();

		String type = product.getType();

		List<Product> list = productMap.get(type);

		list.remove(product);

		int stock = product.getStock();

		stock = stock + 10;

		product.setStock(stock);

		list.add(product);

		productMap.put(type, list);

		demo.writeProducts(productMap);
	}

}
