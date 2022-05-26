package account;

public class Account 
{
	
	private int accountNum;
	private String mailId;
	private double initialAmount;
	private double zCoin;
	//private int numberOfZCoin;
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public double getInitialAmount() {
		return initialAmount;
	}
	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}
	public double getzCoin() {
		return zCoin;
	}
	public void setzCoin(double zCoin) {
		this.zCoin = zCoin;
	}
	
	@Override
	public String toString() {
		return "accountNum : " + accountNum + ", mailId : " + mailId + ", initialAmount : " + initialAmount
				+ ", zCoin : " + zCoin;
	}


}
