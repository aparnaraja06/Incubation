package account;

public class Account {
	
	private int id;
	private String mail;
	private double rcCoin;
	private double zAmount;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public double getRcCoin() {
		return rcCoin;
	}
	public void setRcCoin(double rcCoin) {
		this.rcCoin = rcCoin;
	}
	public double getzAmount() {
		return zAmount;
	}
	public void setzAmount(double zAmount) {
		this.zAmount = zAmount;
	}
	@Override
	public String toString() {
		return "id : " + id + ", mail : " + mail + ", rcCoin : " + rcCoin + ", zAmount : " + zAmount;
	}
	
	
	

}
