package park;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import customer.CustomerInfo;
import customexception.CustomException;
import space.ParkingSpace;
import ticket.Ticket;
import validate.Validate;
import vehicle.Vehicle;

public class ParkingOperations {
	private int ticket = 1000;
    private int slotNum = 100;
    private int customerId=0;
	
	Validate validator = new Validate();

	Map<Integer,Map<String,List<ParkingSpace>>> emptySpaces=new HashMap<>();
	Map<Integer,ParkingSpace> filledSpaces=new HashMap<>();
	Map<Integer, Ticket> ticketMap = new HashMap<>();
	Map<Long,CustomerInfo> customerMap=new HashMap<>();
	

	public int generateTicket() {
		return ++ticket;
	}
	
	public int generateSlot() {
		
		return ++slotNum;
	}
	
	public int generateCustomerId() {
		
		return ++customerId;
	}
	
	public ParkingOperations(){
		addDefaultCustomers();
	}
	
	public void addDefaultCustomers() {
		long[] vehicleNum= {1111,2222,3333,4444,5555};
		double[] wallet= {1000,2000,3000,500,300};
		long[] mobile= {8993074341L,8712647823L,9783478272L,9237428463L,9812429643L};
		
		for(int i=0;i<vehicleNum.length;i++)
		{
			CustomerInfo customer=new CustomerInfo();
			int cust_id=generateCustomerId();
			
			customer.setCustomerId(cust_id);
			customer.setVehicleNum(vehicleNum[i]);
			customer.setAmount(wallet[i]);
			customer.setMobileNum(mobile[i]);
			
			customerMap.put(mobile[i], customer);
		}
	}

	public void addDefaultFloors(int floor_num,int spaceNum) {
		String[] type = { "Compact", "Large", "HandiCapped", "Electric", "TwoWheeler" };

	
		int k = 0;

		for (int i = 0; i <= floor_num; i++) {
			for (int j = 1; j <= spaceNum; j++) {
			
				if ((j % type.length - 1) == 0) {
					k = 0;
				}
                int space_num=generateSlot();
				ParkingSpace space = new ParkingSpace();

				space.setFloorNumber(i);
				space.setNumber(space_num);
				space.setType(type[k]);

				Map<String, List<ParkingSpace>> tempMap = emptySpaces.get(i);

				if (tempMap == null) {
					tempMap = new HashMap<>();

				}
				List<ParkingSpace> list=tempMap.get(type[k]);
				
				if(list==null)
				{
					list=new ArrayList<>();
				}
				
				list.add(space);
				tempMap.put(type[k], list);

				emptySpaces.put(i, tempMap);
				k++;
			}

			
		}

	}

	public Collection<List<ParkingSpace>> getFloorDetails(int floor_num)throws CustomException {
		validator.checkSpace(floor_num,emptySpaces);
		Map<String,List<ParkingSpace>> temp=emptySpaces.get(floor_num);
		
		return temp.values();

	}
	
	public CustomerInfo getInfoByMobile(long mobile)
	{
		
		CustomerInfo customer=customerMap.get(mobile);
		
		return customer;
	}
	
	public int addCustomerAccount(CustomerInfo customer)
	{
		int cust_id=generateCustomerId();
		
		long mobile=customer.getMobileNum();
		customer.setCustomerId(cust_id);
		
		customerMap.put(mobile, customer);
		
		return cust_id;
	}
	
	
	
	/*public int getCustomerId(long vehicle_num)throws CustomException
	{
		//validator.validate(vehicle_num,customerMap);
		CustomerInfo customer=customerMap.get(vehicle_num);
		
		if(customer==null)
		{
			return 0;
		}
		
		int id=customer.getCustomerId();
		
		return id;
	}*/
	
	public double checkWalletBalance(CustomerInfo customer)
	{
		double amount=customer.getAmount();
		
		return amount;
	}
	
	public double addWalletAmount(CustomerInfo customer,double amount)throws CustomException
	{
		
		double wallet=customer.getAmount();
		
        double total=wallet+amount;
		
        long mobile=customer.getMobileNum();
		
		CustomerInfo temp=customerMap.get(mobile);
		temp.setAmount(total);
		
		return total;
	}
	
	public double setWalletAmount(CustomerInfo customer,double amount)throws CustomException
	{
		double wallet=customer.getAmount();
		
		if(amount>wallet)
		{
			throw new CustomException("Your wallet has not sufficient balance please "
					+ "update some amount");
		}
		double total=wallet-amount;
		
		long mobile=customer.getMobileNum();
		
		CustomerInfo temp=customerMap.get(mobile);
		temp.setAmount(total);
		
		return total;
	}

	public String getSpaceType(String type) throws CustomException {
		validator.validate(type);

		switch (type.toLowerCase()) {
		case "car": {
			return "Compact";
		}

		case "van": {
			return "Large";
		}

		case "twowheeler": {
			return "TwoWheeler";
		}

		case "handicapped": {
			return "HandiCapped";
		}
		case "electric": {
			return "Electric";
		}

		}
		return "Large";
	}

	public List<ParkingSpace> getSpaces(int floor_num, String type) throws CustomException {
		
		Map<String,List<ParkingSpace>> tempMap= emptySpaces.get(floor_num);
		String temp = getSpaceType(type);
		
		List<ParkingSpace> list=tempMap.get(temp);
		
		return list;
	}
	

	public ParkingSpace bookSlot(ParkingSpace space) throws CustomException {
		validator.validate(space);

		int number = space.getNumber();

		int floor = space.getFloorNumber();
		String type = space.getType();

		Map<String,List<ParkingSpace>> tempMap=emptySpaces.get(floor);
		
		List<ParkingSpace> list=tempMap.get(type);
		list.remove(space);
		
		filledSpaces.put(number, space);
		return space;
	}

	public Ticket getTicket(ParkingSpace space, Vehicle vehicle) throws CustomException {
		validator.validate(vehicle);
		validator.validate(space);

		int ticket_num = generateTicket();
		int floor = space.getFloorNumber();
		int number = space.getNumber();
		String type = space.getType();
		long vehicleNum = vehicle.getNumber();
		int cust_id=vehicle.getCustomerId();
		long timee = System.currentTimeMillis();
		String time = getTime(timee);

		Ticket ticket = new Ticket();

		ticket.setTicketNumber(ticket_num);
		ticket.setEntryTime(time);
		ticket.setFloorNumber(floor);
		ticket.setSpaceNumber(number);
		ticket.setVehicleNum(vehicleNum);
		ticket.setCustomerId(cust_id);
		ticket.setType(type);

		ticketMap.put(ticket_num, ticket);

		return ticket;
	}

	public Ticket getTicketByNum(int ticket_num) throws CustomException {
		validator.validate(ticket_num);
		validator.validate(ticket_num,ticketMap);

		Ticket ticket = ticketMap.get(ticket_num);

		return ticket;
	}



	public boolean updateSpace(Ticket ticket) throws CustomException {
		validator.validate(ticket);

		int number = ticket.getSpaceNumber();
        int floor=ticket.getFloorNumber();
        String type=ticket.getType();
        
        ParkingSpace space=filledSpaces.get(number);
        filledSpaces.remove(number);
        
        Map<String,List<ParkingSpace>> tempMap=emptySpaces.get(floor);
        List<ParkingSpace> list=tempMap.get(type);
        list.add(space);

		return true;
	}

	public int checkVehicle(int ticket_num, long vehicleNum) throws CustomException {

		validator.validate(ticket_num);
		validator.validate(vehicleNum);
		validator.validate(ticket_num,ticketMap);

		Ticket ticket = getTicketByNum(ticket_num);

		long vehicle = ticket.getVehicleNum();

		boolean result = false;
		if (vehicleNum == vehicle) {
			result = updateSpace(ticket);
		}

		int hour = calculateHours(ticket);

		return hour;

	}

	public int calculateHours(Ticket ticket) throws CustomException {

		validator.validate(ticket);

		String entry = ticket.getEntryTime();
		long time = System.currentTimeMillis();
		String exit = getTime(time);

		String entry_time = entry.replace(String.valueOf(':'), "");
		String exit_time = exit.replace(String.valueOf(':'), "");

		int time1 = Integer.parseInt(entry_time);
		int time2 = Integer.parseInt(exit_time);

		int total = Math.abs(time1 - time2);

		String result = String.valueOf(total);

		if (result.length() != 6) {
			result = String.format("%04d", total);
		}

		String first = result.substring(0, 2);
		int hours = Integer.parseInt(first);

		return hours;

	}

	public String getTime(long millis) throws CustomException {

		validator.validate(millis);

		String pattern = "HH:mm:ss";

		SimpleDateFormat formatter = new SimpleDateFormat(pattern);

		Date date = new Date(millis);

		String time = formatter.format(date);

		return time;
	}
	
	public double chargingCost(int hours)throws CustomException
	{
		validator.validate(hours);
		
		double amount=10;
		
		if(hours==0)
		{
			return amount;
		}
		
		return hours*amount;
	}

	public double calculateCost(int hours) throws CustomException {
		validator.validate(hours);

		double amount = 0.0;

		if (hours <= 1) {
			amount = 4;
			return amount;
		} else if (hours == 2) {
			amount = 4 + 3.5;
		} else {
			amount = 4 + (hours - 1) * 3.5;
		}

		return amount;

	}
	
	/*public void validate(int cust_id,long vehicle)throws CustomException
	{
		validator.validate(cust_id, vehicle, customerMap);
	}*/

}
