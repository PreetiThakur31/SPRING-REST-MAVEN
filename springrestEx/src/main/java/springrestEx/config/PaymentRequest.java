package springrestEx.config;

/** 
 * 
 * @author preeti
 * This is Payment API basic unit class.
 * Payment request class which should be submitted by clients on each payment request.
 */
public class PaymentRequest {

	 private int customerId;
	 private String customerName;
	 private int accountNo;
	 private int accountBalance;
	 
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	 	
	 
}
