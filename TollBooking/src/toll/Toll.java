package toll;

public class Toll {
	
	private int tollNum;
	private String type;
	private double amount;
	private double total;
	
	public int getTollNum() {
		return tollNum;
	}
	public void setTollNum(int tollNum) {
		this.tollNum = tollNum;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "tollNum : " + tollNum + ", type : " + type + ", amount : " + amount + ", total : " + total;
	}
	
	

}
