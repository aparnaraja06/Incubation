package car;

public class Car 
{

	private String name;
	private int id;
	private String fuelType;
	private double cost;
	private int numOfSeat;
	private int engine;
	private double mileage;
	private String location;
	private String branch;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getNumOfSeat() {
		return numOfSeat;
	}
	public void setNumOfSeat(int numOfSeat) {
		this.numOfSeat = numOfSeat;
	}
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() 
	{
		return "\n name : " + name + "\n id : " + id + "\n fuelType : " + fuelType + "\n cost : " + cost + "\n numOfSeat : "
				+ numOfSeat + "\n engine : " + engine + "\n mileage : " + mileage+"\n------------------";
	}
	
	
	
}
