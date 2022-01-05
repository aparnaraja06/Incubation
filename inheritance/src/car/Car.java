package car;

public class Car {
private int yearOfMake;
private String engineNumber;
private String type;
private String check;
public Car() {
	
}
public Car(String input)
{
	this.check=input;
}
public int getYearOfMake() {
	return yearOfMake;
}
public void setYearOfMake(int yearOfMake) {
	this.yearOfMake = yearOfMake;
}
public String getEngineNumber() {
	return engineNumber;
}
public void setEngineNumber(String engineNumber) {
	this.engineNumber = engineNumber;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCheck() {
	return check;
}
public void setCheck(String check) {
	this.check = check;
}
public void maintanance() {
	System.out.println("Car is under maintanance");
}
}
