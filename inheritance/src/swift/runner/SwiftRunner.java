package swift.runner;
import car.Car;
import swift.Swift;
import scross.SCross;
import xuv.XUV;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SwiftRunner {
	static Scanner scanner= new Scanner(System.in);
	Swift swiftObj=new Swift();
	SCross scrossObj=new SCross();
	XUV xuvObj=new XUV();
	Car carObj=new Car();
	Car swiftCar=new Swift();
	Car xuvCar=new XUV();
	Car scrossCar=new SCross();
	public void displaySwift() {
	try
	{
	System.out.println("Enter the number of seats ");
	int seats=scanner.nextInt();
	scanner.nextLine();
	swiftObj.setSeat(seats);
	System.out.println("Enter the number of airbag ");
	int airBag=scanner.nextInt();
	scanner.nextLine();
	swiftObj.setAirBag(airBag);
	System.out.println("Enter the name of the model ");
	String model=scanner.nextLine();
	swiftObj.setModel(model);
	System.out.println("Enter the color of the car ");
	String color=scanner.nextLine();
	swiftObj.setColor(color);
	System.out.println("Number of seats : "+swiftObj.getSeat());
	System.out.println("Number of airbag : "+swiftObj.getAirBag());
	System.out.println("Model name : "+swiftObj.getModel());
	System.out.println("Color of the car : "+swiftObj.getColor());
	}
	catch(InputMismatchException e) 
	{
		System.out.println("You have entered string in place of integer ");
	}
	}
	public void displaySCross() 
	{
		try {
			System.out.println("Enter the number of seats ");
			int seats=scanner.nextInt();
			scanner.nextLine();
			scrossObj.setSeat(seats);
			System.out.println("Enter the number of airbag ");
			int airBag=scanner.nextInt();
			scanner.nextLine();
			scrossObj.setAirBag(airBag);
			System.out.println("Enter the name of the model ");
			String model=scanner.nextLine();
			scrossObj.setModel(model);
			System.out.println("Enter the color of the car ");
			String color=scanner.nextLine();
			scrossObj.setColor(color);
			System.out.println("Enter the year of make ");
			int year=scanner.nextInt();
			scanner.nextLine();
			scrossObj.setYearOfMake(year);
			System.out.println("Enter the engine number ");
			String num=scanner.nextLine();
			scrossObj.setEngineNumber(num);
			System.out.println("Enter the type of the car ");
			String type=scanner.nextLine();
			scrossObj.setType(type);
			System.out.println("Number of seats : "+scrossObj.getSeat());
			System.out.println("Number of airbag : "+scrossObj.getAirBag());
			System.out.println("Model name : "+scrossObj.getModel());
			System.out.println("Color of the car : "+scrossObj.getColor());
			System.out.println("Making year : "+scrossObj.getYearOfMake());
			System.out.println("Engine number : "+scrossObj.getEngineNumber());
			System.out.println("Type : "+scrossObj.getType());
			}
			catch(InputMismatchException e) 
			{
				System.out.println("You have entered string in place of integer ");
			}
	}
		public void displayCar(Car carObj)
		{
			if(carObj instanceof Swift)
			{
				System.out.println("Hatch");
			}
			if(carObj instanceof XUV)
			{
				System.out.println("SUV");
			}
			if(carObj instanceof SCross)
			{
				System.out.println("Sedan");
			}
		}
			public void swiftArg(Car CarObj)
			{
				System.out.println("From car Object as argument");
			}
			
	public static void main(String[] args)
	{
	    SwiftRunner runnerObj=new SwiftRunner();
	    int option=0;
	try 
	{
	   System.out.println("Enter the number between 1-4");
	    option=scanner.nextInt();
	    scanner.nextLine();
	}
	catch(InputMismatchException e)
	{
		System.out.println("You have entered String in place of integer ");
	}
	switch(option)
	{
	case 1:
	{
	runnerObj.displaySwift();
	break;
	}
	case 2:
	{
	runnerObj.displaySCross();
	break;
	}
	case 3:
	{
	runnerObj.displayCar(runnerObj.swiftObj);
	runnerObj.displayCar(runnerObj.xuvObj);
	runnerObj.displayCar(runnerObj.scrossObj);
	break;
	}
	case 4:
	{
	runnerObj.swiftArg(runnerObj.swiftCar);
	runnerObj.swiftArg(runnerObj.xuvCar);
	runnerObj.swiftArg(runnerObj.scrossCar);
	break;
	}
	case 5:
	{
	runnerObj.scrossObj.maintanance();
	runnerObj.scrossCar.maintanance();
	runnerObj.carObj.maintanance();
	runnerObj.swiftObj.maintanance();
	break;
	}
	case 6:
	{
	 System.out.println(runnerObj.xuvObj);
	 break;
	}
    }
}
}
