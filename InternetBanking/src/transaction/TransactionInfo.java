package transaction;

public class TransactionInfo {

	        private long fromAccount;
	        private long toAccount;
	        private double amount;
	        private String type;
	        private double beginningBalance;
	        private double endingBalance;
	        
			public long getFromAccount() {
				return fromAccount;
			}
			public void setFromAccount(long fromAccount) {
				this.fromAccount = fromAccount;
			}
			public long getToAccount() {
				return toAccount;
			}
			public void setToAccount(long toAccount) {
				this.toAccount = toAccount;
			}
			public double getAmount() {
				return amount;
			}
			public void setAmount(double amount) {
				this.amount = amount;
			}
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public double getBeginningBalance() {
				return beginningBalance;
			}
			public void setBeginningBalance(double beginningBalance) {
				this.beginningBalance = beginningBalance;
			}
			public double getEndingBalance() {
				return endingBalance;
			}
			public void setEndingBalance(double endingBalance) {
				this.endingBalance = endingBalance;
			}
	        
	        public String toString() {
	        	return type+" "+toAccount+" "+amount+" "+beginningBalance+" "+endingBalance;
	        }
}
