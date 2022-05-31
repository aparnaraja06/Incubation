package runner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import customer.CustomerInfo;
import customexception.CustomException;

import logic.ParkingLogic;
import space.ParkingSpace;
import ticket.Ticket;
import validate.Validate;
import vehicle.Vehicle;

public class Runner {
	static int floor_num = 0;
	static int userFloor = 0;

	static Scanner scanner = new Scanner(System.in);
	static ParkingLogic reader = new ParkingLogic();
	static Validate validator = new Validate();

	public List<String> getVehicle() {
		List<String> list = new ArrayList<>();
		list.add("Car");
		list.add("Two-Wheeler");
		list.add("Electric");
		list.add("Handi-Capped");
		list.add("Lorry");

		return list;
	}

	public String entry(long vehicleNum) throws CustomException {
		List<String> list = getVehicle();

		System.out.println("Choose the type of vehicle");
		System.out.println("1-car 2-two-wheeler 3-electric 4-handicapped 5-lorry");
		int numm = scanner.nextInt();
		validator.validate(numm, list);
		String type = list.get(numm - 1);
		return type;

	}

	public ParkingSpace bookSpace(String type) throws CustomException {
		System.out.println("Number of available spaces");
		List<ParkingSpace> result = reader.getSpaces(floor_num, type);
		System.out.println(type + "-" + result.size());
		if (result.size() == 0) {
			++floor_num;
			if (userFloor == floor_num) {
				System.out.println("OOps this is the last floor No spaces available");
			}
			return null;
		}
		ParkingSpace space = result.get(0);
		ParkingSpace temp = reader.bookSlot(space);
		System.out.println("Successfully you have booked a space");
		return temp;
	}

	public void settinglot() {
		try {
			System.out.println("Enter the number of floors");
			int floor = scanner.nextInt();
			scanner.nextLine();
			userFloor = floor;

			System.out.println("Enter the number of spaces");
			int space = scanner.nextInt();
			scanner.nextLine();

			reader.addDetails(floor, space);
		} catch (InputMismatchException e) {
			System.out.println("Invalid input type");
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
	}

	public int addAccount(long vehicle_num, long mobile) {
		try {
			System.out.println("Do you want to add account in customer info portal");
			System.out.println("1- Yes 2-No");
			int num = scanner.nextInt();
			scanner.nextLine();

			switch (num) {
			case 1: {
				System.out.println("Enter your name");
				String name = scanner.nextLine();
				System.out.println("Enter your location");
				String location = scanner.nextLine();
				double amount = 0;
				CustomerInfo customer = new CustomerInfo();
				customer.setName(name);
				customer.setLocation(location);
				customer.setMobileNum(mobile);
				customer.setVehicleNum(vehicle_num);
				customer.setAmount(0);

				int cust_id = reader.addCustomerAccount(customer);
				return cust_id;
			}

			case 2: {
				return 0;
			}
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input type");
		}

		return 0;
	}

	public static void main(String[] args) {

		Runner runner = new Runner();

		runner.settinglot();

		boolean flag = true;
		while (flag) {
			System.out.println("Welcome to the portal");
			System.out.println("Enter your choice 1- entry 2- out 3- customer portal " + "4- exit");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1: {
				try {

					// System.out.println(floor_num);
					Collection<List<ParkingSpace>> floor = reader.getFloorDetails(floor_num);

					/*
					 * if(floor==null) {
					 * System.out.println("OOps All the floors are filled..wait for sometime"); }
					 */

					System.out.println("Enter the vehicle number");
					long num = scanner.nextLong();
					scanner.nextLine();

					String type = runner.entry(num);
					ParkingSpace temp = runner.bookSpace(type);

					if (temp == null) {
						System.out.println("No spaces available to book");
						floor_num = 0;
						break;
					}

					// int cust_id=runner.addAccount(num);

					Vehicle vehicle = new Vehicle();
					vehicle.setNumber(num);
					vehicle.setType(type);
					// vehicle.setCustomerId(cust_id);

					Ticket ticket = reader.getTicket(temp, vehicle);
					System.out.println(ticket);

				} catch (InputMismatchException e) {
					System.out.println("Invalid input type");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;

			}

			case 2: {
				try {
					floor_num = 0;

					CustomerInfo customer = null;
					System.out.println("Enter the ticket Number");
					int num = scanner.nextInt();
					scanner.nextLine();
					Ticket ticket = reader.getTicketByNum(num);
					String type = ticket.getType();
					// int id=ticket.getCustomerId();
					System.out.println("Enter vehicle Number");
					long vehicle = scanner.nextLong();
					scanner.nextLine();

					System.out.println("Enter the mobile Number");
					long mobile = scanner.nextLong();
					scanner.nextLine();

					customer = reader.getInfoByMobile(mobile);

					int hours = reader.checkVehicle(num, vehicle);
					System.out.println("You have been parked for " + hours + " hour");
					double cost = reader.calculateCost(hours);

					if (type.equals("Electric")) {
						double charge = reader.chargingCost(hours);
						System.out.println("Charging cost : " + charge);
						double total = charge + cost;
						System.out.println("Total cost : " + total);
					}

					if (customer != null) {
						double amount = reader.checkWalletBalance(customer);
						System.out.println("You have " + amount + " balance");
						if (amount == 0) {
							System.out.println("Enter the amount to add");
							double money = scanner.nextDouble();
							double result = reader.addWalletBalance(customer, money);
							System.out.println("Wallet balance is : " + result);
						}
						double result = reader.setWalletAmount(customer, cost);
						System.out.println("Your wallet balance is : " + result);
					} else {
						int cust_id = runner.addAccount(vehicle, mobile);
						System.out.println("Your customer id : " + cust_id);
						System.out.println("Total cost : " + cost);
					}

				}

				catch (InputMismatchException e) {
					System.out.println("Invalid input type");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

			case 3: {
				try {
					System.out.println("Enter the customer id");
					int cust_id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the vehicle Number");
					long vehicle_num = scanner.nextLong();
					scanner.nextLine();
					// reader.validate(cust_id, vehicle_num);
					String type = runner.entry(vehicle_num);
					ParkingSpace space = runner.bookSpace(type);

					Vehicle vehicle = new Vehicle();
					vehicle.setNumber(vehicle_num);
					vehicle.setType(type);
					vehicle.setCustomerId(cust_id);

					Ticket ticket = reader.getTicket(space, vehicle);
					System.out.println(ticket);

				} catch (InputMismatchException e) {
					System.out.println("Invalid input type");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

			case 4: {
				try {
					System.out.println("Enter your mobile Number");
					long mobile = scanner.nextLong();
					scanner.nextLine();
					CustomerInfo customer = reader.getInfoByMobile(mobile);

					if (customer == null) {
						throw new CustomException("Mobile number not exists");
					}
					System.out.println("Enter the amount to add");
					double money = scanner.nextDouble();
					double result = reader.addWalletBalance(customer, money);
					System.out.println("Wallet balance is : " + result);
				} catch (InputMismatchException e) {
					System.out.println("Invalid input type");
				} catch (CustomException e) {
					System.out.println(e.getMessage());
				}
				break;
			}

			case 5: {
				flag = false;
			}
			}
		}

	}
}
