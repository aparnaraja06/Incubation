package loan;

public class LoanInfo {
          private long customerId;
          private long accountNum;
          private String type;
          private double amount;
          private String status;
         
          
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public long getCustomerId() {
			return customerId;
		}
		public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}
		public long getAccountNum() {
			return accountNum;
		}
		public void setAccountNum(long accountNum) {
			this.accountNum = accountNum;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
          
          
		public String toString() {
			return type+" "+amount+" "+status;
		}
}
